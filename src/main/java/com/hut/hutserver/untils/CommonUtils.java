package com.hut.hutserver.untils;

import lombok.extern.slf4j.Slf4j;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@Slf4j
public class CommonUtils {
    public static String getNewUserID() {
        return UUID.randomUUID().toString();
    }
    public static String encrypt(String input) {
        String prefix = "weaj4t3987gizvbkzxmbf";
        String suffix = "jhkrnvdsbaefdsqqwtdfh";
        String temporaryStr = prefix + input + suffix;
        String res = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(temporaryStr.getBytes());
            byte[] digest = md.digest();
            res = DatatypeConverter.printHexBinary(digest);
        } catch (NoSuchAlgorithmException e) {
            log.error("[com.hut.hutserver.untils.CommonUtils] NoSuchAlgorithmException!");
        }
        return res;
    }
}
