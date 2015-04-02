package org.springforpro.chptr5.javaconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

@Configuration
@Import(OtherConfig.class)
@ImportResource(value = "classpath:events:events.xml")
@PropertySource(value = "classpath:message.properties")
@ComponentScan(basePackages = {"org.springforpro.chptr5.context"})
//@EnableT
public class AppConfig {
	@Autowired
	Environment env;

	@Bean
	@Lazy(value = true)
	public MessageProvider messageProvider() {
		return new ConfigurableMessageProvider();
	}

	@Bean
	@Scope(value = "prototype")
	@DependsOn(value = {"messageProvider"})
	public MessageRenderer messageRenderer() {
		MessageRenderer renderer = new StandardOutMessageRenderer();
		renderer.setMessageProvider(messageProvider());
		return renderer;
	}
}
