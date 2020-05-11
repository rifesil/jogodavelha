package br.com.rifesil.fique.em.casa.tic.tac.toe.dto;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ResponseDTOTest {

	@InjectMocks
	ResponseDTO responseDTO;

	@BeforeEach
	void setUp() {
		responseDTO = new ResponseDTO(true, "");
	}

	@Test
	void testResponseDTO() {
		responseDTO.setWon(true);
		responseDTO.setMessage("");
		assertThat(responseDTO.getWon(), is(true));
		assertThat(responseDTO.getMessage(), is(""));
		assertNotNull(responseDTO.getClass());
		assertNotNull(responseDTO.hashCode());
		assertNotNull(responseDTO.toString());
		assertNotNull(responseDTO.equals(new Object()));
	}

}
