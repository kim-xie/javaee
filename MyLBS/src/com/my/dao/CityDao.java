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

public class CityDao {
	/**
	 * 
	 * @Title: findProvince 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @return  参数说明 
	 * @return List<HashMap<String,Object>>  返回类型 
	 * @throws
	 */
	public List<HashMap<String, Object>> findProvince() {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<HashMap<String, Object>> citys = null;
		try {
			String sql = "SELECT id,province from tm_province";
			//获取链接对象
			connection = ConnectionUtil.getConection();
			//处理对象
			ps = connection.prepareStatement(sql);
			//返回结果集
			rs = ps.executeQuery();
			//遍历结果集
			citys = new ArrayList<>();//jdk7出现了一种菱形泛型
			HashMap<String, Object> city =null;
			while (rs.next()) {
				 city = new HashMap<String, Object>();
				 city.put("id", rs.getLong("id"));
				 city.put("name", rs.getString("province"));
				 citys.add(city);
			}
			return citys;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			ConnectionUtil.closeResultSet(rs, ps, connection);
		}
	}
	/**
	 * @Title: getCity 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param pid
	 * @param @return  参数说明 
	 * @return List<HashMap<String,Object>>  返回类型 
	 * @throws
	 */
	public List<HashMap<String,Object>> getCity(Long pid){
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<HashMap<String,Object>> city = null;
		try {
			String sql ="SELECT id,city FROM tm_city WHERE province_id = ?"; 
			connection = ConnectionUtil.getConection();
			ps = connection.prepareStatement(sql);
			ps.setLong(1, pid);
			rs = ps.executeQuery();
			city = new ArrayList<>();//jdk7出现了一种菱形泛型
			HashMap<String,Object> map = null;
			while(rs.next()){
				map = new HashMap<String,Object>();
				map.put("id", rs.getLong("id"));
				map.put("name", rs.getString("city"));
				city.add(map);
			}
			return city;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			ConnectionUtil.closeResultSet(rs, ps, connection);
		}
	};
	/**
	 * 
	 * @Title: main 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param args  参数说明 
	 * @return void  返回类型 
	 * @throws
	 */
	
	public static void main(String[] args) {
		List<HashMap<String,Object>> city = new CityDao().getCity(220000L);
		System.out.println(city);
		try {
			System.out.println(JSONUtil.serialize(city));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		List<HashMap<String,Object>> citys = new CityDao().findProvince();
		System.out.println(citys);
		try {
			System.out.println(JSONUtil.serialize(citys));
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
