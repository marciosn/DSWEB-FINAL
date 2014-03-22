package es.ufc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table (name = "Atividade")
@NamedQuery (name = "Atividade.findAtividade", query = "from Atividade")
public class Atividade implements Serializable{

	private static final long serialVersionUID = -8149598540577975127L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@Basic(fetch = FetchType.EAGER)
	private int codigo;
	private String descricao;
	private String ministrante;
	private int quantidadePart;	
	private float valor;
	
	@ManyToMany(mappedBy = "atividades", cascade = CascadeType.ALL)
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getMinistrante() {
		return ministrante;
	}
	public void setMinistrante(String ministrante) {
		this.ministrante = ministrante;
	}
	public int getQuantidadePart() {
		return quantidadePart;
	}
	public void setQuantidadePart(int quantidadePart) {
		this.quantidadePart = quantidadePart;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
}
