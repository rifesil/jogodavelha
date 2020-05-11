package br.com.rifesil.fique.em.casa.tic.tac.toe.handler;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.context.request.WebRequest;

import br.com.rifesil.fique.em.casa.tic.tac.toe.error.CustomNotFoundException;

@ExtendWith(MockitoExtension.class)
class TicTacToeDefaultExceptionHandlerTest {

	@Mock
	private TicTacToeDefaultExceptionHandler tacToeDefaultExceptionHandler;

	@Mock
	WebRequest request;
	
	@Mock
	CustomNotFoundException exception;
	
	@BeforeEach
	void setUp() {
		exception = new CustomNotFoundException("");
	}
	@Test
	void testHandleNotFoundException() {
		CustomNotFoundException exception = new CustomNotFoundException("");
		assertNull(tacToeDefaultExceptionHandler.handleNotFoundException(new CustomNotFoundException(exception.getMessage())));
	}

	@Test
	void testHandleAllExceptions() {
		Exception exception = new Exception("");
		assertNotNull(tacToeDefaultExceptionHandler.handleAllExceptions(exception, request));
		
	}

}
