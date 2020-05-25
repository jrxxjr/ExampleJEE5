package br.com.tidicas.facade;
import java.util.List;
import javax.ejb.Local;

import br.com.tidicas.model.Vaga;

@Local 
public interface VagasLocal  { 
    
    void incluir(Vaga parametro);
    Vaga atualizar(Vaga parametro);
    Vaga consultarCodigo(int codigo);
    List<Vaga> consultarDescricao(String descricao);    
    void remover(Vaga parametro);   
    List<Vaga> getLista();

}