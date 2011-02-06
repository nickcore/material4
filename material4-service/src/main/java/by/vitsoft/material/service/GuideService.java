package by.vitsoft.material.service;

import java.util.List;

import by.vitsoft.material.dto.Unit;
import by.vitsoft.material.dto.guide.Guide;
import by.vitsoft.material.dto.response.BaseResponse;
import by.vitsoft.material.filter.BaseFilter;

public interface GuideService {

    Guide getConfig();

    BaseResponse<Unit> getUnits(BaseFilter filter);

    <T> void updateGuide(String guideId, T guideObject);

    <T> T insertGuide(String guideId, T guideObject);

     void deleteGuide(String guideId, Long id);
}
