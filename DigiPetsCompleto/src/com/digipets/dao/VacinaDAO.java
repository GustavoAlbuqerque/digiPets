package  com.digipets.dao;

import com.digipets.controller.ExceptionDAO;
import com.digipets.model.Tutor;
import com.digipets.model.Vacina;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VacinaDAO {

	public boolean CreateVacina(Vacina vacina) throws ExceptionDAO, SQLException {
		String sql = "INSERT INTO Tb_Vacinas(Nome, Data_Aplicacao, Id_Animal) VALUES (?, ?, ?)";
		PreparedStatement pStatement = null;
		Connection connection = null;
		boolean result = false;
		try {
			connection = new ConnectionMVC().getConnection();
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, vacina.getNome());
			pStatement.setString(2,  vacina.getDataAplicacao());
			pStatement.setInt(3,  vacina.getAnimalId());
			pStatement.execute();
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Erro ao cadastrar vacina");
		} finally {
			try {
				if (pStatement != null) {
					pStatement.close();
				}
			} catch (SQLException e) {
				throw new ExceptionDAO("Erro ao fechar statement " + e);
			}
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new ExceptionDAO("Erro ao fechar conex�o " + e);
			}
		}
		return result;
	}

	public boolean UpdateVacina(Vacina vacina) throws ExceptionDAO, SQLException {
		String sql = "UPDATE Tb_Vacinas SET Nome = ?, Data_Aplicacao = ? WHERE Id = ?";
		PreparedStatement pStatement = null;
		Connection connection = null;
		boolean result = false;
		try {
			connection = new ConnectionMVC().getConnection();
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, vacina.getNome());
			pStatement.setString(2, vacina.getDataAplicacao());
			pStatement.setInt(3, vacina.getId());
			pStatement.execute();
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Erro ao alterar vacina |" + e.getMessage());
		} finally {
			pStatement.close();
			connection.close();
		}
		return result;
	}

	public ArrayList<Vacina> GetVacinaByAnimalId(int id) throws Exception {
		String sql = " SELECT vc.Id, vc.Nome, vc.Data_Aplicacao, vc.Id_Animal FROM Tb_Vacinas vc "
				+ "WHERE vc.Id_Animal = "+ id;
		PreparedStatement pStatement = null;
		Connection connection = null;
		ArrayList<Vacina> vacinas = null;

		try {
			connection = new ConnectionMVC().getConnection();
			pStatement = connection.prepareStatement(sql);
			ResultSet rs = pStatement.executeQuery();
			if (rs != null) {
				vacinas = new ArrayList<Vacina>();
				while (rs.next()) {
					int idVac = rs.getInt("Id");
					String nomeVac = rs.getString("Nome");
					String dataVac = rs.getString("Data_Aplicacao");
					int idAnimal = rs.getInt("Id_Animal");
					vacinas.add(new Vacina(idVac, nomeVac, dataVac, idAnimal));
				}
			}
		} catch (SQLException e) {
			throw new ExceptionDAO("Erro ao consultar vacina |" + e.getMessage());
		} finally {
			pStatement.close();
			connection.close();
		}
		return vacinas;
	}
	
	public boolean DeleteVacina(int id) throws Exception{
		String sql = "DELETE FROM Tb_Vacinas WHERE Id = "+id ;

		PreparedStatement pStatement = null;
		Connection connection = null;
		boolean result = false;
		try {
			connection = new ConnectionMVC().getConnection();
			pStatement = connection.prepareStatement(sql);
			pStatement.execute();
			result = true;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Erro ao remover vacina |" + e.getMessage());
		} finally {
			pStatement.close();
			connection.close();
		}
		return result;
	}

	public List<Vacina> getAll() throws Exception {
		String sql = "SELECT * FROM Tb_Vacinas";
		PreparedStatement pStatement = null;
		Connection connection = null;
		ArrayList<Vacina> vacinas = null;

		try {
			connection = new ConnectionMVC().getConnection();
			pStatement = connection.prepareStatement(sql);
			ResultSet rs = pStatement.executeQuery(sql);
			if (rs != null) {
				vacinas = new ArrayList<Vacina>();
				while (rs.next()) {					
					int idVac = rs.getInt("Id");
					String nomeVac = rs.getString("Nome");
					String dataVac = rs.getString("Data_Aplicacao");
					int idAnimal = rs.getInt("Id_Animal");
					vacinas.add(new Vacina(idVac, nomeVac, dataVac, idAnimal));
				}
			}
		} catch (SQLException e) {
			new ExceptionDAO(e.getMessage());
		} finally {
			pStatement.close();
			connection.close();
		}
		
		return vacinas;
	}
}
