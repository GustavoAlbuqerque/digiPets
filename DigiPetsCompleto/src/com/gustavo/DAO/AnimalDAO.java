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
		String sql = "INSERT INTO animais(nomePet, racaPet, sexoPet, especiePet, cpfDono) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement pStatement = null;
		Connection connection = null;

		try {
			connection = new ConnectionMVC().getConnection();
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, animal.getNome());
			pStatement.setString(2, animal.getRaca());
			pStatement.setString(3, animal.getSexo());
			pStatement.setString(4, animal.getEspecie());
			pStatement.setString(5, animal.getCpfDono());

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
		String sql = " SELECT * FROM animal";
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
			throw new ExceptionDAO("Erro ao fechar conexão" + e);
		}

		return animais;
	}
	public ArrayList<Animais> listarAnimaisClienteCompleto(String cpfDono) throws ExceptionDAO, SQLException {
		String sql = " SELECT idPet, nomePet, racaPet, especiePet, sexoPet FROM animais "
				+ "INNER JOIN cliente cli ON cpfDono = cpfCliente WHERE cpfCliente =" + cpfDono ;

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
					anima.setIdPet(rs.getInt("idPet"));
					anima.setNome(rs.getString("nomePet"));
					anima.setEspecie(rs.getString("especiePet"));
					anima.setRaca(rs.getString("racaPet"));
					anima.setSexo(rs.getString("sexoPet"));

					animais.add(anima);
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

	public ArrayList<Animais> listarAnimaisCliente(int a) throws ExceptionDAO, SQLException {


		String sql = " SELECT nomePet, racaPet, sexoPet, especiePet FROM animais WHERE idPet = " + a;
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

					anima.setNome(rs.getString("nomePet"));
					anima.setRaca(rs.getString("racaPet"));
					anima.setSexo(rs.getString("sexoPet"));
					anima.setEspecie(rs.getString("especiePet"));
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
		String sql = " select idPet from animais ";
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
					animal.setIdPet(rs.getInt("idPet"));
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

	public ArrayList<Animais> listarAnimaisFields(int a) throws ExceptionDAO, SQLException {
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
	}



}

