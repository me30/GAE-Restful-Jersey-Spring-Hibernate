package com.commons.config;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;


public class AppResourceConfig extends ResourceConfig {
	public AppResourceConfig() {
		this.packages("com.commons;org.codehaus.jackson.jaxrs");
		this.register(JacksonJsonProvider.class);
		this.register(JacksonFeature.class);
		this.register(MultiPartFeature.class);
		

	}
}
