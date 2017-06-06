package com.tanrw.controller;

import com.tanrw.eneity.Girl;
import com.tanrw.respository.GirlRespository;
import com.tanrw.service.GirlService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator.
 *
 * @create 2017-06-06 下午 3:03
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
    public String girlAdd(@RequestParam("cupSize") String cupSize,@RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        Girl save = girlRespository.save(girl);
        return save.toString();
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

        Girl save = girlRespository.save(girl);
        return save;
    }

    @GetMapping("/girlfindByAge/{age}")
    //通过年龄查询
    public List<Girl> findByAge(@PathVariable("age") Integer age){
        List<Girl> list = girlRespository.findByAge(age);
        return list;
    }

    @GetMapping("/insertTwo")
    public void insertTwo(){
        girlService.insertTwo();
    }

}
