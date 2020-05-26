package com.ml.proxy.Proxy.config;

import java.util.Map;

/**
 * @author Axel.flores
 */
public class ProxyConfiguration {

	private String host;
	private int port;
	private String hostRedirect;
	private Map<String, String> pathRedirects;
	
	public String getHost() {
		return host;
	}
	
	public void setHost(String host) {
		this.host = host;
	}
	
	public int getPort() {
		return port;
	}
	
	public void setPort(int port) {
		this.port = port;
	}
	
	public String getHostRedirect() {
		return hostRedirect;
	}
	
	public void setHostRedirect(String hostRedirect) {
		this.hostRedirect = hostRedirect;
	}
	
	public Map<String, String> getPathRedirects() {
		return pathRedirects;
	}
	
	public void setPathRedirects(Map<String, String> pathRedirects) {
		this.pathRedirects = pathRedirects;
	}
	
	public String getHostPort() {
		return host.concat(String.valueOf(this.port));
	}
}