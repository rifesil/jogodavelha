package br.com.rifesil.fique.em.casa.tic.tac.toe.dto;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RequestDTOTest {

	@InjectMocks
	RequestDTO requestDTO;

	@Mock
	List<String> jogo;
	
	@BeforeEach
	void setUp() {
		jogo = new ArrayList<String>();
		requestDTO = new RequestDTO(jogo);

	}
	
	@Test
	void testRequestDTO() {
		jogo = new ArrayList<String>();
		jogo.add("XXO");
		jogo.add("XOX");
		jogo.add("OOX");
		requestDTO.setJogo(jogo);
		requestDTO = new RequestDTO(jogo);
		assertThat(requestDTO.getJogo().get(0), is("XXO"));
		
		assertNotNull(requestDTO.equals(new RequestDTO(jogo)));
		assertNotNull(requestDTO.getClass());
		assertThat(requestDTO.getJogo().isEmpty(), is(new RequestDTO(jogo).getJogo().isEmpty()));
		assertNotNull(requestDTO.hashCode());
		assertNotNull(requestDTO.toString());
		assertNotNull(requestDTO.getJogo());
		assertNotNull(requestDTO.canEqual(new Object()));
	}

}
