package com.java4all.momo.util;

import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ITyunqing
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringUtilTest {
    //https://blog.csdn.net/canyanruxue/article/details/83015167


    @Test
    public void testGetAllInterfaces(){
        Class<?>[] allInterfaces = SpringUtil.getAllInterfaces(new D());
        Arrays.stream(allInterfaces).forEach(clazz -> System.out.println(clazz));
    }

    @Test
    public void testGetAllInterfacesDeep(){
        Class<?>[] interfaces = SpringUtil.getAllInterfacesDeep(new D());
        Arrays.stream(interfaces).forEach(clazz->System.out.println(clazz));
    }

    @Test
    public void test(){
        System.out.println("aaaaa"+new D().getClass().getModifiers());
    }

}

interface A{
}
interface B{
}
interface C extends B{
}
class F{
}
class D extends F implements A,C{
}
