package com.idorasi.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "town")
@XmlAccessorType(XmlAccessType.FIELD)
public class Town {

    private String name;

    @XmlElement(name = "libraries")
    private LibraryList libraries = null;

    private Town(String name, LibraryList libraries) {
        this.name = name;
        this.libraries = libraries;
    }

    public Town() {
    }

    public String getName() {
        return name;
    }

    public LibraryList getLibraries() {
        return libraries;
    }

    @Override
    public String toString() {
        return "Town{" +
                "name='" + name + '\'' +
                ", libraries=" + libraries +
                '}';
    }

    public static final class TownBuilder {
        private String name;
        private LibraryList libraries = null;

        private TownBuilder() {
        }

        public static TownBuilder builder() {
            return new TownBuilder();
        }

        public TownBuilder name(String name) {
            this.name = name;
            return this;
        }

        public TownBuilder libraries(LibraryList libraries) {
            this.libraries = libraries;
            return this;
        }

        public Town build() {
            return new Town(name, libraries);
        }
    }
}
