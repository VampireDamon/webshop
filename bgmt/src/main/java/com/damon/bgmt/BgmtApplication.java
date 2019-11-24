package com.damon.bgmt;

//import org.mybatis.spring.annotation.MapperScan;
import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
//@MapperScan("com.damon.bgmt.DAO")
@MapperScan(basePackages= {"com.damon.bgmt.DAO"})
//@MapperScan(basePackages = "com.example.demo.*.dao.*")
public class BgmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(BgmtApplication.class, args);
	}

}
