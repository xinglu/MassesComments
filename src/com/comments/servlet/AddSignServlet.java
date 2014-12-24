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

import com.comments.dao.SignDAO;
import com.comments.util.TextUtility;
import com.comments.vo.Sign;

/**
 * Servlet implementation class AddSignServlet
 */
@WebServlet("/AddSignServlet")
public class AddSignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSignServlet() {
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
		String info = request.getParameter("sign_info");
		JSONObject jObject = new JSONObject();
		JSONObject jsonInfo;
		try {
			jsonInfo = new JSONObject(info);
			String sid = jsonInfo.getString("sid");
			String pid = jsonInfo.getString("pid");
			String name = jsonInfo.getString("name");
			String signcontent = jsonInfo.getString("signcontent");
			String signlevel = jsonInfo.getString("signlevel");
			String signimage = jsonInfo.getString("signimage");
			String signtime = jsonInfo.getString("signtime");
			int isid = TextUtility.String2Int(sid);
			int ipid = TextUtility.String2Int(pid);
			Sign sign = new Sign(isid, ipid, name, signcontent, signlevel, signimage, signtime);
			SignDAO signDao = new SignDAO();
			boolean result = signDao.addSignInfo(sign);
			
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
			try {
				jObject.put("ret", 0);
				jObject.put("msg", e.getMessage());
				jObject.put("data", "");
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PrintWriter out = response.getWriter();
		out.println(jObject);
		out.flush();
		out.close();
	}

}
