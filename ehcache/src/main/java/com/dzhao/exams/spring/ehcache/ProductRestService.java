package com.dzhao.exams.spring.ehcache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by dzhao on 2/05/2016.
 */
@RestController
@RequestMapping("/api/product")
public class ProductRestService {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    @ResponseBody
    public MyProduct getProductByName(@PathVariable(value = "name") String name){
        return productService.findByName(name);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<MyProduct> getAllProducts(){
        return productService.findAll();
    }
}
