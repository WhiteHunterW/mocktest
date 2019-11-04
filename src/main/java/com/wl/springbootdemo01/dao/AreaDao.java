package com.wl.springbootdemo01.dao;

import com.wl.springbootdemo01.entity.Area;

import java.util.List;

/**
 * 持久层接口
 */
public interface AreaDao {

    /**
     * 查询所有的地区信息
     * @return
     */
     List<Area> listAreas();

    /**
     * 根据id查询某个地区信息
     * @return
     */
    Area getAreaById(Integer areaId);

    /**
     * 插入信息返回影响的行数
     * @return
     */
     int insertArea(Area area);

    /**
     * 更新地区信息
     * @return
     */
    int updateArea(Area area);

    /**
     * 删除地区信息
     * @return
     */
     int deleteArea(int areaId);
     
}
