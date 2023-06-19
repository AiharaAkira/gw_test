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
import util.SendMail;

public class BuyConfirmServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		HttpSession session2 = request.getSession();

		User user = (User) session.getAttribute("userInfo");

		if (user == null) {
			request.setAttribute("errorLinkText", "login");
			request.setAttribute("errorLink", "/logout");
			request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			return;
		}

		ArrayList<Order> order_list = (ArrayList<Order>) session2.getAttribute("order_list");

		if (order_list.size() < 1) {
			request.setAttribute("errorLinkText", "menu");
			request.setAttribute("errorLink", "/menu");
			request.getRequestDispatcher("/view/error.jsp").forward(request, response);

			return;
		} else {

			ArrayList<Book> list = new ArrayList<>();

			String product = "";
			int sum = 0;

			for (Order order : order_list) {

				Book book = BookDAO.selectByIsbn(order.getIsbn());

				list.add(book);
				OrderDAO.insert(order);
				sum += book.getPrice();
				product += book.getIsbn() + "  " + book.getTitle() + book.getPrice() + "\r\n";
			}

			request.setAttribute("book_list", list);

			// "order_list"の注文情報内容をメール送信する。
//
			String text = user.getUserid() + "様\r\n" + "本のご購入ありがとうざいます。\r\n" + "以下内容でご注文を受け付けましたので、ご連絡致しま\r\n"
					+ "す。\r\n" + product + "合計 " + sum + "円\r\n" + "またのご利用よろしくお願いします。\r\n" + "";
			SendMail.send(user.getUserid(), text);

			session2.setAttribute("order_list", new ArrayList<>());

			request.getRequestDispatcher("/view/buyConfirm.jsp").forward(request, response);

		}

	}
}
