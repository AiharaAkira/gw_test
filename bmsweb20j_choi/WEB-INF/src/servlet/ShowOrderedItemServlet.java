package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.OrderedItem;
import dao.OrderedItemDAO;

public class ShowOrderedItemServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<OrderedItem> list = OrderedItemDAO.selectAll();

		request.setAttribute("ordered_list",list);

		request.getRequestDispatcher("/view/showOrderedItem.jsp").forward(request, response);

	}



}
