package ifsuldeminas.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ifsuldeminas.academico.Disciplina;
import ifsuldeminas.alunos.Aluno;
import ifsuldeminas.funcionarios.Professor;

public class Main {

	public static void main(String[] args) {
		Disciplina disciplina = new Disciplina("Poo", 5, 8, 12, null);
		int contador = 0;
		System.out.println("Cadastrando Alunos: ");

		Scanner aluninho = new Scanner(System.in);
		System.out.println("Digite quantos Alunos serão cadastrados");
		int qntAlunos = aluninho.nextInt();

		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		Aluno A;
		// Cadastro de Alunos
		for (int i = 0; i < qntAlunos; i++) {
			// Cadastrando Nome
			System.out.println("Digite o nome do " + (i + 1) + " aluno");
			String nome = aluninho.next();

			// Cadastrando RA
			System.out.println("Digite o RA do " + (i + 1) + " aluno");
			int ra = aluninho.nextInt();

			// Cadastrando Periodo
			System.out.println("Digite o periodo do " + (i + 1) + " aluno");
			int periodo = aluninho.nextInt();

			// Cadastrando Curso
			System.out.println("Digite o Curso do " + (i + 1) + " aluno");
			String curso = aluninho.next();

			A = new Aluno(nome, ra, periodo, curso);
			boolean matriculou = disciplina.matricularAluno(A);
			if (matriculou) {
				System.out.println("Matriculado com sucesso no main");
			} else {
				while (!matriculou) {
					System.out.println("Numero de RA invalido digite novamente:");
					ra = aluninho.nextInt();
					A = new Aluno(nome, ra, periodo, curso);
					matriculou = disciplina.matricularAluno(A);
				}
			}

		}

		System.out.println("Fim do Cadastro de Alunos");

		Scanner sc1 = new Scanner(System.in);
		double nota;
		for (int i = 0; i < qntAlunos; i++) {
			System.out.println("Digite o valor da Nota do aluno A" + (i + 1));
			nota = sc1.nextDouble();
			if (nota >= 0 && nota <= 10) {
				disciplina.addNota(i, nota);
				System.out.println("Nota do aluno " + (i + 1) + " cadastrada com sucesso");
			} else {
				while (nota < 0 || nota > 10) {
					System.out.println("Digite uma nota valida");
					nota = sc1.nextDouble();
				}
				disciplina.addNota(i, nota);
				System.out.println("Nota do aluno " + (i + 1) + " cadastrada com sucesso");
			}
		}

		System.out.println("Fim do Cadastro de Notas");

		for (int i = 0; i < qntAlunos; i++) {
			System.out.println("Digite a Frequencia do aluno A" + (i + 1));
			int frequencia = sc1.nextInt();

			if (frequencia >= 0 && frequencia <= 9999) {
				disciplina.addFrequencia(i, frequencia);
				System.out.println("Frequencia do aluno " + (i + 1) + " cadastrada com sucesso");
			} else {
				while (frequencia < 0 || frequencia > 9999) {
					System.out.println("Digite uma nota valida");
					frequencia = sc1.nextInt();
				}
				disciplina.addFrequencia(i, frequencia);
				System.out.println("Frequencia do aluno " + (i + 1) + " cadastrada com sucesso");
			}

		}

		System.out.println("Fim do Cadastro de Frequencias");

		System.out.println("Digite o nome do professor");
		String nomeProfessor = sc1.next();

		System.out.println("Digite o SUAP do professor");
		int suapProfessor = sc1.nextInt();

		Professor P = new Professor(nomeProfessor, suapProfessor);

		System.out.println("Professor Criado com sucesso");

		disciplina.setProfessor(P);

		Scanner entrada = new Scanner(System.in);
		System.out.println("Escolha um número entre 1 a 11, se digitar ");
		System.out.println("********************************************************************************");
		System.out.println("Digite 0 para sair ");
		System.out.println("Digite 1 Imprimir informações da disciplina ");
		System.out.println("Digite 2 Apresentar número de alunos na disciplina, número de reprovados e\n"
				+ "número de aprovados ");
		System.out.println("Digite 3 Imprimir aprovados ");
		System.out.println("Digite 4 Imprimir reprovados ");
		System.out.println("Digite 5 Imprimir aluno com a maior e o aluno com menor nota");
		System.out.println("Digite 6 Imprimir o professor responsável; ");
		System.out.println("Digite 7 Imprimir média total da turma e listar todos os alunos acima da média" + "dia");
		System.out.println("Digite 8 Imprimir média total da turma e listar todos os alunos abaixo da" + "média");
		System.out.println("Digite 9 Imprimir nome dos alunos e suas respectivas notas e aproveitamento");
		System.out.println("Digite 10 Imprimir alunos ordenados por nota.");
		System.out.println("Digite 11 Matricular aluno. Deve-se ler o nome, registro acadêmico e curso\n"
				+ "do aluno usando o objeto Scanner. Como a disciplina é uma disciplina do primeiro\n"
				+ "período, assume-se que o aluno é do primeiro período e, portanto, não há necessidades\n"
				+ "de ler seu período. Em seguida deve-se criar o objeto que represente o aluno e então\n"
				+ "matriculá-lo na disciplina; depois deve-se ler a nota e a frequência total do aluno na\n"
				+ "disciplina, esses valores deverão ser corretamente registrados para o aluno. Solicite ao\n" + "\n"
				+ "usuário um valor válido a ser informado. Por exemplo: o registro acadêmico deve es-\n"
				+ "tar no intervalo [0, 9999], a nota deve estar no intervalo [0,10] e frequencia total não\n" + "\n"
				+ "pode ser maior que o número total de aulas da disciplina. Apresente para o usuário se\n" + "\n"
				+ "o aluno foi ou não matriculado com sucesso. Perceba que se o registro acadêmico for-\n"
				+ "necido pelo usuário for igual ao de um aluno já matriculado, então deverá ser exibido\n" + "\n"
				+ "para o usuário que o aluno não foi matriculado, pois seu RA é semelhante ao de um\n"
				+ "aluno matriculado na disciplina.");
		System.out.println("********************************************************************************");

		int numero = 1000000;
		while (numero != 0) {
			System.out.println("Digite uma opcao");
			numero = entrada.nextInt();
			switch (numero) {
			case 1:
				disciplina.exibirDisciplina();
				break;
			case 2:
				System.out.println("Numero de Alunos:" + disciplina.getNumeroAlunos());
				System.out.println("Numero de Reprovados" + disciplina.getQuantidadeReprovados());
				System.out.println("Numero de Aprovados" + disciplina.getQuantidadeAprovados());

				break;
			case 3:
				disciplina.exibirAprovados();
				break;
			case 4:
				disciplina.exibirReprovados();
				break;
			case 5:
				int posMaiorNota = disciplina.procuraNota(disciplina.retornaMaiorNota());
				int posMenorNota = disciplina.procuraNota(disciplina.retornaMenorNota());
				System.out.println("Aluno com maior Nota: " + disciplina.retornaNomeAluno(posMaiorNota));
				System.out.println("Aluno com menor Nota: " + disciplina.retornaNomeAluno(posMenorNota));
				break;
			case 6:

				System.out.println("Nome: " + disciplina.getProfessor().getNome() + "SUAP: "
						+ disciplina.getProfessor().getSuap());

				break;
			case 7:
				System.out.println("media da turma: " + disciplina.calcularMedia());
				disciplina.exibirAlunosAcimaMedia();
				break;
			case 8:
				System.out.println("media da turma: " + disciplina.calcularMedia());
				disciplina.exibirAlunosAbaixoMedia();
				break;
			case 9:
				for (int i = 0; i < disciplina.getNumeroAlunos(); i++) {
					System.out.println("Alunos: " + disciplina.retornaNomeAluno(i));
					System.out.println("Alunos: " + disciplina.retornaNotas(i));
				}
				break;
			case 10:
				disciplina.exibirOrdenadosPorNota();
				break;
			case 11:
				System.out.println("Digite o nome do Aluno: ");
				String nome = aluninho.next();
				System.out.println("Digite o RA do Aluno: ");
				int ra = aluninho.nextInt();
				while (ra < 0 && ra > 9000) {
					System.out.println("Valor errado digite novamente");
					ra = aluninho.nextInt();
				}

				int qntAluno = disciplina.getNumeroAlunos();
				System.out.println("Digite o valor da Nota do aluno A");

				nota = sc1.nextDouble();
				while (nota < 0 && ra > 10) {
					System.out.println("Valor da nota errada digite novamente");
					nota = sc1.nextDouble();
				}

				System.out.println("Digite a Frequencia do aluno A");
				int frequencia = sc1.nextInt();

				while (frequencia > disciplina.getNumAulasSemana()) {
					System.out.println("Valor da frequencia errada digite novamente");
					frequencia = sc1.nextInt();
				}

				System.out.println("Digite o periodo do Aluno: ");
				int periodo = aluninho.nextInt();
				System.out.println("Digite o curso do Aluno: ");
				String curso = aluninho.next();

				A = new Aluno(nome, ra, periodo, curso);

				disciplina.matricularAluno(A);

				if (disciplina.matricularAluno(A)) {
					System.out.println("Aluno Matriculado com sucesso");
				} else {
					System.out.println("Aluno nao foi matriculado");
				}

				disciplina.addNota(qntAluno + 1, nota);
				disciplina.addFrequencia(qntAluno + 1, frequencia);

				break;

			case 0:
				numero = 0;
				break;
			default:
				System.out.println("O número escolhido é inválido! Digite um número entre 1 a 11.");

			}
		}

		System.out.println("Fim do programa");
	}

}
