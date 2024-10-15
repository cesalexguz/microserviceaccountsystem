package com.report.accountstatement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.report.accountstatement.services.client")
@EnableDiscoveryClient
@EnableHystrix
@ImportAutoConfiguration({FeignAutoConfiguration.class})
public class AccountstatementApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountstatementApplication.class, args);
	}

}
