package com.wl.springbootdemo01.controller;

import com.wl.springbootdemo01.entity.Student;
import com.wl.springbootdemo01.service.StudentService;
import com.wl.springbootdemo01.util.ResultUtil;
import com.wl.springbootdemo01.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author w.z
 * @date 2019/11/1 11:12
 */
@RestController
@RequestMapping("/student")
@Api(description = "StudentApi")
public class StudentController {
    
    @Autowired
    private StudentService studentService;
    
    @PostMapping("/add")
    @ApiOperation(value = "新增学生信息")
    public ResultVo add(@ApiParam(name = "传入对象",value = "json格式",required = true) @RequestBody Student student){
        boolean result = studentService.insert(student);
        if (result){
            return ResultUtil.success();
        } else {
            return ResultUtil.error("新增出错");
        }
    }
    
    @GetMapping("/select")
    @ApiOperation(value = "根据学号查询")
    @ApiImplicitParam(name = "studentno",value = "学号",required = true,paramType = "query",dataType ="String" )
    public ResultVo query(@RequestParam String studentno){
        Student student = studentService.select(studentno);
        return ResultUtil.success(student);
    }

    /**
     * swagger上传文档测试
     * @param file
     * @return
     */
    @ApiOperation(value = "文档测试")
    @PostMapping(value = "/upload",headers = "content-type=multipart/form-data")
    public ResultVo file(@ApiParam(value = "文件",required = true) MultipartFile file){
        return ResultUtil.success();
    }
}
