package br.com.rifesil.fique.em.casa.tic.tac.toe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class TicTacToeConfig extends WebMvcConfigurationSupport {

	@Bean
	public Docket greetingApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.rifesil.fique.em.casa.tic.tac.toe.controller"))
				.build().apiInfo(metaData());

	}

	private ApiInfo metaData() {
		return new ApiInfoBuilder().title("Jogo da Velha / Tic Tac Toe")
				.description("Valida se uma lista de jogadas houve vencedor no jogo da velha")
				.version("v2")
				.license("by Ricardo Ferreira da Silva").build();
	}

	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
}
