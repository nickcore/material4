package by.vitsoft.material.dto.guide;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.Unmarshaller;


public abstract class AbstractGuideInfo implements Serializable {
    private Map<String, Property> properties = new HashMap<String, Property>();

    public Map<String, Property> getProperties() {
        return properties;
    }

    public abstract PropertySet getPropertySet();

    public void afterUnmarshal(Unmarshaller u, Object parent) {
        if (getPropertySet() != null && getPropertySet().getProperties() != null) {
            for (Property property: getPropertySet().getProperties()) {
                properties.put(property.getName(), property);
            }
        }
    }
}
