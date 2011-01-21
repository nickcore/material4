package by.vitsoft.material.service;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBElement;
import javax.xml.transform.stream.StreamSource;

import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;
import org.springframework.util.StringUtils;

import by.vitsoft.material.dto.Unit;
import by.vitsoft.material.dto.guide.Guide;
import by.vitsoft.material.filter.BaseFilter;

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

    public <T> void insertGuide(String guideId, T guideObject) {
        getSqlSession().insert("Guide.insert" + StringUtils.capitalize(guideId), guideObject);
    }

    public void deleteGuide(String guideId, Long id) {
        getSqlSession().insert("Guide.delete" + StringUtils.capitalize(guideId), id);
   }

    @SuppressWarnings("unchecked")
    public List<Unit> getUnits(BaseFilter filter) {
        return (List<Unit>) getSqlSession().selectList("Guide.selectAllUnits");
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
