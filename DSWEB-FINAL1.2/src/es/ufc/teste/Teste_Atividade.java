package es.ufc.teste;

import java.util.List;

import es.ufc.DAO.AtividadeJPADAO;
import es.ufc.model.Atividade;

public class Teste_Atividade {

	public static void main(String[] args) {

		AtividadeJPADAO atividadeDAO = new AtividadeJPADAO();
		List<Atividade> lista = atividadeDAO.find();
		
		for(Atividade a: lista){
			System.out.println("CODIGO: " + a.getCodigo());
			System.out.println("Descrição: " + a.getDescricao());
			System.out.println("Ministrante: " + a.getMinistrante());
			System.out.println("Quantidade Part: " + a.getQuantidadePart());
			System.out.println("Valor R$: " + a.getValor());
			System.out.println("================================================");
		}
		atividadeDAO.close();
	}

}
