package br.com.tidicas.facade;
import java.util.List;

import javax.ejb.Remote;

import br.com.tidicas.model.Empresa;

@Remote
public interface EmpresaRemote  { 
    
    void incluir(Empresa empresa);
    Empresa atualizar(Empresa empresa);    
    Empresa consultarCodigo(int codigo);    
    List<Empresa> consultarDescricao(String descricao);
    Empresa consultarEmail(String descricao);
    void remover(Empresa empresa);
    List<Empresa> getLista();
    
}