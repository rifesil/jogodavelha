package br.com.rifesil.fique.em.casa.tic.tac.toe.config;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import javax.servlet.ServletContext;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@ExtendWith(MockitoExtension.class)
class TicTacToeConfigTest {

	@InjectMocks
	TicTacToeConfig ticTacToeConfig;
	
	@Mock
	ResourceHandlerRegistry registry;
	
	@Mock
	ServletContext servletContext;

	@Mock
	ApplicationContext applicationContext;
	
	@BeforeEach
	void setUp() {
		ticTacToeConfig = new TicTacToeConfig();
		registry = new ResourceHandlerRegistry(applicationContext, servletContext);
	}
	
	@Test
	void testGreetingApi() {
		Docket doc = new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.rifesil.fique.em.casa.tic.tac.toe.controller"))
				.build().apiInfo(metaData());
		assertThat(ticTacToeConfig.greetingApi().isEnabled(), is(equalTo(doc.isEnabled())));

	}
	private ApiInfo metaData() {
		return new ApiInfoBuilder().title("Jogo da Velha / Tic Tac Toe")
				.description("Valida se uma lista de jogadas houve vencedor no jogo da velha")
				.version("v2")
				.license("by Ricardo Ferreira da Silva").build();

	}
	@Test
	void addResourceHandlers() {
		assertThat(registry, is(equalTo(registry)));
	}

	
}
