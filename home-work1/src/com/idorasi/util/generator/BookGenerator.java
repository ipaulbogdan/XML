package com.idorasi.util.generator;

import com.idorasi.util.enums.Genre;
import com.idorasi.pojo.Book;
import com.idorasi.pojo.BookList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BookGenerator {

    public static BookList generate() {
        return BookList.BookListBuilder.builder()
                .books(generateBooks(new Random().nextInt(50) + 10))
                .build();
    }

    private static List<Book> generateBooks(int count) {
        List<Book> books = new ArrayList<>();

        while (count != 0) {
            books.add(Book.BookBuilder.builder()
                    .title("Title-" + RandomStringGenerator.getAlphaString(5))
                    .author("Author-" + RandomStringGenerator.getAlphaString(5))
                    .genre(RandomEnumGenerator.generate(Genre.class))
                    .build());

            count--;
        }

        return books;
    }
}
