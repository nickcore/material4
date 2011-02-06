package by.vitsoft.material.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import by.vitsoft.material.dto.Unit;
import by.vitsoft.material.dto.response.BaseResponse;
import by.vitsoft.material.filter.BaseFilter;
import by.vitsoft.material.service.GuideService;


@Controller
public class UnitController {

    @Autowired
    GuideService guideService; 

    @RequestMapping(value="/unit", method = RequestMethod.GET)
    ModelMap getUnit() {
        ModelMap model = new ModelMap();
        model.addAttribute("message", "Hello word!");
        return model;
    }

    @RequestMapping(value="/units", method = RequestMethod.GET)
    BaseResponse<Unit> getUnits(@RequestParam(value = "page") int page, @RequestParam(value = "rows") int rows,
            @RequestParam(value = "sidx") String sidx, @RequestParam(value = "sord") String sord) {
        BaseFilter filter = new BaseFilter(page, rows, sidx, sord);
        return guideService.getUnits(filter);
        //return new GridDataHolder<Unit>(1L, 1L, units.size(), units);
        //return new ModelAndView("xmlView", "units", guideService.getUnits().get(0));
    }


}
