package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databaseController.profileQuery;

/**
 * Servlet implementation class readServlet
 */
@WebServlet(
		description = "Controller for reading User table from mysql", 
		urlPatterns = { 
				"/profileServlet", 
				"/teamProfile"
		})
public class profileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public profileServlet() {
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
		profileQuery pq = new profileQuery ("ncaa_2021", "wyatt", "UGAdawgs21");
		
		//Get HTML Table from readQuery
		pq.doProfileRead();
		String table = pq.getHTMLTable();
		
		//Pass Execution control to read.jsp with HTML table
		request.setAttribute("table", table);
		String url = "/teamProfile.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
