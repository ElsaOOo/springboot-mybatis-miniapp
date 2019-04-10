package com.yezi.demoa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoaApplicationTests {
    @Value("${spring.datasource.driver-class-name}")
    private String jdbcDriver;

    @Test
    public void testPrintProperty() {

        System.out.println(jdbcDriver);
    }

}
