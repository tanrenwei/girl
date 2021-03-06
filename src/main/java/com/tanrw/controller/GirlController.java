package com.tanrw.controller;

import com.tanrw.eneity.Girl;
import com.tanrw.eneity.Result;
import com.tanrw.respository.GirlRespository;
import com.tanrw.service.GirlService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by Administrator.
 *
 * 创建时间： 2017-06-06 下午 3:03
 */
@RestController
public class GirlController {

    @Resource
    private GirlRespository girlRespository;
    @Resource
    private GirlService girlService;
    @GetMapping("/list")
    //查询所有女生列表
    public List<Girl> girlList(){
        return girlRespository.findAll();
    }
    @PostMapping("/girlAdd")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            Result result = new Result();
            result.setCode(1);
            result.setMsg(bindingResult.getFieldError().getDefaultMessage());
            result.setData(null);
            return result;
        }

        Girl save = girlRespository.save(girl);
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(save);
        return result;
    }

    @GetMapping("/girlQuery/{id}")
    //通过ID查询
    public Girl girlQuery(@PathVariable("id") Integer id){
        return girlRespository.findOne(id);
    }
    @GetMapping("/girlDel/{id}")
    //删除指定ID
    public void girlDelete(@PathVariable("id") Integer id){
        girlRespository.delete(id);
    }

    @GetMapping("/girlUpdate/{id}")
    //更新
    public Girl girlUpdate(@PathVariable("id") Integer id){
        Girl girl = girlRespository.findOne(id);
        girl.setCupSize("A");
        return girlRespository.save(girl);
    }

    @GetMapping("/girlfindByAge/{age}")
    //通过年龄查询
    public List<Girl> findByAge(@PathVariable("age") Integer age){
        return girlRespository.findByAge(age);
    }

    @GetMapping("/insertTwo")
    public void insertTwo(){
        girlService.insertTwo();
    }

}
