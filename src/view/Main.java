package view;

import java.util.Scanner;

import br.edu.fateczl.pilhaInt.*;
import controller.NPRController;

public class Main {

	public static void main(String[] args) {
		NPRController npr = new NPRController();
		Scanner sc = new Scanner(System.in);
		Pilha p = new Pilha();
		String input = "";

		System.out.println("Digite números para inserir na pilha ou operações (+, -, *, /). Digite 'x' para sair.");

		while (true) {
			input = sc.nextLine();

			if (input.equals("x")) {
				break;
			}

			try {
				int valor = Integer.parseInt(input);
				npr.insereValor(p, valor);
			} catch (Exception e) {
				int resultado = npr.npr(p, input);
				System.out.println("Resultado atual: " + resultado);
			}
		}

		sc.close();
	}
}