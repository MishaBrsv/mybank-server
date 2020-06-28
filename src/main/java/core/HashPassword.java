package core;

import org.apache.commons.codec.digest.DigestUtils;

public class HashPassword {
    public static String hashPass(String password) {
        String md5Hex = DigestUtils.md5Hex(password);
        return md5Hex;
    }
}
