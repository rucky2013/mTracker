package com.ccoe.build.service.config;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;


public class BuildServiceConfig {

	public BuildServiceConfigBean get(String configName) {
		Client client = ClientBuilder.newClient(new ClientConfig());
		client.register(JacksonFeature.class);

		String target = "http://${HOSTNAME}/build-service/webapi/";
		String path = "/config/" + configName;
		BuildServiceConfigBean configBean = client.target(target).path(path).request().get(BuildServiceConfigBean.class);
		
		return configBean;
	}
	
	public static void main(String[] args) {
		//System.out.println(new BuildServiceConfig().get("${CONFIG.NAME}").isGlobalSwitch());
	}
}