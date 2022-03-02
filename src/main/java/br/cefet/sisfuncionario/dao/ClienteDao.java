package br.cefet.sisfuncionario.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import br.cefet.sisfuncionario.model.Setor;
import br.cefet.sisfuncionario.model.Cliente;


public class ClienteDao {
	
	public void adicionar(Cliente cliente) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		String sql = "insert cliente(nome, endereco, login, pass) "
				+ " values (?,?,?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, cliente.getNome());
		stmt.setString(2, cliente.getEndereco());
		stmt.setString(3, cliente.getLogin());
		stmt.setString(4, cliente.getPass());
		stmt.execute();
		stmt.close();
		con.close();
	}
	
	
	
	public Cliente listarUm(String login, String pass) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		String sql = "select id, nome, endereco, login, pass "
				+ " from cliente where login = ? and pass = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, login);
		stmt.setString(2, pass);
		ResultSet rs = stmt.executeQuery();
		
		Cliente cliente = null;		
		if (rs.next()) {
			int id = rs.getInt("id");
			String nome = rs.getString("nome");
			String endereco = rs.getString("endereco");
			cliente = new Cliente();
			cliente.setId(id);
			cliente.setNome(nome);
			cliente.setPass(pass);
			cliente.setLogin(login);
			cliente.setEndereco(endereco);
		}	
		stmt.close();
		con.close();
		return cliente;
		
	}
	
	
	

}
