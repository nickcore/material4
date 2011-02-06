package by.vitsoft.material.service;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

import by.vitsoft.material.dto.Unit;
import by.vitsoft.material.dto.guide.GuideInfo;
import by.vitsoft.material.dto.guide.Property;
import by.vitsoft.material.dto.response.BaseResponse;
import by.vitsoft.material.filter.BaseFilter;

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
        BaseResponse<Unit> response = guideService.getUnits(new BaseFilter(2, 10, "unitName", "asc"));
        LOG.debug(response.toString());

        guideService.deleteGuide("unit", unit.getId());
    }
}
