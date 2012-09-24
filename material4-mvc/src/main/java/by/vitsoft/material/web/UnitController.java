package by.vitsoft.material.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
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


    //https://material.vitsoft.by:8443/units.json?page=1&rows=10&sidx=id&sord=asc
    @RequestMapping(value="/units", method = RequestMethod.GET)
    BaseResponse<Unit> getUnits(@RequestParam(value = "page") int page, @RequestParam(value = "rows") int rows,
            @RequestParam(value = "sidx") String sidx, @RequestParam(value = "sord") String sord) {
        BaseFilter filter = new BaseFilter(page, rows, sidx, sord);
        return guideService.getGuides("unit", filter);
    }

    /*
    @RequestMapping(value="/units", method = RequestMethod.GET)
    ModelMap getUnits(@RequestBody BaseFilter filter) { //, BindingResult bindingResult
        return new ModelMap(guideService.getGuides(filter));
        //ModelMap model = new ModelMap("baseFilter", filter);
        //model.put("baseResponse", guideService.getGuides(filter));
        //return model;
    }
    */


}
