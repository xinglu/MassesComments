package com.comments.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.comments.dao.UsersDAO;
import com.comments.vo.Users;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		String info = request.getParameter("users_info");
		JSONObject jObject = new JSONObject();
		try {
			JSONObject jsonInfo = new JSONObject(info);
			String pname = jsonInfo.getString("pname");
			String ppassword = jsonInfo.getString("ppassword");
			String nickname = jsonInfo.getString("nickname");
			String sex = jsonInfo.getString("sex");
			Users user = new Users();
			user.setPname(pname);
			user.setPpassword(ppassword);
			user.setNickname(nickname);
			user.setSex(sex);
			UsersDAO useDao = new UsersDAO();
			boolean result = useDao.addUsers(user);
			jObject.put("ret", 1);
			jObject.put("msg", "ok");
			jObject.put("data", ""+result);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			try {
				jObject.put("ret", 0);
				jObject.put("msg", e.getMessage());
				jObject.put("data", "");
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				jObject.put("ret", 0);
				jObject.put("msg", e.getMessage());
				jObject.put("data", "");
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		PrintWriter out = response.getWriter();
		out.println(jObject);
		out.flush();
		out.close();
	}

}
