package SenaiProva;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateAluno {
	
	//método para criar e tratar o comando que será enviado para o banco
	public static void CreateAluno(Aluno aluno) {
		
		//atributo para realizar a conexao
		Connection connection = ConnectionFactory.createConnection();
		
		//atributo para salvar o comando a ser enviado
		String sqlInsertAluno = "INSERT INTO aluno (nome, idade, nota) VALUES (?, ?, ?)";
		
		//condição caso houver algum erro de inserção, retornar o erro tratado
		try {
			
			//atributo que prepara a String que ser enviada
			PreparedStatement psmt = connection.prepareStatement(sqlInsertAluno);
			
			psmt.setString(1, aluno.getNome());
			psmt.setInt(2, aluno.getIdade());
			psmt.setDouble(3, aluno.getNota());
			
			
			//executa o metodo psmt tratado
			psmt.execute();
			psmt.close();
			
			connection.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.out.println("Erro ao tentar inserir um dado no banco de dados");
		}
		
	}

}
