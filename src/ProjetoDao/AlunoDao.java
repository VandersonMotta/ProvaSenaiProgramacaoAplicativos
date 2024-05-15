package ProjetoDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import SenaiProva.Aluno;
import SenaiProva.ConnectionFactory;

public class AlunoDao implements IAlunoDAO {

	
	public Aluno findById(int id_aluno) {
		
		Connection connection = ConnectionFactory.createConnection();
		String selectId = "SELECT * FROM aluno where id_aluno = ?";
		PreparedStatement psmt = null;
		
		
		try {
			psmt = connection.prepareStatement(selectId);
			psmt.setInt(1, id_aluno);
			ResultSet result = psmt.executeQuery();
			
			while(result.next()) {
				
				String nome = result.getString("nome");
				int idade = result.getInt("idade");
				double nota = result.getDouble("nota");
				Aluno aluno = new Aluno(nome, idade, nota);
				return aluno;
			}
		
		} catch (SQLException e) {
			
			try {
				connection.close();
				if(psmt != null) {
				psmt.close();
				}
			}
			 catch (Exception ex) {
				 
				 System.err.print("Erro no sistema");
			 }
			
		}
		
		return null;
	}


	@Override
	public void update(Aluno aluno) {
		
		Connection connection = ConnectionFactory.createConnection();
		String updateFrom = "UPDATE aluno SET nome = ?";
		
		PreparedStatement psmt = null;
		
		try {
			
			psmt = connection.prepareStatement(updateFrom);
			ResultSet result = psmt.executeQuery();
		} catch(SQLException e) {
			
			e.printStackTrace();
			System.out.println("Ocorreu algum erro");
		}
	}

	@Override
	public void delete(Aluno aluno) {
		
		Connection connection = ConnectionFactory.createConnection();
		String deleteFrom = "DELETE FROM aluno WHERE id_aluno = ?";
		
		PreparedStatement psmt = null;
		
		try {
			
			psmt = connection.prepareStatement(deleteFrom);
			ResultSet result = psmt.executeQuery();
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.out.println("Erro no sistema");
		}
		
	}


	@Override
	public void findAll(Aluno aluno) {
		// TODO Auto-generated method stub
		
		Connection connection = ConnectionFactory.createConnection();
		String selectFrom = "SELECT * FROM aluno";
		PreparedStatement psmt = null;
		
		try {
			
			psmt = connection.prepareStatement(selectFrom);
			ResultSet result = psmt.executeQuery();
			
			while(result.next()){
				
				while(result.next()) {
					System.out.println("Id: " + result.getInt("id_aluno") + "| Nome: " + result.getString("nome"));
				}
				psmt.close();
				
				
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.out.println("Erro ao se conectar");
		}	
		
		
	}

	@Override
	public void createAluno(Aluno aluno) {
		// TODO Auto-generated method stub
		
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
