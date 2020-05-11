package br.com.rifesil.fique.em.casa.tic.tac.toe.utils;

import java.util.List;

import br.com.rifesil.fique.em.casa.tic.tac.toe.enums.Player;

public class TicTacToeUtils {

	public static int[][] preencheMatriz(int[] jogo) {
		int i, j, r = 0;
		int matriz[][] = new int[3][3];
		for (i = 0; i <= 2; i++) {
			for (j = 0; j <= 2; j++) {
				matriz[i][j] = jogo[r++];
			}
		}
		return matriz;
	}

	public static int[] tranformeArrayStringToArrayInt(List<String> entrada) {
		int arrayIntJogos[] = new int[9];
		int all = 0;
		for (String item : entrada) {
			char[] gfg = item.toCharArray();
			for (int i = 0; i < gfg.length; i++) {
				arrayIntJogos[all++] = Player.valueOf(String.valueOf(gfg[i])).getValue();
			}
		}
		return arrayIntJogos;
	}

}
