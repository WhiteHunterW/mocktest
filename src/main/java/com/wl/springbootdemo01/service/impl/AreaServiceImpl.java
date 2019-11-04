package com.wl.springbootdemo01.service.impl;

import com.wl.springbootdemo01.dao.AreaDao;
import com.wl.springbootdemo01.entity.Area;
import com.wl.springbootdemo01.service.AreaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author w.z
 * @date 2019/8/8 16:59
 * 业务逻辑层实现类
 */
@Service
@Slf4j
public class AreaServiceImpl implements AreaService {

    @Resource
    private AreaDao areaDao;

    @Override
    public List<Area> getAreaList() {
        return areaDao.listAreas();
    }

    @Override
    public Area getAreaById(Integer areaId) {
        return areaDao.getAreaById(areaId);
    }

    @Override
    public boolean addArea(Area area) {
        if (area.getAreaName() != null && area.getAreaName() != "") {
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            int effectNum = areaDao.insertArea(area);
            if (effectNum > 0) {
                log.info("添加成功");
                return true;
            } else {
                log.info("添加失败");
                return false;
            }
        } else {
            log.info("区域名不能为空");
            return false;
        }
    }
    
    @Override
    public void modifyArea(Area area) {
        if (area.getAreaId() != null) {
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            int effectNum = areaDao.updateArea(area);
            if (effectNum > 0) {
                log.info("修改成功");
            } else {
                log.info("修改错误");
            }
        } else {
            log.info("区域id不能为空");
        }
    }

    @Override
    public void deleteArea(Integer areaId) {
        int effectNum = areaDao.deleteArea(areaId);
        if (effectNum > 0) {
            log.info("删除成功");
        } else {
            log.info("删除失败");
        }
    }

    public void setAreaDao(AreaDao areaDao) {
        this.areaDao = areaDao;
    }
}
