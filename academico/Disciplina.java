package ifsuldeminas.academico;

import java.util.ArrayList;
import java.util.Collections;
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

	public Disciplina(String nome, int periodo, int numAulasSemana, int numSemanas) {
		setNome(nome);
		setPeriodo(periodo);
		setNumAulasSemana(numAulasSemana);
		this.numTotalAulas = this.getNumAulasSemana() * numSemanas;
		this.alunos = new ArrayList<Aluno>();
		this.notas = new ArrayList<Double>();
		this.professor = null;
	}

	public Disciplina(String nome, int periodo, int numAulasSemana, int numSemanas, Professor professor) {
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

		Iterator<Aluno> iterator = this.alunos.iterator();
		
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
	
	public double retornaMaiorNota() {
		Double maxValue = 0.0;

		for (Double notas : this.notas) {
			if (notas > maxValue)
				maxValue = notas;
		}
		
		return maxValue;
	}
	
	public double retornaMenorNota() {
		Double minValue = 0.0;

		for (Double notas : this.notas) {
			if (notas < minValue)
				minValue = notas;
		}
		
		return minValue;
	}
	
	public String retornaNomeAluno(int posicao) {
		return this.alunos.get(posicao).getNome();
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
	
	public void exibirProfessor() {
		System.out.println("Nome " + this.professor.getNome()  + " SUAP " + this.professor.getSuap());
	}
	
	public double getAproveitmentoAluno(int posAluno) {
		
		int frequencia = this.frequencias.get(posAluno);
		double frequenciaTotal = (frequencia*100)/this.numTotalAulas;
		return frequenciaTotal;				
	}
	
	public double getNotaAluno(int posAluno) {
		return this.notas.get(posAluno);
	}
		
	public void exibirAlunosAcimaMedia() {		
		int i;
		int n = this.alunos.size();
		
		for (i=0; i<n; i++) {
			if(this.notas.get(i) >= this.calcularMedia()) {
				System.out.println("Alunos com nota acima da media");
				System.out.println("Nome: " + this.alunos.get(i).getNome() + " RA:  " + this.alunos.get(i).getRa() + " Curso: " + this.alunos.get(i).getCurso() + " Periodo: " + this.alunos.get(i).getPeriodo());
			}
		}
	}
	
	public void exibirAlunosAbaixoMedia() {
		int i;
		int n = this.alunos.size();
		
		for (i=0; i<n; i++) {
			if(this.notas.get(i) < this.calcularMedia()) {
				System.out.println("Alunos com nota abaixo da media");
				System.out.println("Nome: " + this.alunos.get(i).getNome() + " RA:  " + this.alunos.get(i).getRa() + " Curso: " + this.alunos.get(i).getCurso() + " Periodo: " + this.alunos.get(i).getPeriodo());
			}
		}
	}
	
	public void exibirAlunoNotaAproveitamento() {
		int i;
		int n = this.alunos.size();
		
		if(n == 0) {
			System.out.println("Disciplina não possui alunos matriculados");
		}
		else {
			for (i=0; i<n; i++) {
				if(this.notas.get(i) < this.calcularMedia()) {
					System.out.println("Nome: " + this.alunos.get(i).getNome() + " nota:  " + this.notas.get(i) + " Aproveitamento: " + this.alunos.get(i).getCurso() + " Periodo: " + this.getAproveitmentoAluno(i));
				}
			}
		}		
	}
	
	public void desmatricularAlunos() {
		int i;
		int n = this.alunos.size();
		
		if(n == 0) {
			System.out.println("Disciplina não possui alunos matriculados");
		}
		else {
			for (i=0; i<n; i++) {
				this.alunos.remove(i);
				this.notas.remove(i);
				this.frequencias.remove(i);
			}
		}		
	}
	
	public void exibirOrdenadosPorNota() {
		int i,recebePosicao=0;
		int n = this.alunos.size();
		Collections.sort(this.notas, Collections.reverseOrder());
		for(i = 0; i< n; i++){
			recebePosicao = this.procuraNota(this.notas.get(i));
			if(recebePosicao == 0) {
				System.out.println("Não existe esta nota");
			}
			else {
				System.out.println("Aluno " + this.alunos.get(recebePosicao) + "Nota: " + this.notas.get(i));
			}
		}		 		  
	}
	
	public int procuraNota(double posicao) {
		int n = this.notas.size();
		int i;
		int encontraPosicao = 0;
		for(i=0;i<n;i++) {
			if (this.notas.get(i).equals(posicao)) {
		            encontraPosicao = i;
		     }
			else {
				i++;
			}
		}
		
		if(i == n) {
			return 0;
		}
		else {
			return encontraPosicao;
		}	
	}
	
	public void exibirDisciplina() {
		int n = this.notas.size();
		int i;
		System.out.println("********** Exibindo Disciplina *********");
		System.out.println("********** Professor *********");
		System.out.println("Nome do Professor: " + this.professor.getNome() + " SUAP " + this.professor.getSuap());
		System.out.println("********** Professor *********");
		System.out.println("Info do Aluno");
		for(i=0;i<n;i++) {
			System.out.println("*********** Aluno " +  i + " ***************");
			System.out.println("Nome do Aluno " + this.alunos.get(i).getNome() + " RA: " + this.alunos.get(i).getRa() + "Esta no periodo: " + this.alunos.get(i).getPeriodo());
			System.out.println("Sua nota foi de " + this.notas.get(i));
			System.out.println( "Sua frequencia foi de" + this.frequencias.get(i));
			System.out.println("*********** Aluno " +  i + " ***************");
		}
						
		System.out.println("********** Exibindo Disciplina *********");
	}
	
}
