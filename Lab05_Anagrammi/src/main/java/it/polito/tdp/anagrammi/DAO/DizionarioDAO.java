package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DizionarioDAO {

	public boolean isPresent(String anagramma) {
		
		final String sql = "SELECT nome FROM parola WHERE nome = ?";
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, anagramma);
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {		
				rs.close();
				st.close();
				conn.close();
				
				return true;
			}
			else {
				rs.close();
				st.close();
				conn.close();
				
				return false;
			}
			
		} catch(SQLException e) {
			throw new RuntimeException("Errore db", e);
		}
	}

}
