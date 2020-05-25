package br.com.tidicas.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;

/**
 * Classe de entidade Curriculo
 * 
 * @author Evaldo Junior 
 */
@Entity
@Table(name="empresa")
public class Empresa implements Serializable {
	 
	private static final long serialVersionUID = -2146121175116930786L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)   
	@Column(name = "codigo") 
	private Integer codigo;
	@Column(name = "nome") 
    private String nome;
	@Column(name = "email") 
    private String email;	
	@Column(name = "cnpj") 
    private String cnpj;    
    @Column(name = "telefoneDDD") 
    private Integer telefoneDDD;
    @Column(name = "telefone") 
    private Integer telefone;
    @Column(name = "recado")
    private String recado;
    @Column(name = "celularDDD")
    private Integer celularDDD;
    @Column(name = "celular")
    private Integer celular;
    @Column(name = "homePage")
    private String homePage;
    @Column(name = "endereco") 
    private String endereco;
    @Column(name = "numero") 
    private Integer numero;
    @Column(name = "complemento")
    private String complemento;
    @Column(name = "bairro") 
    private String bairro;
    @Column(name = "cep") 
    private Integer cep;
    @Column(name = "estado") 
    private String estado;
    @Column(name = "cidade") 
    private String cidade;    
    @Column(name = "ramo")
    private String ramo;
    
    @OneToMany(mappedBy="empresa", cascade={CascadeType.ALL,CascadeType.REMOVE})
    @Cascade(value=org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
    private Collection<Vaga> vagas=new ArrayList<Vaga>();
    
    @JoinColumn(name="login_id",referencedColumnName="codigo")
	@OneToOne(cascade = CascadeType.ALL)
    private Login login=new Login();
    
    /** Creates a new instance of Empresa */
    public Empresa() {
    }

    /**
     * Cria uma nova inst�ncia de Curriculo com os valores especificados.
     * @param codigo o codigo do Curriculo
     */
    public Empresa(Integer codigo) {
        this.codigo = codigo;
    }
    
    /**
     * Define o codigo deste Curriculo.
     * @return o codigo
     */
    
    public Integer getCodigo() {
        return this.codigo;
    }

    /**
     * Define o codigo deste Curriculo para o valor especificado.
     * @param codigo o novo codigo
     */
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    /**
     * Define o nome deste Curriculo.
     * @return o nome
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Define o nome deste Curriculo para o valor especificado.
     * @param nome o novo nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Define o email deste Curriculo.
     * @return o email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Define o email deste Curriculo para o valor especificado.
     * @param email o novo email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Define o sexo deste Curriculo.
     * @return o sexo
     */
    
    /**
     * Define o telefoneDDD deste Curriculo.
     * @return o telefoneDDD
     */
    public Integer getTelefoneDDD() {
        return this.telefoneDDD;
    }

    /**
     * Define o telefoneDDD deste Curriculo para o valor especificado.
     * @param telefoneDDD o novo telefoneDDD
     */
    public void setTelefoneDDD(Integer telefoneDDD) {
        this.telefoneDDD = telefoneDDD;
    }

    /**
     * Define o telefone deste Curriculo.
     * @return o telefone
     */
    public Integer getTelefone() {
        return this.telefone;
    }

    /**
     * Define o telefone deste Curriculo para o valor especificado.
     * @param telefone o novo telefone
     */
    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    /**
     * Define o recado deste Curriculo.
     * @return o recado
     */
    public String getRecado() {
        return this.recado;
    }

    /**
     * Define o recado deste Curriculo para o valor especificado.
     * @param recado o novo recado
     */
    public void setRecado(String recado) {
        this.recado = recado;
    }

    /**
     * Define o celularDDD deste Curriculo.
     * @return o celularDDD
     */
    public Integer getCelularDDD() {
        return this.celularDDD;
    }

    /**
     * Define o celularDDD deste Curriculo para o valor especificado.
     * @param celularDDD o novo celularDDD
     */
    public void setCelularDDD(Integer celularDDD) {
        this.celularDDD = celularDDD;
    }

    /**
     * Define o celular deste Curriculo.
     * @return o celular
     */
    public Integer getCelular() {
        return this.celular;
    }

    /**
     * Define o celular deste Curriculo para o valor especificado.
     * @param celular o novo celular
     */
    public void setCelular(Integer celular) {
        this.celular = celular;
    }

    /**
     * Define o homePage deste Curriculo.
     * @return o homePage
     */
    public String getHomePage() {
        return this.homePage;
    }

    /**
     * Define o homePage deste Curriculo para o valor especificado.
     * @param homePage o novo homePage
     */
    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }

    /**
     * Define o endereco deste Curriculo.
     * @return o endereco
     */
    public String getEndereco() {
        return this.endereco;
    }

    /**
     * Define o endereco deste Curriculo para o valor especificado.
     * @param endereco o novo endereco
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Define o numero deste Curriculo.
     * @return o numero
     */
    public Integer getNumero() {
        return this.numero;
    }

    /**
     * Define o numero deste Curriculo para o valor especificado.
     * @param numero o novo numero
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    /**
     * Define o complemento deste Curriculo.
     * @return o complemento
     */
    public String getComplemento() {
        return this.complemento;
    }

    /**
     * Define o complemento deste Curriculo para o valor especificado.
     * @param complemento o novo complemento
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * Define o bairro deste Curriculo.
     * @return o bairro
     */
    public String getBairro() {
        return this.bairro;
    }

    /**
     * Define o bairro deste Curriculo para o valor especificado.
     * @param bairro o novo bairro
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * Define o cep1 deste Curriculo.
     * @return o cep1
     */
    public Integer getCep() {
        return this.cep;
    }

    /**
     * Define o cep1 deste Curriculo para o valor especificado.
     * @param cep1 o novo cep1
     */
    public void setCep(Integer cep) {
        this.cep = cep;
    }

    /**
     * Define o estado deste Curriculo.
     * @return o estado
     */
    public String getEstado() {
        return this.estado;
    }

    /**
     * Define o estado deste Curriculo para o valor especificado.
     * @param estado o novo estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Define o cidade deste Curriculo.
     * @return o cidade
     */
    public String getCidade() {
        return this.cidade;
    }

    /**
     * Define o cidade deste Curriculo para o valor especificado.
     * @param cidade o novo cidade
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    
    /**
     * Define o ramo deste Curriculo.
     * @return o ramo
     */
    public String getRamo() {
        return this.ramo;
    }

    /**
     * Define o ramo deste Curriculo para o valor especificado.
     * @param ramo o novo ramo
     */
    public void setRamo(String ramo) {
        this.ramo = ramo;
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
     * Determina se outro objeto � igual a este Curriculo.  O resultado �
     * <code>true</code> se e somente se o argumento n�o for nulo e for um objeto Curriculo o qual
     * tem o mesmo valor para o campo id como este objeto.
     * @param object o objeto de refer�ncia com o qual comparar
     * @return <code>true</code> se este objeto � o mesmo como o argumento;
     * <code>false</code> caso contr�rio.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa)object;
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
        return "model.Curriculo[codigo=" + codigo + "]";
    }
    
	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Collection<Vaga> getVagas() {
		return vagas;
	}

	public void setVagas(Collection<Vaga> vagas) {
		this.vagas = vagas;
	}

}