package br.com.tidicas.facade;
import java.util.List;
import javax.ejb.Local;

import br.com.tidicas.model.Curriculo;

@Local
public interface CurriculoLocal  { 
    
    void incluir(Curriculo curriculo);
    Curriculo atualizar(Curriculo curriculo);    
    Curriculo consultarCodigo(int codigo);    
    List<Curriculo> consultarDescricao(String descricao);
    Curriculo consultarEmail(String descricao);
    void remover(Curriculo curriculo);
    List<Curriculo> getLista();
    void assimilaCurriculoExperiencia(Integer curId, Integer expId);

}