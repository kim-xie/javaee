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

import com.my.dao.AreaDao;
/**
 * 
 * 类名: AreaServlet.java
 * 创建人: king 
 * 创建时间：2016年3月27日 上午12:27:10 
 * @version 1.0.0
 */
public class AreaServlet extends HttpServlet{
	  
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String cid = req.getParameter("cid");
		ServletContext application = req.getServletContext();
		//先去application查询
		@SuppressWarnings("unchecked")
		List<HashMap<String,Object>> area = (List<HashMap<String, Object>>) application.getAttribute("area"+cid);
		//如果没有才进后台查找
		if(area == null){
			area = new AreaDao().getArea(new Long(cid));
			application.setAttribute("area"+cid, area);
		}
		
		PrintWriter out = resp.getWriter();
		
		try {
			out.print(JSONUtil.serialize(area));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		out.flush();
		out.close();
	}
}
