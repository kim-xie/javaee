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

public class ProvinceServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//先去application查询
		ServletContext application = req.getServletContext();
		@SuppressWarnings("unchecked")
		List<HashMap<String,Object>> citys = (List<HashMap<String, Object>>) application.getAttribute("citys");
		//如果没有才进后台查找
		if(citys == null){
			citys = new CityDao().findProvince();
			application.setAttribute("citys",citys);
		}
		
		PrintWriter out = resp.getWriter();
		try {
			out.print(JSONUtil.serialize(citys));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		out.flush();
		out.close();
	}
}
