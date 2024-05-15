package SenaiProva;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FindAll {
	
	public static void FindAll() {
		
		Connection connection = ConnectionFactory.createConnection();
		
		String sqlSelectFrom = "SELECT * FROM aluno	";
			
		try {
			PreparedStatement psmt = connection.prepareStatement(sqlSelectFrom);
			ResultSet result = psmt.executeQuery();
			
			while(result.next()) {
				System.out.println("Id: " + result.getInt("id_aluno") + "| Nome: " + result.getString("nome"));
			}
			psmt.execute();
			psmt.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao tentar selecionar os alunos");
			e.printStackTrace();
		}
		
	}

}
	