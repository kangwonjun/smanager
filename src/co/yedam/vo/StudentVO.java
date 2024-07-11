package co.yedam.vo;

import java.util.Date;

public class StudentVO {
	private String stdNo; // std_no
	private String stdName; //std_name
	private String stdPhone; //std_phone
	private String address; //std_name
	private String birthDate; //birth_date 1999-01-01
	private Date creatiorDate;
	
	
	public String getStdNo() {
		return stdNo;
	}
	public void setStdNo(String stdNo) {
		this.stdNo = stdNo;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public String getStdPhone() {
		return stdPhone;
	}
	public void setStdPhone(String stdPhone) {
		this.stdPhone = stdPhone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public Date getCreatiorDate() {
		return creatiorDate;
	}
	public void setCreatiorDate(Date creatiorDate) {
		this.creatiorDate = creatiorDate;
	}
	@Override
	public String toString() {
		return "StudentVO [stdNo=" + stdNo + ", stdName=" + stdName + ", stdPhone=" + stdPhone + ", address=" + address
				+ ", birthDate=" + birthDate + ", creatiorDate=" + creatiorDate + "]";
	}
	
	public String briefShow() {
		return stdNo+" " + stdName  + " " + stdPhone  ;
	}
	
	
}
