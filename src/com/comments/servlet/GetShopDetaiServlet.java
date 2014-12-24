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

import com.comments.dao.CommentsDAO;
import com.comments.dao.FoodDAO;
import com.comments.dao.SignDAO;
import com.comments.util.TextUtility;
import com.comments.vo.Comments;
import com.comments.vo.Food;
import com.comments.vo.Sign;

/** http://localhost:8085/MassesComments/GetShopDetaiServlet?shopid=1
 * Servlet implementation class GetShopDetaiServlet
 */
@WebServlet("/GetShopDetaiServlet")
public class GetShopDetaiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetShopDetaiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		String id = request.getParameter("shopid");
		int shopid = TextUtility.String2Int(id);
		SignDAO signDao ;
		CommentsDAO commentsDao ;
		FoodDAO foodDao;
		ArrayList<Sign> signList;
		ArrayList<Comments> commentsList;
		ArrayList<Food> foodList;
		JSONObject jObject = new JSONObject();
		try{
			signDao = new SignDAO();
			signList = new ArrayList<Sign>();
			signList = signDao.getAllByShopsid(shopid);
			commentsDao = new CommentsDAO();
			commentsList = commentsDao.getCommentsByShopid(shopid);
			foodDao = new FoodDAO();
			foodList = foodDao.getFoodsByShopid(shopid);
			
			JSONObject jsonData = new JSONObject();
			JSONArray jArray = new JSONArray();
			for(Sign sign : signList){
				jArray.put(sign.writeToJson());
			}
			jsonData.put("sign", jArray);
			
			jArray = new JSONArray();
			for(Comments comm :commentsList){
				jArray.put(comm.writeToJson());
			}
			jsonData.put("comments", jArray);
			
			jArray = new JSONArray();
			for(Food food : foodList){
				jArray.put(food.writoToJSon());
			}
			jsonData.put("food", jArray);
			jObject.put("ret", 1);
			jObject.put("msg", "ok");
			jObject.put("data", jsonData);
			
		}catch(SQLException e){
			try
			{
				jObject.put("ret", 0);
				jObject.put("msg", e.getMessage());
				jObject.put("data", "");
			} catch (JSONException ex)
			{
				ex.printStackTrace();
			}
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
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
