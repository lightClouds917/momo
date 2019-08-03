package com.java4all.momo.nettydemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * netty client starter
 * @author IT云清
 */
@Component
@Order(value = 2)
public class EchoClientStarter implements CommandLineRunner{

    @Override
    public void run(String... strings) throws Exception {
//        new EchoClient("localhost",8888).start();
    }
}
