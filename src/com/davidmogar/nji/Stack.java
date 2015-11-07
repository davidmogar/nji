package com.davidmogar.nji;

public class Stack {

    private byte[] stack;
    private int lastPosition;

    public Stack(int size) {
        stack = new byte[size];
        lastPosition = size;
    }

    public char getCharacter(short pointer) {
        if (pointer < 0 || pointer > lastPosition) {
            throw new IndexOutOfBoundsException("Pointer out of range");
        }

        return (char)(stack[pointer] & 0xff);
    }

    public short getInteger(short pointer) {
        if (pointer < 0 || pointer > lastPosition) {
            throw new IndexOutOfBoundsException("Pointer out of range");
        }

        return (short)(((stack[pointer] << 8) & 0xff00) | (stack[pointer + 1] & 0xff));
    }

    public float getFloat(short pointer) {
        if (pointer < 0 || pointer > lastPosition) {
            throw new IndexOutOfBoundsException("Pointer out of range");
        }

        int bits = (stack[pointer + 3] << 24) & 0xff000000
                | (stack[pointer + 2] << 16) & 0x00ff0000
                | (stack[pointer + 1] << 8) & 0x0000ff00
                | (stack[pointer] & 0x000000ff);

        return Float.intBitsToFloat(bits);
    }

    public void setByte(byte value, short pointer) {
        if (pointer < 0 || pointer > lastPosition) {
            throw new IndexOutOfBoundsException("Pointer out of range");
        }

        stack[pointer] = value;
    }

    public void setInteger(short value, short pointer) {
        if (pointer - 1 < 0 || pointer > lastPosition) {
            throw new IndexOutOfBoundsException("Pointer out of range");
        }

        stack[pointer] = (byte)value;
        stack[pointer + 1] = (byte)((value >> 8));
    }

    public void setFloat(float value, short pointer) {
        if (pointer - 3 < 0 || pointer > lastPosition) {
            throw new IndexOutOfBoundsException("Pointer out of range");
        }
        int bits = Float.floatToIntBits(value);
        stack[pointer] = (byte)(bits >>> 24 & 0xff);
        stack[pointer - 1] = (byte)(bits >>> 16 & 0xff);
        stack[pointer - 2] = (byte)(bits >>> 8 & 0xff);
        stack[pointer - 3] = (byte)(bits & 0xff);
    }

}
