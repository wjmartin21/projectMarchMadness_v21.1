/**
 * 
 */
package databaseController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.team;

/**
 * @author wyattmartin
 *
 */
public class profileQuery {

	private Connection connection;
	private ResultSet results;
	
	public profileQuery(String dbName, String uname, String pwd) {
		String url = "jdbc:mysql://localhost:3306/"+ dbName;
		
		//Set up Driver
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url, uname, pwd);
		} catch(InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(ClassNotFoundException e) {	
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void doProfileRead() {
		String query = "SELECT * FROM teams";
		
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			this.results = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getHTMLTable() {
		String table = "";
		
		table += "<br>";
		table += "<table border="+'"'+"1"+'"'+">";
		table += "<tr>";
		table += "<td>";
		table += "Team: ";
		table += "</td>";
		table += "<td>";
		table += "Tempo";
		table += "</td>";
		table += "<td>";
		table += "eFG%";
		table += "</td>";
		table += "<td>";
		table += "eFG% (Opp)";
		table += "</td>";
		table += "<td>";
		table += "TO%";
		table += "</td>";
		table += "<td>";
		table += "TO% (Opp)";
		table += "</td>";
		table += "<td>";
		table += "ORPct";
		table += "</td>";
		table += "<td>";
		table += "ORPct (Opp)";
		table += "</td>";
		table += "<td>";
		table += "FTRate";
		table += "</td>";
		table += "<td>";
		table += "FTRate (Opp)";
		table += "</td>";
		table += "<td>";
		table += "FT %";
		table += "</td>";
	
		
		try {
			while (this.results.next()) {
				team team = new team();
				
				//Get variables from SQL
				team.setTeamName(this.results.getString("TeamName"));
				
				team.setFTPct(this.results.getDouble("FTPct"));
				
				team.setOff_eFGPct(this.results.getDouble("Off_eFG"));
				team.setDef_eFGPct(this.results.getDouble("Def_eFG"));
				team.setOff_TOPct(this.results.getDouble("Off_TO"));
				team.setDef_TOPct(this.results.getDouble("Def_TO"));
				team.setOff_ORPct(this.results.getDouble("Off_OR"));
				team.setDef_ORPct(this.results.getDouble("Def_OR"));
				team.setOff_FTRate(this.results.getDouble("Off_FT"));
				team.setDef_FTRate(this.results.getDouble("Def_FT"));
				team.setTempo(this.results.getDouble("Tempo"));
				team.setFTPct(this.results.getDouble("FTPct"));
				
				table += "<tr>";
				table += "<td>";
				table += team.getTeamName();
				table += "</td>";
				table += "<td>";	
				table += team.getTempo();
				table += "</td>";
				table += "<td>";
				table += team.getOff_eFGPct();
				table += "</td>";
				table += "<td>";
				table += team.getDef_eFGPct();
				table += "</td>";
				table += "<td>";
				table += team.getOff_TOPct();
				table += "</td>";
				table += "<td>";
				table += team.getDef_TOPct();
				table += "</td>";
				table += "<td>";
				table += team.getOff_ORPct();
				table += "</td>";
				table += "<td>";
				table += team.getDef_ORPct();
				table += "</td>";
				table += "<td>";
				table += team.getOff_FTRate();
				table += "</td>";
				table += "<td>";
				table += team.getDef_FTRate();
				table += "</td>";
				table += "<td>";
				table += team.getFTPct();
				table += "</td>";
				table += "</tr>";

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		table += "</table>";
		
		return table;
	}
	
}
