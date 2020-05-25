package br.com.tidicas.facade;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.PrePassivate;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import org.jboss.annotation.ejb.LocalBinding;
import org.jboss.annotation.ejb.RemoteBinding;

import br.com.tidicas.model.Curriculo;
import br.com.tidicas.model.Experiencia;  

@Stateful
@Local (CurriculoLocal.class)
@Remote (CurriculoRemote.class)
@RemoteBinding( jndiBinding="CurriculoBean/remote" )
@LocalBinding( jndiBinding="CurriculoBean/local" )
@TransactionManagement(TransactionManagementType.BEAN)
public class CurriculoBean  { 
    private List<Curriculo> curriculos; 
    
    @PersistenceUnit(unitName="Curriculo")  
    private EntityManagerFactory emf=null;
    
    @PersistenceContext(unitName = "Curriculo")  
    private EntityManager entitymanager= null;   
    
    @Resource
    private UserTransaction transaction;
        
    public CurriculoBean() { 
    	curriculos = new ArrayList<Curriculo>();   
    	this.emf =  Persistence.createEntityManagerFactory("Curriculo");
    	this.entitymanager=emf.createEntityManager();
    	 
    } 

    //@TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void inclui(Curriculo curriculo) {
    	try {
    			  
    		transaction.begin();
	    	entitymanager.persist(curriculo);
	    	transaction.commit();
	    	
		} catch (Exception e) {
			try {
				transaction.rollback();
			} catch (IllegalStateException e1) {
				e1.printStackTrace();
			} catch (SecurityException e1) {
				e1.printStackTrace();
			} catch (SystemException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} 
    	
    } 
    
    public Curriculo atualiza(Curriculo curriculo) {
    	try {
    		transaction.begin();
	    	curriculo=entitymanager.merge(curriculo);
	    	transaction.commit();
    	} catch (Exception e) {			
    		try {
				transaction.rollback();
			} catch (IllegalStateException e1) {
				e1.printStackTrace();
			} catch (SecurityException e1) {
				e1.printStackTrace();
			} catch (SystemException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
        return curriculo; 
    }
    
    //@TransactionAttribute(TransactionAttributeType.NEVER)
    public Curriculo consultaCodigo(int codigo) {
    	Curriculo curriculo =null;
    	try {
    		Query query = entitymanager.createQuery("select x from Curriculo as x"+ 
					" fetch all properties"+					
					" where x.codigo=" + codigo);
    	
    		curriculo = (Curriculo)query.getSingleResult();
    		curriculo.getExperiencias().size();
    		curriculo.getIdiomas().size();
    	
		} catch (Exception e) {		
			e.printStackTrace();
		}
    	
        return curriculo;        
    }
    
    public List<Curriculo> consultaNome(String nome) {
    	curriculos = entitymanager.createQuery("select x from Curriculo x where x.nome like '" + nome + "%' ").getResultList();       
        return curriculos;
                
    }
    
    public Curriculo consultaEmail(String email) {
    	Curriculo curriculo = null;   
    	curriculo = (Curriculo) entitymanager.createQuery("select x from Curriculo x where x.email = '" + email + "' ").getSingleResult();       
        return curriculo;
                
    }
    public void remove(Curriculo curriculo) {
    	try {
    		transaction.begin();    		
			entitymanager.remove(entitymanager.merge(curriculo));
			entitymanager.flush();
			transaction.commit();
			
    	} catch (Exception e) {			
    		try {
				transaction.rollback();
			} catch (IllegalStateException e1) {
				e1.printStackTrace();
			} catch (SecurityException e1) {
				e1.printStackTrace();
			} catch (SystemException e1) {
				e1.printStackTrace();
			}    		
    		e.printStackTrace();
		}
    }
    
    public void assimilaCurriculoExperiencia(int curId, int expId) {
        Experiencia experiencia = entitymanager.find(Experiencia.class, expId);
        Curriculo curriculo = entitymanager.find(Curriculo.class, curId);
        experiencia.setCurriculos(curriculo);
        List<Experiencia> lista = new ArrayList<Experiencia>();
        lista.add(experiencia);
        curriculo.setExperiencias(lista);
    }
    
    public List<Curriculo> getLista() { 
       curriculos = entitymanager.createQuery("select x from Curriculo x").getResultList();       
       return curriculos;       
    }
        
    public void ejbCreate() {
    	System.out.println("");	
    }
    public void ejbRemove() {
    	System.out.println("");	
    }
    public void ejbActivate(){
    	System.out.println("");
    }
    @PrePassivate
    public void ejbPassivate(){
    	System.out.println("");
    }
  
}