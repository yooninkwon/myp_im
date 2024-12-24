package com.tech.im.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

//이메일 인증번호 보낼 때 응답시간이 길어 비동기 방식으로 하기 위함
@Configuration
@EnableAsync
public class AsyncConfig {

}
