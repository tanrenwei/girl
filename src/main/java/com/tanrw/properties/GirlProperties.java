package com.tanrw.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017-5-26.
 */
@ConfigurationProperties(prefix = "girl1")
@Component
public class GirlProperties {
    private String cupsize;
    private int age;

    public String getCupsize() {
        return cupsize;
    }

    public void setCupsize(String cupsize) {
        this.cupsize = cupsize;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "GirlProperties{" +
                "cupsize='" + cupsize + '\'' +
                ", age=" + age +
                '}';
    }
}
