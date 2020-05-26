package com.ml.proxy.Proxy.config;

import java.util.Collections;

import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory;
import org.springframework.boot.web.embedded.netty.NettyServerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import reactor.netty.http.server.HttpServer;

@Configuration
public class NettyConfiguration {

	@Bean
	public NettyReactiveWebServerFactory factory() {
		NettyReactiveWebServerFactory factory = new NettyReactiveWebServerFactory();

		factory.setServerCustomizers(Collections.singletonList(new NettyServerCustomizer() {
			@Override
			public HttpServer apply(HttpServer httpServer) {
				return httpServer.tcpConfiguration(tcpServer -> tcpServer.bootstrap(
						serverBootstrap -> serverBootstrap.group(new NioEventLoopGroup(1), new NioEventLoopGroup(1))
								.channel(NioServerSocketChannel.class)));
			}
		}));

		return factory;
	}
}