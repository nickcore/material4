package by.vitsoft.material.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import by.vitsoft.material.dto.Unit;
import by.vitsoft.material.dto.guide.GuideInfo;
import by.vitsoft.material.dto.response.BaseResponse;
import by.vitsoft.material.service.GuideService;

@Controller
@RequestMapping("/api")
public class GuideController {
    @Autowired
    GuideService guideService; 

    @RequestMapping(value="/{guide}/info", method = RequestMethod.GET)
    GuideInfo getGuideInfo(@PathVariable String guide) {
        return guideService.getConfig().getGuideInfos().get(guide);
    }

    @RequestMapping(value="/{guide}/list", method = RequestMethod.GET)
    BaseResponse<Unit> getGuideList(@PathVariable String guide) {
        //GuideInfo info = guideService.getConfig().getGuideInfos().get(guide);
        return guideService.getUnits(null);
    }

    @RequestMapping(value="/unit/add", method = RequestMethod.POST)
    @ResponseBody Unit addUnit(@RequestBody Unit unit) {
        return guideService.insertGuide("unit", unit);
    }
}
