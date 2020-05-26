package com.ml.proxy.Proxy;

import com.ml.proxy.Proxy.components.ProxyServer;
import com.ml.proxy.Proxy.config.ConfigurationUtils;

/**
 * @author Axel.flores
 */
public class ProxyApplication {
	
	public static void main(String[] args) {
		ProxyServer proxy = new ProxyServer(new ConfigurationUtils().loadConfiguration());
		proxy.start();
	}
}