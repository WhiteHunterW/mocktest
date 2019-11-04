package com.wl.springbootdemo01.controller;


import com.wl.springbootdemo01.entity.Area;
import com.wl.springbootdemo01.service.impl.AreaServiceImpl;
import com.wl.springbootdemo01.util.ResultUtil;
import com.wl.springbootdemo01.vo.ResultVo;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author w.z
 * @date 2019/8/8 16:54
 * 控制层
 */
@RestController
@RequestMapping("/area")
@Api(description = "AreaController API")
@Slf4j
@CrossOrigin
public class AreaController {

    @Autowired
    private AreaServiceImpl areaService;

    /**
     * 查询数据库所有的信息
     *
     * @return
     */
    @ApiOperation(value = "查询区域信息", notes = "查询数据库中所有的区域信息",authorizations = {@Authorization(value="basicAuth")}
    )
    @GetMapping(value = "/listarea")
    public ResultVo queryAll() {
        List<Area> list = areaService.getAreaList();
        return ResultUtil.success(list);
    }

    /**
     * 根据id查询,get方式请求
     *
     * path @PathVariable
     * query @RequestParam
     * header @ResponseHeader
     * body @RequestBody
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id查询区域信息", notes = "查询数据库中某个区域信息")
    @ApiImplicitParam(name = "id", value = "区域id", paramType = "path", required = true, dataType = "int")
    @GetMapping(value = "/area")
    public ResultVo queryById(@RequestParam(value = "id") int id) {
        Area area = areaService.getAreaById(id);
        return ResultUtil.success(area);
    }

    /**
     * 添加数据
     *
     * @param areaName
     * @param priority
     * @return
     */
    @ApiOperation(value = "新增区域信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "areaName", value = "地区名", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "priority", value = "权重", paramType = "query", required = true, dataType = "int")
    })
    @PostMapping(value = "/add")
    @ApiResponse(code = 404,message = "页面找不到")
    public ResultVo addArea(@RequestParam(value = "areaName") String areaName, 
                            @RequestParam(value = "priority") int priority) {
        Area area = new Area();
        area.setAreaName(areaName);
        area.setPriority(priority);
        areaService.addArea(area);
        return ResultUtil.success(area);
    }

    /**
     * 更新数据
     *
     * @param id
     * @param areaName
     * @param priority
     * @return
     */
    @ApiOperation(value = "修改某个区域信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "区域id", paramType = "query", required = true, dataType = "int"),
            @ApiImplicitParam(name = "areaName", value = "地区名", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "priority", value = "权重", paramType = "query", required = true, dataType = "int")
    })
    @PutMapping(value = "/update")
    public ResultVo updateArea(@RequestParam(value = "id",required = true) int id,
                               @RequestParam(value = "areaName",required = true) String areaName,
                               @RequestParam(value = "priority",required = true) int priority) {
        Area area = new Area();
        area.setAreaId(id);
        area.setAreaName(areaName);
        area.setPriority(priority);
        areaService.modifyArea(area);
        return ResultUtil.success(area);
    }

    /**
     * 删除区域信息
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id删除区域信息")
    @ApiImplicitParam(name = "id", value = "区域id", paramType = "query", required = true, dataType = "int")
    @DeleteMapping(value = "/delete")
    public ResultVo deleteArea(@RequestParam(value = "id") int id) {
        areaService.deleteArea(id);
        return ResultUtil.success();
    }
}
