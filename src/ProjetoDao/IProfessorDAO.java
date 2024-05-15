package ProjetoDao;

import java.util.List;

import SenaiProva.Aluno;
import SenaiProva.Professor;

public interface IProfessorDAO {
	
	Aluno findById(int id_professor);
	void  findAll(Professor professor);
	void cadastrarProfessor(Professor professor);
	void update(Professor professor);
	void delete(Professor professor);

}
