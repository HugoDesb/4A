package TP7;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class CommandeAppel implements Commande{

	private Deque<String> stack;

	public CommandeAppel() {
		this.stack = new ArrayDeque<>();
	}

	@Override
	public void executeString(String str) {
		stack.push(str);
	}

}
