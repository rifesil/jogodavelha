package br.com.rifesil.fique.em.casa.tic.tac.toe.handler;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.context.request.WebRequest;

import br.com.rifesil.fique.em.casa.tic.tac.toe.error.CustomNotFoundException;

@ExtendWith(MockitoExtension.class)
class TicTacToeDefaultExceptionHandlerTest {

	@InjectMocks
	private TicTacToeDefaultExceptionHandler tacToeDefaultExceptionHandler;

	@Mock
	WebRequest request;

	@InjectMocks
	CustomNotFoundException customNotFoundException;

	private Map<Boolean, String> map = new HashMap<Boolean, String>();

	@BeforeEach
	void setUp() {
		map.put(false, "Empate");
		customNotFoundException = new CustomNotFoundException(map.get(false));
	}

	@Test
	void testHandleNotFoundException() {
		assertNotNull(tacToeDefaultExceptionHandler.handleNotFoundException(customNotFoundException));
	}

	@Test
	void testHandleAllExceptions() {
		Exception exception = new Exception("");
		assertNotNull(tacToeDefaultExceptionHandler.handleAllExceptions(exception, request));
	}

}
