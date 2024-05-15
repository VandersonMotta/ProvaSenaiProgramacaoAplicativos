package SenaiProva;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;

public class ConnectionFactory {
	
	
	//método que cria uma conexão
	public static Connection createConnection() {
		
		//atributos de acesso o banco
		String url = "jdbc:mysql://localhost:3306/provasenai";
		String user = "root";
		String password = "vander.1998";
		
		//atributo que salva a connection
		Connection connection = null;
		
		
		//estrutura caso der erro, ter como tratar o erro
		try {
			 connection = DriverManager.getConnection(url, user, password);
			 
		} catch (SQLSyntaxErrorException e) {
			
			e.printStackTrace();
			System.out.println("Comando inválido");
			
			
		} catch (SQLException e) {
			
			System.out.println("Erro ao tentar conexão");
			e.printStackTrace();
		}
		
		return connection;
		
		
	}

}
