package com.dumbo.orejitaspeludas;

import org.springframework.boot.SpringApplication;

public class TestOrejitaspeludasApplication {

	public static void main(String[] args) {
		SpringApplication.from(OrejitaspeludasApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
