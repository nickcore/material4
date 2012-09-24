/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.vitsoft.material.dto.guide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.codehaus.jackson.annotate.JsonIgnore;


public abstract class AbstractProperty {
    private volatile List<LookUpInfo> lookUps = null;


    public List<LookUpInfo> getLookUps() {
        List<LookUpInfo> result = lookUps;
        if (result == null) {
            synchronized(this) {
                result = lookUps;
                if (result == null) {
                    lookUps = result = createLookUps();
                }
            }
        }
        return result;
    }

    private List<LookUpInfo> createLookUps() {
        if (getLookUpElements() != null) {
            List<LookUpInfo> result = new ArrayList<LookUpInfo>();
            for (JAXBElement<Object> element: getLookUpElements()) {
                result.add((LookUpInfo)element.getValue());
            }
            return result;
        } else {
            return Collections.emptyList();
        }
    }
    
    @JsonIgnore
    public abstract List<JAXBElement<Object>> getLookUpElements();
}

