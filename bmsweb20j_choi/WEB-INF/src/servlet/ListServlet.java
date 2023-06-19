package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Book;
import dao.BookDAO;

public class ListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		ArrayList<Book> books = BookDAO.selectAll();
		request.setAttribute("book_list", books);
		request.getRequestDispatcher("view/list.jsp").forward(request, response);

	}

}
