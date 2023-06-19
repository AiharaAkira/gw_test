package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import bean.Order;
import bean.User;

public class UserDAO {

	// データベース接続情報
		private static String RDB_DRIVE = "com.mysql.jdbc.Driver";
		private static String URL = "jdbc:mysql://localhost/mybookdb";
		private static String USER = "root";
		private static String PASS = "root123";

		// データベース接続を行うメソッド
		// データベース接続用定義を基にデータベースへ接続し、戻り値としてコネクション情報を返す
		public static Connection getConnection() {
			try {
				Class.forName(RDB_DRIVE);
				Connection con = DriverManager.getConnection(URL, USER, PASS);
				return con;
			} catch (Exception e) {
				throw new IllegalStateException(e);
			}
		}



	public static User login(HttpServletRequest request, User user) {
		String userId = user.getUserid();
		String userPw = user.getPassword();

		Connection con = null;
		Statement smt = null;
		ResultSet rs = null;

		user = new User();
		try {
			String sql = "select * from userinfo where user = '"+userId+"'";
			con = getConnection();
			smt = con.createStatement();
			rs = smt.executeQuery(sql);

			if (rs.next()) {
				String dbPW = rs.getString("password");

				if (userPw.equals(dbPW)) {


					user.setUserid(rs.getString("user"));
					user.setPassword(rs.getString("password"));
					user.setEmail(rs.getString("email"));
					user.setAuthority(rs.getString("authority"));

					HttpSession hs = request.getSession();
					hs.setAttribute("userInfo", user);
					hs.setMaxInactiveInterval(1800);

					HttpSession hs2 = request.getSession();
					hs2.setAttribute("order_list", new ArrayList<Order>());
					hs2.setMaxInactiveInterval(1800);

					System.out.println("login success");

				} else {
					System.out.println("pw worng!");
					user = null;

				}
			} else {

				System.out.println("no userdata");
				user = null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ignore) {
				}
			}
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}

		}
		return user;



	}

}
