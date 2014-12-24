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

/**http://localhost:8085/MassesComments/LoginServlet?pname=123&ppassword=123
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 *  
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		String pname = request.getParameter("pname");
		String ppassword = request.getParameter("ppassword");
		UsersDAO usersDao = new UsersDAO();
		JSONObject jObject = new JSONObject();
		try {
			Users user = usersDao.getUsers(pname, ppassword);
			jObject.put("ret", 1);
			jObject.put("msg", "ok");
			if(user != null){
				jObject.put("data", "yes");
			}else{
				jObject.put("data", "no");
			}
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
		}
		
		PrintWriter out = response.getWriter();
		out.println(jObject);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		String pname = request.getParameter("pname");
		String ppassword = request.getParameter("ppassword");
		UsersDAO usersDao = new UsersDAO();
		JSONObject jObject = new JSONObject();
		try {
			Users user = usersDao.getUsers(pname, ppassword);
			jObject.put("ret", 1);
			jObject.put("msg", "ok");
			if(user != null){
				jObject.put("data", "yes");
			}else{
				jObject.put("data", "no");
			}
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
		}
		
		PrintWriter out = response.getWriter();
		out.println(jObject);
		out.flush();
		out.close();
	}

}
