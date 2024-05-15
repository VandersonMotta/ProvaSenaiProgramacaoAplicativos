package ProjetoDao;

import SenaiProva.Aluno;
import SenaiProva.Professor;
import SenaiProva.Turma;

public interface IturmaDAO {
	
	Aluno findById(int id_turma);
	void  findAll(Turma turma);
	void cadastrarTurma(Turma turma);
	void update(Turma turma);
	void delete(Turma turma);

}
