package com.idorasi.util.generator;

import com.idorasi.pojo.LibraryList;
import com.idorasi.pojo.Town;
import com.idorasi.pojo.TownList;

import java.util.ArrayList;
import java.util.List;

public class TownGenerator {

    public static TownList generate(int count) {
        return TownList.TownListBuilder.builder()
                .towns(generateTowns(count, LibraryGenerator.generate()))
                .build();
    }

    private static List<Town> generateTowns(int count, LibraryList libraryList) {
        List<Town> towns = new ArrayList<>();

        while (count != 0) {
            towns.add(Town.TownBuilder.builder()
                    .name("Town-" + RandomStringGenerator.getAlphaString(5))
                    .libraries(libraryList)
                    .build());

            count--;
        }

        return towns;
    }
}
