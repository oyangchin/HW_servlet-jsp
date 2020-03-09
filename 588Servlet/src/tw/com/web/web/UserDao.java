package tw.com.web.web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import tw.com.bean.User;
import tw.com.input.AddUserInput;
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

	
	public Integer addUser(AddUserInput AddUser) {
//		System.out.print(">>>>> addUser >>>>>" + AddUser.getUserId());
		int count = 0;
		Connection conn = null;
		PreparedStatement ps = null;

		

		try {
			StringBuffer sql = new StringBuffer();
			sql.append(" INSERT INTO   ");
			sql.append(" USER (NAME,USERID,PASSWORD,AGE,PHONE,COUNTRY) ");
			sql.append(" VALUES  ");
			sql.append("  ('" + AddUser.getName() + "','" + AddUser.getUserId() + "','" + AddUser.getPassword() + "',"
					+ AddUser.getAge() + ",'" + AddUser.getPhone() + ";,'"
					+ "','" + AddUser.getCountry() + "'); ");

			conn = this.getConnection();
			ps = conn.prepareStatement(sql.toString());
			System.out.println(">>>> user addUser >>>>" + ps);
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