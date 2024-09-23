package com.mss.fashion.code;

public enum CategoryType {
    TOP("상의"),
    BOTTOM("하의"),
    OUTER("아우터"),
    SNEAKERS("스니커즈"),
    BAG("가방"),
    HAT("모자"),
    SOCKS("양말"),
    ACCESSORY("액세서리");

    private final String name;

    CategoryType(String name) {
        this.name = name;
    }
}
