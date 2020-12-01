/**
 * 
 */
package model;

import model.team;

/**
 * @author wyattmartin
 *
 */
public class game {

	private String gameID;
	private team homeTeam;
	private team awayTeam;
	private int homeScore;
	private int awayScore;
	private int margin;
	private double vegasSpread;
	private team vegasFavorite;
	private team vegasDog;
	private double modelSpread;
	private team modelFavorite;
	private team modelDog;
	
	/**
	 * Default
	 */
	public game() {
		
	}

	
	/**
	 * @param homeTeam
	 * @param awayTeam
	 */
	public game(team homeTeam, team awayTeam) {
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
	}
	
	/**
	 * @param homeTeam
	 * @param awayTeam
	 * @param homeScore
	 * @param awayScore
	 * @param margin
	 * @param vegasSpread
	 * @param vegasFavorite
	 * @param vegasDog
	 * @param modelSpread
	 * @param modelFavorite
	 * @param modelDog
	 */
	public game(team homeTeam, team awayTeam, int homeScore, int awayScore, int margin, double vegasSpread,
			team vegasFavorite, team vegasDog, double modelSpread, team modelFavorite, team modelDog) {
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.homeScore = homeScore;
		this.awayScore = awayScore;
		this.margin = margin;
		this.vegasSpread = vegasSpread;
		this.vegasFavorite = vegasFavorite;
		this.vegasDog = vegasDog;
		this.modelSpread = modelSpread;
		this.modelFavorite = modelFavorite;
		this.modelDog = modelDog;
	}



	/**
	 * @return the gameID
	 */
	public String getGameID() {
		return gameID;
	}

	
	
	/**
	 * @return the homeTeam
	 */
	public team getHomeTeam() {
		return homeTeam;
	}



	/**
	 * @return the awayTeam
	 */
	public team getAwayTeam() {
		return awayTeam;
	}



	/**
	 * @return the homeScore
	 */
	public int getHomeScore() {
		return homeScore;
	}



	/**
	 * @return the awayScore
	 */
	public int getAwayScore() {
		return awayScore;
	}



	/**
	 * @return the margin
	 */
	public int getMargin() {
		return margin;
	}



	/**
	 * @return the vegasSpread
	 */
	public double getVegasSpread() {
		return vegasSpread;
	}



	/**
	 * @return the vegasFavorite
	 */
	public team getVegasFavorite() {
		return vegasFavorite;
	}



	/**
	 * @return the vegasDog
	 */
	public team getVegasDog() {
		return vegasDog;
	}



	/**
	 * @return the modelSpread
	 */
	public double getModelSpread() {
		return modelSpread;
	}



	/**
	 * @return the modelFavorite
	 */
	public team getModelFavorite() {
		return modelFavorite;
	}



	/**
	 * @return the modelDog
	 */
	public team getModelDog() {
		return modelDog;
	}


	/**
	 * @param gameID the gameID to set
	 */
	public void setGameID(String gameID) {
		this.gameID = gameID;
	}
	

	/**
	 * @param string the homeTeam to set
	 */
	public void setHomeTeam(team homeTeam) {
		this.homeTeam = homeTeam;
	}



	/**
	 * @param awayTeam the awayTeam to set
	 */
	public void setAwayTeam(team awayTeam) {
		this.awayTeam = awayTeam;
	}



	/**
	 * @param homeScore the homeScore to set
	 */
	public void setHomeScore(int homeScore) {
		this.homeScore = homeScore;
	}



	/**
	 * @param awayScore the awayScore to set
	 */
	public void setAwayScore(int awayScore) {
		this.awayScore = awayScore;
	}



	/**
	 * @param margin the margin to set
	 */
	public void setMargin(int margin) {
		this.margin = margin;
	}



	/**
	 * @param vegasSpread the vegasSpread to set
	 */
	public void setVegasSpread(double vegasSpread) {
		this.vegasSpread = vegasSpread;
	}



	/**
	 * @param vegasFavorite the vegasFavorite to set
	 */
	public void setVegasFavorite(team vegasFavorite) {
		this.vegasFavorite = vegasFavorite;
	}



	/**
	 * @param vegasDog the vegasDog to set
	 */
	public void setVegasDog(team vegasDog) {
		this.vegasDog = vegasDog;
	}



	/**
	 * @param modelSpread the modelSpread to set
	 */
	public void setModelSpread(double modelSpread) {
		this.modelSpread = modelSpread;
	}



	/**
	 * @param modelFavorite the modelFavorite to set
	 */
	public void setModelFavorite(team modelFavorite) {
		this.modelFavorite = modelFavorite;
	}



	/**
	 * @param modelDog the modelDog to set
	 */
	public void setModelDog(team modelDog) {
		this.modelDog = modelDog;
	}



	/**
	 * @param margin the margin to set
	 */
	public void calcMargin() {
		int diff = 0;
	
		if (this.homeScore > this.awayScore) {
			diff = this.homeScore - this.awayScore;
		}
		else {
			diff = this.awayScore - this.homeScore;
		}
		this.margin = diff;
	}
	
	//Print table
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
			
					
			table += "<tr>";
			table += "<td>";
			table += this.getGameID();
			table += "</td>";
			table += "<td>";
			table += this.homeTeam.getTeamName();
			table += "</td>";
			table += "<td>";
			table += this.awayTeam.getTeamName();
			table += "</td>";
			table += "<td>";
			table += this.getVegasFavorite()+" -"+this.getVegasSpread();
			table += "</td>";
			table += "<td>";
			table += this.getModelFavorite()+" -"+this.getModelSpread();
			table += "</td>";	
					
			table += "</table> <br>";
			
			return table;
		}
	
}
