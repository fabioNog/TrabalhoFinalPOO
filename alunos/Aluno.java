package ifsuldeminas.alunos;

import ifsuldeminas.academico.Pessoa;

public class Aluno extends Pessoa{
	public Aluno(String nome,int ra, String curso) {
		super(nome);
		setRa(ra);
		setCurso(curso);
		setPeriodo(1);
	}
	
	public Aluno(String nome,int ra, int periodo,String curso) {
		super(nome);
		setRa(ra);
		setCurso(curso);
		setPeriodo(periodo);
	}
	
	private String nome;
	private int ra;
	private String curso;
	private int periodo;
	

	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getRa() {
		return ra;
	}

	public void setRa(int ra) {
		this.ra = ra;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
	
	public void exibirAluno() {
		System.out.print("Nome: " + this.getNome() + " RA: " + this.getRa() + " Periodo: " + this.getPeriodo() + " Curso: " + this.getCurso());
	}
	
}
