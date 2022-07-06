package ifsuldeminas.main;

import java.util.Scanner;

import ifsuldeminas.academico.Disciplina;
import ifsuldeminas.alunos.Aluno;
import ifsuldeminas.funcionarios.Professor;

public class Main {

	public static void main(String[] args) {
		Disciplina disciplina = new Disciplina("Poo",5,8,12);
		Aluno A1 = new Aluno("Fabio",102030,3,"Engenharia da Computacao");
		Aluno A2 = new Aluno("Pedro",102040,3,"Engenharia da Computacao");
		Aluno A3 = new Aluno("Ana",102050,3,"Engenharia da Computacao");
		Aluno A4 = new Aluno("Bea",102060,3,"Engenharia da Computacao");
		Aluno A5 = new Aluno("Dani",102070,3,"Engenharia da Computacao");
		Aluno A6 = new Aluno("Claudio",102080,3,"Engenharia da Computacao");
		Aluno A7 = new Aluno("Maria",102090,3,"Engenharia da Computacao");
		Aluno A8 = new Aluno("Sebastião",102010,3,"Engenharia da Computacao");
		Aluno A9 = new Aluno("Vitoria",101030,3,"Engenharia da Computacao");
		Aluno A10 = new Aluno("Youdy",101020,3,"Engenharia da Computacao");
		
		disciplina.matricularAluno(A1);
		disciplina.matricularAluno(A2);
		disciplina.matricularAluno(A3);
		disciplina.matricularAluno(A4);
		disciplina.matricularAluno(A5);
		disciplina.matricularAluno(A6);
		disciplina.matricularAluno(A7);
		disciplina.matricularAluno(A8);
		disciplina.matricularAluno(A9);
		disciplina.matricularAluno(A10);
		Scanner sc1 = new Scanner(System.in);
		
		for(int i=0;i<10;i++) {
			System.out.println("Digite o valor da Nota do aluno A" + i);
			double nota = sc1.nextDouble();
			disciplina.addNota(i, nota);
		}
		
		for(int i=0;i<10;i++) {
			System.out.println("Digite a Frequencia do aluno A" + i);
			int frequencia = sc1.nextInt();
			disciplina.addFrequencia(i, frequencia);
		}
		
		Professor P = new Professor("Ricardo",504010);
		
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
		  System.out.println("Digite 7 Imprimir média total da turma e listar todos os alunos acima da média"
		  		+ "dia");
		  System.out.println("Digite 8 Imprimir média total da turma e listar todos os alunos abaixo da"
		  		+ "média");
		  System.out.println("Digite 9 Imprimir nome dos alunos e suas respectivas notas e aproveitamento");
		  System.out.println("Digite 10 Imprimir alunos ordenados por nota.");
		  System.out.println("Digite 11 Matricular aluno. Deve-se ler o nome, registro acadêmico e curso\n"
		  		+ "do aluno usando o objeto Scanner. Como a disciplina é uma disciplina do primeiro\n"
		  		+ "período, assume-se que o aluno é do primeiro período e, portanto, não há necessidades\n"
		  		+ "de ler seu período. Em seguida deve-se criar o objeto que represente o aluno e então\n"
		  		+ "matriculá-lo na disciplina; depois deve-se ler a nota e a frequência total do aluno na\n"
		  		+ "disciplina, esses valores deverão ser corretamente registrados para o aluno. Solicite ao\n"
		  		+ "\n"
		  		+ "usuário um valor válido a ser informado. Por exemplo: o registro acadêmico deve es-\n"
		  		+ "tar no intervalo [0, 9999], a nota deve estar no intervalo [0,10] e frequencia total não\n"
		  		+ "\n"
		  		+ "pode ser maior que o número total de aulas da disciplina. Apresente para o usuário se\n"
		  		+ "\n"
		  		+ "o aluno foi ou não matriculado com sucesso. Perceba que se o registro acadêmico for-\n"
		  		+ "necido pelo usuário for igual ao de um aluno já matriculado, então deverá ser exibido\n"
		  		+ "\n"
		  		+ "para o usuário que o aluno não foi matriculado, pois seu RA é semelhante ao de um\n"
		  		+ "aluno matriculado na disciplina.");
		  	System.out.println("********************************************************************************");
		  
		  
		  int numero = entrada.nextInt();
		  while(numero != 0) {
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
			        int n = disciplina.getNumeroAlunos();
			       break;
			     case 6:		    	 

			    	int posMaiorNota = disciplina.procuraNota(disciplina.retornaMaiorNota());
			    	int posMenorNota = disciplina.procuraNota(disciplina.retornaMenorNota());
			    	System.out.println("Aluno com maior Nota: " +  disciplina.retornaNomeAluno(posMaiorNota));
			    	System.out.println("Aluno com menor Nota: " +  disciplina.retornaNomeAluno(posMenorNota));
			       
			       break;
			     case 7:
			       System.out.println("Professor Responsavel");
			       break;
			     case 8:
			       System.out.println("O número escolhido foi: 8.");
			       break;
			     case 9:
			       System.out.println("O número escolhido foi: 9.");
			       break;
			     case 10:
			       System.out.println("O número escolhido foi: 10.");
			       break;
			     case 11:
				       numero = 0;
				       break;  
			     default:
			       System.out.println("O número escolhido é inválido! Digite um número entre 1 a 10.");
			
			   }
		  }

		
	}

}
