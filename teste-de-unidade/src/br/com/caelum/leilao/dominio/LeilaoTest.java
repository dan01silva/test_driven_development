package br.com.caelum.leilao.dominio;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.caelum.leilao.servico.Avaliador;

public class LeilaoTest {
	@Test
	public void devereceberumleilao() {
		
		Leilao leilao = new Leilao("Macbook Pro 20");
		
		assertEquals(0, leilao.getLances().size());
		
		leilao.propoe(new Lance(new Usuario("Daniel"), 2000));
		
		assertEquals(2000.0, leilao.getLances().get(0).getValor(), 0000.1);
	}
	 @Test
	    public void deveReceberVariosLances() {
	        Leilao leilao = new Leilao("Macbook Pro 15");
	        leilao.propoe(new Lance(new Usuario("Steve Jobs"), 2000));
	        leilao.propoe(new Lance(new Usuario("Steve Wozniak"), 3000));

	        assertEquals(2, leilao.getLances().size());
	        assertEquals(2000.0, leilao.getLances().get(0).getValor(), 0.00001);
	        assertEquals(3000.0, leilao.getLances().get(1).getValor(), 0.00001);
	    }
	 @Test
	 public void naoDeveAceitarDoisLancesSeguidosDoMesmoUsuario() {
	     Leilao leilao = new Leilao("Macbook Pro 15");
	     Usuario steveJobs = new Usuario("Steve Jobs");

	     leilao.propoe(new Lance(steveJobs, 2000.0));
	     leilao.propoe(new Lance(steveJobs, 3000.0));
	     //Verificando o tamanho da lista:
	     assertEquals(1, leilao.getLances().size());
	     //Verificando o conteúdo da lista:
	     assertEquals(2000.0, leilao.getLances().get(0).getValor(), 0.00001);
	 }
	 @Test
	 public void naoDeveAceitarMaisDoQueCincoLeiloes() {
	     Leilao leilao = new Leilao("Macbook Pro 15");
	     Usuario steveJobs = new Usuario("Steve Jobs");
	     Usuario bilGates = new Usuario("Bil Gates");
	     
	     leilao.propoe(new Lance(steveJobs, 2000.0));
	     leilao.propoe(new Lance(bilGates, 3000.0));
	     
	     leilao.propoe(new Lance(steveJobs, 4000.0));
	     leilao.propoe(new Lance(bilGates, 5000.0));
	     
	     leilao.propoe(new Lance(steveJobs, 6000.0));
	     leilao.propoe(new Lance(bilGates, 7000.0));
	     
	     leilao.propoe(new Lance(steveJobs, 8000.0));
	     leilao.propoe(new Lance(bilGates, 9000.0));
	     
	     leilao.propoe(new Lance(steveJobs, 10000.0));
	     leilao.propoe(new Lance(bilGates, 11000.0));
	     
	     //lance deve ser ignorado
	     leilao.propoe(new Lance(steveJobs, 120000.0));
	     
	     assertEquals(10, leilao.getLances().size());
	     assertEquals(11000, leilao.getLances().get(leilao.getLances().size() -1).getValor(), 0.000001);
		
	}
	 
//	 Implemente o método dobraLance(Usuario usuario) na classe Leilao.
//	 Este método deve encontrar o último lance dado por este usuário e 
//	 criar um novo lance com o dobro do lance anterior. Caso ele não tenha 
//	 dado nenhum lance anteriormente, não é criado um novo lance.
//	 Repare que ainda precisamos seguir as regras da propor um lance: no
//	 máximo 5 lances por usuários e dois lances seguidos do mesmo usuário não é válido.
	 
	 @Test
	 public void deveDobrarLanceAnterior() {
		 
		Leilao leilao = new Leilao("JBLQuantumONE");
		
		
		Usuario daniel = new Usuario("Daniel");
		Usuario bilGates = new Usuario("Bil Gates");
	    
	     leilao.propoe(new Lance(daniel, 2000.0));
	     leilao.propoe(new Lance(bilGates, 3000.0));
	     leilao.dobraLance(daniel);
	     
	    
	     assertEquals(0, leilao.getLances().size());
	     // verificando se o valor foi dobrado
	    //assertEquals(4000.0, leilao.getLances().get(leilao.getLances().size()-1).getValor(), 0000.1);
	     
	     
	     
	     
	 }
}

