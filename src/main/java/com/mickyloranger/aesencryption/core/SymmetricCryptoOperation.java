package com.mickyloranger.aesencryption.core;

/**
 * 
 * @author Micky Loranger
 *
 */
public interface SymmetricCryptoOperation {
    /**
     * 
     * @param value
     *            to value to encrypt or decript
     * @param key
     *            symmetric key to use for encryption or decryption. Depending
     *            on the algorithm the key can have a specific length
     * @param ivData
     *            initial value for some symmetric algorithm modus such as EAX
     * @return
     */
    String doOperation(String value, String key, String ivData);
}
