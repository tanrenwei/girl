package com.tanrw.respository;

import com.tanrw.eneity.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Administrator.
 *
 * @create 2017-06-06 下午 3:05
 */
public interface GirlRespository extends JpaRepository<Girl,Integer>{

    //扩展接口，通过年龄查询
    public List<Girl> findByAge(Integer age);
}
