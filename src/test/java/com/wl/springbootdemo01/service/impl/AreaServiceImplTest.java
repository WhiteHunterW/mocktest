package com.wl.springbootdemo01.service.impl;

import com.wl.springbootdemo01.dao.AreaDao;
import com.wl.springbootdemo01.entity.Area;
import com.wl.springbootdemo01.service.AreaService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author w.z
 * @date 2019/8/8 16:59
 * service层测试方法
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaServiceImplTest {
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    
    @Test
    public void getAreaList() {
        AreaService areaService = new AreaServiceImpl();

        AreaDao areaDao = mock(AreaDao.class);
        ((AreaServiceImpl) areaService).setAreaDao(areaDao);
        
        List<Area> list = new ArrayList<Area>();
        when(areaDao.listAreas()).thenReturn(list);
        logger.info("list{}",list);
        List<Area> list1 = areaService.getAreaList();
        logger.info("list{}",list1);
        Assert.assertNotNull(list1);
        Assert.assertSame(list,list1);
    }

    @Test
    public void getAreaById() {
        AreaService areaService = new AreaServiceImpl();

        AreaDao areaDao = mock(AreaDao.class);
        ((AreaServiceImpl) areaService).setAreaDao(areaDao);
        
        Area area = new Area();
        area.setAreaId(18);
        area.setAreaName("北苑北");
        area.setPriority(3);
        when(areaDao.getAreaById(18)).thenReturn(area);
        logger.info("area1{}",area);
        Area area1 = new Area();
        area1 = areaService.getAreaById(18);
        logger.info("area1{}",area1);
        Assert.assertSame(area1,area);
    }

    @Test
    public void addArea() {

        AreaService areaService = new AreaServiceImpl();

        AreaDao areaDao = mock(AreaDao.class);
        ((AreaServiceImpl) areaService).setAreaDao(areaDao);
        Area area = new Area();
        area.setAreaName("东北大院1");
        area.setPriority(5);
        
        when(areaDao.insertArea(area)).thenReturn(1);
        logger.info("return={}",areaDao.insertArea(area));
        boolean count = areaService.addArea(area);
        Assert.assertTrue(count);
    }

    @Test
    public void modifyArea() {

        AreaService areaService = new AreaServiceImpl();

        AreaDao areaDao = mock(AreaDao.class);
        ((AreaServiceImpl) areaService).setAreaDao(areaDao);
        
        Area area = new Area();
        area.setAreaId(18);
        area.setAreaName("北苑北");
        area.setPriority(3);
        
        when(areaDao.updateArea(area)).thenReturn(1);
        
       areaService.modifyArea(area);
    }

    @Test
    public void deleteArea() {

        AreaService areaService = new AreaServiceImpl();

        AreaDao areaDao = mock(AreaDao.class);
        ((AreaServiceImpl) areaService).setAreaDao(areaDao);
        
        when(areaDao.deleteArea(2)).thenReturn(1);
        logger.info("resultNum={}",areaDao.deleteArea(2));
        
        areaService.deleteArea(2);
    }
}