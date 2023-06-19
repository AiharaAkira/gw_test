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
import dao.OrderDAO;

public class InsertIntoCartServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession hs = request.getSession();
		User user = (User) hs.getAttribute("userInfo");

		HttpSession hs2 = request.getSession();


		if(user == null) {

			request.setAttribute("errorLinkText", "login");
			request.setAttribute("errorLink", "/logout");


			request.getRequestDispatcher("/view/error.jsp").forward(request, response);
		}

		String isbn = request.getParameter("isbn");

		Book book = BookDAO.selectByIsbn(isbn);
		request.setAttribute("book", book);

		Order order = new Order();
		order.setIsbn(isbn);
		order.setUserid(user.getUserid());
		order.setQuantity(1);

		ArrayList<Order> list = (ArrayList<Order>) hs2.getAttribute("order_list");
		if (list == null) {
			list = new ArrayList<Order>();
		}

		list.add(order);

		hs2.setAttribute("order_list", list);

		/*
		 * エラーの有無でフォワード先を呼び別ける。
		 * ・エラーが無い場合(正常ルート)はスコープデータに②で取得したBookをinsertIntoCart.jspにフォワードする
		 * 例）request.getRequestDispatcher("/view/insertIntoCart.jsp").forward(request,
		 * response) ・エラーが有る場合(異常ルート)はerror.jspにフォワードする
		 * 例）request.getRequestDispatcher("/view/error.jsp").forward(request, response)
		 *
		 */

		request.getRequestDispatcher("/view/insertIntoCart.jsp").forward(request, response);

	}

}
