package com.idorasi;

import com.idorasi.parser.DomParser;
import com.idorasi.parser.JaxbParser;
import com.idorasi.pojo.Library;
import com.idorasi.util.enums.Genre;
import com.idorasi.util.enums.Zone;
import com.idorasi.util.generator.TownGenerator;
import com.idorasi.pojo.TownList;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws JAXBException, IOException, SAXException, ParserConfigurationException {
        //generateDatabase(); used for generating the initial db

//        Does not work. library.getFirstChild().getNextSibling().getNodeValue() is null. Everything is null actually :D
//        DomParser domParser = new DomParser();
//        domParser.findAllLibrariesByZoneAndGenre(Zone.CENTRAL, Genre.CRIME);

        JaxbParser jaxbParser = new JaxbParser();
        List<Library> libraryList = jaxbParser.findAllLibrariesByZoneAndGenre("Town-cZitN", Zone.CENTRAL, Genre.ADVENTURE);
        System.out.println(libraryList);

    }

    public static void generateDatabase() throws JAXBException {
        TownList townlist = TownGenerator.generate(3);

        JAXBContext jaxbContext = JAXBContext.newInstance(TownList.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(townlist, new File("towns.xml"));
    }


}
