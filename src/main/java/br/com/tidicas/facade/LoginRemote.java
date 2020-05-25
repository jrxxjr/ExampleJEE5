package br.com.tidicas.facade;
import java.util.List;

import javax.ejb.Remote;

import br.com.tidicas.model.Login;

@Remote
public interface LoginRemote  { 
    
    void incluir(Login parametro);
    Login atualizar(Login parametro);
    Login consultarCodigo(int codigo);
    List<Login> consultarDescricao(String descricao);    
    void remover(Login parametro);   
    List<Login> getLista();

}