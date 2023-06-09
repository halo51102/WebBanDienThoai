package mvc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.CartDB;
import utils.ProductDB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Cart;
import bean.Product;
import conn.DBConnection;

/**
 * Servlet implementation class SearchProductController
 */
@WebServlet(name="SearchProduct",urlPatterns={"/search"})
public class SearchProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try 
		{
			conn=DBConnection.getConnection();
		} 
		catch (ClassNotFoundException | SQLException e1) 
		{
			//TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String name=(String)request.getParameter("keyword");
		List<Product> list=null;
		try {
			list=ProductDB.searchProduct(conn,name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("searchProduct", list);	
		response.setContentType("text/html;charset=UTF-8");
		
		response.addHeader("Content-Security-Policy", "frame-ancestors 'none'");
		
		RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/views/searchProduct.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
