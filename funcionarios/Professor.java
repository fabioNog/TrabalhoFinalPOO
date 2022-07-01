package ifsuldeminas.funcionarios;

import ifsuldeminas.academico.Pessoa;

public class Professor extends Pessoa{
	
	private int suap;

	public Professor(String nome,int suap) {
		super(nome);
	}

	public int getSuap() {
		return suap;
	}

	public void setSuap(int suap) {
		this.suap = suap;
	}
	
	public void exibirProfessor() {
		System.out.print("Nome: " + this.getNome() + " suap: " + this.getSuap());
	}
	
}
