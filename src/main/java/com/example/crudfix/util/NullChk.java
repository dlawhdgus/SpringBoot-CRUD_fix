package com.example.crudfix.util;

public class NullChk {
    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty() || str.isBlank();
    }
}