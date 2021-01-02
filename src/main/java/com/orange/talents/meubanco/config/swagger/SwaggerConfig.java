package com.orange.talents.meubanco.config.swagger;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.client.LinkDiscoverer;
import org.springframework.hateoas.client.LinkDiscoverers;
import org.springframework.hateoas.mediatype.collectionjson.CollectionJsonLinkDiscoverer;
import org.springframework.plugin.core.SimplePluginRegistry;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket zupAPI() {
		return new Docket(DocumentationType.SWAGGER_2)
				 .select() .apis(RequestHandlerSelectors.basePackage("com.orange.talents.meubanco.controller"))
				 .paths(PathSelectors.any()) .build() .apiInfo(infogeral());
	}
	
	@Bean
    public LinkDiscoverers discoverers() {
        List<LinkDiscoverer> plugins = new ArrayList<>();
        plugins.add(new CollectionJsonLinkDiscoverer());
        return new LinkDiscoverers(SimplePluginRegistry.create(plugins));

    }
	
	private ApiInfo infogeral() {
		return new ApiInfo("",
				"[ Projeto Orange Talents ] API RESTful 'Meu Banco' com dois endpoints para a entidade Pessoa. ",
				"1.0", "Terms of Service", new springfox.documentation.service.Contact
				("Ewerton Cordeiro Miranda", "https://github.com/ewertoncmiranda", "sonardevplus@gmail.com"),
				"Apache License Version 2.0" ,
				"https://www.apache.org/licenses/LICENSE-2.0" , 
				new ArrayList<VendorExtension>());
	}
	
	

}
