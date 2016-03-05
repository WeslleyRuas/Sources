package me.weslleyruas.testconection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL{
	public static String status = "Não conectou..."; 
	public static Connection connection = null;
	public ConexaoMySQL() 
	{ 
	}
	public static java.sql.Connection getConexaoMySQL() {
		try{
			String driverName = "com.mysql.jdbc.Driver";
			Class.forName(driverName);
			String serverName = "localhost";
			String mydatabase = "teste";
			String url = "jdbc:mysql://" + serverName+ "/" + mydatabase;
			String username = "root";
			String password = "123456";
			connection = DriverManager.getConnection(url, username,password);
			if(connection != null)
			{
				status = ("MySQL ---> Conectado com sucesso");
			}
			else
			{
				status = ("MySQL ---> Nao foi possivel realizar a conexao");
			}
			return connection;
			}
		catch(ClassNotFoundException e)
			{
			System.out.println("O driver especificado nao foi encontrado");
			return null;
			}
		catch(SQLException e)
			{
			System.out.println("Nao foi possivel conectar ao Banco de Dados."); 
			return null;
			}
		}
	public static boolean FecharConexao(){
		try{
			ConexaoMySQL.getConexaoMySQL().close();
			return true;
		} catch(SQLException e){
			return false;
		}
		
		}
	public static java.sql.Connection ReiniciarConexao() 
	{ 
		FecharConexao(); 
		return ConexaoMySQL.getConexaoMySQL(); 
		}
	}
