package com.tanrw.service;

import com.tanrw.respository.GirlRespository;
import com.tanrw.eneity.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator.
 *
 * @create 2017-06-06 下午 3:39
 */
@Service
@Transactional
public class GirlService {
    @Autowired
    private GirlRespository girlRespository;

    public void insertTwo(){
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(22);
        Girl girlB = new Girl();
        girlB.setCupSize("B");
        girlB.setAge(23);
        girlRespository.save(girlA);
        girlRespository.save(girlB);
    }
}