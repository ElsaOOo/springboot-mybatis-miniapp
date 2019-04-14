package com.yezi.demoa.controller;

import com.yezi.demoa.entity.TbArea;
import com.yezi.demoa.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: yezi
 * @Date: 2019/4/11 08 22
 * @Description:
 */
@RestController
@RequestMapping(value = "/superadmin")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @GetMapping(value = "/listarea")
    private Map<String, Object> listArea() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<TbArea> list = areaService.queryArea();
        modelMap.put("areaList", list);
        return modelMap;
    }

    @RequestMapping(value = "/getareabyid", method = { RequestMethod.GET, RequestMethod.POST })
    private Map<String, Object> getAreaById( Integer areaId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        TbArea area = areaService.queryAreaById(areaId);
        modelMap.put("area", area);
        modelMap.put("success", true);
        return modelMap;
    }

    @PostMapping(value = "/addOrUpdateArea")
    private Map<String, Object> addOrUpdateArea(@RequestBody TbArea area) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", areaService.addOrUpdateArea(area));
        return modelMap;
    }

    @PostMapping(value = "/insertarea")
    private Map<String, Object> insertArea(@RequestBody TbArea area) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", areaService.insertArea(area));
        return modelMap;
    }

    @PostMapping(value = "/updatearea")
    private Map<String, Object> updateArea(@RequestBody TbArea area) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", areaService.updateArea(area));
        return modelMap;
    }

    @GetMapping(value = "/deleteareabyid")
    private Map<String, Object> deleteArea(Integer areaId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", areaService.deleteArea(areaId));
        return modelMap;
    }
}
