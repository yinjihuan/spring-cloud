package com.fangjia.fsh.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yinjihuan
 * @create 2018-01-02 17:24
 **/
@RestController
public class LocalController {
    @GetMapping("/local/{id}")
    public String local(@PathVariable String id) {
        return id;
    }
}
