package br.com.caelum.leilao.servico;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class Avaliador {

	private double maiorDeTodos = Double.NEGATIVE_INFINITY;
	private double menorDeTodos = Double.POSITIVE_INFINITY;
	private List<Lance> maiores;

	public void avalia(Leilao leilao) {
		if(maiores.size() == 0) {
			throw new RuntimeException("Não é possivel fazer um leilão sem lances");
		}
		
		for(Lance lance : leilao.getLances()){
			if(lance.getValor() > maiorDeTodos) maiorDeTodos = lance.getValor();
			if(lance.getValor() < menorDeTodos) menorDeTodos = lance.getValor();
		}
		maiores = new ArrayList<Lance>(leilao.getLances());
		maiores.sort(new Comparator<Lance>() {

			public int compare(Lance l1, Lance l2) {
				if(l1.getValor() < l2.getValor())
					return 1;
					if(l1.getValor() > l2.getValor())
						return -1;
			return 0;
			}
		});
		
		maiores = maiores.subList(0,maiores.size() > 3 ? 3 : maiores.size());
		
	}
	
	public List<Lance> getTresMaiores() {
		return this.maiores; 
	}

	public double getMaiorLance() {
		return this.maiorDeTodos;
	}
	
	public double getMenorLance() {
		return this.menorDeTodos;
	}

	

}
