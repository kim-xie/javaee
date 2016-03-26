package com.my.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;

import com.my.utils.ConnectionUtil;
/**
 * 类名: AreaDao.java
 * 创建人: king 
 * 创建时间：2016年3月27日 上午12:27:39 
 * @version 1.0.0
 */
public class AreaDao {
	public List<HashMap<String,Object>> getArea(Long cid){
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<HashMap<String,Object>> area = null;
		try {
			String sql ="SELECT id,area FROM tm_area WHERE city_id = ?"; 
			connection = ConnectionUtil.getConection();
			ps = connection.prepareStatement(sql);
			ps.setLong(1, cid);
			rs = ps.executeQuery();
			area = new ArrayList<>();//jdk7出现了一种菱形泛型
			HashMap<String,Object> map = null;
			while(rs.next()){
				map = new HashMap<String,Object>();
				map.put("id", rs.getLong("id"));
				map.put("name", rs.getString("area"));
				area.add(map);
			}
			return area;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			ConnectionUtil.closeResultSet(rs, ps, connection);
		}
	};
	
	public static void main(String[] args) {
		List<HashMap<String,Object>> area = new AreaDao().getArea(220200L);
		System.out.println(area);
		try {
			System.out.println(JSONUtil.serialize(area));
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
