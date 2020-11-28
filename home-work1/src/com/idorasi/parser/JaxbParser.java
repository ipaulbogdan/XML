package com.idorasi.parser;

import com.idorasi.pojo.Library;
import com.idorasi.pojo.Town;
import com.idorasi.pojo.TownList;
import com.idorasi.util.enums.Genre;
import com.idorasi.util.enums.Zone;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class JaxbParser {

    private TownList townList;

    public JaxbParser() throws JAXBException, SAXException {
        JAXBContext jaxbContext = JAXBContext.newInstance(TownList.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        unmarshaller.setSchema(buildSchema());
        townList = (TownList) unmarshaller.unmarshal(new File("towns.xml"));
    }

    public List<Library> findAllLibrariesByZoneAndGenre(String townName, Zone zone, Genre genre) {
        Town town = townList.getTowns().stream().filter(t -> t.getName().equals(townName)).findFirst()
                .orElseThrow(() -> new RuntimeException("Town with name:" + townName + " was not found!"));

        return town.getLibraries().getLibraries().stream()
                .filter(library -> library.containsGenre(genre))
                .filter(library -> library.getZone().equals(zone))
                .collect(Collectors.toList());
    }

    //adding xsd for validation
    private Schema buildSchema() throws SAXException {
        return SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI).newSchema(new File("towns.xsd"));
    }
}
