package com.davidmogar.nji;

public class Stack {

    private byte[] stack;
    private int lastPosition;

    public Stack(int size) {
        stack = new byte[size];
        lastPosition = size;
    }

    public byte getByte(int pointer) {
        if (pointer < 0 || pointer > lastPosition) {
            throw new IndexOutOfBoundsException("Pointer out of range");
        }

        return (byte) (stack[pointer] & 0xff);
    }

    public int getInteger(int pointer) {
        if (pointer < 0 || pointer + 1> lastPosition) {
            throw new IndexOutOfBoundsException("Pointer out of range");
        }

        return (short)((stack[pointer]) & 0xff | (stack[pointer + 1] << 8 & 0xff00));
    }

    public float getFloat(int pointer) {
        if (pointer < 0 || pointer + 3 > lastPosition) {
            throw new IndexOutOfBoundsException("Pointer out of range");
        }

        int bits = (stack[pointer] << 24) & 0xff000000
                | (stack[pointer + 1] << 16) & 0xff0000
                | (stack[pointer + 2] << 8) & 0xff00
                | (stack[pointer + 3] & 0xff);

        return Float.intBitsToFloat(bits);
    }

    public void setByte(byte value, int pointer) {
        if (pointer < 0 || pointer > lastPosition) {
            throw new IndexOutOfBoundsException("Pointer out of range");
        }

        stack[pointer] = value;
    }

    public void setInteger(int value, int pointer) {
        if (pointer < 0 || pointer + 1 > lastPosition) {
            throw new IndexOutOfBoundsException("Pointer out of range");
        }

        stack[pointer] = (byte) (value & 0xff);
        stack[pointer + 1] = (byte) ((value >>> 8) & 0xff);
    }

    public void setFloat(float value, int pointer) {
        if (pointer < 0 || pointer + 3 > lastPosition) {
            throw new IndexOutOfBoundsException("Pointer out of range");
        }

        int bits = Float.floatToIntBits(value);
        stack[pointer] = (byte )(bits >>> 24 & 0xff);
        stack[pointer + 1] = (byte) (bits >>> 16 & 0xff);
        stack[pointer + 2] = (byte) (bits >>> 8 & 0xff);
        stack[pointer + 3] = (byte) (bits & 0xff);
    }

}
