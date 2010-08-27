package by.vitsoft.material.service;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import by.vitsoft.material.dto.Unit;


public class GuideServiceImpl extends SqlMapClientDaoSupport implements GuideService {
    @SuppressWarnings("unchecked")
    public List<Unit> getUnits() {
        return (List<Unit>) getSqlMapClientTemplate().queryForList("Guide.selectAllUnits");
    }

    public void updateUnit(Unit unit) {
        getSqlMapClientTemplate().update("Guide.updateUnit", unit);
    }

    public void insertUnit(Long unitId) {
        getSqlMapClientTemplate().delete("Guide.insertUnit", unitId);
    }

    public void deleteUnit(Long unitId) {
        getSqlMapClientTemplate().delete("Guide.deleteUnit", unitId);
    }
}
