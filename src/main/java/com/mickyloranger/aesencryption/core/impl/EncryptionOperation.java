package com.mickyloranger.aesencryption.core.impl;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import com.mickyloranger.aesencryption.core.SymmetricCryptoOperation;

public class EncryptionOperation implements SymmetricCryptoOperation {

    public String doOperation(String value, String key, String ivData) {

	Security.addProvider(new BouncyCastleProvider());

	byte[] iv = ivData.getBytes();

	IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

	byte[] keyBytes = key.getBytes();

	SecretKey secretKeySpec = new SecretKeySpec(keyBytes, "AES");

	Cipher cipher;
	byte[] encryptedValue;
	
	try {
	    cipher = Cipher.getInstance("AES/EAX/NoPadding", "BC");
	    cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
	    encryptedValue = cipher.doFinal(value.getBytes());
	} catch (NoSuchAlgorithmException e) {
	    throw new RuntimeException(e);
	} catch (NoSuchProviderException e) {
	    throw new RuntimeException(e);
	} catch (NoSuchPaddingException e) {
	    throw new RuntimeException(e);
	} catch (InvalidKeyException e) {
	    throw new RuntimeException(e);
	} catch (InvalidAlgorithmParameterException e) {
	    throw new RuntimeException(e);
	} catch (IllegalBlockSizeException e) {
	    throw new RuntimeException(e);
	} catch (BadPaddingException e) {
	    throw new RuntimeException(e);
	}

	String result = new String(encryptedValue);

	return result;
    }

}
