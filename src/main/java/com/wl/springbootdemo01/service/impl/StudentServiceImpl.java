package com.wl.springbootdemo01.service.impl;

import com.wl.springbootdemo01.dao.StudentDao;
import com.wl.springbootdemo01.entity.Student;
import com.wl.springbootdemo01.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author w.z
 * @date 2019/11/1 11:06
 */
@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    /**
     * 添加学生信息
     * @param student
     * @return
     */
    @Override
    public boolean insert(Student student) {
        if (student == null){
            log.error("StudetnServiceImpl#insert: student is null.");
        }
        int result = studentDao.insert(student);
        if (result > 0){
            return true;
        } else {
            return false;
        }
    }

    /**
     * 查找学生信息
     * @param studentno
     * @return
     */
    @Override
    public Student select(String studentno) {
        return  studentDao.selectByNo(studentno);
    }
}
