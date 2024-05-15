package SenaiProva;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FindAllAluno {
	
	public static void FindAllAluno(String consultaNome) throws SQLException {
		
		Connection connection = ConnectionFactory.createConnection();
		
		String sqlSelectAluno = "SELECT * FROM aluno where nome = ?";
		
		PreparedStatement pmst = connection.prepareStatement(sqlSelectAluno);
		
		pmst.setString(1, consultaNome);
		
		ResultSet result = pmst.executeQuery();
		
		while(result.next()) {
			System.out.println("Id: " + result.getInt("id_aluno") + "| Nome: " + result.getString("nome"));
		}
	}

}
