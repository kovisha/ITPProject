package package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import package1.Supplier;

import package1.Supplier;

import package1.SupplierIDGenerator;

import package1.DBConnect;

public class SupplierDBUtil {


	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private static ResultSet rs1 = null;
	
	/*Supplier Insert Method*/
	public static boolean insertsupplier(String name, String status, String address, String email, String phone1, String phone2, String description) {
		boolean isSuccess = false;
		
		SupplierIDGenerator sid = new SupplierIDGenerator();
		String supplierid = sid.supplierIDgenerator();
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "insert into supplier values (0,'"+supplierid+"', '"+name+"', '"+status+"', '"+address+"', '"+email+"', '"+description+"')";
			String sql2 = "insert into supplierphone values (0,'"+supplierid+"', '"+phone1+"', '"+phone2+"')";
			
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
		
	/* Display All Suppliers-Method*/
	public static List<Supplier> displaysupplier1() {
		
		ArrayList<Supplier> supplier = new ArrayList<>();
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "select s.supplierID, s.suppliername, s.status, s.address, s.email, sp.phone1, sp.phone2, s.description from udssuper.supplier s, udssuper.supplierphone sp where s.supplierID=sp.supplierID";			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				String supplierID = rs.getString(1);
				String name = rs.getString(2);
				String status = rs.getString(3);
				String address = rs.getString(4);
				String email = rs.getString(5);
				String phone1 = rs.getString(6);
				String phone2 = rs.getString(7);
				String description = rs.getString(8);
				
				Supplier s = new Supplier(supplierID, name , status , address, email, phone1, phone2, description);
				supplier.add(s);
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return supplier;
	}
	
	/* Display Stocks For The Suppliers-Method*/
	public static List<Supplier> displaysupplierstock(String ID) {
		
		ArrayList<Supplier> supplier = new ArrayList<>();
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "select sp.suppliername, st.stockname, st.stocksize from supplier sp, stock st where sp.supplierID = st.supplierdid and sp.supplierID = '"+ID+"'";
				
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
			
				
				String name = rs.getString(1);
				String stockname = rs.getString(2);
				float stocksize = rs.getFloat(3);
				
				
				Supplier s = new Supplier(name,stockname,stocksize);
				supplier.add(s);
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return supplier;
	}
	
	public static List<Supplier> displaysupplier2() {
	  
	  ArrayList<Supplier> supplier = new ArrayList<>();
	  
	  try {
	  
		  con = DBConnect.getConnection(); 
		  stmt = con.createStatement();
		  
		  String sql = "select s.supplierID, s.suppliername, st.stockname, st.stocksize,s.status, s.address, s.email, sp.phone1, sp.phone2, s.description from supplier s, supplierphone sp, stock st  where s.supplierID=sp.supplierID and s.supplierID = st.supplierdid";
		  
	  
		  rs = stmt.executeQuery(sql);
	  
	  while(rs.next()) {
	  
	  
		  String supplierID = rs.getString(1); 
		  String name = rs.getString(2); 
		  String stockname = rs.getString(3); 
		  float stocksize = rs.getFloat(4);
		  String status = rs.getString(5);
		  String address= rs.getString(6); 
		  String email = rs.getString(7); 
		  String phone1 =rs.getString(8); 
		  String phone2 = rs.getString(9); 
		  String description =rs.getString(10);
	  
	  
		  Supplier s = new Supplier(supplierID, name, stockname, stocksize,status, address, email, phone1, phone2, description);
		  supplier.add(s);
	  
	  }
	  
	  } catch(Exception e) { 
		  e.printStackTrace(); 
		  
	  } 
	  return supplier; 
	  }
	 
		public static List<Supplier> displaysupplier3() {
			
			ArrayList<Supplier> supplier = new ArrayList<>();
			
			try {
				
				con = DBConnect.getConnection();
				stmt = con.createStatement();
				
				String sql = "select s.supplierID, s.suppliername, st.stockname, st.stocksize, s.status, s.address, s.email, sp.phone1, sp.phone2, s.description from supplier s  LEFT JOIN stock st ON s.supplierID = st.supplierdid INNER JOIN supplierphone sp ON s.supplierID=sp.supplierID";
			
				
				rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					
				
					String supplierID = rs.getString(1);
					String name = rs.getString(2);
					String stockname = rs.getString(3);
					float stocksize = rs.getFloat(4);
					String status = rs.getString(5);
					String address = rs.getString(6);
					String email = rs.getString(7);
					String phone1 = rs.getString(8);
					String phone2 = rs.getString(9);
					String description = rs.getString(10);
					
					
					Supplier s = new Supplier(supplierID, name, stockname, stocksize,status, address, email, phone1, phone2, description);
					supplier.add(s);
					
				}
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return supplier;
		}
		
	/* Update Supplier Method*/
	public static boolean updateSupplier(String supplierID , String name , String status , String address , String email, String phone1, String phone2, String description) {
		
		boolean isSuccess = false;
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "update supplier set suppliername='"+name+"' , status='"+status+"' ,address='"+address+"' ,email='"+email+"' ,description='"+description+"'"
						+"where supplierID='"+supplierID+"'";
			String sql2 = "update supplierphone set phone1='"+phone1+"', phone2='"+phone2+"'"
						+"where supplierID='"+supplierID+"'";
			
			int rs = stmt.executeUpdate(sql);
			int rs1 = stmt.executeUpdate(sql2);
			
			if(rs > 0 && rs1> 0 ) {
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
	
	/* Delete Supplier Method*/
	public static boolean deleteSupplier(String supplierID) {

		boolean isSuccess = false;
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "DELETE FROM supplierphone WHERE supplierID='"+supplierID+"'";
			String sql1 = "DELETE FROM supplier WHERE supplierID='"+supplierID+"'";
			
			
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
	
	/* Display All Deleted Suppliers-Method*/
	public static List<Supplier> displayDeletedsupplier1() {
		
		ArrayList<Supplier> supplier = new ArrayList<>();
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "select s.supplierID, s.suppliername, s.status, s.address, s.email, sp.phone1, sp.phone2, s.description from supplierlog s, supplierphonelog sp where s.supplierID=sp.supplierID";

			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
			
				String supplierID = rs.getString(1);
				String name = rs.getString(2);
				String status = rs.getString(3);
				String address = rs.getString(4);
				String email = rs.getString(5);
				String phone1 = rs.getString(6);
				String phone2 = rs.getString(7);
				String description = rs.getString(8);
				
				
				Supplier s = new Supplier(supplierID, name , status , address, email, phone1, phone2, description);
				supplier.add(s);
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return supplier;
	}
	
	/* Re-Insert All The Deleted Suppliers-Method*/
	public static boolean ReinsertSupplier(String supplierID) {

		boolean isSuccess = false;
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql1 = "DELETE FROM supplierlog WHERE supplierID='"+supplierID+"'";
			String sql = "DELETE FROM supplierphonelog WHERE supplierID='"+supplierID+"'";
			
			
			
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
