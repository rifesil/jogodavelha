package br.com.rifesil.fique.em.casa.tic.tac.toe.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import br.com.rifesil.fique.em.casa.tic.tac.toe.dto.RequestDTO;
import br.com.rifesil.fique.em.casa.tic.tac.toe.dto.ResponseDTO;
import br.com.rifesil.fique.em.casa.tic.tac.toe.error.CustomNotFoundException;
import br.com.rifesil.fique.em.casa.tic.tac.toe.service.TicTacToeService;

@ExtendWith(MockitoExtension.class)
class TicTacToeControllerTest {

	@InjectMocks
	TicTacToeController controller;
	@Mock
	TicTacToeService service;
	@Mock
	RequestDTO requestDTO;
	@Mock
	ResponseDTO responseDTO;
	@Mock
	List<String> jogo;
			
	@BeforeEach
	void setUp() {
		service = new TicTacToeService();
		controller = new TicTacToeController(service);
		jogo = new ArrayList<String>();

	}

	@Test
	void testDiagonalDireita() throws Exception {
		jogo = new ArrayList<String>();
		jogo.add("XXO");
		jogo.add("XOX");
		jogo.add("OOX");
		requestDTO = new RequestDTO(jogo);
		responseDTO = new ResponseDTO(true, "Ganhou | O | Diagonal para Direita");
		assertThat(controller.isVelha(requestDTO), is(equalTo(ResponseEntity.ok().body(responseDTO))));
	}
	
	@Test
	void testDiagonalEsquerda() throws Exception {
		jogo = new ArrayList<String>();
		jogo.add("OXO");
		jogo.add("OOX");
		jogo.add("XOO");
		requestDTO = new RequestDTO(jogo);
		responseDTO = new ResponseDTO(true, "Ganhou | O | Diagonal para Esquerda");
		assertThat(controller.isVelha(requestDTO), is(equalTo(ResponseEntity.ok().body(responseDTO))));
	}
	
	@Test
	void testHorizontalLinha1() throws Exception {
		jogo = new ArrayList<String>();
		jogo.add("XXX");
		jogo.add("XOX");
		jogo.add("OOO");
		requestDTO = new RequestDTO(jogo);
		responseDTO = new ResponseDTO(true, "Ganhou | X | Horizontal linha 1");
		assertThat(controller.isVelha(requestDTO), is(equalTo(ResponseEntity.ok().body(responseDTO))));
	}

	@Test
	void testHorizontalLinha2() throws Exception {
		jogo = new ArrayList<String>();
		jogo.add("XOX");
		jogo.add("XXX");
		jogo.add("OOO");
		requestDTO = new RequestDTO(jogo);
		responseDTO = new ResponseDTO(true, "Ganhou | X | Horizontal linha 2");
		assertThat(controller.isVelha(requestDTO), is(equalTo(ResponseEntity.ok().body(responseDTO))));
	}
	
	@Test
	void testHorizontalLinha3() throws Exception {
		jogo = new ArrayList<String>();
		jogo.add("OOX");
		jogo.add("OXO");
		jogo.add("XXX");
		requestDTO = new RequestDTO(jogo);
		responseDTO = new ResponseDTO(true, "Ganhou | X | Horizontal linha 3");
		assertThat(controller.isVelha(requestDTO), is(equalTo(ResponseEntity.ok().body(responseDTO))));
	}
	
	@Test
	void testVerticalLinha1() throws Exception {
		jogo = new ArrayList<String>();
		jogo.add("XXO");
		jogo.add("XOX");
		jogo.add("XOO");
		requestDTO = new RequestDTO(jogo);
		responseDTO = new ResponseDTO(true, "Ganhou | X | Vertical coluna 1");
		assertThat(controller.isVelha(requestDTO), is(equalTo(ResponseEntity.ok().body(responseDTO))));
	}

	@Test
	void testVerticalLinha2() throws Exception {
		jogo = new ArrayList<String>();
		jogo.add("OOX");
		jogo.add("XOO");
		jogo.add("OOX");
		requestDTO = new RequestDTO(jogo);
		responseDTO = new ResponseDTO(true, "Ganhou | O | Vertical coluna 2");
		assertThat(controller.isVelha(requestDTO), is(equalTo(ResponseEntity.ok().body(responseDTO))));
	}
	
	@Test
	void testVerticalLinha3() throws Exception {
		jogo = new ArrayList<String>();
		jogo.add("OXO");
		jogo.add("XOO");
		jogo.add("XXO");
		requestDTO = new RequestDTO(jogo);
		responseDTO = new ResponseDTO(true, "Ganhou | O | Vertical coluna 3");
		assertThat(controller.isVelha(requestDTO), is(equalTo(ResponseEntity.ok().body(responseDTO))));
	}
	
	@Test
	void testEmpate() throws Exception {
        final CustomNotFoundException thrown = assertThrows(
        		CustomNotFoundException.class,
                () -> { throw new CustomNotFoundException("Empate"); }
        );
        assertEquals("Empate", thrown.getMessage());
	}
}