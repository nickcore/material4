package by.vitsoft.material.service;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBElement;
import javax.xml.transform.stream.StreamSource;

import org.apache.ibatis.mapping.ResultMap;
import org.apache.ibatis.mapping.ResultMapping;
import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import by.vitsoft.material.dto.guide.Guide;
import by.vitsoft.material.dto.response.BaseResponse;
import by.vitsoft.material.filter.BaseFilter;
import by.vitsoft.material.filter.Rule;

import static java.text.MessageFormat.format;

//ibatis 2.3
//SqlMapClientDaoSupport
public class GuideServiceImpl extends SqlSessionDaoSupport implements GuideService {
    @Autowired
    private Unmarshaller marshaler;

    private Resource configSource;
    private Guide config;
    private static final Logger LOG = Logger.getLogger(GuideServiceImpl.class);

    public void setConfigSource(Resource configSource) {
        this.configSource = configSource;
    }

    public Guide getConfig() {
        return config;
    }

    @PostConstruct
    public void init() throws XmlMappingException, IOException {
        JAXBElement<Guide> element = (JAXBElement<Guide>) marshaler.unmarshal(new StreamSource(configSource.getInputStream()));
        LOG.debug("Invocation of init methof is succsessfull " + element);
        config = element.getValue();
    }

    public <T> void updateGuide(String guideId, T guideObject) {
        //getSqlMapClientTemplate
        getSqlSession().update("Guide.update" + StringUtils.capitalize(guideId), guideObject);
    }

    public <T> T insertGuide(String guideId, T guideObject) {
        getSqlSession().insert("Guide.insert" + StringUtils.capitalize(guideId), guideObject);
        return guideObject;
    }

    public void deleteGuide(String guideId, Long id) {
        getSqlSession().insert("Guide.delete" + StringUtils.capitalize(guideId), id);
   }

    @SuppressWarnings("unchecked")
    public <T> BaseResponse<T> getGuides(String guideId, BaseFilter filter) {
        String guideIdCap = StringUtils.capitalize(guideId);
        ResultMap rm = getSqlSession().getConfiguration().getResultMap(format("Guide.{0}Result", guideIdCap));

        //convert property name to column name
        Map<String, Rule> rules = new HashMap<String, Rule>();
        if (filter.getRuleSet() != null && !CollectionUtils.isEmpty(filter.getRuleSet().getRules())) {
            for (Rule rule : filter.getRuleSet().getRules()) {
                rules.put(rule.getField(), rule);
            }
        }
        for (ResultMapping item : rm.getResultMappings()) {
            Rule rule = rules.get(item.getProperty());
            if (rule != null) {
                rule.setColumn(item.getColumn());
            }
        }

        //prepare params
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("ruleSet", filter.getRuleSet());

         // Get the requested page. By default grid sets this to 1. 
        long page = filter.getPage(); 
        // get how many rows we want to have into the grid - rowNum parameter in the grid
        long limit = filter.getRows();
        // calculate the number of rows for the query. We need this for paging the result
        long count = (Long) getSqlSession().selectOne(format("Guide.select{0}Count", guideIdCap), params);
        // calculate the total pages for the query
        long totalPages;
        if(count > 0 && limit > 0) { 
            totalPages = count / limit + (count % limit > 0 ? 1 : 0); 
        } else { 
            totalPages = 0; 
        }
        // if for some reasons the requested page is greater than the total 
        // set the requested page to total page 
        if (page > totalPages) page=totalPages;

        // calculate the starting position of the rows
        long start = limit * page - limit + 1;
        // if for some reasons start position is negative set it to 0
        // typical case is that the user type 0 for the requested page
        if (start < 0) start = 0;
        //calculation end position of the rows
        long end = start + limit - 1;


        String sidx = filter.getSidx();
        String scolumn = null;
        String scollate = null;
        for (ResultMapping item : rm.getResultMappings()) {
            if (item.getProperty().equals(sidx)) {
                scolumn = item.getColumn();
                scollate = (item.getJavaType() == String.class ? "collate pxw_cyrl" : "");
                break;
            }
        }

        
        params.put("start", start);
        params.put("end", end);
        params.put("scolumn", scolumn);
        params.put("scollate", scollate);
        params.put("sord", filter.getSord());

        List<T> units = count >0 ? getSqlSession().selectList(format("Guide.select{0}s", guideIdCap), params) : Collections.emptyList();
        return new BaseResponse<T>(page, totalPages, count, units);
    }


    /*
    public void updateUnit(Unit unit) {
        getSqlMapClientTemplate().update("Guide.updateUnit", unit);
    }

    public void insertUnit(Long unitId) {
        getSqlMapClientTemplate().delete("Guide.insertUnit", unitId);
    }

    public void deleteUnit(Long unitId) {
        getSqlMapClientTemplate().delete("Guide.deleteUnit", unitId);
    }
    */
}
