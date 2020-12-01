package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databaseController.analyzeQuery;
import databaseController.gameQuery;
import databaseController.profileQuery;
import model.game;
import model.team;

/**
 * Servlet implementation class analyzeServlet
 */
@WebServlet(urlPatterns = { "/addGameServlet", "/addGame" })
public class addGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addGameServlet() {
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
				
		//Get HTML Table from readQuery
		game game = new game();
		team hTeam = new team();
		team aTeam = new team();
		String homeTeam = request.getParameter("homeTeam");
		String awayTeam = request.getParameter("awayTeam");
		double modelSpread = Double.valueOf(request.getParameter("modelSpread"));
		String modelFav = request.getParameter("modelFav");
		String modelDog = request.getParameter("modelDog");
		
		hTeam.setTeamName(homeTeam);
		aTeam.setTeamName(awayTeam);
		
		game.setHomeTeam(hTeam);
		game.setAwayTeam(aTeam);
		game.setModelSpread(modelSpread);
		
		if (homeTeam.equalsIgnoreCase(modelFav)) {
			game.setModelFavorite(hTeam);
			game.setModelDog(aTeam);
		}
		else {
			game.setModelFavorite(aTeam);
			game.setModelDog(hTeam);
		}
		
		//Add Extra variables
		game.setVegasSpread(111);
		game.setVegasFavorite(aTeam);
		game.setVegasDog(hTeam);
		
		// Create gameQuery object
		gameQuery gq = new gameQuery ("ncaa_2020", "wyatt", "UGAdawgs21");
		
		
		String result = gq.addGame(game);
		gq.doFullGameRead();
		String table = gq.printAll();
		
				
		//Pass Execution control to read.jsp with HTML table
		request.setAttribute("result", result);
		request.setAttribute("gameLog", table);
		String url = "/gameLog.jsp";
				
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
