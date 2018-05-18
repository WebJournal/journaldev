package com.journaldev.spring.component;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class HelloWorldRouter {

	@Bean
	public RouterFunction<ServerResponse> routeHelloWorld(HelloWorldHandler helloWorldHandler) {

		return RouterFunctions
			.route(RequestPredicates.GET("/helloWorld").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), helloWorldHandler::helloWorld);
	}
}
