package package2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import package1.DBConnect;
import package1.SupplierIDGenerator;
import package2.SupplierPayment;

public class SupplierPaymentDBUtil {

	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private static ResultSet rs1 = null;
	
	/*Inserting A New Supplier Payment Method*/
	public static boolean insertsupplierpayment(String stockid,  String type, float discountpercentage, double totalamount) {
		
		boolean isSuccess = false;
		
		SupplierIDGenerator spid = new SupplierIDGenerator();
		String supplierpayid = spid.supplierpaymentIDgenerator();
		
		SupplierIDGenerator sdid = new SupplierIDGenerator();
		String discountid = sdid.supplierdiscountIDgenerator();
		
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
	
	/*Confirming The Supplier Paying Method*/
	public static boolean insertsupplierpaynow(String supplierpayid, String payingdate, int chequenumber, double payamount, String invoicenumber) {
		boolean isSuccess = false;
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			double updatedAmount;
			
			  String sql1 = "select paidAmout from supplierpayment where suppPayID = '"+supplierpayid+"'"; 
			  
			  rs = stmt.executeQuery(sql1);
				
			  while(rs.next()) {
			  
				  double paidAmount = rs.getDouble("paidAmout");
			  
				  updatedAmount =  paidAmount + payamount;
			    
				  	String sql = "update supplierpayment set paidAmout ='"+updatedAmount+"', lastPayDate = '"+payingdate+"',chequeNo = '"+chequenumber+"', invoiceNo = '"+invoicenumber+"' where suppPayID = '"+supplierpayid+"'";	
			
				  int rs = stmt.executeUpdate(sql);
			
				  if(rs > 0 ) {
					  isSuccess = true;
				  }else {
					  isSuccess = false;
				  }
			  }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	/*Display Supplier Payments*/
	public static List<SupplierPayment> displaysupplierpayment() {
		
		ArrayList<SupplierPayment> supplierpayment = new ArrayList<>();
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "select s.suppPayID, s.stockid, s.totalAmount, s.paidAmout, s.lastPayDate, s.invoiceNo, d.type, d.discpercent from supplierpayment s, discount d where s.suppPayID = d.suppPayID";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
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
	
	/*Display Supplier Payments*/
	public static List<SupplierPayment> displaysupplierpayment1() {
		
		ArrayList<SupplierPayment> supplierpayment = new ArrayList<>();
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "select sp.suppPayID, s.suppliername, st.stockname, st.stocksize , st.supplieddate, sp.invoiceNo, sp.lastPayDate, st.stockid, d.type, d.discpercent, sp.totalAmount, sp.chequeNo, sp.paidAmout from uds_ex.stock st, uds_ex.discount d, uds_ex.supplierpayment sp, uds_ex.supplier s where sp.suppPayID = d.suppPayID and st.stockid = sp.stockid and s.supplierID = st.supplierdid"; 
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				String suppPayID = rs.getString(1);
				String suppliername = rs.getString(2);
				String stockname = rs.getString(3);
				float stocksize = rs.getFloat(4);
				String supplieddate = rs.getString(5);
				String invoiceNo = rs.getString(6);		
				String lastPayDate = rs.getString(7);	
				String stockid = rs.getString(8);
				String type = rs.getString(9);	
				float discpercent = rs.getFloat(10);	
				double totalAmount = rs.getDouble(11);
				int chequeNo = rs.getInt(12);
				double paidAmount = rs.getDouble(13);
			
				SupplierPayment sp = new SupplierPayment(suppPayID, suppliername, stockname, stocksize,supplieddate, invoiceNo, lastPayDate, stockid,type, discpercent,totalAmount, chequeNo, paidAmount);
				supplierpayment.add(sp);
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return supplierpayment;
	}
	
	/*Delete Supplier Payments*/
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
