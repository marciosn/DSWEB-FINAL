package es.ufc.control;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import es.ufc.DAO.AtividadeDAO;
import es.ufc.DAO.AtividadeJPADAO;
import es.ufc.DAO.UsuarioJPADAO;
import es.ufc.model.Atividade;
import es.ufc.model.Usuario;
@ManagedBean
public class UsuarioBean {
	
	private Usuario usuario = new Usuario();
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	private List<Atividade> atividades = new ArrayList<Atividade>();
	private UsuarioJPADAO usuarioDAO = new UsuarioJPADAO();
	private AtividadeJPADAO atividadeDAO = new AtividadeJPADAO();
	
	private int id;
	
	public String inserirUsuario(){
		
		try{
			usuarioDAO.beginTransaction();
			usuarioDAO.save(usuario);
			usuarios.add(usuario);
			usuarioDAO.commit();
		}catch(Exception e){
			usuarioDAO.rollback();
			e.printStackTrace();
		}finally{
			usuarioDAO.close();
		}
		return "/pages/listarUsuario?faces-redirect=true";
	}
	
	public List<Usuario> getUsuariosBanco(){
		List<Usuario> usuarios = usuarioDAO.find();
		return usuarios;
	
	}
	public List<Atividade> getListaAtividade(){
		List<Atividade> atividades = new ArrayList<Atividade>();
		List<Usuario> aux = getUsuariosBanco();
		for(int i=0; i < aux.size();i++){
			if(id == aux.get(i).getId()){
				atividades = aux.get(i).getAtividades();
			}
		}
		return atividades;
	}
	
	public String deletaUsuario(){
		try{
			usuarioDAO.beginTransaction();
			usuarioDAO.delete(usuario);
			usuarioDAO.commit();
		}catch (Exception e) {
			usuarioDAO.rollback();
			e.printStackTrace();
		}finally{
			usuarioDAO.close();
		}
		
		return "/pages/listarUsuario?faces-redirect=true";
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}
	
	
}
