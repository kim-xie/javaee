package com.my.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;

import com.my.dao.CityDao;
/**
 * 
 * 类名: CityServlet.java
 * 创建人: king 
 * 创建时间：2016年3月27日 上午12:26:33 
 * @version 1.0.0
 */
public class CityServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String pid = req.getParameter("pid");
		//先去application查询
		ServletContext application = req.getServletContext();
		@SuppressWarnings("unchecked")
		List<HashMap<String,Object>> city = (List<HashMap<String, Object>>) application.getAttribute("city"+pid);
		//如果没有才进后台查找
		if(city == null){
			city = new CityDao().getCity(new Long(pid));
			application.setAttribute("city"+pid, city);
		}
		
		PrintWriter out = resp.getWriter();
		
		try {
			out.print(JSONUtil.serialize(city));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		out.flush();
		out.close();
	}
}
