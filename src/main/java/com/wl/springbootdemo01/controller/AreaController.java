package com.wl.springbootdemo01.controller;


import com.wl.springbootdemo01.entity.Area;
import com.wl.springbootdemo01.service.impl.AreaServiceImpl;
import com.wl.springbootdemo01.util.ResultUtil;
import com.wl.springbootdemo01.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author w.z
 * @date 2019/8/8 16:54
 * 控制层
 */
@Controller
@RequestMapping("/area")
public class AreaController {
    
    @Autowired
    private AreaServiceImpl areaService;

    /**
     * 查询数据库所有的信息
     * @return
     */
    @RequestMapping(value = "/listarea", method = RequestMethod.GET)
    @ResponseBody
    public ResultVo queryAll(){
        List<Area> list = areaService.getAreaList();
        return ResultUtil.success(list);
    }

    /**
     * 根据id查询,get方式请求
     * @param id
     * @return
     */
    @RequestMapping(value = "/area", method = RequestMethod.GET)
    @ResponseBody
    public ResultVo queryById(Integer id){
        Area area = areaService.getAreaById(id);
        return ResultUtil.success(area);
    }

    /**
     * 添加数据
     * @param areaName
     * @param priority
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo addArea(String areaName, Integer priority){
            Area area = new Area();
            area.setAreaName(areaName);
            area.setPriority(priority);
            areaService.addArea(area);
            return ResultUtil.success(area);
    }

    /**
     * 更新数据
     * @param id
     * @param areaName
     * @param priority
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public ResultVo updateArea(Integer id,String areaName, Integer priority){
        Area area = new Area();
        area.setAreaId(id);
        area.setAreaName(areaName);
        area.setPriority(priority);
        areaService.modifyArea(area);
        return ResultUtil.success(area);
    }

    /**
     * 删除区域信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public ResultVo deleteArea(int id){
        areaService.deleteArea(id);
        return ResultUtil.success();
    }
}
