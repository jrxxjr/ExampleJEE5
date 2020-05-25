package br.com.tidicas.facade;
import java.util.List;

import javax.ejb.Local;

import br.com.tidicas.model.Empresa;

@Local
public interface EmpresaLocal  { 
    
    void incluir(Empresa empresa);
    Empresa atualizar(Empresa empresa);    
    Empresa consultarCodigo(int codigo);    
    List<Empresa> consultarDescricao(String descricao);
    Empresa consultarEmail(String descricao);
    void remover(Empresa empresa);
    List<Empresa> getLista();
    

}