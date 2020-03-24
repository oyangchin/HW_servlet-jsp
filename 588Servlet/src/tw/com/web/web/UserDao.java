package tw.com.web.web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import tw.com.bean.User;
import tw.com.input.AddUserInput;
import tw.com.input.QueryUserInput;
import tw.com.web.dao.BaseDao;

public class UserDao extends BaseDao {
	/**
	 * 取得所有帳號列表
	 * 
	 * @return
	 */
	public List<User> getAll() {
		List<User> list = new ArrayList<User>();
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			StringBuffer sql = new StringBuffer();
			sql.append(" SELECT * FROM USERS ORDER BY ID");

			conn = this.getConnection();
			ps = conn.prepareStatement(sql.toString());
			ResultSet rs = ps.executeQuery();
			User user = null;
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt("ID"));
				user.setAge(rs.getInt("AGE"));
				user.setName(rs.getString("NAME"));
				user.setCountry(rs.getString("COUNTRY"));
				user.setPhone(rs.getString("PHONE"));
				user.setUserId(rs.getString("USERID"));
				list.add(user);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {

				}
			}
		}

		return list;
	}

	public List<User> query(QueryUserInput queryUser) {

		List<User> list = new ArrayList<User>();

		Connection conn = null;
		PreparedStatement ps = null;

		String name = queryUser.getName();
		String phone = queryUser.getPhone();

		try {
			StringBuffer sql = new StringBuffer();
			sql.append(" SELECT * FROM USERS ");
			sql.append(" WHERE 1 = 1 ");

//			
			if (name != null && !"".equals(name)) {
				sql.append(" and name LIKE ? ");
			}
			if (phone != null && !"".equals(phone)) {
				sql.append(" and phone LIKE ? ");
			}
			
			sql.append(" ORDER BY ID ");
			System.out.println("User Query SQL : " + sql.toString());
			conn = this.getConnection();
			ps = conn.prepareStatement(sql.toString());

			if (name != null && !"".equals(name)) {
				ps.setString(1, "%" + name + "%");

				if (phone != null && !"".equals(phone)) {
					ps.setString(2,  "%" + phone + "%");
				}

			} else {
				if (phone != null && !"".equals(phone)) {
					ps.setString(1, "%" + phone + "%");
				}
			}

			System.out.println("User Query SQL ps : " + ps);
			ResultSet rs = ps.executeQuery();
			User user = null;
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt("ID"));
				user.setAge(rs.getInt("AGE"));
				user.setName(rs.getString("NAME"));
				user.setCountry(rs.getString("COUNTRY"));
				user.setPhone(rs.getString("PHONE"));
				user.setUserId(rs.getString("USERID"));
				list.add(user);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {

				}
			}
		}

		return list;

	}

	public Integer addUser(AddUserInput AddUser) {
		
		int count = 0;
		Connection conn = null;
		PreparedStatement ps = null;

		String name = AddUser.getName();
		String phone = AddUser.getPhone();
		String age = Integer.toString(AddUser.getAge());  
		String userId = AddUser.getUserId();
		String password = AddUser.getPassword();
		String country = AddUser.getCountry();
		
		try {
			StringBuffer sql = new StringBuffer();
			sql.append(" INSERT INTO   ");
			sql.append(" USERS (NAME,USERID,PASSWORD,AGE,PHONE,COUNTRY) ");
			sql.append(" VALUES   ( ? , ? , ? , ? , ? , ? ); ");

			conn = this.getConnection();
			ps = conn.prepareStatement(sql.toString());
			
			ps.setString(1, name);
			ps.setString(2, userId);
			ps.setString(3, password);
			ps.setString(4, age);
			ps.setString(5, phone);
			ps.setString(6, country);
			
			count = ps.executeUpdate();

			System.out.print(">>>>> addUser count>>>>>" + count);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {

				}
			}
		}
		return count;
	}

}
