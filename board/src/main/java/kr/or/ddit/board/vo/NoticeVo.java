package kr.or.ddit.board.vo;

import java.util.Date;

public class NoticeVo {
	private int 	nt_id;  
	private String 	userid; 
	private String 	nt_name;
	private String	nt_ues; 
	private Date 	nt_date;
	
	public NoticeVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NoticeVo(int nt_id, String userid, String nt_name, String nt_ues,
			Date nt_date) {
		super();
		this.nt_id = nt_id;
		this.userid = userid;
		this.nt_name = nt_name;
		this.nt_ues = nt_ues;
		this.nt_date = nt_date;
	}

	public int getNt_id() {
		return nt_id;
	}

	public void setNt_id(int nt_id) {
		this.nt_id = nt_id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getNt_name() {
		return nt_name;
	}

	public void setNt_name(String nt_name) {
		this.nt_name = nt_name;
	}

	public String getNt_ues() {
		return nt_ues;
	}

	public void setNt_ues(String nt_ues) {
		this.nt_ues = nt_ues;
	}

	public Date getNt_date() {
		return nt_date;
	}

	public void setNt_date(Date nt_date) {
		this.nt_date = nt_date;
	}
	
	
	
}
