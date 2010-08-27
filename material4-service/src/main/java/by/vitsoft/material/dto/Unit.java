package by.vitsoft.material.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Unit DTO.
 * @author nick
 */
@XmlRootElement()
public class Unit {

    private long id;
    private long unitId;
    private String unitName;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public long getUnitId() {
        return unitId;
    }

    public void setUnitId(long unitId) {
        this.unitId = unitId;
    }
}
