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
			int frquencia = sc1.nextInt();
			disciplina.addFrequencia(i, frquencia);
		}
		
		Professor P = new Professor("Ricardo",504010);
		
		disciplina.setProfessor(P);
		
		
		
	}

}
