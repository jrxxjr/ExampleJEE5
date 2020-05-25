package br.com.tidicas.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Classe de entidade Idiomas
 * 
 * @author Evaldo Junior
 */
@Entity
@Table(name="idiomas")
public class Idioma implements Serializable {

	private static final long serialVersionUID = 6542155822467884187L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)  
	@Column(name = "codigo") 
	private Integer codigo;
	@Column(name = "descricao") 
    private String descricao;
	@Column(name = "nivel")
    private Integer nivel;
	@JoinColumn(name="cur_id",referencedColumnName="codigo")
	@ManyToOne(optional=false,fetch=FetchType.EAGER)
    private Curriculo curriculo=new Curriculo();
    
    /** Creates a new instance of Idiomas */
    public Idioma() {
    }

    /**
     * Cria uma nova inst�ncia de Idiomas com os valores especificados.
     * @param codigo o codigo do Idiomas
     */
    public Idioma(Integer codigo) {
        this.codigo = codigo;
    }

    /**
     * Define o codigo deste Idiomas.
     * @return o codigo
     */
    public Integer getCodigo() {
        return this.codigo;
    }

    /**
     * Define o codigo deste Idiomas para o valor especificado.
     * @param codigo o novo codigo
     */
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    /**
     * Define o descricao deste Idiomas.
     * @return o descricao
     */
    public String getDescricao() {
        return this.descricao;
    }

    /**
     * Define o descricao deste Idiomas para o valor especificado.
     * @param descricao o novo descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Define o nivel deste Idiomas.
     * @return o nivel
     */
    public Integer getNivel() {
        return this.nivel;
    }

    /**
     * Define o nivel deste Idiomas para o valor especificado.
     * @param nivel o novo nivel
     */
    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    /**
     * Retorna um valor de c�digo hash para o objeto.  Esta implementa��o computa
     * um valor de c�digo hash baseado nos campos id deste objeto.
     * @return um valor de c�digo hash para este objeto.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.codigo != null ? this.codigo.hashCode() : 0);
        return hash;
    }

    /**
     * Determina se outro objeto � igual a este Idiomas.  O resultado �
     * <code>true</code> se e somente se o argumento n�o for nulo e for um objeto Idiomas o qual
     * tem o mesmo valor para o campo id como este objeto.
     * @param object o objeto de refer�ncia com o qual comparar
     * @return <code>true</code> se este objeto � o mesmo como o argumento;
     * <code>false</code> caso contr�rio.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Idioma)) {
            return false;
        }
        Idioma other = (Idioma)object;
        if (this.codigo != other.codigo && (this.codigo == null || !this.codigo.equals(other.codigo))) return false;
        return true;
    }

    /**
     * Retorna uma representa��o literal deste objeto.  Esta implementa��o cria
     * uma representa��o baseada nos campos id.
     * @return uma representa��o literal deste objeto.
     */
    @Override
    public String toString() {
        return "model.Idiomas[codigo=" + codigo + "]";
    }
    
    public Curriculo getCurriculo() {
		return curriculo;
	}

	public void setCurriculos(Curriculo curriculo) {
		this.curriculo = curriculo;
	}
    
}
