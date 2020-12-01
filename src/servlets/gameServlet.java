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

/**
 * Servlet implementation class analyzeServlet
 */
@WebServlet(urlPatterns = { "/gameServlet", "/game" })
public class gameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gameServlet() {
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
		// Create gameQuery object
		gameQuery gq = new gameQuery ("ncaa_2020", "wyatt", "UGAdawgs21");
				
		//Get HTML Table from readQuery
		gq.doFullGameRead();
		String table = gq.printAll();
		String result = "Table read successfully";
		
				
		//Pass Execution control to read.jsp with HTML table
		request.setAttribute("gameLog", table);
		request.setAttribute("result", result);

		String url = "/gameLog.jsp";
				
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
