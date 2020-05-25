package br.com.tidicas.facade;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.PrePassivate;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import org.jboss.annotation.ejb.LocalBinding;
import org.jboss.annotation.ejb.RemoteBinding;
import br.com.tidicas.model.Vaga;

@Stateful
@Local (VagasLocal.class)
@Remote (VagasRemote.class)
@RemoteBinding( jndiBinding="VagasBean/remote" )
@LocalBinding( jndiBinding="VagasBean/local" )
@TransactionManagement(TransactionManagementType.BEAN)
public class VagasBean { 
    private List<Vaga> vagas; 
    
    @PersistenceUnit(unitName = "Curriculo")  
    private EntityManagerFactory emf=null;
    @PersistenceContext (unitName="Curriculo")    
    private EntityManager entitymanager= null;
    private UserTransaction transaction = null;
        
    public VagasBean() { 
    	vagas = new ArrayList<Vaga>(); 
    	this.emf =  Persistence.createEntityManagerFactory("Curriculo");  
    	this.entitymanager=emf.createEntityManager();
    	try {
			this.transaction = (UserTransaction) new InitialContext().lookup("UserTransaction");
		} catch (Exception e) {			
			e.printStackTrace();
		}
    } 
    
    public void inclui(Vaga vaga) {
    	try {
    		transaction.begin();			
	    	entitymanager.persist(vaga);
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
    
    public Vaga atualiza(Vaga vaga) {
    	try {
    		transaction.begin();			
	    	vaga=entitymanager.merge(vaga);
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
        return vaga; 
    }
    
    public Vaga consultaCodigo(int codigo) {
        return entitymanager.find(Vaga.class,codigo);        
    }
    
    public List<Vaga> consultaNome(String nome) {
    	vagas = entitymanager.createQuery("select x from Vagas x where x.titulo like '" + nome + "%' ").getResultList();       
        return vagas;
                
    }
    
    public void remove(Vaga vaga) {
    	try {
    		transaction.begin();			
			entitymanager.remove(entitymanager.merge(vaga));
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
        
    public List<Vaga> getLista() { 
       vagas = entitymanager.createQuery("select x from Vagas x").getResultList();       
       return vagas; 
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