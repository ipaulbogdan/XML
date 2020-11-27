package com.idorasi.util.generator;

import java.util.Random;

public class RandomEnumGenerator {

    public static <T extends Enum<T>> T generate(Class<?> clazz) {
        T[] values = (T[]) clazz.getEnumConstants();
        int index = new Random().nextInt(values.length);

        return values[index];
    }
}
