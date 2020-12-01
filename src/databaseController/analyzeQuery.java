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
public class analyzeQuery {

	private Connection connection;
	private ResultSet results;
	team hTeam = new team();
	team aTeam = new team();
	
	public analyzeQuery(String dbName, String uname, String pwd) {
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
	
	public void doAnalysisRead(String homeTeam, String awayTeam) {
		String query = "SELECT * FROM teams WHERE TeamName ='"+homeTeam+"' OR TeamName='"+awayTeam+"'";
		
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			this.results = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public double getOeffAVG() throws SQLException {
		double OeffAVG = 0;
		String query = "SELECT AVG(Oeff) FROM projectMarchMadness";
		
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			this.results = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
			OeffAVG = this.results.getDouble(0);
		
		return OeffAVG;
		
	}
	
	public double getDeffAVG() throws SQLException {
		double DeffAVG;
		String query = "SELECT AVG(Deff) FROM projectMarchMadness";
		
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			this.results = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
			DeffAVG = this.results.getDouble("AVG(Deff)");
		
		return DeffAVG;
		
	}

	public String printAdvanceStats(String homeTeam) {
		try {
			while (this.results.next()) {
				if(this.results.getString("TeamName").equals(homeTeam)) {
					hTeam.setTeamName(this.results.getString("TeamName"));
					hTeam.seteFGPct(this.results.getDouble("eFGPct"));
					hTeam.setOppeFGPct(this.results.getDouble("OppeFGPct"));
					hTeam.setTOPct(this.results.getDouble("TOPct"));
					hTeam.setOppTOPct(this.results.getDouble("OppTOPct"));
					hTeam.setORPct(this.results.getDouble("ORPct"));
					hTeam.setOppORPct(this.results.getDouble("OppORPct"));
					hTeam.setFTRate(this.results.getDouble("FTRate"));
					hTeam.setOppFTRate(this.results.getDouble("OppFTRate"));
					hTeam.setTempo(this.results.getDouble("Tempo"));
					hTeam.setAdjtempo(this.results.getDouble("AdjTempo"));
					hTeam.setOE(this.results.getDouble("OE"));
					hTeam.setAdjOE(this.results.getDouble("AdjOE"));
					hTeam.setDE(this.results.getDouble("DE"));
					hTeam.setAdjDE(this.results.getDouble("AdjDE"));
					hTeam.setAdjEM(this.results.getDouble("AdjEM"));
				}
				else {
					aTeam.setTeamName(this.results.getString("TeamName"));
					aTeam.setTeamName(this.results.getString("TeamName"));
					aTeam.seteFGPct(this.results.getDouble("eFGPct"));
					aTeam.setOppeFGPct(this.results.getDouble("OppeFGPct"));
					aTeam.setTOPct(this.results.getDouble("TOPct"));
					aTeam.setOppTOPct(this.results.getDouble("OppTOPct"));
					aTeam.setORPct(this.results.getDouble("ORPct"));
					aTeam.setOppORPct(this.results.getDouble("OppORPct"));
					aTeam.setFTRate(this.results.getDouble("FTRate"));
					aTeam.setOppFTRate(this.results.getDouble("OppFTRate"));
					aTeam.setTempo(this.results.getDouble("Tempo"));
					aTeam.setAdjtempo(this.results.getDouble("AdjTempo"));
					aTeam.setOE(this.results.getDouble("OE"));
					aTeam.setAdjOE(this.results.getDouble("AdjOE"));
					aTeam.setDE(this.results.getDouble("DE"));
					aTeam.setAdjDE(this.results.getDouble("AdjDE"));
					aTeam.setAdjEM(this.results.getDouble("AdjEM"));
				
				}
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
				
				
		
		String table = hTeam.printAdvancedStats(aTeam);
		
		
		return table;
	}
	
	//Double results
	public double spreadAnalysis03(String homeTeam, double OEAVG, double TempoAVG, int tempoType) {
		
		try {
			while (this.results.next()) {
				if(this.results.getString("TeamName").equals(homeTeam)) {
					hTeam.setTeamName(this.results.getString("TeamName"));
					hTeam.seteFGPct(this.results.getDouble("eFGPct"));
					hTeam.setOppeFGPct(this.results.getDouble("OppeFGPct"));
					hTeam.setTOPct(this.results.getDouble("TOPct"));
					hTeam.setOppTOPct(this.results.getDouble("OppTOPct"));
					hTeam.setORPct(this.results.getDouble("ORPct"));
					hTeam.setOppORPct(this.results.getDouble("OppORPct"));
					hTeam.setFTRate(this.results.getDouble("FTRate"));
					hTeam.setOppFTRate(this.results.getDouble("OppFTRate"));
					hTeam.setTempo(this.results.getDouble("Tempo"));
					hTeam.setAdjtempo(this.results.getDouble("AdjTempo"));
					hTeam.setOE(this.results.getDouble("OE"));
					hTeam.setAdjOE(this.results.getDouble("AdjOE"));
					hTeam.setDE(this.results.getDouble("DE"));
					hTeam.setAdjDE(this.results.getDouble("AdjDE"));
					hTeam.setAdjEM(this.results.getDouble("AdjEM"));
				}
				else {
					aTeam.setTeamName(this.results.getString("TeamName"));
					aTeam.setTeamName(this.results.getString("TeamName"));
					aTeam.seteFGPct(this.results.getDouble("eFGPct"));
					aTeam.setOppeFGPct(this.results.getDouble("OppeFGPct"));
					aTeam.setTOPct(this.results.getDouble("TOPct"));
					aTeam.setOppTOPct(this.results.getDouble("OppTOPct"));
					aTeam.setORPct(this.results.getDouble("ORPct"));
					aTeam.setOppORPct(this.results.getDouble("OppORPct"));
					aTeam.setFTRate(this.results.getDouble("FTRate"));
					aTeam.setOppFTRate(this.results.getDouble("OppFTRate"));
					aTeam.setTempo(this.results.getDouble("Tempo"));
					aTeam.setAdjtempo(this.results.getDouble("AdjTempo"));
					aTeam.setOE(this.results.getDouble("OE"));
					aTeam.setAdjOE(this.results.getDouble("AdjOE"));
					aTeam.setDE(this.results.getDouble("DE"));
					aTeam.setAdjDE(this.results.getDouble("AdjDE"));
					aTeam.setAdjEM(this.results.getDouble("AdjEM"));
				
				}
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		double modelSpread = hTeam.spreadAnalysis03(aTeam,OEAVG, TempoAVG, tempoType);
		
		
		return modelSpread;
	}
	
	public double spreadAnalysis04(String homeTeam, double TempoAVG, int tempoType) {
	
		try {
			while (this.results.next()) {
				if(this.results.getString("TeamName").equals(homeTeam)) {
					hTeam.setTeamName(this.results.getString("TeamName"));
					hTeam.seteFGPct(this.results.getDouble("eFGPct"));
					hTeam.setOppeFGPct(this.results.getDouble("OppeFGPct"));
					hTeam.setTOPct(this.results.getDouble("TOPct"));
					hTeam.setOppTOPct(this.results.getDouble("OppTOPct"));
					hTeam.setORPct(this.results.getDouble("ORPct"));
					hTeam.setOppORPct(this.results.getDouble("OppORPct"));
					hTeam.setFTRate(this.results.getDouble("FTRate"));
					hTeam.setOppFTRate(this.results.getDouble("OppFTRate"));
					hTeam.setTempo(this.results.getDouble("Tempo"));
					hTeam.setAdjtempo(this.results.getDouble("AdjTempo"));
					hTeam.setOE(this.results.getDouble("OE"));
					hTeam.setAdjOE(this.results.getDouble("AdjOE"));
					hTeam.setDE(this.results.getDouble("DE"));
					hTeam.setAdjDE(this.results.getDouble("AdjDE"));
					hTeam.setAdjEM(this.results.getDouble("AdjEM"));
				}
				else {
					aTeam.setTeamName(this.results.getString("TeamName"));
					aTeam.setTeamName(this.results.getString("TeamName"));
					aTeam.seteFGPct(this.results.getDouble("eFGPct"));
					aTeam.setOppeFGPct(this.results.getDouble("OppeFGPct"));
					aTeam.setTOPct(this.results.getDouble("TOPct"));
					aTeam.setOppTOPct(this.results.getDouble("OppTOPct"));
					aTeam.setORPct(this.results.getDouble("ORPct"));
					aTeam.setOppORPct(this.results.getDouble("OppORPct"));
					aTeam.setFTRate(this.results.getDouble("FTRate"));
					aTeam.setOppFTRate(this.results.getDouble("OppFTRate"));
					aTeam.setTempo(this.results.getDouble("Tempo"));
					aTeam.setAdjtempo(this.results.getDouble("AdjTempo"));
					aTeam.setOE(this.results.getDouble("OE"));
					aTeam.setAdjOE(this.results.getDouble("AdjOE"));
					aTeam.setDE(this.results.getDouble("DE"));
					aTeam.setAdjDE(this.results.getDouble("AdjDE"));
					aTeam.setAdjEM(this.results.getDouble("AdjEM"));
				
				}
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		double modelSpread = hTeam.spreadAnalysis04(aTeam, TempoAVG, tempoType);
		
		
		return modelSpread;
	}
	
	//String results
	public String analysis01(String homeTeam) {
		String table = "Analysis01: ";
		
		try {
			while (this.results.next()) {
				if(this.results.getString("TeamName").equals(homeTeam)) {
					hTeam.setTeamName(this.results.getString("TeamName"));
					hTeam.seteFGPct(this.results.getDouble("eFGPct"));
					hTeam.setOppeFGPct(this.results.getDouble("OppeFGPct"));
					hTeam.setTOPct(this.results.getDouble("TOPct"));
					hTeam.setOppTOPct(this.results.getDouble("OppTOPct"));
					hTeam.setORPct(this.results.getDouble("ORPct"));
					hTeam.setOppORPct(this.results.getDouble("OppORPct"));
					hTeam.setFTRate(this.results.getDouble("FTRate"));
					hTeam.setOppFTRate(this.results.getDouble("OppFTRate"));
					hTeam.setTempo(this.results.getDouble("Tempo"));
					hTeam.setAdjtempo(this.results.getDouble("AdjTempo"));
					hTeam.setOE(this.results.getDouble("OE"));
					hTeam.setAdjOE(this.results.getDouble("AdjOE"));
					hTeam.setDE(this.results.getDouble("DE"));
					hTeam.setAdjDE(this.results.getDouble("AdjDE"));
					hTeam.setAdjEM(this.results.getDouble("AdjEM"));
				}
				else {
					aTeam.setTeamName(this.results.getString("TeamName"));
					aTeam.setTeamName(this.results.getString("TeamName"));
					aTeam.seteFGPct(this.results.getDouble("eFGPct"));
					aTeam.setOppeFGPct(this.results.getDouble("OppeFGPct"));
					aTeam.setTOPct(this.results.getDouble("TOPct"));
					aTeam.setOppTOPct(this.results.getDouble("OppTOPct"));
					aTeam.setORPct(this.results.getDouble("ORPct"));
					aTeam.setOppORPct(this.results.getDouble("OppORPct"));
					aTeam.setFTRate(this.results.getDouble("FTRate"));
					aTeam.setOppFTRate(this.results.getDouble("OppFTRate"));
					aTeam.setTempo(this.results.getDouble("Tempo"));
					aTeam.setAdjtempo(this.results.getDouble("AdjTempo"));
					aTeam.setOE(this.results.getDouble("OE"));
					aTeam.setAdjOE(this.results.getDouble("AdjOE"));
					aTeam.setDE(this.results.getDouble("DE"));
					aTeam.setAdjDE(this.results.getDouble("AdjDE"));
					aTeam.setAdjEM(this.results.getDouble("AdjEM"));
				
				}
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
				
				
		
		String matchupResults = hTeam.matchupAnalysis01(aTeam);
		
		table+= matchupResults;
		
		return table;
	}
	
	public String analysis02(String homeTeam, double OeffAVG, double DeffAVG) {
		String table = "";
		try {
			while (this.results.next()) {
				if(this.results.getString("TeamName").equals(homeTeam)) {
					hTeam.setTeamName(this.results.getString("TeamName"));
					hTeam.seteFGPct(this.results.getDouble("eFGPct"));
					hTeam.setOppeFGPct(this.results.getDouble("OppeFGPct"));
					hTeam.setTOPct(this.results.getDouble("TOPct"));
					hTeam.setOppTOPct(this.results.getDouble("OppTOPct"));
					hTeam.setORPct(this.results.getDouble("ORPct"));
					hTeam.setOppORPct(this.results.getDouble("OppORPct"));
					hTeam.setFTRate(this.results.getDouble("FTRate"));
					hTeam.setOppFTRate(this.results.getDouble("OppFTRate"));
					hTeam.setTempo(this.results.getDouble("Tempo"));
					hTeam.setAdjtempo(this.results.getDouble("AdjTempo"));
					hTeam.setOE(this.results.getDouble("OE"));
					hTeam.setAdjOE(this.results.getDouble("AdjOE"));
					hTeam.setDE(this.results.getDouble("DE"));
					hTeam.setAdjDE(this.results.getDouble("AdjDE"));
					hTeam.setAdjEM(this.results.getDouble("AdjEM"));
				}
				else {
					aTeam.setTeamName(this.results.getString("TeamName"));
					aTeam.setTeamName(this.results.getString("TeamName"));
					aTeam.seteFGPct(this.results.getDouble("eFGPct"));
					aTeam.setOppeFGPct(this.results.getDouble("OppeFGPct"));
					aTeam.setTOPct(this.results.getDouble("TOPct"));
					aTeam.setOppTOPct(this.results.getDouble("OppTOPct"));
					aTeam.setORPct(this.results.getDouble("ORPct"));
					aTeam.setOppORPct(this.results.getDouble("OppORPct"));
					aTeam.setFTRate(this.results.getDouble("FTRate"));
					aTeam.setOppFTRate(this.results.getDouble("OppFTRate"));
					aTeam.setTempo(this.results.getDouble("Tempo"));
					aTeam.setAdjtempo(this.results.getDouble("AdjTempo"));
					aTeam.setOE(this.results.getDouble("OE"));
					aTeam.setAdjOE(this.results.getDouble("AdjOE"));
					aTeam.setDE(this.results.getDouble("DE"));
					aTeam.setAdjDE(this.results.getDouble("AdjDE"));
					aTeam.setAdjEM(this.results.getDouble("AdjEM"));
				
				}
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		String matchupResults = hTeam.matchupAnalysis02(aTeam,OeffAVG, DeffAVG);
		
		table+= matchupResults;
		
		return table;
	}
	
	public String analysis03(String homeTeam, double OEAVG, double TempoAVG, int tempoType) {
		String table = "";
		try {
			while (this.results.next()) {
				if(this.results.getString("TeamName").equals(homeTeam)) {
					hTeam.setTeamName(this.results.getString("TeamName"));
					hTeam.seteFGPct(this.results.getDouble("eFGPct"));
					hTeam.setOppeFGPct(this.results.getDouble("OppeFGPct"));
					hTeam.setTOPct(this.results.getDouble("TOPct"));
					hTeam.setOppTOPct(this.results.getDouble("OppTOPct"));
					hTeam.setORPct(this.results.getDouble("ORPct"));
					hTeam.setOppORPct(this.results.getDouble("OppORPct"));
					hTeam.setFTRate(this.results.getDouble("FTRate"));
					hTeam.setOppFTRate(this.results.getDouble("OppFTRate"));
					hTeam.setTempo(this.results.getDouble("Tempo"));
					hTeam.setAdjtempo(this.results.getDouble("AdjTempo"));
					hTeam.setOE(this.results.getDouble("OE"));
					hTeam.setAdjOE(this.results.getDouble("AdjOE"));
					hTeam.setDE(this.results.getDouble("DE"));
					hTeam.setAdjDE(this.results.getDouble("AdjDE"));
					hTeam.setAdjEM(this.results.getDouble("AdjEM"));
				}
				else {
					aTeam.setTeamName(this.results.getString("TeamName"));
					aTeam.setTeamName(this.results.getString("TeamName"));
					aTeam.seteFGPct(this.results.getDouble("eFGPct"));
					aTeam.setOppeFGPct(this.results.getDouble("OppeFGPct"));
					aTeam.setTOPct(this.results.getDouble("TOPct"));
					aTeam.setOppTOPct(this.results.getDouble("OppTOPct"));
					aTeam.setORPct(this.results.getDouble("ORPct"));
					aTeam.setOppORPct(this.results.getDouble("OppORPct"));
					aTeam.setFTRate(this.results.getDouble("FTRate"));
					aTeam.setOppFTRate(this.results.getDouble("OppFTRate"));
					aTeam.setTempo(this.results.getDouble("Tempo"));
					aTeam.setAdjtempo(this.results.getDouble("AdjTempo"));
					aTeam.setOE(this.results.getDouble("OE"));
					aTeam.setAdjOE(this.results.getDouble("AdjOE"));
					aTeam.setDE(this.results.getDouble("DE"));
					aTeam.setAdjDE(this.results.getDouble("AdjDE"));
					aTeam.setAdjEM(this.results.getDouble("AdjEM"));
				
				}
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		String matchupResults = hTeam.matchupAnalysis03(aTeam,OEAVG, TempoAVG, tempoType);
		double modelSpread = hTeam.spreadAnalysis03(aTeam,OEAVG, TempoAVG, tempoType);
		
		
		table += matchupResults;
		
		return table;
	}
	
	public String analysis04(String homeTeam, double TempoAVG, int tempoType) {
		String table = "";
		try {
			while (this.results.next()) {
				if(this.results.getString("TeamName").equals(homeTeam)) {
					hTeam.setTeamName(this.results.getString("TeamName"));
					hTeam.seteFGPct(this.results.getDouble("eFGPct"));
					hTeam.setOppeFGPct(this.results.getDouble("OppeFGPct"));
					hTeam.setTOPct(this.results.getDouble("TOPct"));
					hTeam.setOppTOPct(this.results.getDouble("OppTOPct"));
					hTeam.setORPct(this.results.getDouble("ORPct"));
					hTeam.setOppORPct(this.results.getDouble("OppORPct"));
					hTeam.setFTRate(this.results.getDouble("FTRate"));
					hTeam.setOppFTRate(this.results.getDouble("OppFTRate"));
					hTeam.setTempo(this.results.getDouble("Tempo"));
					hTeam.setAdjtempo(this.results.getDouble("AdjTempo"));
					hTeam.setOE(this.results.getDouble("OE"));
					hTeam.setAdjOE(this.results.getDouble("AdjOE"));
					hTeam.setDE(this.results.getDouble("DE"));
					hTeam.setAdjDE(this.results.getDouble("AdjDE"));
					hTeam.setAdjEM(this.results.getDouble("AdjEM"));
				}
				else {
					aTeam.setTeamName(this.results.getString("TeamName"));
					aTeam.setTeamName(this.results.getString("TeamName"));
					aTeam.seteFGPct(this.results.getDouble("eFGPct"));
					aTeam.setOppeFGPct(this.results.getDouble("OppeFGPct"));
					aTeam.setTOPct(this.results.getDouble("TOPct"));
					aTeam.setOppTOPct(this.results.getDouble("OppTOPct"));
					aTeam.setORPct(this.results.getDouble("ORPct"));
					aTeam.setOppORPct(this.results.getDouble("OppORPct"));
					aTeam.setFTRate(this.results.getDouble("FTRate"));
					aTeam.setOppFTRate(this.results.getDouble("OppFTRate"));
					aTeam.setTempo(this.results.getDouble("Tempo"));
					aTeam.setAdjtempo(this.results.getDouble("AdjTempo"));
					aTeam.setOE(this.results.getDouble("OE"));
					aTeam.setAdjOE(this.results.getDouble("AdjOE"));
					aTeam.setDE(this.results.getDouble("DE"));
					aTeam.setAdjDE(this.results.getDouble("AdjDE"));
					aTeam.setAdjEM(this.results.getDouble("AdjEM"));
				
				}
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		String matchupResults = hTeam.matchupAnalysis04(aTeam, TempoAVG, tempoType);
		
		table += matchupResults;
		
		return table;
	}
	
	public String analysis05(String homeTeam, double OEAVG, double TempoAVG, int tempoType) {
		String table = "";
		try {
			while (this.results.next()) {
				if(this.results.getString("TeamName").equals(homeTeam)) {
					hTeam.setTeamName(this.results.getString("TeamName"));
					hTeam.seteFGPct(this.results.getDouble("eFGPct"));
					hTeam.setOppeFGPct(this.results.getDouble("OppeFGPct"));
					hTeam.setTOPct(this.results.getDouble("TOPct"));
					hTeam.setOppTOPct(this.results.getDouble("OppTOPct"));
					hTeam.setORPct(this.results.getDouble("ORPct"));
					hTeam.setOppORPct(this.results.getDouble("OppORPct"));
					hTeam.setFTRate(this.results.getDouble("FTRate"));
					hTeam.setOppFTRate(this.results.getDouble("OppFTRate"));
					hTeam.setTempo(this.results.getDouble("Tempo"));
					hTeam.setAdjtempo(this.results.getDouble("AdjTempo"));
					hTeam.setOE(this.results.getDouble("OE"));
					hTeam.setAdjOE(this.results.getDouble("AdjOE"));
					hTeam.setDE(this.results.getDouble("DE"));
					hTeam.setAdjDE(this.results.getDouble("AdjDE"));
					hTeam.setAdjEM(this.results.getDouble("AdjEM"));
				}
				else {
					aTeam.setTeamName(this.results.getString("TeamName"));
					aTeam.setTeamName(this.results.getString("TeamName"));
					aTeam.seteFGPct(this.results.getDouble("eFGPct"));
					aTeam.setOppeFGPct(this.results.getDouble("OppeFGPct"));
					aTeam.setTOPct(this.results.getDouble("TOPct"));
					aTeam.setOppTOPct(this.results.getDouble("OppTOPct"));
					aTeam.setORPct(this.results.getDouble("ORPct"));
					aTeam.setOppORPct(this.results.getDouble("OppORPct"));
					aTeam.setFTRate(this.results.getDouble("FTRate"));
					aTeam.setOppFTRate(this.results.getDouble("OppFTRate"));
					aTeam.setTempo(this.results.getDouble("Tempo"));
					aTeam.setAdjtempo(this.results.getDouble("AdjTempo"));
					aTeam.setOE(this.results.getDouble("OE"));
					aTeam.setAdjOE(this.results.getDouble("AdjOE"));
					aTeam.setDE(this.results.getDouble("DE"));
					aTeam.setAdjDE(this.results.getDouble("AdjDE"));
					aTeam.setAdjEM(this.results.getDouble("AdjEM"));
				
				}
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		String matchupResults = hTeam.matchupAnalysis05(aTeam,OEAVG, TempoAVG, tempoType);
		table += matchupResults;
		
		return table;
	}
	
	public String calcWinningPct01(String homeTeam) {
		String table = "";
		try {
			while (this.results.next()) {
				if(this.results.getString("TeamName").equals(homeTeam)) {
					hTeam.setTeamName(this.results.getString("TeamName"));
					hTeam.seteFGPct(this.results.getDouble("eFGPct"));
					hTeam.setOppeFGPct(this.results.getDouble("OppeFGPct"));
					hTeam.setTOPct(this.results.getDouble("TOPct"));
					hTeam.setOppTOPct(this.results.getDouble("OppTOPct"));
					hTeam.setORPct(this.results.getDouble("ORPct"));
					hTeam.setOppORPct(this.results.getDouble("OppORPct"));
					hTeam.setFTRate(this.results.getDouble("FTRate"));
					hTeam.setOppFTRate(this.results.getDouble("OppFTRate"));
					hTeam.setTempo(this.results.getDouble("Tempo"));
					hTeam.setAdjtempo(this.results.getDouble("AdjTempo"));
					hTeam.setOE(this.results.getDouble("OE"));
					hTeam.setAdjOE(this.results.getDouble("AdjOE"));
					hTeam.setDE(this.results.getDouble("DE"));
					hTeam.setAdjDE(this.results.getDouble("AdjDE"));
					hTeam.setAdjEM(this.results.getDouble("AdjEM"));
				}
				else {
					aTeam.setTeamName(this.results.getString("TeamName"));
					aTeam.setTeamName(this.results.getString("TeamName"));
					aTeam.seteFGPct(this.results.getDouble("eFGPct"));
					aTeam.setOppeFGPct(this.results.getDouble("OppeFGPct"));
					aTeam.setTOPct(this.results.getDouble("TOPct"));
					aTeam.setOppTOPct(this.results.getDouble("OppTOPct"));
					aTeam.setORPct(this.results.getDouble("ORPct"));
					aTeam.setOppORPct(this.results.getDouble("OppORPct"));
					aTeam.setFTRate(this.results.getDouble("FTRate"));
					aTeam.setOppFTRate(this.results.getDouble("OppFTRate"));
					aTeam.setTempo(this.results.getDouble("Tempo"));
					aTeam.setAdjtempo(this.results.getDouble("AdjTempo"));
					aTeam.setOE(this.results.getDouble("OE"));
					aTeam.setAdjOE(this.results.getDouble("AdjOE"));
					aTeam.setDE(this.results.getDouble("DE"));
					aTeam.setAdjDE(this.results.getDouble("AdjDE"));
					aTeam.setAdjEM(this.results.getDouble("AdjEM"));
				
				}
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		table += "<br>" +hTeam.getTeamName() +" win %: ";
		double matchupResults = hTeam.calcWinningPct01(aTeam);
		table += matchupResults +"<br>";
		
		table += aTeam.getTeamName() +" win %: ";
		matchupResults = aTeam.calcWinningPct01(hTeam);
		table += matchupResults;
		
		return table;
	}

	
}
