package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.IscrittiPerCorso;
import it.polito.tdp.lab04.model.Studente;

public class IscrittiDAO {


	/*
	 * Ottengo tutti gli iscritti salvati nel Db
	 */
	public List<IscrittiPerCorso> getTuttiGliStudenti() {

		final String sql = "SELECT * FROM studente";

		List<IscrittiPerCorso> iscritti = new LinkedList<IscrittiPerCorso>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				// Crea un nuovo JAVA Bean IscrittoPerCorso
				// Aggiungi il nuovo Iscritto alla lista
				int matricola = rs.getInt("matricola");
				String codins = rs.getString("codins");
				
				
				iscritti.add(new IscrittiPerCorso(codins, matricola));
				
			}
			conn.close();
			return iscritti;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}
}
