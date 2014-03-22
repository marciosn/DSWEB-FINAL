package es.ufc.DAO;

import es.ufc.model.Atividade;

public class AtividadeJPADAO extends GenericJPADAO<Atividade> implements AtividadeDAO{
	
	public AtividadeJPADAO(){
		this.persistentClass = Atividade.class;
	}

}
