package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

import model.game;
import model.team;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databaseController.analyzeQuery;
import databaseController.profileQuery;

/**
 * Servlet implementation class analyzeServlet
 */
@WebServlet(urlPatterns = { "/analyzeServlet", "/analyze" })
public class analyzeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public analyzeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Create readQuery object
		analyzeQuery aq = new analyzeQuery ("ncaa_2020", "wyatt", "UGAdawgs21");
				
		//Get HTML Table from readQuery
		String homeTeam = request.getParameter("homeTeam");
		String awayTeam = request.getParameter("awayTeam");
		aq.doAnalysisRead(homeTeam, awayTeam);
			homeTeam = request.getParameter("homeTeam");
			awayTeam = request.getParameter("awayTeam");
			game game = new game();
			team hTeam = new team();
			team aTeam = new team();
			hTeam.setTeamName(homeTeam);
			aTeam.setTeamName(awayTeam);
			game.setHomeTeam(hTeam);
			game.setAwayTeam(aTeam);
		
		double OEAVG = 100.43;
		double DEAVG = 100.57;
		double TempoAVG = 69.27;

		String table = aq.printAdvanceStats(homeTeam);
		table+="<br> Winning Pct: ";
		table+=aq.calcWinningPct01(awayTeam);
		table+="<br> <br> Analysis 03, Tempo 3:";
		table+=aq.analysis03(awayTeam, OEAVG, TempoAVG, 3);
		table+="<br> <br> Analysis 05, Tempo 3:";
		table+=aq.analysis05(awayTeam, OEAVG, TempoAVG, 3);
		
		//Add model spread and winner to game object
		double rawModelSpread = aq.spreadAnalysis03(homeTeam, OEAVG, TempoAVG, 1);
		double modelSpread = Math.abs(rawModelSpread);
		 if(rawModelSpread > 0) {
				game.setModelFavorite(hTeam);
				game.setModelDog(aTeam);
				
			}
			else {
				game.setModelFavorite(aTeam);
				game.setModelDog(hTeam);
			}
		 game.setModelSpread(modelSpread);
		 
		 //TO DO: AUTO
		 //Set empty game fields
		 game.setGameID("XX/XX/XXX"+game.getAwayTeam().getTeamName()+game.getHomeTeam().getTeamName());
		 game.setHomeScore(0);
		 game.setAwayScore(0);
		 game.setVegasSpread(0);
		 game.setVegasFavorite(game.getModelFavorite());
		 game.setVegasDog(game.getModelDog());
		 
		//Pass Execution control to read.jsp with HTML table
		request.setAttribute("table", table);
		request.setAttribute("homeTeam", homeTeam);
		request.setAttribute("awayTeam", awayTeam);
		request.setAttribute("spread", modelSpread);
		request.setAttribute("modelFav", game.getModelFavorite().getTeamName());
		request.setAttribute("modelDog", game.getModelDog().getTeamName());
		
		String url = "/analysis.jsp";
				
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
