package tw.com.web.web;

import java.sql.Connection;
import java.sql.PreparedStatement;

import tw.com.bean.Currency;
import tw.com.web.dao.BaseDao;

public class ExcelDao extends BaseDao {

	public void insertData(Currency data){
		System.out.println(">>>>> InsertData >>>>>>>> " );
		
		
		try {
			
		int count = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		
		StringBuffer sql = new StringBuffer();
		sql.append(" INSERT INTO TAIWANBANK (CURRENCY, TYPE, MONEY, SPOT, FORWARD10, FORWARD30, FORWARD60, FORWARD90, FORWARD120, FORWARD150, FORWARD180) ");
		sql.append(" VALUES ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?) ");
		String currency = data.getCurrency();
		String type = data.getType();
		double money = data.getMoney();
		double spot = data.getSpot();

		double forward10 = data.getForward10();
		double forward30 = data.getForward30();
		double forward60 = data.getForward60();
		double forward90 = data.getForward90();
		double forward120 = data.getForward120();
		double forward150 = data.getForward150();
		double forward180 = data.getForward180();
	
		conn = this.getConnection();
		ps = conn.prepareStatement(sql.toString());
		ps.setString(1, currency);
		ps.setString(2, type);
		ps.setDouble(3, money);
		ps.setDouble(4, spot);
		
		ps.setDouble(5, forward10);
		ps.setDouble(6, forward30);
		ps.setDouble(7, forward60);
		ps.setDouble(8, forward90);
		ps.setDouble(9, forward120);
		ps.setDouble(10, forward150);
		ps.setDouble(11, forward180);
		
		count = ps.executeUpdate();
		System.out.print(">>>>> Insert into Excel count>>>>>" + count);
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(">>>>> Insert into Excel ERROR >>>>>" + e.toString());
		}
		
	}
}
