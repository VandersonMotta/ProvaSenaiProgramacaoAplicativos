package ProjetoDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import SenaiProva.ConnectionFactory;
import SenaiProva.Professor;
import SenaiProva.Turma;

public class TurmaDAO {
	
		public void cadastrarTurma(Turma turma) {
			

			Connection connection = ConnectionFactory.createConnection();
			
		
			String sqlInsertTurma = "INSERT INTO turma (nome) VALUES (?)";
			
	
			try {
				
			
				PreparedStatement psmt = connection.prepareStatement(sqlInsertTurma);
				
				psmt.setString(1, turma.getNome());
				
				
				psmt.execute();
				psmt.close();
				
				connection.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
				System.out.println("Erro ao tentar inserir um dado no banco de dados");
			}
			
		}
	
		public void findAll() {
		
		Connection connection = ConnectionFactory.createConnection();
		
		String sqlSelectFrom = "SELECT * FROM turma	";
			
		try {
			PreparedStatement psmt = connection.prepareStatement(sqlSelectFrom);
			
			ResultSet result = psmt.executeQuery();
					
			while(result.next()) {
				System.out.println("Id: " + result.getInt("idturma") + "| Nome: " + result.getString("nome"));
			}
			
			psmt.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao tentar selecionar o professor");
			e.printStackTrace();
		}
	}
		
		

}
