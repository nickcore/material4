package by.vitsoft.material.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import by.vitsoft.material.dto.Unit;
import by.vitsoft.material.dto.guide.GuideInfo;
import by.vitsoft.material.dto.response.BaseResponse;
import by.vitsoft.material.filter.BaseFilter;
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
    BaseResponse<Unit> getGuideList(@PathVariable String guide, @RequestParam(value = "page") int page,
        @RequestParam(value = "rows") int rows, @RequestParam(value = "sidx") String sidx, @RequestParam(value = "sord") String sord) {
        BaseFilter filter = new BaseFilter(page, rows, sidx, sord);
        return guideService.getGuides(guide, filter);
    }

    @RequestMapping(value="/unit/add", method = RequestMethod.POST)
    @ResponseBody Unit addUnit(@RequestBody Unit unit) {
        return guideService.insertGuide("unit", unit);
    }

    @RequestMapping(value="/unit/update", method = RequestMethod.POST)
    void updateUnit(@RequestBody Unit unit) {
        guideService.updateGuide("unit", unit);
    }
}
