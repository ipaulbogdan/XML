package com.idorasi.util.generator;

import com.idorasi.util.enums.Zone;
import com.idorasi.pojo.BookList;
import com.idorasi.pojo.Library;
import com.idorasi.pojo.LibraryList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LibraryGenerator {

    public static LibraryList generate() {
        return LibraryList.LibraryListBuilder.builder()
                .libraries(generateLibraries(new Random().nextInt(8) + 2, BookGenerator.generate()))
                .build();
    }

    public static List<Library> generateLibraries(int count, BookList books) {
        List<Library> libraries = new ArrayList<>();

        while (count != 0) {
            libraries.add(Library.LibraryBuilder.builder()
                    .name("Library-" + RandomStringGenerator.getAlphaString(5))
                    .zone(RandomEnumGenerator.generate(Zone.class))
                    .bookList(books)
                    .build());

            count--;
        }

        return libraries;
    }
}
