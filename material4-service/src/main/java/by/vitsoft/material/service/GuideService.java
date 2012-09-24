package by.vitsoft.material.service;

import by.vitsoft.material.dto.guide.Guide;
import by.vitsoft.material.dto.response.BaseResponse;
import by.vitsoft.material.filter.BaseFilter;

public interface GuideService {

    Guide getConfig();

    <T> BaseResponse<T> getGuides(String guideId, BaseFilter filter);

    <T> void updateGuide(String guideId, T guideObject);

    <T> T insertGuide(String guideId, T guideObject);

     void deleteGuide(String guideId, Long id);
}
