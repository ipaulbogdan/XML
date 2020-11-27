package com.idorasi.converter.dom;

import com.idorasi.pojo.Book;
import com.idorasi.pojo.BookList;
import com.idorasi.util.dom.NodeListConverter;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.List;
import java.util.stream.Collectors;

public class BookListConverter {

    BookConverter bookConverter;

    public BookListConverter() {
        bookConverter = new BookConverter();
    }

    public BookList convertFromNode(Node bookListNode) {
        return BookList.BookListBuilder.builder()
                .books(retrieveBooksList(bookListNode.getChildNodes()))
                .build();
    }

    private List<Book> retrieveBooksList(NodeList childNodes) {
        return NodeListConverter.convertToList(childNodes)
                .stream()
                .map(bookConverter::convertFromNode)
                .collect(Collectors.toList());
    }
}
