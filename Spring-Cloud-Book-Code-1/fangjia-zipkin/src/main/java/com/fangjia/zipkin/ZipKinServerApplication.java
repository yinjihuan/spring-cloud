package com.fangjia.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;
import zipkin.server.EnableZipkinServer;

/**
 * ZipKin Server
 *
 * @author yinjihuan
 * @create 2017-11-28 11:18
 **/
@SpringBootApplication
@EnableZipkinStreamServer
public class ZipKinServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZipKinServerApplication.class, args);
    }
}
