package ru.pas.zhukov.thinkpadnavigator;

import org.springframework.boot.SpringApplication;

public class TestThinkpadNavigatorApplication {

	public static void main(String[] args) {
		SpringApplication.from(ThinkpadNavigatorApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
