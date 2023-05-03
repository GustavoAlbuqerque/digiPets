package  com.gustavo.DAO;

import com.gustavo.control.ExceptionDAO;
import com.gustavo.model.Animais;
import com.gustavo.model.Animais;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AnimalDAO  {

	public void cadastrarAnimais(Animais animal) throws ExceptionDAO {
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



	public ArrayList<Animais> listarAnimais() throws ExceptionDAO, SQLException {
		String sql = " SELECT * FROM Tb_Animais";
		PreparedStatement pStatement = null;
		Connection connection = null;
		ArrayList<Animais> animais = null;

		try {
			connection = new ConnectionMVC().getConnection();
			pStatement = connection.prepareStatement(sql);
			ResultSet rs = pStatement.executeQuery(sql);

			if (rs != null) {

				animais = new ArrayList<Animais>();

				while (rs.next()) {

					Animais animal = new Animais();

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
			try {
				if (pStatement != null) {
					pStatement.close();
				}
			} catch (SQLException e) {
				throw new ExceptionDAO("Erro ao fechar o pStatement" + e);
			}
		}
		try {
			if (pStatement != null) {
				pStatement.close();
			}
		} catch (SQLException e) {
			throw new ExceptionDAO("Erro ao fechar conexão" + e);
		}

		return animais;
	}
	public ArrayList<Animais> listarAnimaisClienteCompleto(int idDono) throws ExceptionDAO, SQLException {
		String sql = " SELECT Id, Nome, Raca, Especie, Sexo FROM Tb_Animais as an "
				+ "INNER JOIN Tb_Tutores tu ON tu.Id = an.Id_Tutor WHERE an.Id_Tutor =" + idDono ;

		PreparedStatement pStatement = null;
		Connection connection = null;

		ArrayList<Animais> animais = null;

		try {
			connection = new ConnectionMVC().getConnection();
			pStatement = connection.prepareStatement(sql);
			ResultSet rs = pStatement.executeQuery(sql);

			if (rs != null) {

				animais = new ArrayList<Animais>();

				while (rs.next()) {

					Animais animal = new Animais();
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
			try {
				if (pStatement != null) {
					pStatement.close();
				}
			} catch (SQLException e) {
				throw new ExceptionDAO("Erro ao fechar o pStatement" + e);
			}
		}
		try {
			if (pStatement != null) {
				pStatement.close();
			}
		} catch (SQLException e) {
			throw new ExceptionDAO("Erro ao fechar conex�o" + e);
		}

		return animais;
	}

	public ArrayList<Animais> listarAnimaisCliente(int id) throws ExceptionDAO, SQLException {


		String sql = " SELECT Id, Nome, Raca, Sexo, Especie FROM Tb_Animais WHERE Id = " + id;
		PreparedStatement pStatement = null;
		Connection connection = null;

		ArrayList<Animais> animais = null;

		try {
			connection = new ConnectionMVC().getConnection();
			pStatement = connection.prepareStatement(sql);
			ResultSet rs = pStatement.executeQuery(sql);

			if (rs != null) {

				animais = new ArrayList<Animais>();

				while (rs.next()) {

					Animais anima = new Animais();

					anima.setIdPet(rs.getInt("Id"));
					anima.setNome(rs.getString("Nome"));
					anima.setRaca(rs.getString("Raca"));
					anima.setSexo(rs.getString("Sexo"));
					anima.setEspecie(rs.getString("Especie"));
					animais.add(anima);
				}
			}
		} catch (SQLException e) {
			throw new ExceptionDAO("Erro ao consultar pet");
		} finally {
			try {
				if (pStatement != null) {
					pStatement.close();
				}
			} catch (SQLException e) {
				throw new ExceptionDAO("Erro ao fechar o pStatement" + e);
			}
		}
		try {
			if (pStatement != null) {
				pStatement.close();
			}
		} catch (SQLException e) {
			throw new ExceptionDAO("Erro ao fechar conex�o" + e);
		}

		return animais;
	}

	public ArrayList<Animais> carregandoID() throws ExceptionDAO, SQLException {
		String sql = " SELECT Id FROM Tb_Animais ";
		PreparedStatement pStatement = null;
		Connection connection = null;
		ArrayList<Animais> animals = null;

		try {
			connection = new ConnectionMVC().getConnection();
			pStatement = connection.prepareStatement(sql);
			ResultSet rs = pStatement.executeQuery(sql);

			if (rs != null) {
				animals = new ArrayList<Animais>();
				while (rs.next()) {
					Animais animal = new Animais();
					animal.setIdPet(rs.getInt("Id"));
					// 					cliente.setNome(rs.getString("nome_cliente"));
					animals.add(animal);
				}
			}
		} catch (SQLException e) {
			throw new ExceptionDAO("Erro ao consultar Id pet");
		} finally {
			try {
				if (pStatement != null) {
					pStatement.close();
				}
			} catch (SQLException e) {
				throw new ExceptionDAO("Erro ao fechar o pStatement" + e);
			}
		}
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			throw new ExceptionDAO("Erro ao fechar conex�o" + e);
		}

		return animals;

	}

	/*public ArrayList<Animais> listarAnimaisFields(int a) throws ExceptionDAO, SQLException {
		String sql = " SELECT * FROM animal WHERE idAnimais = "+a;
		PreparedStatement pStatement = null;
		Connection connection = null;
		ArrayList<Animais> animais = null;

		try {
			connection = new ConnectionMVC().getConnection();
			pStatement = connection.prepareStatement(sql);
			ResultSet rs = pStatement.executeQuery(sql);

			if (rs != null) {

				animais = new ArrayList<Animais>();

				while (rs.next()) {

					Animais anima = new Animais();

					anima.setIdPet(rs.getInt("idAnimais"));
					anima.setNome(rs.getString("nome"));
					anima.setRaca(rs.getString("raca"));
					anima.setSexo(rs.getString("sexo"));
					anima.setEspecie(rs.getString("especie"));
					anima.setCpfDono(rs.getString("cpfDono"));
					animais.add(anima);
				}
			}
		} catch (SQLException e) {
			throw new ExceptionDAO("Erro ao consultar item");
		} finally {
			try {
				if (pStatement != null) {
					pStatement.close();
				}
			} catch (SQLException e) {
				throw new ExceptionDAO("Erro ao fechar o pStatement" + e);
			}
		}
		try {
			if (pStatement != null) {
				pStatement.close();
			}
		} catch (SQLException e) {
			throw new ExceptionDAO("Erro ao fechar conex�o" + e);
		}

		return animais;
	}*/



}

