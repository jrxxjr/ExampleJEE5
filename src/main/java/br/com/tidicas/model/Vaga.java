
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
 * Classe de entidade Vagas
 * 
 * @author Evaldo Junior
 */
@Entity
@Table(name="vagas")
public class Vaga implements Serializable {

	private static final long serialVersionUID = -814893417388994512L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)  
	@Column(name = "codigo") 
	private Integer codigo;
	@Column(name = "titulo") 
    private String titulo;
	@Column(name = "requisitos")
    private String requisitos;
	@Column(name = "estado") 
    private String estado;
    @Column(name = "cidade") 
    private String cidade;
    
    @JoinColumn(name="emp_id",referencedColumnName="codigo")
	@ManyToOne(optional=false,fetch=FetchType.EAGER)
    private Empresa empresa=new Empresa();
    
    /** Creates a new instance of Vagas */
    public Vaga() {
    }

    /**
     * Cria uma nova inst�ncia de Vagas com os valores especificados.
     * @param codigo o codigo do Vagas
     */
    public Vaga(Integer codigo) {
        this.codigo = codigo;
    }

    /**
     * Define o codigo deste Vagas.
     * @return o codigo
     */
    public Integer getCodigo() {
        return this.codigo;
    }

    /**
     * Define o codigo deste Vagas para o valor especificado.
     * @param codigo o novo codigo
     */
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    /**
     * Define o titulo deste Vagas.
     * @return o titulo
     */
    public String getTitulo() {
        return this.titulo;
    }

    /**
     * Define o titulo deste Vagas para o valor especificado.
     * @param titulo o novo titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Define o requisitos deste Vagas.
     * @return o requisitos
     */
    public String getRequisitos() {
        return this.requisitos;
    }

    /**
     * Define o requisitos deste Vagas para o valor especificado.
     * @param requisitos o novo requisitos
     */
    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
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
     * Determina se outro objeto � igual a este Vagas.  O resultado �
     * <code>true</code> se e somente se o argumento n�o for nulo e for um objeto Vagas o qual
     * tem o mesmo valor para o campo id como este objeto.
     * @param object o objeto de refer�ncia com o qual comparar
     * @return <code>true</code> se este objeto � o mesmo como o argumento;
     * <code>false</code> caso contr�rio.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vaga)) {
            return false;
        }
        Vaga other = (Vaga)object;
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
        return "model.Vagas[codigo=" + codigo + "]";
    }

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
    
}