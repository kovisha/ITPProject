package Delivery;

public class Suggestions {

	String id;
	String cusID;
	String suggest;
	String complaints;
	
	
		
	public Suggestions(String id, String cusID, String suggest, String complaints) {
		super();
		this.id = id;
		this.cusID = cusID;
		this.suggest = suggest;
		this.complaints = complaints;
	}
	
	
	public String getId() {
		return id;
	}
	public String getCusID() {
		return cusID;
	}

	public String getSuggest() {
		return suggest;
	}


	public void setSuggest(String suggest) {
		this.suggest = suggest;
	}


	public String getComplaints() {
		return complaints;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setCusID(String cusID) {
		this.cusID = cusID;
	}

	public void setComplaints(String complaints) {
		this.complaints = complaints;
	}
	
	
	
}
