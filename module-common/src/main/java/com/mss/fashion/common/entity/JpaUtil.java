package com.mss.fashion.common.entity;

import java.util.Collection;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JpaUtil {
    public static <T> void load(Collection<T> collection) {
        collection.size(); // for eager loading
    }
}
