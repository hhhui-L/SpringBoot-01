package com.lgh.boot;

import com.lgh.boot.bean.Pet;
import com.lgh.boot.bean.User;
import com.lgh.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * 主程序类
 * * @SpringBootApplication：这是一个SpringBoot应用
 * scanBasePackages来指定扫描的基础包就是com.cky,也就是将整个包层级放大一点，让它来进行扫描
 */
/*方法1*/
//@SpringBootApplication(scanBasePackages = "com.lgh")
/*方法2*/
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan("com.lgh")
//只存在@SpringBootApplication相当于在ComponentScan("com.lgh.boot")路径下，无法扫描
public class MainApplication {

    public static void main(String[] args) {
        //1.返回我们IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
        //2.查看容器里面的组件
        String[] names = run.getBeanDefinitionNames();
        for(String name:names){
            System.out.println(name);
        }
        //3.从容器中获取组件
        Pet tom01=run.getBean("tom", Pet.class);
        Pet tom02=run.getBean("tom",Pet.class);
        System.out.println("组件："+(tom01==tom02));

        //4.com.lgh.boot.config.MyConfig$$EnhancerBySpringCGLIB$$beeca609@5b6e8f77
        MyConfig bean = run.getBean(MyConfig.class);
        System.out.println(bean);

        //如果@Configuration(proxyBeanMethods = true)代理对象调用方法。SpringBoot总会检查这个组件是否在容器中有
        //保持组件单实例
        User user = bean.user01();
        User user1 = bean.user01();
        System.out.println(user==user1);

        User user01 = run.getBean("user01", User.class);
        Pet tom = run.getBean("tom", Pet.class);
        System.out.println("用户的宠物："+(user01.getPet()==tom));

    }
}