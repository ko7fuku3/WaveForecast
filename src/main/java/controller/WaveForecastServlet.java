package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WaveForecastServlet
 */
@WebServlet("/WaveForecastServlet")
public class WaveForecastServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	final String VIEW = "/WEB-INF/view/index.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WaveForecastServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);

		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String windDirection = request.getParameter("windDirection");
		
		request.setAttribute("waveCondition", "エクセレント");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);

		dispatcher.forward(request, response);
	}

}
