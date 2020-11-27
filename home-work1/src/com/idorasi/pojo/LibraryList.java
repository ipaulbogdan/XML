package com.idorasi.pojo;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "libraries")
@XmlAccessorType(XmlAccessType.FIELD)
public class LibraryList {

    @XmlElement(name = "library")
    List<Library> libraries = null;

    private LibraryList(List<Library> libraries) {
        this.libraries = libraries;
    }

    public LibraryList() {
    }

    public List<Library> getLibraries() {
        return libraries;
    }

    @Override
    public String toString() {
        return "LibraryList{" +
                "libraries=" + libraries +
                '}';
    }

    public static final class LibraryListBuilder {
        List<Library> libraries = null;

        private LibraryListBuilder() {
        }

        public static LibraryListBuilder builder() {
            return new LibraryListBuilder();
        }

        public LibraryListBuilder libraries(List<Library> libraries) {
            this.libraries = libraries;
            return this;
        }

        public LibraryList build() {
            return new LibraryList(libraries);
        }
    }
}

