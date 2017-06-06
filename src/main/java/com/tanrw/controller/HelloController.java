package com.tanrw.controller;

import com.tanrw.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017-5-25.
 */
@RestController
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value = {"/say","/hi"}, method = {RequestMethod.GET,RequestMethod.POST})
    public Object say(@RequestParam(value = "id" ,defaultValue = "10" ) int id ) {

        return id;

    }
}
