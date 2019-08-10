package com.wl.springbootdemo01.dao;

import com.wl.springbootdemo01.entity.Area;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author w.z
 * @date 2019/8/8 16:59
 * dao层测试方法
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AreaDao areaDao;

    @Test
    public void queryArea() {
       List<Area> lists =  areaDao.listAreas();
       logger.info("list{}",lists);
    }

    @Test
    public void queryAreaById() {
        logger.info("area{}",areaDao.getAreaById(1));
    }

    @Test
    public void insertArea() {
        Area area = new Area();
        area.setAreaName("中国上海");
        area.setPriority(8);
        areaDao.insertArea(area);
    }
    
    @Test
    public void updateArea(){
        Area area = new Area();
        area.setAreaId(14);
        area.setAreaName("北京西南");
        area.setPriority(4);
        areaDao.updateArea(area);
    }
    
    @Test
    public void deleteArea(){
        areaDao.deleteArea(3);
    }
}