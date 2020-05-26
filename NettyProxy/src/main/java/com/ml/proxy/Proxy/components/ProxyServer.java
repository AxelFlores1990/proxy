package com.ml.proxy.Proxy.components;

import com.ml.proxy.Proxy.config.ProxyConfiguration;

import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import reactor.netty.DisposableServer;
import reactor.netty.http.server.HttpServer;
import reactor.netty.http.server.HttpServerRequest;

public class ProxyServer {

	private ProxyConfiguration config;
	
	public ProxyServer(ProxyConfiguration config) {
		this.config = config;
	}
	
	public void start() {
		DisposableServer server = HttpServer.create()
				.host(this.config.getHost())
				.port(this.config.getPort())
				.route(routes -> 
					routes.get("*/**", (req, resp) -> resp.sendRedirect(this.redirectUrl(req)))
						.post("*/**", (req, resp) -> resp.sendRedirect(this.redirectUrl(req)))
						.put("*/**", (req, resp) -> resp.sendRedirect(this.redirectUrl(req)))
						.delete("*/**", (req, resp) -> resp.sendRedirect(this.redirectUrl(req)))
						.options("*/**", (req, resp) -> resp.sendRedirect(this.redirectUrl(req))))
				.tcpConfiguration(tcpServer -> tcpServer.bootstrap(
						serverBootstrap -> serverBootstrap.group(new NioEventLoopGroup(1))
								.channel(NioServerSocketChannel.class)))
				.bindNow();

		server.onDispose().block();
	}
	
	private String redirectUrl(HttpServerRequest request) {
		return this.config.getHostRedirect().concat(request.fullPath());
	}
}