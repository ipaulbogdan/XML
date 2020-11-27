package com.idorasi.parser;

import com.idorasi.converter.dom.LibraryConverter;
import com.idorasi.util.enums.Genre;
import com.idorasi.util.enums.Zone;
import com.idorasi.pojo.Library;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DomParser {

    private Document document;

    public DomParser() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        document = builder.parse(new File("towns.xml"));
    }

    public List<Library> findAllLibrariesByZoneAndGenre(Zone zone, Genre genre) {
        LibraryConverter libraryConverter = new LibraryConverter();

        return filterLibraryByZone(document.getElementsByTagName("library"), zone)
                .stream()
                .filter(libraryNode -> isGenrePresent(libraryNode.getChildNodes(), genre))
                .map(libraryConverter::convertFromNode)
                .collect(Collectors.toList());
    }

    private List<Node> filterLibraryByZone(NodeList libraries, Zone zone) {
        List<Node> libraryList = new ArrayList<>();

        for (int i = 0 ; i < libraries.getLength() ; i++) {
            Node library  = libraries.item(i);
            if (library.getFirstChild().getNextSibling().getNodeValue().equals(zone.name())) {
                libraryList.add(library);
            }
        }

        return libraryList;
    }

    private boolean isGenrePresent(NodeList booksNodeList, Genre genre) {
        for (int i = 0; i < booksNodeList.getLength(); i++) {
            Node book =  booksNodeList.item(i);
            if (book.getLastChild().getNodeValue().equals(genre.name())) {
                return true;
            }
        }

        return false;
    }
}
