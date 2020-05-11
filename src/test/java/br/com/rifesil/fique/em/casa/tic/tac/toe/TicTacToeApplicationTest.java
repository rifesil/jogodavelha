package br.com.rifesil.fique.em.casa.tic.tac.toe;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TicTacToeApplicationTest {

	  @Test
	  public void testMain() {
	    TicTacToeApplication.main(new String[] {});
	  }
	  
	  @Test
	  public void testMainNotNUll() {
	    assertNotNull(TicTacToeApplication.class);
	  }
}
