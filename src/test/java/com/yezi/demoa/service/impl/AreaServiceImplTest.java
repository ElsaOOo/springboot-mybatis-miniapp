package com.yezi.demoa.service.impl;

import com.yezi.demoa.entity.TbArea;
import com.yezi.demoa.service.AreaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author: yezi
 * @Date: 2019/4/14 09 46
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaServiceImplTest {
    @Autowired
    AreaService areaService;

    @Test
    public void addOrUpdateArea() {
        TbArea area = new TbArea();
        // area.setAreaId(3);
        area.setAreaName("西苑");
        area.setPriority(2);
        boolean effectedBool =  areaService.addOrUpdateArea(area);
        assertEquals(true, effectedBool);
    }
}