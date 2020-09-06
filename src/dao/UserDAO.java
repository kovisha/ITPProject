package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import util.DBManager;

import model.User;
import model.CardNumGenerator;

public class UserDAO {
	
	
	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	private static Statement st = null;
	
	
	//-------------------method to validate the presence of the logged user----------------------------------------------
			public  boolean validate(String username , String password)
			{
				boolean status = false;

				try {

					//1. making the connection
					con=DBManager.getConnection(); 

					//2. create a statement using connection object
					ps = con.prepareStatement("select UName , pw  from customer where UName = ? and pw = ? ") ;


					ps.setString(1, username);
					ps.setString(2 , password);


					System.out.println(ps);

					//3.execute the query
					rs = ps.executeQuery();
					status = rs.next();

				}
				catch(Exception e)
				{
					e.printStackTrace();
				}

				return status;
			}
			
			
			
			
		//--------------------------if user exists retrieving the details of user-----------------------------------------
			 public User UserLogin(String username, String password) {
				 
					String sqlQuery = "select * from customer where Username=? and Password=?";
					
					User loggedUser = new User();
					
					try {
						
						//1. making the connection
						  con=DBManager.getConnection(); 
						 
						  //2.create a statement using connection object
						 ps = con.prepareStatement(sqlQuery) ;
						 
						 ps.setString(1, username);
						 ps.setString(2, password);
						 
						 
						 //3.execute the query
						  rs = ps.executeQuery();
						 
						 while(rs.next()) {
								loggedUser.setiD(rs.getInt(1));
								loggedUser.setUserID(rs.getString(2));
								loggedUser.setuName(rs.getString(3));
								loggedUser.setPw(rs.getString(4));
								loggedUser.setAddress(rs.getString(5));
								loggedUser.setEmail(rs.getString(6));
								loggedUser.setDob(rs.getString(7));
								loggedUser.setAnniversary(rs.getString(8));
								loggedUser.setOccupation(rs.getString(9));
								loggedUser.setLoyaltyCardNo(rs.getString(11));
								loggedUser.setLoyaltyExpiry(rs.getString(12));
								loggedUser.setLoyaltyPoints(rs.getInt(13));
								loggedUser.setPhone(rs.getString(14));
								loggedUser.setfName(rs.getString(15));
								loggedUser.setlName(rs.getString(16));
								
								
					}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						
					}
					return loggedUser;		
			 
					}
			 
			 
			 
			 
			 //----------------------------method for retrieving user details-------------------------------
			    public static List<User> getUsers(String uID){
				
			    		//using an array list to get doctors
						ArrayList<User> cust = new ArrayList<>();
						
						try { 
						    con = DBManager.getConnection();//establishing connection
						    st = con.createStatement();
						    String sql = "select * from customer where UName='"+uID+"'";	    
						    rs = st.executeQuery(sql); //execute query
						    
						    while(rs.next()) {
						    	int iD = rs.getInt(1);
						    	String userID = rs.getString(2);
						    	String uName = rs.getString(3);
						    	String pw = rs.getString(4);
						    	String address = rs.getString(5);
						    	String email = rs.getString(6);
						    	String dob = rs.getString(7);
						    	String anniversary = rs.getString(8);
						    	String occupation = rs.getString(9);
						    	String loyaltyCardNo = rs.getString(11);
						    	String loyaltyExpiry = rs.getString(12);
						    	int loyaltyPoints = rs.getInt(13);
						    	String phone = rs.getString(14);
						    	String fName = rs.getString(15);
						    	String lName = rs.getString(16);
							
							
							//creating a new instance of doctor class
							User user = new User(iD,userID,uName,pw,address,email,dob,anniversary,occupation,loyaltyCardNo,loyaltyExpiry,loyaltyPoints,phone,fName,lName);
							cust.add(user);
						    }
						    
						}
						catch(Exception e) {
						    e.printStackTrace();
						}
						
						return cust;
				
			    }
			    
			    
			    
		//------------------------------Register A User-------------------------------------------------------------------
			    public static boolean registerUser(String fname,String lname, String UName, String email, String address, String phone, String dob, String doa , String occupation , String pw) {
					boolean isSuccess =false;
					
					LocalDate ld = java.time.LocalDate.now();
					LocalDate yearLater = ld.plusYears ( 1 );
					
					
					CardNumGenerator cd = new CardNumGenerator();
					String cardNum = cd.generator();
					
					CardNumGenerator id = new CardNumGenerator();
					String userNum = id.idGenerator();
					
					//String userID = "CUS006";
					
					try {
						
						con = DBManager.getConnection();//establishing connection
						st =con.createStatement();
						
						//inserting appointment details
						String sql="insert into customer values(0,'"+userNum+"','"+UName+"','"+pw+"','"+address+"','"+email+"','"+dob+"', '"+doa+"','"+occupation+"','"+null+"','"+cardNum+"','"+yearLater+"',0,'"+phone+"','"+fname+"','"+lname+"')";
						int rs = st.executeUpdate(sql);//execute query
						
						if(rs > 0)//if inserted successfully returns true 
						{
							isSuccess = true;
						}else //if failed returns false
						{
							isSuccess = false;
						}
						
					}
					catch(Exception e) {
						e.printStackTrace();
					}
					
					
					return  isSuccess;
					
				}
			    
			    
			  //--------------------------------------update---------------------------------------------------------------------------------
			    public  boolean updateUser(String uname ,String fname ,  String lname ,  String email , String address,  String dob, String anniversary,  String occupation,  String phone)
				{
					 boolean status = false;
					 
					 try {
			     		
						 //1. making the connection
						 
			       	   con=DBManager.getConnection();
			       	  
			       	   //2. creating a statement using connection object
			           st = con.createStatement();
			          
			          String sql = "update customer set fname = '"+fname+"' , lname = '"+lname+"', email = '"+email+"', address = '"+address+"', dob = '"+dob+"', anniversary = '"+anniversary+"', occupation = '"+occupation+"', Phone = '"+phone+"' where UName = '"+uname+"'";
			          
			          
			          //3. execute query or update
			          int rs = st.executeUpdate(sql);
			          
			          if(rs > 0)
			          {
			        	  status = true;
			          }
			          
			          else
			          {
			        	  status = false;
			          }
					 }catch(Exception e)
					 {
						 e.printStackTrace();
					 }
					 
					 return status;
					 
				}
			

}
