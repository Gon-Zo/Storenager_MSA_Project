package vo;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @file Management.java
 * @brief Management class
 * @author park
 * @version 1.0
 */
public class Management {

	private int no, num, storeNo;
	private String type, state;
	private Date updateDay;
	private Timestamp regdate;

	private String[] types = { "C", "H", "K", "F", "A", "B" };

	public Management() {
		// TODO Auto-generated constructor stub
	}

	public Management(int storeNo) {
		// TODO Auto-generated constructor stub
		this.storeNo = storeNo;
	}
	public Management(String type) {
		// TODO Auto-generated constructor stub
		this.type = type;
	}
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String[] getTypes() {
		return types;
	}

	public void setTypes(String[] types) {
		this.types = types;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getStoreNo() {
		return storeNo;
	}

	public void setStoreNo(int storeNo) {
		this.storeNo = storeNo;
	}

	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setType2(String type) {
		switch (type) {
		case "카스":
			this.type = "C";
			break;
		case "하이트":
			this.type = "H";
			break;
		case "클라우드":
			this.type = "K";
			break;
		case "처음처럼":
			this.type = "F";
			break;
		case "참이슬후레쉬":
			this.type = "A";
			break;
		case "참이스클레식":
			this.type = "B";
			break;
		default:
			this.type = null;
			break;
		}
	}

	public Date getUpdateDay() {
		return updateDay;
	}

	public void setUpdateDay(Date updateDay) {
		this.updateDay = updateDay;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

}
