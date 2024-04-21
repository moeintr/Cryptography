package kish;

import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Map;

public class Reza {
    public static void main(String[] args)throws Exception {
        System.out.println(MD5.getHash("amirsam"));
        //System.out.println(SHA.getHash512("AMIRSAM"));
       // System.out.println(AES.getAESEncrypt("myjava1234","amirsam"));
        //System.out.println(AES.getAESDecrypt("myjava1234","6DF62CA952F412972D76800273AEF75F"));



       /*Map<String, Key> stringKeyMap =  RSA.getRSAKeys();
        PublicKey publicKey = (PublicKey) stringKeyMap.get("PublicKey");
        PrivateKey privateKey = (PrivateKey) stringKeyMap.get("PrivateKey");


       byte[] bytes =  RSA.getRSAEncrypt(publicKey,"amirsam");
        for (byte aByte : bytes) {
            System.out.print(aByte);
        }
        System.out.println();
        System.out.println(RSA.getRSADecrypt(privateKey,bytes));*/
    }
}
