package com.lgh.boot.config;

import ch.qos.logback.core.db.DBHelper;
import com.lgh.boot.bean.Pet;
import com.lgh.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.security.ConditionalOnDefaultWebSecurity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 1、配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的
 * 2、配置类本身也是组件
 * 3、proxyBeanMethods:代理bean的方法
 *   Full(proxyBeanMethods = true)
 *   Lite(proxyBeanMethods = false)
 *   组件依赖必须使用Full模式默认。其他默认是否Lite模式
 * 4、@Import({User.class, DBHelper.class})
 *   给容器中自动创建出这两个类型的组件、默认组件的名字就是全类名
 *
 */
@Import({User.class, DBHelper.class}) // // DBHelper.class 为第三方 jar 包中的类
@Configuration(proxyBeanMethods = true) //告诉SpringBoot这是一个配置类，等同于配置文件
//@ConditionalOnBean(name="tom") //标注在类上，含有tom组件，以下才生效
@ConditionalOnMissingBean(name="tom") //不含有tom组件，以下才生效
public class MyConfig {

    /**
     * 外部无论对配置类中的这个组件注册方法调用多少次获取的都是之前注册容器中的单实例对象
     * @return
     */

//    @ConditionalOnBean(name="tom") //条件装配注解，含有tom组件才生效
    @Bean //给容器中添加组件，以方法名作为组件的id，返回类型就是组件类型，返回的值就是组件在容器中的实例
    public User user01(){
        User zhangsan=new User("zhangsan",18);
        //user组件依赖了Pet组件
        zhangsan.setPet(tomcatPet());
        return zhangsan;
    }

    @Bean("tom22") //如果不想让方法名作为组件名也可以在Bean标签直接给一个自定义的名字
    public Pet tomcatPet(){
        return new Pet("tomcat");
    }
}
