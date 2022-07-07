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
			System.out.println("Digite o valor da Nota do aluno A" + i);
			nota = sc1.nextDouble();
			if(nota >= 0 && nota <=10) {
				disciplina.addNota(i, nota);
			}
			else {
				while(nota < 0 || nota > 10) {
					System.out.println("Digite uma nota valida");
					nota = sc1.nextDouble();
				}
				disciplina.addNota(i, nota);
			}
			
		}

		System.out.println("Fim do programa");
	}

}
