package  com.gustavo.DAO;

import com.gustavo.control.ExceptionDAO;
import com.gustavo.model.Cliente;
import com.gustavo.model.Vacina;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VacinaDAO {

	public void cadastrarVacina(Vacina vacina) throws ExceptionDAO, SQLException {
		String sql = "INSERT INTO vacina(nomeVacina, dataAplicaVacina, idPet) VALUES (?, ?, ?)";
		PreparedStatement pStatement = null;
		Connection connection = null;

		try {

			connection = new ConnectionMVC().getConnection();
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, vacina.getNome());
			pStatement.setString(2,  vacina.getDataAplicacao());
			pStatement.setInt(3,  vacina.getCodPet());
			pStatement.execute();
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
	}

	public void alterarVacina(Vacina vacina) throws ExceptionDAO, SQLException {
		String sql = "UPDATE vacina SET nomeVacina = ?, dataAplicaVacina = ? WHERE codVacina = ?";
		PreparedStatement pStatement = null;
		Connection connection = null;
		try {

			connection = new ConnectionMVC().getConnection();
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, vacina.getNome());
			pStatement.setString(2, vacina.getDataAplicacao());
			pStatement.setInt(3, vacina.getCodigo());
			
			System.out.println(vacina.getCodigo());
			
			pStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Erro ao alterar vacina");
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

	public ArrayList<Vacina> listarVacinaPet(int cod) throws ExceptionDAO, SQLException {
		String sql = " SELECT vc.codVacina, vc.nomeVacina, vc.dataAplicaVacina FROM vacina vc "
				+ "INNER JOIN animais an ON vc.idPet = an.idPet  WHERE an.idPet = '"+ cod+"'";
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

					Vacina vac = new Vacina();

					vac.setCodigo(rs.getInt("codVacina"));
					vac.setNome(rs.getString("nomeVacina"));
					vac.setDataAplicacao(rs.getString("dataAplicaVacina"));
					vacinas.add(vac);
				}
			}
		} catch (SQLException e) {
			throw new ExceptionDAO("Erro ao consultar vacina");
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

		return vacinas;

	}
	public void deletarVacina(int cod) throws ExceptionDAO{
		String sql = "DELETE FROM vacina WHERE codVacina = "+cod ;

		PreparedStatement pStatement = null;
		Connection connection = null;
		try {
			connection = new ConnectionMVC().getConnection();
			pStatement = connection.prepareStatement(sql);

			Vacina vacina = new Vacina();
			pStatement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Erro ao remover vacina");
		} finally {
			try {
				if (pStatement != null) {
					pStatement.close();
				}
			} catch (SQLException e) {
				throw new ExceptionDAO("Erro ao fechar pStatement " + e);
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

	public ArrayList<Vacina> carregandoID() throws ExceptionDAO, SQLException {
		String sql = "select codVacina from vacina ";
		PreparedStatement pStatement = null;
		Connection connection = null;
		ArrayList<Vacina> vacinas = null;

		try {
			connection = new ConnectionMVC().getConnection();
			pStatement = connection.prepareStatement(sql);
			ResultSet rs = pStatement.executeQuery(sql);
			System.out.println("Resultado consulta"+ rs);
			if (rs != null) {
				vacinas = new ArrayList<Vacina>();
				while (rs.next()) {
					Vacina vacina = new Vacina();
					vacina.setCodigo(rs.getInt("codVacina"));
					vacinas.add(vacina);
				}
			}
		} catch (SQLException e) {
			throw new ExceptionDAO("Erro ao consultar vacinasId");
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
		System.out.println("Retorno do metodo dao"+vacinas);
		return vacinas;


	}

}
