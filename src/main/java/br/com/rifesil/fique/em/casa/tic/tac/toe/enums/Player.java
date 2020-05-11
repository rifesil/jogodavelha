package br.com.rifesil.fique.em.casa.tic.tac.toe.enums;

import java.util.HashMap;
import java.util.Map;

public enum Player {
	O(0), X(1);

	private int value;
	private static Map<Integer, Player> map = new HashMap<>();

	private Player(int value) {
		this.value = value;
	}

	static {
		for (Player pageType : Player.values()) {
			map.put(pageType.value, pageType);
		}
	}

	public static Player valueOf(int pageType) {
		return (Player) map.get(pageType);
	}

	public int getValue() {
		return value;
	}
}
