package es.ufc.teste;

import java.util.List;

import es.ufc.DAO.UsuarioJPADAO;
import es.ufc.model.Usuario;

public class Teste_Usuario {
	public static void main(String[] args) {
		UsuarioJPADAO usuarioDAO = new UsuarioJPADAO();
		List<Usuario> lista = usuarioDAO.find();
		
		for(Usuario u : lista){
			System.out.println("ID: " + u.getId());
			System.out.println("Nome: " + u.getNome());
			System.out.println("Endereço: " + u.getEndereco());
			System.out.println("Cidade: " + u.getCidade());
			System.out.println("Email: " + u.getEmail());
			System.out.println("Telefone: " + u.getTelefone());
			System.out.println("=================================================");
		}
		usuarioDAO.close();
	}

}
