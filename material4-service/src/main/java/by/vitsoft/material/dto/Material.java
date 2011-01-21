package by.vitsoft.material.dto;

/**
 * Material DTO.
 * @author nick
 *
 */
public class Material {
    private long id;
    private long materialId;
    private long materialName;

    private Unit unit;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getMaterialId() {
        return materialId;
    }
    public void setMaterialId(long materialId) {
        this.materialId = materialId;
    }
    public long getMaterialName() {
        return materialName;
    }
    public void setMaterialName(long materialName) {
        this.materialName = materialName;
    }
    public Unit getUnit() {
        return unit;
    }
    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
