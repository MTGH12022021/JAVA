package Hashing;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

public class HashingPass {

    public static String getSecurePassword(String passwordToHash) {
        MessageDigest md = null;
        String generatedPassword = null;
        try {
            md = MessageDigest.getInstance("MD5");

            byte[] bytes = md.digest(passwordToHash.getBytes());

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
                        .substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return generatedPassword;
    }

    public static  String getSalt (){
        SecureRandom sr = null;
        try {
            sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (NoSuchProviderException e) {
            throw new RuntimeException(e);
        }

        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt.toString();
    }
}
