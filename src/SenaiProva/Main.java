package SenaiProva;

import java.sql.SQLException;
import java.util.Scanner;

import ProjetoDao.AlunoDao;
import ProjetoDao.IAlunoDAO;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		int opcao;
		
		Scanner scanner = new Scanner(System.in);
		
		
		do {
			
			System.out.println("----GERENCIAMENTO DE CADASTROS----\n\n"
					+ "1 - cadastrar novo usuario\n"
					+ "2 - Selecionar pelo nome\n"
					+ "3 - Selecionar toda a lista\n"
					+ "4 - Mostrar id"
					+ "5 - Sair\n");
			
			opcao = scanner.nextInt();
			
			switch(opcao) {
			
				case 1 :
					
					System.out.println("Digite o nome do aluno: ");
					String nome = scanner.next();
					
					System.out.println("Digite a idade do aluno: ");
					int idade = scanner.nextInt();
					
					System.out.println("Digite a nota do aluno: ");
					double nota = scanner.nextDouble();
					
					Aluno aluno = new Aluno(nome, idade, nota);
					
					CreateAluno.CreateAluno(aluno);
					
					break;
					
				case 2 :
					
					System.out.println("Digite o nome do aluno que deseja selecionar: ");
					String consultaNome= scanner.next();
					
					FindAllAluno.FindAllAluno(consultaNome);
					
					break;
				
					
				case 3 :
					
					FindAll.FindAll();
					
					break;
					
				case 4 :
					
					IAlunoDAO alunoDao = new AlunoDao();
					Aluno Aluno = alunoDao.findById(3);
					System.out.println(Aluno.toString());
					
					
			}
			
			
			
		} while(opcao != 5);
	
		
		
		
	
		
		/*
		Aluno aluno = new Aluno("Vanderson", 25, 7.00 );
		Aluno aluno2 = new Aluno("Maria", 30, 8.00);
		Aluno aluno3 = new Aluno("João", 28, 9.00);
		
		Professor professor = new Professor("mario", 45, 1300);
		
		Turma turma = new Turma("Bem bolados\n");
		
		turma.adicionarAluno(aluno);
		turma.adicionarAluno(aluno2);
		turma.adicionarAluno(aluno3);
		
				
		
		System.out.println("Turma: " + turma.getNome());
		System.out.println("Professor: " + professor.getNome() + "| Idade: " + professor.getIdade() + 
						   "| Salário: " + professor.getSalario() + "\n");
		
		turma.visualizarTurma();
		
		*/
		
		
		
		}	
	}
