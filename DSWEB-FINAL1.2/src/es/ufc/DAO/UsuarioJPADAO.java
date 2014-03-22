package es.ufc.DAO;

import es.ufc.model.Usuario;

public class UsuarioJPADAO extends GenericJPADAO<Usuario> implements UsuarioDAO{
	
	public UsuarioJPADAO(){
		this.persistentClass = Usuario.class;
	}
}
