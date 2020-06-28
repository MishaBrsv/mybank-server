package services;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

@Service
public class HashPasswordService {
    public static String hashPass(String password) {
        String md5Hex = DigestUtils.md5Hex(password);
        return md5Hex;
    }

    public static boolean checkPass(String enteredPassword, String password){
        return enteredPassword.equals(password);
    }
}
