package es.ufc.control;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import es.ufc.DAO.AtividadeJPADAO;
import es.ufc.DAO.UsuarioJPADAO;
import es.ufc.model.Atividade;
import es.ufc.model.Usuario;
@ManagedBean
//@ApplicationScoped
public class AtividadeBean {

	private Atividade atividade = new Atividade();
	private Usuario participante = new Usuario();
	private Usuario usuario = new Usuario();
	//
	
	private List<Atividade> atividades = new ArrayList<Atividade>();
	//private List<Usuario> participantes = new ArrayList<Usuario>();
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	private AtividadeJPADAO atividadeDAO = new AtividadeJPADAO();
	private UsuarioJPADAO usuarioDAO = new UsuarioJPADAO();
	
	private int id;
	private int id2;
		
	public String criarAtividade(){
		
		try{
			atividadeDAO.beginTransaction();
			atividadeDAO.save(atividade);
			atividadeDAO.commit();
		}catch(Exception e){
			atividadeDAO.rollback();
			e.printStackTrace();
		}finally{
			atividadeDAO.close();
		}
		return "/pages/listarAtividades?faces-redirect=true";
	}
	
	public List<Atividade> getAtividadeBanco(){
		List<Atividade> atividades = atividadeDAO.find();
		return atividades;
	}
	
    public List<Usuario> getListaUsuario(){
	List<Usuario> usuarios = new ArrayList<Usuario>();
	List<Atividade> aux = getAtividadeBanco();
	for(int i=0; i < aux.size();i++){
		if(id == aux.get(i).getCodigo()){
			System.out.println("entrou no if");
			usuarios = aux.get(i).getUsuarios();
		}
	}
	return usuarios;
}
public List<Usuario> ListarUsuarios(){
	usuarios = atividade.getUsuarios();
	return usuarios;	
}
public String AddUsuarioInAtividade(){
	System.out.println("==========================ENTROU NO MÉTODO ADD=================================");
	List<Usuario> u ;
	Usuario aux = null;
	u = usuarioDAO.find();
	for(int i=0; i < u.size();i++){
		if(id2 == u.get(i).getId()){
			aux = u.get(i);
			System.out.println("passou pelo IF");
			}
			
	try{
		atividadeDAO.beginTransaction();
		atividade.getUsuarios().add(aux);
		atividadeDAO.save(this.atividade);
		atividadeDAO.commit();
	}catch (Exception e) {
		atividadeDAO.rollback();
		e.printStackTrace();
	}finally{
		atividadeDAO.close();
	}

}
	return "/pages/listarAtividades?faces-redirect=true";
}
public String deletaAtividade(){
		
		try{
			atividadeDAO.beginTransaction();
			atividadeDAO.delete(this.atividade);
			atividadeDAO.commit();
		}catch (Exception e){
			atividadeDAO.rollback();
			e.printStackTrace();
		}finally{
			atividadeDAO.close();
		}
		return "/pages/listarAtividades?faces-redirect=true";
	}
	public Atividade getAtividade() {
		return atividade;
	}
	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}
	public List<Atividade> getAtividades() {
		return atividades;
	}
	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return participante;
	}
	public void setUsuario(Usuario usuario) {
		this.participante = usuario;
	}
	public int getId2() {
		return id2;
	}
	public void setId2(int id2) {
		this.id2 = id2;
	}
}
