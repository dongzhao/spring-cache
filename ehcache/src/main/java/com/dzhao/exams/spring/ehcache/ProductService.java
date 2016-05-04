package com.dzhao.exams.spring.ehcache;

import java.util.List;

/**
 * Created by dzhao on 2/05/2016.
 */
public interface ProductService {
    MyProduct findByName(String name);
    List<MyProduct> findAll();

}
