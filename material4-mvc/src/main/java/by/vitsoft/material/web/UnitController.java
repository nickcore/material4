package by.vitsoft.material.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.vitsoft.material.dto.Unit;
import by.vitsoft.material.service.GuideService;


@Controller
public class UnitController {

    @SuppressWarnings("unused")
    private static class GridDataHolder<T> {
        Long page = 1L;
        Long total;
        long records;
        Collection<T> data;

        public GridDataHolder() {
        }

        public GridDataHolder(Long page, Long total, long records, Collection<T> data) {
            super();
            this.page = page;
            this.total = total;
            this.records = records;
            this.data = data;
        }

        public Long getPage() {
            return page;
        }
        public Long getTotal() {
            return total;
        }
        public long getRecords() {
            return records;
        }
        public Collection<T> getData() {
            return data;
        }
    }

    @Autowired
    GuideService guideService; 

    @RequestMapping(value="/unit", method = RequestMethod.GET)
    ModelMap getUnit() {
        ModelMap model = new ModelMap();
        model.addAttribute("message", "Hello word!");
        return model;
    }

    @RequestMapping(value="/units", method = RequestMethod.GET)
    GridDataHolder<Unit> getUnits() {
        //return new ModelAndView("xmlView", "units", guideService.getUnits().get(0));
        return new GridDataHolder(1L, 1L, guideService.getUnits().size(), guideService.getUnits());
    }
}