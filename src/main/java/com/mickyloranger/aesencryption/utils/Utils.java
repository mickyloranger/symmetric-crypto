package com.mickyloranger.aesencryption.utils;

public class Utils {

    private static String characters = "0123456789abcdef";

    private static String toHex(byte[] data, int length) {
	StringBuffer buf = new StringBuffer();

	for (int i = 0; i != length; i++) {
	    int value = data[i] & 0xff;

	    buf.append(characters.charAt(value >> 4));
	    buf.append(characters.charAt(value & 0xf));
	}

	return buf.toString();
    }

    public static String toHexadecimal(byte[] data) {
	return toHex(data, data.length);
    }
}
