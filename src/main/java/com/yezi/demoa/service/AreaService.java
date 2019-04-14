package com.yezi.demoa.service;

import com.yezi.demoa.entity.TbArea;

import java.util.List;

/**
 * @Author: yezi
 * @Date: 2019/4/11 08 06
 * @Description:
 */
public interface AreaService {

    List<TbArea> queryArea();
    TbArea queryAreaById(int areaId);
    boolean insertArea(TbArea area);
    boolean updateArea(TbArea area);
    boolean deleteArea(int areaId);
    boolean addOrUpdateArea(TbArea area);
}
