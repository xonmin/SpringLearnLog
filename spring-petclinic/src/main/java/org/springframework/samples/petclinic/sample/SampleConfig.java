package org.springframework.samples.petclinic.sample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class SampleConfig {
	//자바 설정파일

	@Bean
	public SampleController sampleController(){
		return new SampleController();
		//Bean 	직접 정의
		//return 값이 IOC 컨테이너 안에 bean으로 등록이된다.
		// 따라서 sampleContorller에 @controller를 어노테이션 안해도된다.

	}
}
