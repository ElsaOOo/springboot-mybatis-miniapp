package com.yezi.demoa.dao;

import com.yezi.demoa.entity.TbArea;

import java.util.List;

/**
 * @Author: yezi
 * @Date: 2019/4/10 07 42
 * @Description:
 */
public interface AreaDao {
    List<TbArea> queryArea();
    TbArea queryAreaById(int areaId);
    int insertArea(TbArea area);
    int updateArea(TbArea area);
    int deleteArea(int areaId);
}
