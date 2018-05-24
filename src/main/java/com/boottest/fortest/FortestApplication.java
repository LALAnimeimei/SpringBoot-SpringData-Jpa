package com.boottest.fortest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*该注解开启了Spring的组件扫描和springboot的自动配置功能，相当于将以下三个注解组合在了一起,但路径都是默认路径下,即本类所在的目录路径下扫描

（1）@Configuration：表名该类使用基于Java的配置,将此类作为配置类

（2）@ComponentScan：启用注解扫描

（3）@EnableAutoConfiguration：开启springboot的自动配置功能
 */
public class FortestApplication {

	public static void main(String[] args) {
		SpringApplication.run(FortestApplication.class, args);
	}
}
