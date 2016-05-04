package com.dzhao.exams.spring.ehcache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by dzhao on 2/05/2016.
 */
@Service("productService")
public class ProductServiceImpl implements ProductService{

    @Cacheable(value = "productSearchCache", key = "#name")
    public MyProduct findByName(String name) {
        try {
            Thread.sleep(2*1000);
            System.out.println("findByName is running...");
            return productByName(name);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }

    }

    @Cacheable(value = "productSearchCache")
    public List<MyProduct> findAll() {
        try {
            Thread.sleep(5*1000);
            System.out.println("findAll is running...");
            return allProduct();
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

    private MyProduct productByName(String name){
        MyProduct product = new MyProduct();
        product.setId(1);
        product.setName(name);
        return product;
    }

    private List<MyProduct> allProduct(){
        MyProduct p1 = new MyProduct();
        p1.setId(1);
        p1.setName("iPad");

        MyProduct p2 = new MyProduct();
        p2.setId(2);
        p2.setName("MacBook air");

        MyProduct p3 = new MyProduct();
        p3.setId(3);
        p3.setName("iPhone");

        return Arrays.asList(p1, p2, p3);
    }
}
