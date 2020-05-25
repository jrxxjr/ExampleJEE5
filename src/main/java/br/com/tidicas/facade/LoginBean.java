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
import br.com.tidicas.model.Login;

@Stateful
@Local (LoginLocal.class)
@Remote (LoginRemote.class)
@RemoteBinding( jndiBinding="LoginBean/remote" )
@LocalBinding( jndiBinding="LoginBean/local" )
@TransactionManagement(TransactionManagementType.BEAN)
public class LoginBean { 
    private List<Login> login; 
    
    @PersistenceUnit(unitName = "Curriculo")  
    private EntityManagerFactory emf=null;
    @PersistenceContext (unitName="Curriculo")
    private EntityManager entitymanager= null;
    private UserTransaction transaction = null;
        
    public LoginBean() { 
    	login = new ArrayList<Login>(); 
    	this.emf =  Persistence.createEntityManagerFactory("Curriculo");  
    	this.entitymanager=emf.createEntityManager();
    	try {
			this.transaction = (UserTransaction) new InitialContext().lookup("UserTransaction");
		} catch (Exception e) {			
			e.printStackTrace();
		}
    } 
    
    public void inclui(Login parametro) {
    	try {
    		System.out.println("login para incluir:");
    		transaction.begin();			
	    	entitymanager.persist(parametro);
	    	transaction.commit();
	    	System.out.println("login incluido:" + parametro.getCodigo());
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
    
    public Login atualiza(Login parametro) {
    	try {
    		transaction.begin();			
	    	parametro=entitymanager.merge(parametro);
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
        return parametro; 
    }
    
    public Login consultaCodigo(int codigo) {
        return entitymanager.find(Login.class,codigo);        
    }
    
    public void remove(Login parametro) {
    	try {
    		transaction.begin();			
			entitymanager.remove(entitymanager.merge(parametro));
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
		}
    }
        
    public List<Login> getLista() { 
       login = entitymanager.createQuery("select x from Login x").getResultList();       
       return login; 
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