package ifsuldeminas.funcionarios;

import ifsuldeminas.academico.Pessoa;

public class Professor extends Pessoa{
	
	private int suap;

	public Professor(String nome,int suap) {
		super(nome);
		if(suap >=1000 && suap <=9999) {
			this.setSuap(suap);
		}
		else {
			System.out.println("Não foi possivel criar o professor");
		}
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
