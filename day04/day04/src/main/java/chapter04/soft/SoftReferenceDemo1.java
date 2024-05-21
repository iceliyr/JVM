package chapter04.soft;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
/**
 * 软引用案例1 - Caffeine中的软引用
 */
public class SoftReferenceDemo1 {
    public static void main(String[] args) {
        Cache<Object, Object> build = Caffeine.newBuilder().softValues().build();
    }
}
