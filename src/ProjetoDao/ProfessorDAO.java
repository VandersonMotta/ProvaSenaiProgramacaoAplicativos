package ProjetoDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import SenaiProva.Aluno;
import SenaiProva.ConnectionFactory;
import SenaiProva.Professor;

public class ProfessorDAO implements IProfessorDAO {
		
		@Override
		public Aluno findById(int idprofessor) {
			// TODO Auto-generated method stub
			
			Connection connection = ConnectionFactory.createConnection();
			String sql = "SELECT * FROM professor WHERE id = ?";
			PreparedStatement pdst = null;
			
			try {
				pdst = connection.prepareStatement(sql);
				pdst.setInt(1, idprofessor);
				ResultSet result = pdst.executeQuery();
				
				while(result.next()) {
					String nome = result.getString("nome");
					int idade = result.getInt("idade");
					double salario = result.getDouble("salario");
					
				}
			} catch(SQLException e) {
				
				try {
					connection.close();
					if(pdst != null) {
					pdst.close();
					}
				}
				 catch (Exception ex) {
					 
					 System.err.print("Erro no sistema");
				 }
				
			}
			
			return null;
		}
		
	
		public void cadastrarProfessor(Professor professor) {
				
				//atributo para realizar a conexao
				Connection connection = ConnectionFactory.createConnection();
				
				//atributo para salvar o comando a ser enviado
				String sqlInsertAluno = "INSERT INTO professor (nome, idade, salario) VALUES (?, ?, ?)";
				
				//condição caso houver algum erro de inserção, retornar o erro tratado
				try {
					
					//atributo que prepara a String que ser enviada
					PreparedStatement psmt = connection.prepareStatement(sqlInsertAluno);
					
					psmt.setString(1, professor.getNome());
					psmt.setInt(2, professor.getIdade());
					psmt.setDouble(3, professor.getSalario());
					
					
					//executa o metodo psmt tratado
					psmt.execute();
					psmt.close();
					
					connection.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
					System.out.println("Erro ao tentar inserir um dado no banco de dados");
				}
				
			}

		

		@Override
		public void findAll(Professor professor) {
			// TODO Auto-generated method stub
			
			Connection connection = ConnectionFactory.createConnection();
			
			String sqlSelectFrom = "SELECT * FROM professor	";
				
			try {
				PreparedStatement psmt = connection.prepareStatement(sqlSelectFrom);
				
				ResultSet result = psmt.executeQuery();
						
				while(result.next()) {
					System.out.println("Id: " + result.getInt("idprofessor") + "| Nome: " + result.getString("nome"));
				}
				
				psmt.close();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Erro ao tentar selecionar o professor");
				e.printStackTrace();
			}
			
		}

		@Override
		public void update(Professor professor) {
			// TODO Auto-generated method stub
			
			Connection connection = ConnectionFactory.createConnection();
			String updateFrom = "UPDATE professor SET nome = ?";
			
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
		public void delete(Professor professor) {
			// TODO Auto-generated method stub
			
			Connection connection = ConnectionFactory.createConnection();
			String deleteFrom = "DELETE FROM professor WHERE idprofessor = ?";
			
			PreparedStatement psmt = null;
			
			try {
				
				psmt = connection.prepareStatement(deleteFrom);
				ResultSet result = psmt.executeQuery();
			} catch (SQLException e) {
				
				e.printStackTrace();
				System.out.println("Erro no sistema");
			}
			
		}

}
