package by.vitsoft.material.service;

import static java.util.Arrays.asList;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

import by.vitsoft.material.dto.Material;
import by.vitsoft.material.dto.Unit;
import by.vitsoft.material.dto.guide.GuideInfo;
import by.vitsoft.material.dto.guide.Property;
import by.vitsoft.material.dto.response.BaseResponse;
import by.vitsoft.material.filter.BaseFilter;
import by.vitsoft.material.filter.GroupOp;
import by.vitsoft.material.filter.Rule;
import by.vitsoft.material.filter.RuleOp;
import by.vitsoft.material.filter.RuleSet;

@Test
@ContextConfiguration(locations={"classpath:spring-dao.xml", "classpath:spring-service.xml"})
@TransactionConfiguration(transactionManager = "jdbcTransactionManager")
public class GuideServiceIntegrationTest extends AbstractTransactionalTestNGSpringContextTests {
//mvn -Dmaven.surefire.debug test
//mvn -Dmaven.surefire.debug="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=8000 -Xnoagent -Djava.compiler=NONE" test
//mvn install -DskipTests
//mvn install -Dmaven.test.skip=true
    Logger LOG = Logger.getLogger(GuideServiceIntegrationTest.class);
    @Autowired
    private GuideService guideService;

    @Autowired ObjectMapper mapper;

    @Test
    public void testInit() {
        List<Object> info = guideService.getConfig().getGuideInfoOrOperationalInfoOrLookUpInfo();
        Assert.assertNotNull(info);
        LOG.debug(info.get(0));

        Map<String, GuideInfo> guides = guideService.getConfig().getGuideInfos();
        Assert.assertNotNull(info);
        GuideInfo guide = guides.get("material");
        Assert.assertNotNull(info);
        LOG.debug(guide);

        Property property = guide.getProperties().get("unit.id");
        Assert.assertNotNull(property);
        LOG.debug(property);
    }

    @Test
    public void testUnit() {
        Unit unit = new Unit();
        unit.setUnitId(300L);
        unit.setUnitName("Плюшка");
        guideService.insertGuide("unit", unit);
        Assert.assertNotNull(unit.getId());
        unit.setUnitName(unit.getUnitName() + 2);
        guideService.updateGuide("unit", unit);
        BaseFilter filter = new BaseFilter(2, 10, "unitName", "asc", 
                new RuleSet(GroupOp.AND, asList(new Rule("unitName", RuleOp.EQUAL, "шт"))));
        BaseResponse<Unit> response = guideService.getGuides("unit", filter);
        LOG.debug(response.toString());

        guideService.deleteGuide("unit", unit.getId());
    }

    @Test
    public void testMaterial() {
        Material material = new Material();
        material.setMaterialId(600300L);
        material.setMaterialName("Конь педальный");
        guideService.insertGuide("material", material);
        Assert.assertNotNull(material.getId());
        material.setMaterialName(material.getMaterialName() + 2);
        guideService.updateGuide("material", material);
        BaseFilter filter = new BaseFilter(2, 10, "materialName", "asc", 
                new RuleSet(GroupOp.AND, asList(new Rule("materialName", RuleOp.CONTAINS, "пед"))));
        BaseResponse<Unit> response = guideService.getGuides("material", filter);
        LOG.debug(response.toString());

        guideService.deleteGuide("material", material.getId());
    }

    
    @Test
    public void testFilter() throws JsonGenerationException, JsonMappingException, IOException {
        LOG.debug("Test JSON serialization of deserialization of the filter");


        List<Rule> rules = asList(new Rule("unitName", RuleOp.EQUAL, "шт"));
        RuleSet rs = new RuleSet(GroupOp.AND, rules);
        BaseFilter filter = new BaseFilter(2, 10, "unitName", "asc", rs);
        LOG.debug(mapper.writeValueAsString(filter));

        String rsString = "{\"groupOp\":\"AND\",\n"
            + "\"rules\":[\n"
            + "     {\"field\":\"invdate\",\"op\":\"ge\",\"data\":\"2007-10-06\"},\n"
            + "     {\"field\":\"invdate\",\"op\":\"le\",\"data\":\"2007-10-20\"},\n" 
            + "     {\"field\":\"name\",\"op\":\"bw\",\"data\":\"Client 3\"}\n"
            +"]}\n";
        LOG.debug(rsString);
        rs = mapper.readValue(rsString, RuleSet.class);
        LOG.debug(rs);
    }
}
