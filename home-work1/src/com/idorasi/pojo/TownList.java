package com.idorasi.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "towns")
@XmlAccessorType(XmlAccessType.FIELD)
public class TownList {

    @XmlElement(name = "town")
    private List<Town> towns = null;

    private TownList(List<Town> towns) {
        this.towns = towns;
    }

    public TownList() {
    }

    public List<Town> getTowns() {
        return towns;
    }

    @Override
    public String toString() {
        return "TownList{" +
                "towns=" + towns +
                '}';
    }

    public static final class TownListBuilder {
        private List<Town> towns = null;

        private TownListBuilder() {
        }

        public static TownListBuilder builder() {
            return new TownListBuilder();
        }

        public TownListBuilder towns(List<Town> towns) {
            this.towns = towns;
            return this;
        }

        public TownList build() {
            return new TownList(towns);
        }
    }
}
