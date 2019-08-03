package com.java4all.momo.nettydemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * echo server starter
 * @author IT云清
 */
@Component
@Order(value = 1)
public class EchoServerStarter implements CommandLineRunner{

    @Override
    public void run(String... strings) throws Exception {
//        new EchoServer(8888).start();
    }
}
