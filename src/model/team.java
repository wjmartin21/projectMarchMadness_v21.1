/**
 * 
 */
package model;


import databaseController.analyzeQuery;
import java.math.*;
import java.sql.SQLException;

/**
 * @author wyattmartin
 *
 */
public class team {
	
	//Attributes
	private String teamName;
	private double Off_eFGPct;
	private double Def_eFGPct;
	private double Off_TOPct;
	private double Def_TOPct;
	private double Off_ORPct;
	private double Def_ORPct;
	private double Off_FTRate;
	private double Def_FTRate;
	private double tempo;
	private double FTPct;
	
	/**
	 * @param teamName
	 * @param off_eFGPct
	 * @param def_eFGPct
	 * @param off_TOPct
	 * @param def_TOPct
	 * @param off_ORPct
	 * @param def_ORPct
	 * @param off_FTRate
	 * @param deff_FTRate
	 * @param tempo
	 * @param fTPct
	 */
	public team() {
			
	}
	

	/**
	 * @param teamName
	 * @param off_eFGPct
	 * @param def_eFGPct
	 * @param off_TOPct
	 * @param def_TOPct
	 * @param off_ORPct
	 * @param def_ORPct
	 * @param off_FTRate
	 * @param deff_FTRate
	 * @param tempo
	 * @param fTPct
	 */
	public team(String teamName, double off_eFGPct, double def_eFGPct, double off_TOPct,
			double def_TOPct, double off_ORPct, double def_ORPct, double off_FTRate, double deff_FTRate, double tempo,
			double fTPct) {
		this.teamName = teamName;
		Off_eFGPct = off_eFGPct;
		Def_eFGPct = def_eFGPct;
		Off_TOPct = off_TOPct;
		Def_TOPct = def_TOPct;
		Off_ORPct = off_ORPct;
		Def_ORPct = def_ORPct;
		Off_FTRate = off_FTRate;
		Def_FTRate = deff_FTRate;
		this.tempo = tempo;
		FTPct = fTPct;
	}

	/**
	 * @return the teamName
	 */
	public String getTeamName() {
		return teamName;
	}


	/**
	 * @param teamName the teamName to set
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}


	/**
	 * @return the off_eFGPct
	 */
	public double getOff_eFGPct() {
		return Off_eFGPct;
	}


	/**
	 * @param off_eFGPct the off_eFGPct to set
	 */
	public void setOff_eFGPct(double off_eFGPct) {
		Off_eFGPct = off_eFGPct;
	}


	/**
	 * @return the def_eFGPct
	 */
	public double getDef_eFGPct() {
		return Def_eFGPct;
	}


	/**
	 * @param def_eFGPct the def_eFGPct to set
	 */
	public void setDef_eFGPct(double def_eFGPct) {
		Def_eFGPct = def_eFGPct;
	}


	/**
	 * @return the off_TOPct
	 */
	public double getOff_TOPct() {
		return Off_TOPct;
	}


	/**
	 * @param off_TOPct the off_TOPct to set
	 */
	public void setOff_TOPct(double off_TOPct) {
		Off_TOPct = off_TOPct;
	}


	/**
	 * @return the def_TOPct
	 */
	public double getDef_TOPct() {
		return Def_TOPct;
	}


	/**
	 * @param def_TOPct the def_TOPct to set
	 */
	public void setDef_TOPct(double def_TOPct) {
		Def_TOPct = def_TOPct;
	}


	/**
	 * @return the off_ORPct
	 */
	public double getOff_ORPct() {
		return Off_ORPct;
	}


	/**
	 * @param off_ORPct the off_ORPct to set
	 */
	public void setOff_ORPct(double off_ORPct) {
		Off_ORPct = off_ORPct;
	}


	/**
	 * @return the def_ORPct
	 */
	public double getDef_ORPct() {
		return Def_ORPct;
	}


	/**
	 * @param def_ORPct the def_ORPct to set
	 */
	public void setDef_ORPct(double def_ORPct) {
		Def_ORPct = def_ORPct;
	}


	/**
	 * @return the off_FTRate
	 */
	public double getOff_FTRate() {
		return Off_FTRate;
	}


	/**
	 * @param off_FTRate the off_FTRate to set
	 */
	public void setOff_FTRate(double off_FTRate) {
		Off_FTRate = off_FTRate;
	}


	/**
	 * @return the deff_FTRate
	 */
	public double getDef_FTRate() {
		return Def_FTRate;
	}


	/**
	 * @param deff_FTRate the deff_FTRate to set
	 */
	public void setDef_FTRate(double def_FTRate) {
		Def_FTRate = def_FTRate;
	}


	/**
	 * @return the tempo
	 */
	public double getTempo() {
		return tempo;
	}


	/**
	 * @param tempo the tempo to set
	 */
	public void setTempo(double tempo) {
		this.tempo = tempo;
	}


	/**
	 * @return the fTPct
	 */
	public double getFTPct() {
		return FTPct;
	}


	/**
	 * @param fTPct the fTPct to set
	 */
	public void setFTPct(double fTPct) {
		FTPct = fTPct;
	}


	//Print table
	public String printAdvancedStats(team awayTeam) {
		String table = "Machup Stats:";
		table += "<br>";
		table += "<table border="+'"'+"1"+'"'+">";
		table += "<tr>";
		table += "<td>";
		table += "Team: ";
		table += "</td>";
		table += "<td>";
		table += "eFG% (Opp)";
		table += "</td>";
		table += "<td>";
		table += "TO% (Opp)";
		table += "</td>";
		table += "<td>";
		table += "ORPct (Opp)";
		table += "</td>";
		table += "<td>";
		table += "FTRate (Opp)";
		table += "</td>";
		table += "<td>";
		table += "Tempo";
		table += "</td>";
		table += "<td>";
		table += "AdjTempo";
		table += "</td>";
		table += "<td>";
		table += "Offensive efficiency";
		table += "</td>";
		table += "<td>";
		table += "Adj OE";
		table += "</td>";
		table += "<td>";
		table += "Defensive efficiency";
		table += "</td>";
		table += "<td>";
		table += "Adj DE";
		table += "</td>";
		table += "<td>";
		table += "Adj EM";
		table += "</td>";
		
		table += "</table> <br>";
		
		return table;
	}
	

}
