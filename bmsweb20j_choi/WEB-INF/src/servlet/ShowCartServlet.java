package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Book;
import bean.Order;
import bean.User;
import dao.BookDAO;

public class ShowCartServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String delno = request.getParameter("delno");

		HttpSession hs = request.getSession();
		User user = (User) hs.getAttribute("userInfo");

		HttpSession hs2 = request.getSession();


		if (user == null) {
			request.setAttribute("errorLinkText", "menu");
			request.setAttribute("errorLink", "/menu");


			request.getRequestDispatcher("/view/error.jsp").forward(request, response);
		}

		ArrayList<Order> order_list = (ArrayList<Order>) hs2.getAttribute("order_list");

		Book book = null;

		if(delno != null) {

			for (Order order : order_list) {

				if (order.getOrderno() == Integer.parseInt(delno)) {
					order_list.remove(Integer.parseInt(delno));
				}


			}

		}

		ArrayList<Book> books = new ArrayList<>();

		for (Order order2 : order_list) {

			book = BookDAO.selectByIsbn(order2.getIsbn());
			books.add(book);
		}

		request.setAttribute("book_list", books);

		request.getRequestDispatcher("/view/showCart.jsp").forward(request, response);

	}

}
