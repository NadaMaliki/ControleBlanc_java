package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.MembreDao;
import databaseManager.DBConnection;
import model.Membre;

public class MembreDaoImpl implements MembreDao {
	
	DBConnection dbconnection = new DBConnection();
	Connection conn = dbconnection.getConnection();
	
	@Override
	//Inserer l'ordre dans la base de données
	public boolean Insere(Membre m){
        String query = "insert into `membre`(id, nom, prenom, email, phone) values (?, ?, ?, ?, ?)";

        try(PreparedStatement statement= conn.prepareStatement(query)){
            statement.setInt(1, m.getId());
            statement.setString(2, m.getNom());
            statement.setString(3, m.getPrenom());
            statement.setString(4, m.getEmail());
            statement.setString(5, m.getPhone());
            int result = statement.executeUpdate();
            return (result >0);
            
        } catch (SQLException e) {
            e.printStackTrace();
        	return false;
        }
    }
	
	@Override
	public boolean ChargerListIncidents() {
        String query = "select * from Incident";
        try {
            ResultSet result = conn.createStatement().executeQuery(query);
            if(result.next()) {
                return true;
            } else return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
	

}
