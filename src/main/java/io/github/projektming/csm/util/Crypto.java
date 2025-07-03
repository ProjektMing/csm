package io.github.projektming.csm.util;

import org.jetbrains.annotations.NotNull;

public class Crypto {
    public static String getSimpleHash(@NotNull String input) {
        // 简单哈希一下避免明文储存
        return Integer.toHexString(input.hashCode());
    }
}
