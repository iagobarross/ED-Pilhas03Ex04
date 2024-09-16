/*4. Implementar um novo projeto Java com a biblioteca PilhaInt.
Esse projeto deve implementar uma solução para uma calculadora em Notação Polonesa Reversa (NPR),
também conhecida como posfixa. Calculadoras HP, como a 48G ou a 12C u�lizam esse formato de cálculo, em
detrimento da maneira algébrica (infixa).
A lógica da NPR se dá como a seguir:
Notação Polonesa Reversa:
(O vídeo htps://www.youtube.com/watch?v=-b-f9-9_xAI mostra a HP 50G em operações infixa e posfixa)
• Enquanto for digitado número, ele será empilhado.
• Quando for digitada uma operação (+,-,*,/), 2 valores devem ser desempilhados, se faz a
operação com eles e o resultado retorna à pilha
• É importante verificar que a pilha deve ter, no mínimo 2 valores para fazer a operação
O projeto deve ter uma classe de controle (NPRController) que inicializa uma nova Pilha e deve ter duas
operações:
• Operação insereValor(Pilha p, int valor):void, faz um push() na pilha
• Operação npr(Pilha p, String op):int. O método deve verificar se a String se trata de uma
operação (+,-,*,/), verifica se é possível fazer 2 pop() e, em sendo possível, fazer os 2 pop(),
fazer a operação, gravar em uma variável resultado (que é o retorno da operação) e fazer o
push() do resultado.
o Para operações de subtração e divisão (que a ordem importa), fazer o valor do 2o pop()
operação valor do 1o pop(), ou seja o valor mais antigo à esquerda da operação
o Se não houverem 2 valores, deve-se lançar um Exception de pilha com valores
insuficientes

A classe view Principal, deve inicializar a pilha e solicitar dados (número ou operação) ao usuário até alguma
condição de encerramento, definido por você.
Dica: Para inverter, pode-se usar os métodos substring ou charAt
*/
package controller;

import br.edu.fateczl.pilhaInt.Pilha;

public class NPRController {

	public NPRController() {
		super();
	}

	public void insereValor(Pilha p, int valor) {
		try {
			p.push(valor);
		} catch (Exception e) {
			System.err.println("Erro ao inserir valor na pilha: " + e.getMessage());
		}
	}

	public int npr(Pilha p, String op) {
		int resultado = 0;

		if (p.size() >= 2) {
			try {
				int valor1 = p.pop();
				int valor2 = p.pop();

				switch (op) {

				case "+":
					resultado = valor2 + valor1;
					break;
				case "-":
					resultado = valor2 - valor1;
					break;
				case "*":
					resultado = valor2 * valor1;
					break;
				case "/":
					if (valor1 != 0) {
						resultado = valor2 / valor1;
					} else {
						System.err.println("Divisão por zero.");
						return 0;
					}
					break;
				default:
					System.out.println("Operação inválida.");
					return 0;
				}

				p.push(resultado);
			} catch (Exception e) {
				System.err.println("Erro na operação NPR: " + e.getMessage());
			}
		} else {
			System.err.println("Pilha com valores insuficientes.");
		}
		return resultado;
	}
}
