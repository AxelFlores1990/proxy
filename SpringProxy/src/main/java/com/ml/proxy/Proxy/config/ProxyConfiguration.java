package com.ml.proxy.Proxy.config;

import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @author Axel.flores
 */
@Configuration
public class ProxyConfiguration {

	@Bean
	public RouterFunction<ServerResponse> baseRedirectConfiguration(RedirectHandler handler) {
		return route(path("*"), handler::handle);
	}

	@Bean
	public RouterFunction<ServerResponse> nestedsRedirectConfiguration(RedirectHandler handler) {
		return route(path("*/**"), handler::handle);
	}
}