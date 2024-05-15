package ProjetoDao;

import java.util.List;

import SenaiProva.Aluno;

public interface IAlunoDAO {
	
	Aluno findById(int id_aluno);
	void findAll(Aluno aluno);
	void createAluno(Aluno aluno);
	void update(Aluno aluno);
	void delete(Aluno aluno);
	


}
