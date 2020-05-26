package com.ml.proxy.Proxy.config;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

/**
 * @author Axel.flores
 */
@Component
public class RedirectHandler {

	private Map<String, String> cache = new HashMap<>();
	
	public Mono<ServerResponse> handle(ServerRequest request) {
		return ServerResponse.temporaryRedirect(URI.create(this.formatUrl(request.uri().toString()))).build();
	}
	
	private String formatUrl(String url) {
		return this.cache.computeIfAbsent(url, v -> url.toString().replace("localhost:8080", "localhost:8081"));
	}
}
