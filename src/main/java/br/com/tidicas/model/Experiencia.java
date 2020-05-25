package br.com.tidicas.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe de entidade Experiencias
 * 
 * @author Evaldo Junior
 */
@Entity
@Table(name="experiencias")
public class Experiencia implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6938926391096974419L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)  
	@Column(name = "codigo") 
	private Integer codigo;
	@Temporal(TemporalType.DATE)
	@Column(name = "dataentradamesano") 
    private Date dataEntradaMesAno;
	@Temporal(TemporalType.DATE)
	@Column(name = "datasaidamesano") 
    private Date dataSaidaMesAno;
	@Column(name = "nomeempresa") 
    private String nomeEmpresa;
	@Column(name = "experienciaCargo")
    private String experienciaCargo;
	@Column(name = "descricao")
    private String descricao;
	@JoinColumn(name="cur_id",referencedColumnName="codigo")
	@ManyToOne(optional=false,fetch=FetchType.EAGER)
    private Curriculo curriculo=new Curriculo();
    
    /** Creates a new instance of Experiencias */
    public Experiencia() {
    }

    /**
     * Cria uma nova inst�ncia de Experiencias com os valores especificados.
     * @param codigo o codigo do Experiencias
     */
    public Experiencia(Integer codigo) {
        this.codigo = codigo;
    }

    
    /**
     * Define o codigo deste Experiencias.
     * @return o codigo
     */
    public Integer getCodigo() {
        return this.codigo;
    }

    /**
     * Define o codigo deste Experiencias para o valor especificado.
     * @param codigo o novo codigo
     */
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    
    /**
     * Define o nomeEmpresa deste Experiencias.
     * @return o nomeEmpresa
     */
    public String getNomeEmpresa() {
        return this.nomeEmpresa;
    }

    /**
     * Define o nomeEmpresa deste Experiencias para o valor especificado.
     * @param nomeEmpresa o novo nomeEmpresa
     */
    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    /**
     * Define o experienciaCargo deste Experiencias.
     * @return o experienciaCargo
     */
    public String getExperienciaCargo() {
        return this.experienciaCargo;
    }

    /**
     * Define o experienciaCargo deste Experiencias para o valor especificado.
     * @param experienciaCargo o novo experienciaCargo
     */
    public void setExperienciaCargo(String experienciaCargo) {
        this.experienciaCargo = experienciaCargo;
    }

    /**
     * Define o descricao deste Experiencias.
     * @return o descricao
     */
    public String getDescricao() {
        return this.descricao;
    }

    /**
     * Define o descricao deste Experiencias para o valor especificado.
     * @param descricao o novo descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Curriculo getCurriculo() {
        return curriculo;
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
     * Determina se outro objeto � igual a este Experiencias.  O resultado �
     * <code>true</code> se e somente se o argumento n�o for nulo e for um objeto Experiencias o qual
     * tem o mesmo valor para o campo id como este objeto.
     * @param object o objeto de refer�ncia com o qual comparar
     * @return <code>true</code> se este objeto � o mesmo como o argumento;
     * <code>false</code> caso contr�rio.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Experiencia)) {
            return false;
        }
        Experiencia other = (Experiencia)object;
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
        return "model.Experiencias[codigo=" + codigo + "]";
    }

	public void setCurriculos(Curriculo curriculo) {
		this.curriculo = curriculo;
	}

	public Date getDataEntradaMesAno() {
		return dataEntradaMesAno;
	}

	public void setDataEntradaMesAno(Date dataEntradaMesAno) {
		this.dataEntradaMesAno = dataEntradaMesAno;
	}

	public Date getDataSaidaMesAno() {
		return dataSaidaMesAno;
	}

	public void setDataSaidaMesAno(Date dataSaidaMesAno) {
		this.dataSaidaMesAno = dataSaidaMesAno;
	}
    
}
