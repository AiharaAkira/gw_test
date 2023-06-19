package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Book;
import dao.BookDAO;

public class DetailServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String isbn = request.getParameter("isbn");
		String cmd = request.getParameter("cmd");
		Book book = BookDAO.selectByIsbn(isbn);
		request.setAttribute("book", book);

		if(cmd.equals("update")) {

			request.getRequestDispatcher("view/update.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("view/detail.jsp").forward(request, response);

		}
	}


	}
