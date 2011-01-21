package by.vitsoft.material.dto.guide;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.Unmarshaller;


public abstract class AbstractGuide {
    private Map<String, GuideInfo> guideInfos = new HashMap<String, GuideInfo>();
    private Map<String, OperationalInfo> operationalInfos = new HashMap<String, OperationalInfo>();

    public Map<String, GuideInfo> getGuideInfos() {
        return guideInfos;
    }

    public abstract List<Object> getGuideInfoOrOperationalInfoOrLookUpInfo();

    public void afterUnmarshal(Unmarshaller u, Object parent) {
        if (getGuideInfoOrOperationalInfoOrLookUpInfo() != null) {
            for (Object object : getGuideInfoOrOperationalInfoOrLookUpInfo()) {
                if (object instanceof GuideInfo) {
                    GuideInfo guideInfo = (GuideInfo) object;
                    guideInfos.put(guideInfo.getId(), guideInfo);
                } else if (object instanceof OperationalInfo) {
                    OperationalInfo operationalInfo = (OperationalInfo) object;
                    operationalInfos.put(operationalInfo.getId(), operationalInfo);
                }
            }
        }
    }
}
