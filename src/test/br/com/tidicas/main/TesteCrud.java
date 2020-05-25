package br.com.tidicas.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.tidicas.model.Curriculo;
import br.com.tidicas.model.Experiencia;
import br.com.tidicas.model.Idioma;
import br.com.tidicas.model.Login;
import junit.framework.TestCase;

/**
 * 	@author Evaldo Junior
 * 	@since 30/03/2011
 * 	@version 1.0
 */	
public class TesteCrud extends TestCase { 
   
	public static void testCrud(){
	   
	   EntityManagerFactory factory = Persistence.createEntityManagerFactory("Curriculo"); 
	   EntityManager em = factory.createEntityManager(); 		    

	   // 1 Login
	   Login login = new Login();	   
	   login.setSenha("senha");
	   login.setSenhaAnterior("senhaold");
	   login.setDicaSenha("senha do site");
	   
	   em.getTransaction().begin();
	   em.persist(login);
	   em.getTransaction().commit();
	   
	   // 2 Curriculo
	   Curriculo curriculo = new Curriculo();
	   
	   curriculo.setArea("TI");
	   curriculo.setBairro("Centro");	   
	   curriculo.setCelularDDD(11);
	   curriculo.setCelular(912345678);
	   curriculo.setCep(05501001);
	   curriculo.setCidade("São Paulo");
	   curriculo.setCpf("0123456789");
	   curriculo.setDesejoTrabalharCidade("Campinas");
	   curriculo.setEmail("teste@tidicas.com.br");
	   curriculo.setEmpregado("Sim");
	   curriculo.setEndereco("Rua teste");
	   curriculo.setNumero(123);
	   curriculo.setEspecializacoes("Especialização");
	   curriculo.setEstado("SP");
	   curriculo.setEstadoCivil("solteiro");
	   curriculo.setFormacaoCurso("Administração");
	   curriculo.setFormacaoDataInicioMesAno(new Date());
	   curriculo.setFormacaoDataSaidaMesAno(new Date());
	   curriculo.setFormacaoGrau("3º grau");
	   curriculo.setFormacaoInstituicao("Faculdade xyz");
	   curriculo.setHomePage("www.tidicas.com.br");
	   curriculo.setLogin(login);
	   curriculo.setMinicurriculo("teste");
	   curriculo.setNascimento(new Date());
	   curriculo.setNivel("nivel um");
	   curriculo.setNome("nome sobrenome");
	   curriculo.setObjetivo("objetivo profissional");
	   curriculo.setPalavraChave("Palavra Chave");
	   curriculo.setPretensao(10000d);
	   curriculo.setRamo("Ramo");
	   curriculo.setRecado("Recado");
	   curriculo.setSexo("masculino");
	   curriculo.setTelefone(12345678);
	   curriculo.setTelefoneDDD(11);
	   
	   em.getTransaction().begin();
	   em.persist(curriculo);
	   em.getTransaction().commit();
	   
	   // 3 Experiencias
	   List<Experiencia> lista = new ArrayList<Experiencia>();	        
	   lista = (List<Experiencia>) curriculo.getExperiencias();
	   
	   for (int i=0;i<3;i++){
		   Experiencia experiencias = new Experiencia();
		   Calendar calendar = Calendar.getInstance();
		   calendar.set(2004 +i, 9, 1);
		   experiencias.setDataEntradaMesAno(calendar.getTime());
		   experiencias.setDataSaidaMesAno(calendar.getTime());
		   experiencias.setDescricao("Descrição das atividades exercidas "+i);
		   experiencias.setExperienciaCargo("Cargo exercido "+i);
		   experiencias.setNomeEmpresa("Nome da empresa " +i);
		   experiencias.setCurriculos(curriculo);
		   
		   lista.add(experiencias);
	   }
	   
	   curriculo.setExperiencias(lista);
	   
	   em.getTransaction().begin();
	   em.merge(curriculo);
	   em.getTransaction().commit();

	   // 3 Idiomas
	   Idioma idiomasIng = new Idioma();
	   idiomasIng.setDescricao("Inglês");
	   idiomasIng.setNivel(4);
	   idiomasIng.setCurriculos(curriculo);
	   
	   Idioma idiomasEsp = new Idioma();
	   idiomasEsp.setDescricao("Espanhol");
	   idiomasEsp.setNivel(1);
	   idiomasEsp.setCurriculos(curriculo);
	   
	   List<Idioma> listaIdiomas = new ArrayList<Idioma>();
	   listaIdiomas.add(idiomasEsp);
	   listaIdiomas.add(idiomasIng);
	   
	   curriculo.setIdiomas(listaIdiomas);
	   
	   em.getTransaction().begin();
	   em.merge(curriculo);
	   em.getTransaction().commit();

       // 4 Consultar registro incluído
	   Query query = em.createQuery("select x from Curriculo as x"+ 
				" fetch all properties"+					
				" where x.codigo=" + curriculo.getCodigo());
	
		curriculo = (Curriculo)query.getSingleResult();
		curriculo.getExperiencias().size();
		curriculo.getIdiomas().size();
		
		System.out.println("Quantidasde de experiências: " + curriculo.getExperiencias().size());		
		System.out.println("Quantidasde de idiomas: " + curriculo.getIdiomas().size());
   }
      
} 