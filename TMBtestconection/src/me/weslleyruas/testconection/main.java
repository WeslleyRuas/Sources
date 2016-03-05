package me.weslleyruas.testconection;

import me.weslleyruas.testconection.ConexaoMySQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
	Statement statement = null;
	public void onEnable(){
		ConexaoMySQL.getConexaoMySQL();
		Connection z = ConexaoMySQL.connection;
		if(z != null){
		try {
			statement = z.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			statement.executeUpdate("INSERT INTO teste (`PlayerName`) VALUES ('teste');");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Inserted info");
		}
	}
	}
