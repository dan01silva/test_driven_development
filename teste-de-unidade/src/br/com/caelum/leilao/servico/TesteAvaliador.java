package br.com.caelum.leilao.servico;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class TesteAvaliador {

	@Test
	public void deveEntenderLancesEmOrdemComOutrosVAlores() {
		/**
		 * parte 1: Criando a situação 		
		 */
		Usuario joao = new Usuario("joão");
		Usuario maria = new Usuario("maria");
		
		Leilao leilao = new Leilao("Playstation 5 ");
		
		leilao.propoe(new Lance(joao,1000.0));
		leilao.propoe(new Lance(maria,2000.0));
		/**
		 * parte 2: Ação 		
		 */
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		/**
		 * parte 3: Validação
		 */
		
		assertEquals(2000.0, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(1000.0, leiloeiro.getMenorLance(), 0.0001);
		
	}

	@Test
	public void deveEntenderLeilaoComApenasUmLance() {
		
		Usuario joao = new Usuario("joão");
		Leilao leilao = new Leilao("Playstation 4 ");
		
		leilao.propoe(new Lance(joao,1000.0));
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		assertEquals(1000.0, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(1000.0, leiloeiro.getMenorLance(), 0.00001);
	}
	
	@Test
	public void deveEncontrarTresMaioresLances() {
		
		Usuario daniel = new Usuario("Daniel");
		Usuario osmar = new Usuario("Osmar");
		Usuario marly = new Usuario("Marly");
		Usuario gui = new Usuario("Gui");
		
		
		Leilao leilao = new Leilao("Playstation 3 ");
		
		leilao.propoe(new Lance(daniel,1000.0));
		leilao.propoe(new Lance(osmar,2000.0));
		leilao.propoe(new Lance(marly,3000.0));
		leilao.propoe(new Lance(gui,4000.0));
		
		
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		List<Lance> maiores = leiloeiro.getTresMaiores();
		
		assertEquals(3, maiores.size());
		assertEquals(4000.0, maiores.get(0).getValor(), 0.00001);
        assertEquals(3000.0, maiores.get(1).getValor(), 0.00001);
        assertEquals(2000.0, maiores.get(2).getValor(), 0.00001);
        
        
	}
}
