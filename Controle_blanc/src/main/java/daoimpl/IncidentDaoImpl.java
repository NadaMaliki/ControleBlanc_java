package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Set;

import dao.IncidentDao;
import databaseManager.DBConnection;
import model.Incident;

public class IncidentDaoImpl implements IncidentDao{
	
	DBConnection dbconnection = new DBConnection();
	Connection conn = dbconnection.getConnection();
	
	@Override
	public boolean Inserer(Incident i) {
		String query = "insert into incident (reference, time, status) values (?, ?, ?,)";

        try(PreparedStatement statement= conn.prepareStatement(query)){
            statement.setString(1, i.getReference());
            statement.setTime(2, i.getTime());
            statement.setString(3, i.getStatus());
            int result = statement.executeUpdate();
            return (result >0);
            
        } catch (SQLException e) {
            e.printStackTrace();
        	return false;
        }
	}
	
	@Override 
	public boolean Inser(Set is) {
		try {
			
			for (Object i : is) {
				Inserer((Incident)i);
			}
			return true;
			
		} catch(Exception e) {
			e.printStackTrace();
        	return false;
		}

	}

}
