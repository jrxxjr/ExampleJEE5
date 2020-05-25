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
import javax.persistence.Query;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import org.jboss.annotation.ejb.LocalBinding;
import org.jboss.annotation.ejb.RemoteBinding;
import br.com.tidicas.model.Empresa;

@Stateful
@Local (EmpresaLocal.class)
@Remote (EmpresaRemote.class)
@RemoteBinding( jndiBinding="EmpresaBean/remote" )
@LocalBinding( jndiBinding="EmpresaBean/local" )
@TransactionManagement(TransactionManagementType.BEAN)
public class EmpresaBean  { 
    private List<Empresa> empresas; 
    
    @PersistenceUnit(unitName="Curriculo")  
    private EntityManagerFactory emf=null;
    
    @PersistenceContext(unitName = "Curriculo")  
    private EntityManager entitymanager= null;   
     
    private UserTransaction transaction = null;
        
    public EmpresaBean() { 
    	empresas = new ArrayList<Empresa>();   
    	this.emf =  Persistence.createEntityManagerFactory("Curriculo");
    	this.entitymanager=emf.createEntityManager();
    	try {
			this.transaction = (UserTransaction) new InitialContext().lookup("UserTransaction");
		} catch (Exception e) {			
			e.printStackTrace();
		} 
    } 
    
    //@TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void inclui(Empresa empresa) {
    	try {
    			  
    		transaction.begin();
	    	entitymanager.persist(empresa);
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
    
    public Empresa atualiza(Empresa empresa) {
    	try {
    		transaction.begin();
	    	empresa=entitymanager.merge(empresa);
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
        return empresa; 
    }
    
    //@TransactionAttribute(TransactionAttributeType.NEVER)
    public Empresa consultaCodigo(int codigo) {
    	Empresa empresa =null;
    	try {
    		Query query = entitymanager.createQuery("select x from Empresa as x"+ 
					" fetch all properties"+					
					" where x.codigo=" + codigo);
    	
    		empresa = (Empresa)query.getSingleResult();
    		empresa.getVagas().size();
    		    	
		} catch (Exception e) {			
			e.printStackTrace();
		}
    	
        return empresa;        
    }
    
    public List<Empresa> consultaNome(String nome) {
    	empresas = entitymanager.createQuery("select x from Empresa x where x.nome like '" + nome + "%' ").getResultList();       
        return empresas;
                
    }
    
    public Empresa consultaEmail(String email) {
    	Empresa empresa = null;   
    	empresa = (Empresa) entitymanager.createQuery("select x from Empresa x where x.email = '" + email + "' ").getSingleResult();       
        return empresa;
                
    }
    public void remove(Empresa empresa) {
    	try {
    		transaction.begin();    		
			entitymanager.remove(entitymanager.merge(empresa));
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
    
    public List<Empresa> getLista() { 
       empresas = entitymanager.createQuery("select x from Empresa x").getResultList();       
       return empresas;       
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