package SenaiProva;

import java.util.ArrayList;

public class Turma {
	private String nome;
	private Professor professor;
	
	private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	private ArrayList<Professor> professores = new ArrayList<Professor>();
	private ArrayList<Turma> turma = new ArrayList<Turma>();
	
	public Turma(String nome) {
		
		this.nome=nome;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void adicionarAluno(Aluno aluno) {
		
		alunos.add(aluno);	
	}

	public void adicionarProfessor(Professor professor) {
		
		this.professor = professor;
		
	}
	
	
	public void visualizarTurma() {
		
		
		for(Aluno aluno : this.alunos) {
			
			System.out.println("Nome: " + aluno.getNome() + "| Idade: " + aluno.getIdade() + " | Nota: " + aluno.getNota());
		}
	}


}