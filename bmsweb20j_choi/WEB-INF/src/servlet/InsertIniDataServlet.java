package servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Book;
import dao.BookDAO;

public class InsertIniDataServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<Book> list = BookDAO.selectAll();


		if (list.size() > 0) {

			request.setAttribute("errorLinkText", "menu");
			request.setAttribute("errorLink", "/menu");


			request.getRequestDispatcher("/view/error.jsp").forward(request, response);


		} else {

			String path = getServletContext().getRealPath("file\\initial_data.csv");
			String[] strData = null; // 読み込みデータの分割格納用配列

			try {
				// 教科データファイルの読み込み
				Scanner sin = new Scanner(new File(path));

				// 全データを配列に読み込む
				while (sin.hasNextLine()) {
					// 読み込み1行データカンマで分割
					strData = sin.nextLine().split(",");

					// 各配列にデータを格納
					Book b = new Book(strData[0],strData[1],Integer.parseInt(strData[2]));
					list.add(b);
					BookDAO.insert(b);
				}

				sin.close();
			} catch (Exception e) {
				e.printStackTrace();
			}


			request.setAttribute("book_list", list);
			request.getRequestDispatcher("/view/insertIniData.jsp").forward(request, response);

		}

	}
}
