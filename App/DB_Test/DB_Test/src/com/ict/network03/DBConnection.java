package com.ict.network03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ict.db.VO;

public class DBConnection {
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	
	public DBConnection() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hwlim";
			String password = "1111";
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
		}
	}
	
	/* 원래 예제
	// 전체 정보 보기 
	public ArrayList<String> selectAll(){
		ArrayList<String> list = new ArrayList<>();
		try {
			String sql = "select * from members order by idx";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				StringBuffer sb = new StringBuffer();
				sb.append(rs.getString("idx")+"\t\t");
				sb.append(rs.getString("id")+"\t\t");
				sb.append(rs.getString("password")+"\t\t");
				sb.append(rs.getString("name")+"\t\t");
				sb.append(rs.getString("age")+"\t\t");
				sb.append(rs.getString("addr")+"\t\t");
				
				list.add(sb.toString());
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}*/
	
	
	
	
	public ArrayList<String> getDetailItemInfo(String item_id){
		ArrayList<String> list = new ArrayList<>();
		try {
			String sql = "select * from sw_cart";
			//String sql = "select * from sw_item where item_id = ?";
			pstm = conn.prepareStatement(sql);
			//pstm.setString(1, item_id);
			rs = pstm.executeQuery();
			System.out.println("1");
			while(rs.next()) {
				System.out.println("2-1");
				StringBuffer sb = new StringBuffer();
				sb.append(rs.getString("cust_id")+"\t\t");
				sb.append(rs.getString("item_id")+"\t\t");
				//sb.append(rs.getString("item_spec")+"\t\t");
				//sb.append(rs.getString("item_price")+"\t\t");
				//sb.append(rs.getString("item_nutri")+"\t\t");
				//sb.append(rs.getString("item_aller")+"\t\t");
				
				list.add(sb.toString());
				System.out.println("2-2");
			}
		} catch (Exception e) {
			System.out.println("3");
			System.out.println(e);
		} finally {
			try {
				rs.close();
				pstm.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println("4");
		return list;
	}
	
	
	public String userLogin (String id, String pwd){
		String res = null;
		try {
			String sql = "select * from sw_customer where id=? and pwd = ?";
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, id);
			pstm.setString(2, pwd);
			
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				res =  rs.getString("id")+  "-" + rs.getString("pwd");
			
			}
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			try {
				rs.close();
				pstm.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return res;
	}
}