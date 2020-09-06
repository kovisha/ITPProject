package Installment;

public class installmentType {

	private int id;
	private String typeId;
	private String tDesc;
	private int months;
	
	public installmentType(int id, String typeId, String tDesc, int months) {
		super();
		this.id = id;
		this.typeId = typeId;
		this.tDesc = tDesc;
		this.months = months;
	}

	public int getId() {
		return id;
	}

	public String getTypeId() {
		return typeId;
	}

	public String gettDesc() {
		return tDesc;
	}

	public int getMonths() {
		return months;
	}

}
