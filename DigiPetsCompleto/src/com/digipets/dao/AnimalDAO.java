package  com.digipets.dao;

import com.digipets.controller.ExceptionDAO;
import com.digipets.model.Animal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AnimalDAO  {

	public void CreateAnimal(Animal animal) throws ExceptionDAO {
		String sql = "INSERT INTO Tb_Animais(Nome, Raca, Sexo, Especie, Id_Tutor) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement pStatement = null;
		Connection connection = null;

		try {
			connection = new ConnectionMVC().getConnection();
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, animal.getNome());
			pStatement.setString(2, animal.getRaca());
			pStatement.setString(3, animal.getSexo());
			pStatement.setString(4, animal.getEspecie());
			pStatement.setInt(5, animal.getIdDono());

			pStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Erro ao cadastrar animal");
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
	}



	public ArrayList<Animal> GetAnimais() throws ExceptionDAO, SQLException {
		String sql = " SELECT * FROM Tb_Animais";
		PreparedStatement pStatement = null;
		Connection connection = null;
		ArrayList<Animal> animais = null;
		try {
			connection = new ConnectionMVC().getConnection();
			pStatement = connection.prepareStatement(sql);
			ResultSet rs = pStatement.executeQuery();
			if (rs != null) {
				animais = new ArrayList<Animal>();
				while (rs.next()) {
					Animal animal = new Animal();
					animal.setIdPet(rs.getInt("Id"));
					animal.setNome(rs.getString("Nome"));
					animal.setRaca(rs.getString("Raca"));
					animal.setSexo(rs.getString("Sexo"));
					animal.setEspecie(rs.getString("Especie"));
					animal.setIdDono(rs.getInt("Id_Tutor"));
					animais.add(animal);
				}
			}
		} catch (SQLException e) {
			throw new ExceptionDAO("Erro ao consultar item");
		} finally {
			pStatement.close();
			connection.close();
		}
		
		return animais;
	}
	public ArrayList<Animal> GetAnimaisFromTutorId(int id) throws ExceptionDAO, SQLException {
		String sql = " SELECT an.Id, an.Nome, an.Raca, an.Especie, an.Sexo FROM Tb_Animais as an "
				+ "WHERE an.Id_Tutor = " + id ;

		Connection connection = null;
		PreparedStatement pStatement = null;
		ArrayList<Animal> animais = null;

		try {
			connection = new ConnectionMVC().getConnection();
			pStatement = connection.prepareStatement(sql);
			ResultSet rs = pStatement.executeQuery();
			if (rs != null) {

				animais = new ArrayList<Animal>();

				while (rs.next()) {

					Animal animal = new Animal();
					animal.setIdPet(rs.getInt("Id"));
					animal.setNome(rs.getString("Nome"));
					animal.setEspecie(rs.getString("Especie"));
					animal.setRaca(rs.getString("Raca"));
					animal.setSexo(rs.getString("Sexo"));
					animais.add(animal);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Erro ao consultar pet");
		} finally {
			pStatement.close();
			connection.close();
		}
		return animais;
	}
}

