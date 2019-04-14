package com.yezi.demoa.service.impl;

import com.yezi.demoa.dao.AreaDao;
import com.yezi.demoa.entity.TbArea;
import com.yezi.demoa.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Author: yezi
 * @Date: 2019/4/11 08 07
 * @Description:
 */
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public List<TbArea> queryArea() {
        return areaDao.queryArea();
    }

    @Override
    public TbArea queryAreaById(int areaId) {
        return areaDao.queryAreaById(areaId);
    }

    @Transactional
    @Override
    public boolean addOrUpdateArea(TbArea area) {
        // 编辑
        if (area.getAreaId() != null && area.getAreaId() > 0) {
            return updateArea(area);
        } else if (area.getAreaName() != null && !"".equals(area.getAreaName())){
            return insertArea(area);
        } else {
            throw new RuntimeException("修改区域信息失败!");
        }
    }

    // Transactional事务回滚默认是RUNtime异常的时候回滚
    @Transactional
    @Override
    public boolean insertArea(TbArea area) {
        area.setCreateTime(new Date());
        area.setLastEditTime(new Date());
        try {
            int effectedNum = areaDao.insertArea(area);
            if (effectedNum > 0) {
                return true;
            } else {
                throw new RuntimeException("插入区域信息失败!");
            }
        } catch (Exception e) {
            throw new RuntimeException("插入区域信息失败:" + e.getMessage());
        }
    }

    @Override
    public boolean updateArea(TbArea area) {
        // 空值判断，主要是AreaId不为空

        // 设置默认值
        area.setLastEditTime(new Date());
        try {
            // 更新区域信息
            int effectedNum = areaDao.updateArea(area);
            if (effectedNum > 0) {
                return true;
            } else {
                throw new RuntimeException("更新区域信息失败!");
            }
        } catch (Exception e) {
            throw new RuntimeException("更新区域信息失败: " + e.getMessage());
        }
    }

    @Override
    public boolean deleteArea(int areaId) {
        int effectedNum = areaDao.deleteArea(areaId);
        if (effectedNum > 0) {
            return true;
        } else {
            throw new RuntimeException("删除区域信息失败!");
        }
    }
}
