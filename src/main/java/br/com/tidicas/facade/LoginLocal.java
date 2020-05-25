package br.com.tidicas.facade;
import java.util.List;

import javax.ejb.Local;

import br.com.tidicas.model.Login;

@Local 
public interface LoginLocal  { 
    
    void incluir(Login parametro);
    Login atualizar(Login parametro);
    Login consultarCodigo(int codigo);
    List<Login> consultarDescricao(String descricao);    
    void remover(Login parametro);   
    List<Login> getLista();

}