package br.cefet.sisfuncionario.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.cefet.sisfuncionario.model.Funcionario;
import br.cefet.sisfuncionario.model.Setor;

public class FuncionarioDao {

	public void adicionar(Funcionario funcionario) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		String sql = "insert funcionario(nome,profissao,idsetor) values (?,?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, funcionario.getNome());
		stmt.setString(2, funcionario.getProfissao());
		stmt.setInt(3, funcionario.getSetor().getId());
		stmt.execute();
		stmt.close();
		con.close();
	}
	
	public List<Funcionario> listar(String texto) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		texto = "%" + texto + "%";
		String sql = "select id, nome, profissao, idsetor "
				+ " from funcionario where nome like (?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		Funcionario funcionario = null;
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		Setor setor;
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String nome = rs.getString("nome");
			String profissao = rs.getString("profissao");
			int idsetor = rs.getInt("idsetor");
			
		
			funcionario = new Funcionario();
			funcionario.setId(id);
			funcionario.setNome(nome);
			funcionario.setProfissao(profissao);
			
			SetorDao setDao = new SetorDao();
			setor = setDao.listarUm(idsetor);
			funcionario.setSetor(setor);
		
			funcionarios.add(funcionario);			
		}	
		stmt.close();
		con.close();
		return funcionarios;
		
	}
	
}
