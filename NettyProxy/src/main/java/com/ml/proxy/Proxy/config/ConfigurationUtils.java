package com.ml.proxy.Proxy.config;

import java.io.InputStream;

import org.yaml.snakeyaml.Yaml;

public class ConfigurationUtils {

	public ProxyConfiguration loadConfiguration() {
		Yaml yaml = new Yaml();
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("proxy-config.yml");
		return yaml.loadAs(inputStream, ProxyConfiguration.class);
	}
}