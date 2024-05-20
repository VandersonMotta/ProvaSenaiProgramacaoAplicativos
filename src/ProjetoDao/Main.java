package ProjetoDao;

import java.sql.SQLException;
import java.util.Scanner;

import SenaiProva.Aluno;
import SenaiProva.Professor;
import SenaiProva.Turma;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		
		AlunoDAO dao = new AlunoDAO();
		Aluno aluno = new Aluno(null, 0, 0);
		
		
		
		int opcao = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		do {
			
			System.out.println("-----ALUNOS-------\n\n"
					+ "1-  Cadastrar novo aluno\n"
					+ "2 - buscar pelo id do aluno\n"
					+ "3 - Selecionar todos\n"
					+ "4 - deletar\n"
					+ "5 - update\n"
					+ "6 - sair");
			opcao = scanner.nextInt();
			
			switch(opcao) {
			
				case 1 :
					System.out.println("Digite o nome do aluno");
					String nome = scanner.next();
					
					System.out.println("Digite a idade do aluno");
					int idade = scanner.nextInt();
					
					System.out.println("Digite a média do aluno");
					double nota = scanner.nextDouble();
					
					aluno = new Aluno(nome, idade, nota);
					
					dao.createAluno(aluno);
					
					break;
					
				case 2 :
					aluno = dao.findById(2);
					break;
					
				case 3 :
					dao.findAll(aluno);
					break;
					
				case 4 :
					dao.delete(aluno);
					break;
					
				case 5 :
					dao.update(aluno);
					break;
					
					
					
			}
			
		} while(opcao !=6);
		
		
		
		
		
		
		
		
		
		
		
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
