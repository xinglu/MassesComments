package com.comments.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.comments.dao.ShopDao;
import com.comments.util.TextUtility;
import com.comments.vo.Shop;

/**http://localhost:8085/MassesComments/GetShopInfoFilterTuanServlet?start=1&end=8
 * Servlet implementation class GetShopInfoFilterTuanServlet
 */
@WebServlet("/GetShopInfoFilterTuanServlet")
public class GetShopInfoFilterTuanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetShopInfoFilterTuanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		int istart = TextUtility.String2Int(start);
		int iend = TextUtility.String2Int(end);
		JSONObject jObject = new JSONObject();
		ArrayList<Shop> shopList = new ArrayList<Shop>();
		ShopDao shopDao = new ShopDao();
		
		try {
			shopList = shopDao.getAllByFilterTuan(istart, iend);
			JSONArray jArray = new JSONArray();
			for(Shop shop : shopList){
				jArray.put(shop.writeToJson());
			}
			JSONObject jdata = new JSONObject();
			jdata.put("shop", jArray);
			jObject.put("ret", 1);
			jObject.put("msg", "ok");
			jObject.put("data", jdata);
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
		doGet(request, response);
	}

}
