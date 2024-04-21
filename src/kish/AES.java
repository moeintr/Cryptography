package kish;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import java.security.*;


public class AES {
    private AES(){

    }
    public static String getAESEncrypt(String seed, String cleartext) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        sr.setSeed(seed.getBytes());
        kgen.init(128, sr);
        SecretKey skey = kgen.generateKey();
        byte[] rawKey = skey.getEncoded();
        SecretKeySpec skeySpec = new SecretKeySpec(rawKey, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(cleartext.getBytes());
        if (encrypted == null)
            return "";
        StringBuffer result = new StringBuffer(2 * encrypted.length);
        String HEX = "0123456789ABCDEF";
        for (int i = 0; i < encrypted.length; i++) {
            result.append(HEX.charAt((encrypted[i] >> 4) & 0x0f)).append(HEX.charAt(encrypted[i] & 0x0f));
        }
        return result.toString();
    }

    public static String getAESDecrypt(String seed, String encrypted) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        sr.setSeed(seed.getBytes());
        kgen.init(128, sr);
        SecretKey skey = kgen.generateKey();
        byte[] rawKey = skey.getEncoded();
        int len = encrypted.length() / 2;
        byte[] enc = new byte[len];
        for (int i = 0; i < len; i++) {
            enc[i] = Integer.valueOf(encrypted.substring(2 * i, 2 * i + 2), 16).byteValue();
        }
        SecretKeySpec skeySpec = new SecretKeySpec(rawKey, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        byte[] decrypted = cipher.doFinal(enc);
        return new String(decrypted);
    }

}