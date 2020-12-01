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
import model.game;
/**
 * @author wyattmartin
 *
 */
public class gameQuery {

	private Connection connection;
	private ResultSet results;
	
	public gameQuery(String dbName, String uname, String pwd) {
		String url = "jdbc:mysql://localhost:3306/"+ dbName;
		
		//Set up Driver
		try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				this.connection = DriverManager.getConnection(url, uname, pwd);
			} catch(InstantiationException e) {
				e.printStackTrace();
			} catch(IllegalAccessException e) {
				e.printStackTrace();
			} catch(ClassNotFoundException e) {	
				e.printStackTrace();
			} catch(SQLException e) {
				e.printStackTrace();
			}
	}	
	
	public void doFullGameRead() {
		String query = "SELECT * FROM game";
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			this.results = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String addGame(game game) {
		String message = "";
		String gameID = game.getGameID();
		String homeTeam = game.getHomeTeam().getTeamName();
		String awayTeam = game.getAwayTeam().getTeamName();
		int homeScore = game.getHomeScore();
		int awayScore = game.getAwayScore();
		Double vegasSpread = game.getVegasSpread();
		String vegasFav = game.getVegasFavorite().getTeamName();
		String vegasDog = game.getVegasDog().getTeamName();
		Double modelSpread = game.getModelSpread();
		String modelFav = game.getModelFavorite().getTeamName();
		String modelDog = game.getModelDog().getTeamName();
		
		String query = "INSERT INTO `ncaa_2020`.`game` (`gameID`, `homeTeam`, `awayTeam`, `homeScore`, `awayScore`, `vegasSpread`, `vegasFavorite`, `vegasDog`, `modelSpread`, `modelFavorite`, `modelDog`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			ps.setString(1, game.getGameID());
			ps.setString(2, game.getHomeTeam().getTeamName());
			ps.setString(3, game.getAwayTeam().getTeamName());
			ps.setInt(4, game.getHomeScore());
			ps.setInt(5, game.getAwayScore());
			ps.setDouble(6, game.getVegasSpread());
			ps.setString(7, game.getVegasFavorite().getTeamName());
			ps.setString(8, game.getVegasDog().getTeamName());
			ps.setDouble(9, game.getModelSpread());
			ps.setString(10, game.getModelFavorite().getTeamName());
			ps.setString(11, game.getModelDog().getTeamName());
			
			
			
			
			ps.executeUpdate();
			message = "Game logged successesfully";
			return message;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message = "Game not logged";
			return message;
		}
	}

	public String printAll() {
		//Headers
		String table = "Game log:";
		table += "<br>";
		table += "<table border="+'"'+"1"+'"'+">";
		table += "<tr>";
		table += "<td>";
		table += "Game ID";
		table += "</td>";
		table += "<td>";
		table += "Home Team";
		table += "</td>";
		table += "<td>";
		table += "Away Team";
		table += "</td>";
		table += "<td>";
		table += "Vegas";
		table += "</td>";
		table += "<td>";
		table += "Model";
		table += "</td>";
		
		try {
			while (this.results.next()) {
				game game = new game();
				team homeTeam = new team();
				team awayTeam = new team();
				game.setGameID(this.results.getString("gameID"));
				homeTeam.setTeamName(this.results.getString("homeTeam"));
				awayTeam.setTeamName(this.results.getString("awayTeam"));
				game.setHomeScore(this.results.getInt("homeScore"));
				game.setAwayScore(this.results.getInt("awayScore"));
				game.setVegasSpread(this.results.getDouble("vegasSpread"));
					
				String vegasFav = this.results.getString("vegasFavorite");
					
				if(vegasFav.equalsIgnoreCase(homeTeam.getTeamName())) {
					game.setVegasFavorite(homeTeam);
					game.setVegasDog(awayTeam);
				}
				else {
					game.setVegasFavorite(awayTeam);
					game.setVegasDog(homeTeam);
				}
					
				game.setModelSpread(this.results.getDouble("modelSpread"));
					
				String modelFav = this.results.getString("modelFavorite");
					
				if(modelFav.equalsIgnoreCase(homeTeam.getTeamName())) {
					game.setModelFavorite(homeTeam);
					game.setModelDog(awayTeam);
				}
				else {
					game.setModelFavorite(awayTeam);
					game.setModelDog(homeTeam);
				}
		table += "<tr>";
		table += "<td>";
		table += game.getGameID();
		table += "</td>";
		table += "<td>";
		table += homeTeam.getTeamName();
		table += "</td>";
		table += "<td>";
		table += awayTeam.getTeamName();
		table += "</td>";
		table += "<td>";
		table += game.getVegasFavorite()+" -"+game.getVegasSpread();
		table += "</td>";
		table += "<td>";
		table += game.getModelFavorite()+" -"+game.getModelSpread();
		table += "</td>";	
		table += "</tr>";
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		table += "</table> <br>";
		
		return table;
	}
	
}