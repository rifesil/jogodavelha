package br.com.rifesil.fique.em.casa.tic.tac.toe.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.com.rifesil.fique.em.casa.tic.tac.toe.dto.RequestDTO;
import br.com.rifesil.fique.em.casa.tic.tac.toe.dto.ResponseDTO;
import br.com.rifesil.fique.em.casa.tic.tac.toe.enums.Player;
import br.com.rifesil.fique.em.casa.tic.tac.toe.error.CustomNotFoundException;
import br.com.rifesil.fique.em.casa.tic.tac.toe.utils.TicTacToeUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TicTacToeService {

	private Map<Boolean, String> map = new HashMap<Boolean, String>();
	
	public ResponseDTO hasWon(RequestDTO jogoRequest) {

		int[] jogos = TicTacToeUtils.tranformeArrayStringToArrayInt(jogoRequest.getJogo());
		boolean won = this.isVelha(jogos);
		if(!won) {
			throw new CustomNotFoundException(map.get(false));
		}
		return new ResponseDTO(true, "Ganhou | " + map.get(true));

	}
	
	public boolean isVelha(int[] jogo) {
		int[][] matriz = TicTacToeUtils.preencheMatriz(jogo);
		if (matriz[0][0] == matriz[0][1] && matriz[0][0] == matriz[0][2]) {
			log.info("Horizontal linha 1");
			map.put(true, Player.valueOf(matriz[0][0]).name() + " | Horizontal linha 1");
			return true;
		} else if (matriz[1][0] == matriz[1][1] && matriz[1][0] == matriz[1][2]) {
			log.info("Horizontal linha 2");
			map.put(true, Player.valueOf(matriz[1][0]).name() + " | Horizontal linha 2");
			return true;
		} else if (matriz[2][0] == matriz[2][1] && matriz[2][0] == matriz[2][2]) {
			log.info("Horizontal linha 3");
			map.put(true, Player.valueOf(matriz[2][0]).name() + " | Horizontal linha 3");
			return true;
		} else if (matriz[0][0] == matriz[1][0] && matriz[0][0] == matriz[2][0]) {
			log.info("Vertical coluna 1");
			map.put(true, Player.valueOf(matriz[0][0]).name() + " | Vertical coluna 1");
			return true;
		} else if (matriz[0][1] == matriz[1][1] && matriz[0][1] == matriz[2][1]) {
			log.info("Vertical coluna 2");
			map.put(true, Player.valueOf(matriz[0][1]).name() + " | Vertical coluna 2");
			return true;
		} else if (matriz[0][2] == matriz[1][2] && matriz[0][2] == matriz[2][2]) {
			log.info("Vertical coluna 3");
			map.put(true, Player.valueOf(matriz[0][2]).name() + " | Vertical coluna 3");
			return true;
		} else if (matriz[0][0] == matriz[1][1] && matriz[0][0] == matriz[2][2]) {
			log.info("Diagonal para Esquerda");
			map.put(true, Player.valueOf(matriz[0][0]).name() + " | Diagonal para Esquerda");
			return true;
		} else if (matriz[0][2] == matriz[1][1] && matriz[0][2] == matriz[2][0]) {
			log.info("Diagonal para Direita");
			map.put(true, Player.valueOf(matriz[0][2]).name() + " | Diagonal para Direita");
			return true;
		} else {
			map.put(false, "Empate");
			return false;
		}
	}

}
