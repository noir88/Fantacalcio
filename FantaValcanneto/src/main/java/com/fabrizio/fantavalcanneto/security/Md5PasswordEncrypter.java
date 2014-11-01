package com.fabrizio.fantavalcanneto.security;

import java.security.MessageDigest;

public class Md5PasswordEncrypter {
	

	public String encryptPasswordToMd5(String password) throws Exception {

		String temp = password;
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(temp.getBytes());
		byte[] digest = md.digest();
		StringBuffer sb = new StringBuffer();
		for (byte b : digest) {
			sb.append(String.format("%02x", b & 0xff));
		}

		return sb.toString();
	}

}
