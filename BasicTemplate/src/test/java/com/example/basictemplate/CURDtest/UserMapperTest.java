package com.example.basictemplate.CURDtest;

import com.example.basictemplate.mapper.userMapper;
import com.example.basictemplate.model.user;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

// SpringBoot用@SpringBootTest注解替代了spring-test中的@ContextConfiguration注解，该注解可以创建ApplicationContext,而且还添加了一些其他注解来测试特定的应用
/*
* 使用 @SpringBootTest 的 WebEnvironment 属性来修改测试的运行方式。
*    MOCK：加载 Web 应用程序上下文并提供模拟的 Web 环境。该注解不会启动嵌入的服务器，可以结合@AutoConfigureMockMvc 和 @AutoConfigureWebTest-Client 注解使用。
*    RANDOM_PORT：加载 WebServerApplicationContext 并提供真实的 Web环境，嵌入的服务器启动后可以监听随机端口。
*    DEFINED_PORT：加载 WebServerApplicationContext 并提供真实的 Web 环境，嵌入的服务器启动后可以监听特定的端口。特定的端口可以从 application.properties 获取，也可以设置为默认的 8080 端口。
*    NONE：使用 SpringApplication 加载 ApplicationContext，但不提供任何 Web 环境
*/
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.NONE)
@MapperScan({"com.example.basictemplate.mapper"})
public class UserMapperTest {

    @Test
    void userSelectAllTest(@Autowired userMapper usermapper){
        user users=usermapper.selectByPrimaryKey(1);
        System.out.println(users.toString());
    }
}
