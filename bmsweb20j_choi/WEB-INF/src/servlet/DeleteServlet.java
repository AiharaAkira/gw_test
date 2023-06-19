package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Book;
import dao.BookDAO;

public class DeleteServlet extends HttpServlet{


			public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				request.setCharacterEncoding("UTF-8");

				String isbn = request.getParameter("isbn");

				String nullCheck = "  ";
				String isbnIsNotNull = "  ";

				Book book = BookDAO.selectByIsbn(isbn);


				if(isbn.equals("")) {
					nullCheck = "エラー\n\n 入力isbnが未入力のため、書籍登録処理は行えませんでした。";
					request.setAttribute("isbnIsNotNull", isbnIsNotNull);
					request.setAttribute("nullCheck", nullCheck);

					request.setAttribute("errorLinkText", "list");
					request.setAttribute("errorLink", "/list");

					request.getRequestDispatcher("/view/error.jsp").forward(request, response);
					return;
				}



				if (BookDAO.delete(book) >= 1) {
					ArrayList<Book> books = BookDAO.selectAll();

					request.setAttribute("book_list", books);
					request.getRequestDispatcher("view/list.jsp").forward(request, response);

				}



			}


}
