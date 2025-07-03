package io.github.projektming.csm.util;

import org.jetbrains.annotations.NotNull;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Crypto {
    public static String getSimpleHash(@NotNull String input) {
        // 简单哈希一下避免明文储存
        byte[] digest;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            digest = md.digest(input.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        // WTF，简直离谱，Array 你赢了
        return Arrays.toString(digest);
    }
}
