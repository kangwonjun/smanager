package go.game.vo;

import java.util.Date;

//필드
//생성자
//메소드

public class GamesellerVO {
	private String titleNO; // title_NO 타이틀넘버
	private String gamModel; // gam_model 기종 
	private String gamTitle; // gam_title 게임제목
	private String gamPrice; // gam_price 게임가격
	private String stock; // stock         제고보유상황   
	private String restokingdate; // RESTOKING_DATE 1999-01-01 재고입고날짜	
	private String creatiorDate;  // 만든 날짜
		


	public String getTitleNO() {
		return titleNO;
	}



	public void setTitleNO(String titleNO) {
		this.titleNO = titleNO;
	}



	public String getGamModel() {
		return gamModel;
	}



	public void setGamModel(String gamModel) {
		this.gamModel = gamModel;
	}



	public String getGamTitle() {
		return gamTitle;
	}



	public void setGamTitle(String gamTitle) {
		this.gamTitle = gamTitle;
	}



	public String getGamPrice() {
		return gamPrice;
	}



	public void setGamPrice(String gamPrice) {
		this.gamPrice = gamPrice;
	}



	public String getStock() {
		return stock;
	}



	public void setStock(String stock) {
		this.stock = stock;
	}



	public String getRestokingdate() {
		return restokingdate;
	}



	public void setRestokingdate(String restokingdate) {
		this.restokingdate = restokingdate;
	}




	public String getCreatiorDate() {
		return creatiorDate;
	}



	public void setCreatiorDate(String creatiorDate) {
		this.creatiorDate = creatiorDate;
	}



	@Override
	public String toString() {
		return "gamesellerVO [titleNO=" + titleNO + ", gamModel=" + gamModel + ", gamTitle=" + gamTitle + ", gamPrice=" + gamPrice
				+ ", stock=" + stock + ", restokingdate=" + restokingdate + ", creatiorDate=" + creatiorDate + "]";
	}
	
	public String briefShow() {
		return gamModel+" " + gamTitle  + " " + gamPrice  ;
	}
	
	
	
	
}
