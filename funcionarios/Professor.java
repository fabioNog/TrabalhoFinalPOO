package ifsuldeminas.funcionarios;

import java.util.Scanner;

import ifsuldeminas.academico.Pessoa;

public class Professor{
	private String nome;
	private int suap;
	
	Scanner p = new Scanner(System.in);
	int prof;

	public Professor(String nome,int suap) {
		setNome(nome);
		if(suap >= 1000 && suap <=9999) {
			this.setSuap(suap);
		}
		else {
			while(suap < 1000 || suap > 9999) {
				System.out.println("Não foi possivel criar o professor,digite novamente o SUAP ");
				suap = p.nextInt();
			}
			this.setSuap(suap);
			
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
