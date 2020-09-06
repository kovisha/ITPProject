package package2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import package1.DBConnect;

import package2.SupplierPayment;

public class SupplierPaymentDBUtil {

	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private static ResultSet rs1 = null;
	
	public static boolean insertsupplierpayment(String supplierpayid, String stockid, String discountid, String type, float discountpercentage, double totalamount) {
		boolean isSuccess = false;
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "insert into supplierpayment values (0,'"+supplierpayid+"', '"+stockid+"', '"+totalamount+"', '"+discountid+"',null,null,null,null)";
			String sql2 = "insert into discount values (0, '"+supplierpayid+"' ,'"+discountid+"', '"+type+"', '"+discountpercentage+"')";
			
			int rs = stmt.executeUpdate(sql);
			int rs1 = stmt.executeUpdate(sql2);
			
			if(rs > 0 && rs1 > 0) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	public static boolean insertsupplierpaynow(String supplierpayid, String payingdate, int chequenumber, double payamount, String invoicenumber) {
		boolean isSuccess = false;
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			
			String sql = "update supplierpayment set paidAmout ='"+payamount+"', lastPayDate = '"+payingdate+"',chequeNo = '"+chequenumber+"', invoiceNo = '"+invoicenumber+"' where suppPayID = '"+supplierpayid+"'";	
			
			int rs = stmt.executeUpdate(sql);
			
			
			if(rs > 0 ) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	public static List<SupplierPayment> displaysupplierpayment() {
		
		ArrayList<SupplierPayment> supplierpayment = new ArrayList<>();
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "select s.suppPayID, s.stockid, s.totalAmount, s.paidAmout, s.lastPayDate, s.invoiceNo, d.type, d.discpercent from supplierpayment s, discount d where s.suppPayID = d.suppPayID";
			
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
//				int id = rs.getInt(1);
				String suppPayID = rs.getString(1);
				String stockid = rs.getString(2);
				double totalAmount = rs.getDouble(3);
				double paidAmount = rs.getDouble(4);
				String lastPayDate = rs.getString(5);	
				String invoiceNo = rs.getString(6);		
				String type = rs.getString(7);		
				float discpercent = rs.getFloat(8);	
				
				
				
				SupplierPayment sp = new SupplierPayment(suppPayID, stockid, totalAmount, paidAmount, lastPayDate, invoiceNo, type, discpercent);
				supplierpayment.add(sp);
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return supplierpayment;
	}
	
	public static boolean deleteSupplierpayment(String suppPayID, String stockid, double totalAmount, double paidAmount) {
		
		boolean isSuccess = false;
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "DELETE FROM discount WHERE suppPayID='"+suppPayID+"'";
			String sql1 = "DELETE FROM supplierpayment WHERE suppPayID='"+suppPayID+"'";
			
			
			int rs = stmt.executeUpdate(sql);
			int rs1 = stmt.executeUpdate(sql1);
			
			if(rs > 0  && rs1 > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	
}
