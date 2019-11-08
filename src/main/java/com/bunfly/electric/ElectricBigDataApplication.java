package com.bunfly.electric;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @date: 2019/07/16
 * @author: 范林茂
 */
@SpringBootApplication
@MapperScan("com.bunfly.electric.dao")
public class ElectricBigDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElectricBigDataApplication.class, args);
	}

}
