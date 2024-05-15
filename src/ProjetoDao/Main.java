package ProjetoDao;

import SenaiProva.Aluno;
import SenaiProva.Professor;
import SenaiProva.Turma;

public class Main {

	public static void main(String[] args) {
		
		
		AlunoDao dao = new AlunoDao();
		
		Aluno aluno = dao.findById(5);
		
		System.out.print(aluno.getNome() + aluno.getIdade() + aluno.getNota());
		
		
		
		
		
		
		
		
		
		/*
		Aluno alunoUm = new Aluno("Vanderson motta", 25, 7.8);
		Aluno alunoDois = new Aluno("Michelle Obama", 29, 6.8);
		Aluno alunoTres = new Aluno("Maikon beregon", 30, 8.8);
		
		Professor professorUm = new Professor("Douglas", 40, 1.200);
		Turma turma = new Turma("Os calangos 2");
		
		turma.adicionarAluno(alunoUm);
		
		turma.adicionarProfessor(professorUm);
		
		new AlunoDao().createAluno(alunoUm);
		new AlunoDao().createAluno(alunoDois);
		new AlunoDao().createAluno(alunoTres);
		
		new ProfessorDao().cadastrarProfessor(professorUm);
		new TurmaDao().cadastrarTurma(turma);
		*/
		
		
		
		
		
		
	
		
		

	}

}
