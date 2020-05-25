package br.com.tidicas.facade;
import java.util.List;

import javax.ejb.Remote;

import br.com.tidicas.model.Curriculo;

@Remote
public interface CurriculoRemote  { 
    
    void incluir(Curriculo curriculo);
    Curriculo atualizar(Curriculo curriculo);    
    Curriculo consultarCodigo(int codigo);    
    List<Curriculo> consultarDescricao(String descricao);
    Curriculo consultarEmail(String descricao);
    void remover(Curriculo curriculo);
    List<Curriculo> getLista();
    void assimilaCurriculoExperiencia(Integer curId, Integer expId);
}