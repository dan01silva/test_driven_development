package br.com.caelum.bixesto;

public class AnoBissexto {
	int ano;
	public AnoBissexto(int ano) {
		this.ano = ano;
	}
	
	public static boolean ehBixesto(int ano) {
		
		if(ano % 4 == 0 || ano % 400 == 0 && ano % 100 != 0 ) {
			return true;
		}
		return false;
	}
}