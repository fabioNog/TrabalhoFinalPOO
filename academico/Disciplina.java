package ifsuldeminas.academico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ifsuldeminas.alunos.Aluno;
import ifsuldeminas.funcionarios.Professor;

public class Disciplina {
	private String nome;
	private int periodo;
	private int numAulasSemana;
	private int numTotalAulas;
	private Professor professor;

	private List<Aluno> alunos;
	private List<Double> notas;
	private List<Integer> frequencias;

	Disciplina(String nome, int periodo, int numAulasSemana, int numSemanas) {
		setNome(nome);
		setPeriodo(periodo);
		setNumAulasSemana(numAulasSemana);
		this.numTotalAulas = this.getNumAulasSemana() * numSemanas;
		this.alunos = new ArrayList<Aluno>();
		this.notas = new ArrayList<Double>();
		this.professor = null;
	}

	Disciplina(String nome, int periodo, int numAulasSemana, int numSemanas, Professor professor) {
		setNome(nome);
		setPeriodo(periodo);
		setNumAulasSemana(numAulasSemana);
		setProfessor(professor);
		this.numTotalAulas = this.getNumAulasSemana() * numSemanas;
		this.alunos = new ArrayList<Aluno>();
		this.notas = new ArrayList<Double>();
		this.frequencias = new ArrayList<Integer>();
	}

	// Metodos Getters e Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public int getNumAulasSemana() {
		return numAulasSemana;
	}

	public void setNumAulasSemana(int numAulasSemana) {
		this.numAulasSemana = numAulasSemana;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public boolean matricularAluno(Aluno aluno) {
		// Disciplina D = new
		// Disciplina(this.nome,this.periodo,this.numAulasSemana,this.numTotalAulas);

		Iterator<Aluno> iterator = this.alunos.iterator();
		while (iterator.hasNext()) {
			if (iterator.equals(aluno.getRa())) {
				return false;
			}
		}
		this.alunos.add(aluno);
		this.notas.add(0.0);
		this.frequencias.add(0);
		return true;
	}

	public boolean desmatricularAluno(int posAluno) {
		if (this.alunos.get(posAluno) != null) {
			this.alunos.remove(posAluno);
			this.notas.remove(posAluno);
			this.frequencias.remove(posAluno);
			return true;
		} else {
			System.out.println("Não existe aluno nesta posicao");
			return false;
		}
	}

	public void removerProfessor() {
		if (this.professor != null) {
			this.setProfessor(null);
			System.out.println("Professor Removido");
		}

	}

	public int getNumeroAlunos() {
		return this.alunos.size();
	}

	public boolean addNota(int posAluno, double nota) {
		if (nota >= 0 && nota <= 10) {
			this.notas.add(posAluno, nota);
			return true;
		} else {
			return false;
		}
	}

	public boolean addFrequencia(int posAluno, int frequenciaTotal) {
		if (frequenciaTotal >= 0 && frequenciaTotal <= this.numTotalAulas) {
			this.frequencias.add(posAluno, frequenciaTotal);
			return true;
		} else {
			return false;
		}
	}

	public boolean estaAprovado(int posAluno) {
		// this.Aluno.get(posAluno);
		double mediaFrequencia = 75 / 100;
		if (this.notas.get(posAluno) >= 6 && this.frequencias.get(posAluno) >= (this.numTotalAulas * mediaFrequencia)) {
			return true;
		}

		else {
			return false;
		}
	}

	public void exibirAprovados() {
		int i;
		int n = this.alunos.size();
		if (n == 0) {
			System.out.println("Disciplina não possui alunos matriculados");
		} else {
			int contaReprovados = 0;
			for (i = 0; i < n; i++) {
				if (estaAprovado(i)) {
					System.out.printf("Posição %d- %s\n", i, alunos.get(i));
				}

				else {
					contaReprovados++;
				}
			}
			if (contaReprovados == n) {
				System.out.printf("Não há alunos Aprovados.");
			}
		}
	}

	public void exibirReprovados() {
		int i;
		int n = this.alunos.size();
		if (n == 0) {
			System.out.println("Disciplina não possui alunos matriculados");
		} else {
			int contaAprovados = 0;
			for (i = 0; i < n; i++) {
				if (estaAprovado(i) == false) {
					System.out.printf("Posição %d- %s\n", i, alunos.get(i));
				}

				else {
					contaAprovados++;
				}
			}
			if (contaAprovados == n) {
				System.out.printf("Não há alunos Reprovados.");
			}
		}
	}

	public double calcularMedia() {
		int i;
		int n = this.alunos.size();
		double media = 0;
		double somaNotas = 0;

		for (i = 0; i < n; i++) {
			somaNotas = somaNotas + this.notas.get(i);
		}
		media = somaNotas / n;
		return media;
	}

	public void exibirMaiorNota() {
		Double maxValue = 0.0;

		for (Double notas : this.notas) {
			if (notas > maxValue)
				maxValue = notas;
		}
		System.out.println("Maior Nota" + maxValue);
	}

	public void exibirMenorNota() {
		Double maxValue = 0.0;

		for (Double notas : this.notas) {
			if (notas < maxValue)
				maxValue = notas;
		}
		System.out.println("Menor Nota" + maxValue);
	}

	public int getQuantidadeReprovados() {

		int i;
		int n = this.notas.size();
		if (n == 0) {
			System.out.println("Disciplina não possui alunos matriculados");
			return 0;
		} else {
			int contaReprovados = 0;
			int contaAprovados = 0;
			for (i = 0; i < n; i++) {
				if (estaAprovado(i) == false) {
					contaReprovados++;
				} else {
					contaAprovados++;
				}
			}

			if (contaAprovados == n) {
				return 0;
			} else {
				return contaReprovados;
			}

		}
	}

	public int getQuantidadeAprovados() {

		int i;
		int n = this.notas.size();
		if (n == 0) {
			System.out.println("Disciplina não possui alunos matriculados");
			return 0;
		} else {
			int contaAprovados = 0;
			int contaReprovados = 0;
			for (i = 0; i < n; i++) {
				if (estaAprovado(i)) {
					contaAprovados++;
				} else {
					contaReprovados++;
				}
			}
			if (contaReprovados == n) {
				return 0;
			} else {
				return contaAprovados;
			}

		}
	}

}
