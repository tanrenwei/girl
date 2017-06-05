package com.tanrw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2017-5-25.
 */
@Controller
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;

    //添加一下
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String say() {
        return "index";

    }
}
