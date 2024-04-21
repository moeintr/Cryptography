package kish;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.Serializable;
import java.security.*;
import java.util.HashMap;

public class RSA {
    private RSA(){}
    public static HashMap getRSAKeys() throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair kp = keyGen.genKeyPair();
        PublicKey publicKey = kp.getPublic();
        PrivateKey privateKey = kp.getPrivate();
        HashMap<String,Key> keys = new HashMap<>();
        keys.put("PublicKey", publicKey);
        keys.put("PrivateKey", privateKey);
        return keys;
    }

    public static byte[] getRSAEncrypt(Key publicKey, String clearText) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(clearText.getBytes());
    }

    public static String getRSADecrypt(Key privateKey, byte[] encrypt) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return new String(cipher.doFinal(encrypt));
    }

}
