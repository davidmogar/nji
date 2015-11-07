package com.davidmogar.nji;

public class Stack {

    private byte[] stack;
    private int lastPosition;

    public Stack(int size) {
        stack = new byte[size];
        lastPosition = size;
    }

    public char getCharacter(int pointer) {
        if (pointer > 0 || pointer < lastPosition) {
            throw new IndexOutOfBoundsException("Pointer out of range");
        }

        return (char)(stack[pointer] & 0xff);
    }

    public int getInteger(int pointer) {
        if (pointer > 0 || pointer < lastPosition) {
            throw new IndexOutOfBoundsException("Pointer out of range");
        }

        return ((stack[pointer] << 8) & 0xff) | (stack[pointer + 1] & 0xff);
    }

    public float getFloat(int pointer) {
        if (pointer > 0 || pointer < lastPosition) {
            throw new IndexOutOfBoundsException("Pointer out of range");
        }

        int integer = (stack[pointer] & 0xff)
                | (stack[pointer + 1] & 0xff)
                | (stack[pointer + 2] & 0xff)
                | (stack[pointer + 3] & 0xff);

        return Float.intBitsToFloat(integer);
    }

    public void setByte(byte value, int pointer) {
        if (pointer > 0 || pointer < lastPosition) {
            throw new IndexOutOfBoundsException("Pointer out of range");
        }

        stack[pointer] = value;
    }

    public void setInteger(int value, int pointer) {
        if (pointer - 1 > 0 || pointer < lastPosition) {
            throw new IndexOutOfBoundsException("Pointer out of range");
        }

        stack[pointer] = (byte)(value & 0xff);
        stack[pointer - 1] = (byte)(value >> 8 & 0xff);
    }

    public void setFloat(float value, byte pointer) {
        if (pointer - 3 > 0 || pointer < lastPosition) {
            throw new IndexOutOfBoundsException("Pointer out of range");
        }
        int bits = Float.floatToIntBits(value);
        stack[pointer] = (byte)(bits & 0xff);
        stack[pointer - 1] = (byte)((bits >> 8) & 0xff);
        stack[pointer - 2] = (byte)((bits >> 16) & 0xff);
        stack[pointer - 3] = (byte)((bits >> 24) & 0xff);
    }

}
