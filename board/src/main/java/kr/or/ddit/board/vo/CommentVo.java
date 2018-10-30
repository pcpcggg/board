package kr.or.ddit.board.vo;

import java.util.Date;

public class CommentVo {
	private int co_id;
	private int po_id;
	private String userid;
	private String co_contents;
	private Date co_date;
	private String co_delete;
	
	
	
	public CommentVo() {
		super();
	
	}



	public CommentVo(int co_id, int po_id, String userid, String co_contents,
			Date co_date, String co_delete) {
		super();
		this.co_id = co_id;
		this.po_id = po_id;
		this.userid = userid;
		this.co_contents = co_contents;
		this.co_date = co_date;
		this.co_delete = co_delete;
	}
	


	public String getCo_delete() {
		return co_delete;
	}



	public void setCo_delete(String co_delete) {
		this.co_delete = co_delete;
	}



	public int getCo_id() {
		return co_id;
	}



	public void setCo_id(int co_id) {
		this.co_id = co_id;
	}



	public int getPo_id() {
		return po_id;
	}



	public void setPo_id(int po_id) {
		this.po_id = po_id;
	}



	public String getUserid() {
		return userid;
	}



	public void setUserid(String userid) {
		this.userid = userid;
	}



	public String getCo_contents() {
		return co_contents;
	}



	public void setCo_contents(String co_contents) {
		this.co_contents = co_contents;
	}



	public Date getCo_date() {
		return co_date;
	}



	public void setCo_date(Date co_date) {
		this.co_date = co_date;
	}
	
	
	
	
	
}
