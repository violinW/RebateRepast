package member;

import java.util.List;

import com.mysql.jdbc.Statement;

import common.DbAccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import config.SystemDBConfig;;

public class memberDao implements memberInterface {
	
	SystemDBConfig conf = new SystemDBConfig();

	@Override
	public void addMember(Object data) {
		System.out.println("addMember 添加会员\n\n");
		
		memberType dt = (memberType)data;
		
		String sql = "insert into BDMember (UUID, BD_UUID, name, phone, sex, yunpay_account, self_recommend, Recommended_account) values ('" 
		+ UUID.randomUUID() + "', '" + dt.BD_UUID + "' ,'" + dt.name + "', '" + dt.phone + "', '" + dt.sex + "', '" + dt.yunpay_account + "', " + dt.self_recommend 
		+ ", '" + dt.Recommended_account + "')";
		
		try {
			DbAccess acc = new DbAccess();
			// statement用来执行SQL语句
			acc.connectDB(conf.host, conf.port, conf.dbName, conf.user, conf.password);
			Statement statement = (Statement) acc.conn.createStatement();
			
			System.out.println("sql: [" + sql + "]");
			
			// 结果集
			int rs = statement.executeUpdate(sql);
			
			acc.closeConnection();
			
			System.out.println("access table BDMember insert " + rs);
		
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		}catch (Exception e) {

			e.printStackTrace();

		}
	}

	@Override
	public void updateMember(String dt_UUID, Object data) {
		System.out.println("updateMember 更新会员\n\n");

		memberType dt = (memberType)data;
		
		String sql = "update from BDMember where UUID = '" + dt_UUID + "set name = '" + dt.name + "', phone = '" + dt.phone + "', sex = '" + dt.sex + "', yunpay_account = '"
		+ dt.yunpay_account + "', self_recommend = " + dt.self_recommend + ", Recommended_account = '" + dt.Recommended_account + "'";
		
		try {
			DbAccess acc = new DbAccess();
			// statement用来执行SQL语句
			acc.connectDB(conf.host, conf.port, conf.dbName, conf.user, conf.password);
			Statement statement = (Statement) acc.conn.createStatement();
			
			System.out.println("sql: [" + sql + "]");
			
			// 结果集
			int rs = statement.executeUpdate(sql);
			
			acc.closeConnection();
			
			System.out.println("access table BDMember update " + rs);
		
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		}catch (Exception e) {

			e.printStackTrace();

		}
		
	}

	@Override
	public void deleteMember(String dt_UUID) {
		System.out.println("deleteMember 删除会员\n\n");

		String sql = "update from BDMember where UUID = '" + dt_UUID + "' set deleted = true";
		
		try {
			DbAccess acc = new DbAccess();
			// statement用来执行SQL语句
			acc.connectDB(conf.host, conf.port, conf.dbName, conf.user, conf.password);
			Statement statement = (Statement) acc.conn.createStatement();
			
			System.out.println("sql: [" + sql + "]");
			
			// 结果集
			int rs = statement.executeUpdate(sql);
			
			acc.closeConnection();
			
			System.out.println("access table BDMember delete " + rs);
		
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		}catch (Exception e) {

			e.printStackTrace();

		}
		
	}

	@Override
	public Object queryMember(String dt_UUID) {
		System.out.println("queryMember 查询会员\n\n");

		String sql = "select * from BDMember where UUID = '" + dt_UUID +"' and deleted = false";
		
		try {
			DbAccess acc = new DbAccess();
			// statement用来执行SQL语句
			acc.connectDB(conf.host, conf.port, conf.dbName, conf.user, conf.password);
			Statement statement = (Statement) acc.conn.createStatement();
			
			System.out.println("sql: [" + sql + "]");
			
			// 结果集
			ResultSet rs = statement.executeQuery(sql);
			
			rs.next();
			memberType data = new memberType();
			data.UUID = rs.getString("UUID");
			data.name = rs.getString("name");
			data.phone = rs.getString("phone");
			data.sex = rs.getString("sex");
			data.yunpay_account = rs.getString("yunpay_account");
			data.self_recommend = rs.getBoolean("self_recommend");
			data.Recommended_account = rs.getString("Recommended_account");
			acc.closeConnection();
			
			System.out.println("access table BDMember query " + data);
			
			return (Object)data;
		
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		}catch (Exception e) {

			e.printStackTrace();

		}
		
		return null;
		
	}

	@Override
	public List<Object> getAllMember() {
		System.out.println("getAllMember 查询所有会员\n\n");

		String sql = "select * from BDMember where deleted = false";
		
		try {
			DbAccess acc = new DbAccess();
			// statement用来执行SQL语句
			acc.connectDB(conf.host, conf.port, conf.dbName, conf.user, conf.password);
			Statement statement = (Statement) acc.conn.createStatement();
			
			System.out.println("sql: [" + sql + "]");
			
			// 结果集
			ResultSet rs = statement.executeQuery(sql);
			
			List<Object> data = new ArrayList<Object>();
			
			while(rs.next()) {
				memberType item = new memberType();
				item.UUID = rs.getString("UUID");
				item.name = rs.getString("name");
				item.phone = rs.getString("phone");
				item.sex = rs.getString("sex");
				item.yunpay_account = rs.getString("yunpay_account");
				item.self_recommend = rs.getBoolean("self_recommend");
				item.Recommended_account = rs.getString("Recommended_account");
				data.add((Object)item);
			}
			acc.closeConnection();
			
			System.out.println("access table BDMember query " + data);
			
			return data;
		
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		}catch (Exception e) {

			e.printStackTrace();

		}
		
		return null;
	}

	@Override
	public List<Object> getMemberByBD(String BD_UUID) {
		System.out.println("getMemberByBD 根据商圈查询会员\n\n");

		String sql = "select * from BDMember where BD_UUID = '" + BD_UUID + "' deleted = false";
		
		try {
			DbAccess acc = new DbAccess();
			// statement用来执行SQL语句
			acc.connectDB(conf.host, conf.port, conf.dbName, conf.user, conf.password);
			Statement statement = (Statement) acc.conn.createStatement();
			
			System.out.println("sql: [" + sql + "]");
			
			// 结果集
			ResultSet rs = statement.executeQuery(sql);
			
			List<Object> data = new ArrayList<Object>();
			
			while(rs.next()) {
				memberType item = new memberType();
				item.UUID = rs.getString("UUID");
				item.name = rs.getString("name");
				item.phone = rs.getString("phone");
				item.sex = rs.getString("sex");
				item.yunpay_account = rs.getString("yunpay_account");
				item.self_recommend = rs.getBoolean("self_recommend");
				item.Recommended_account = rs.getString("Recommended_account");
				data.add((Object)item);
			}
			acc.closeConnection();
			
			System.out.println("access table BDMember query " + data);
			
			return data;
		
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		}catch (Exception e) {

			e.printStackTrace();

		}
		
		return null;
	}
	
	private class memberType{
		String UUID;
		String BD_UUID;
		String name;
		String phone;
		String sex;
		String yunpay_account;
		Boolean self_recommend;
		String Recommended_account;
	}

}
