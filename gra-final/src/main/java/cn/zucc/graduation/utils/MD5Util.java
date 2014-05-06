package cn.zucc.graduation.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	static char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

	public static String getMD5(String key) {
		byte[] md5 = null;
		char[] str = null;
		try {
			MessageDigest digest = MessageDigest.getInstance("md5");
			digest.update(key.getBytes());
			md5 = digest.digest();
			int j = md5.length;
			str = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md5[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return new String(str);
	}

	public static void main(String[] args) {
		System.out.println(getMD5("123456"));
	}
}
