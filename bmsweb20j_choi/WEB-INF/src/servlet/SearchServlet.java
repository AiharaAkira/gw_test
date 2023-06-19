package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Book;
import dao.BookDAO;

public class SearchServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String isbn = request.getParameter("isbn");
		String title = request.getParameter("title");
		String price = request.getParameter("price");

		ArrayList<Book> books = (ArrayList<Book>) BookDAO.search(isbn, title, price);

		if(isbn.equals(null)&&title.equals(null)&&price.equals(null)) {
			books = (ArrayList<Book>) BookDAO.selectAll();
		}

		request.setAttribute("book_list", books);

		request.getRequestDispatcher("view/list.jsp").forward(request, response);


	}

}
