package kr.or.ddit.board.vo;

import java.util.Date;

public class PostsVo {
	
	private int		po_id;
	private int		po_id2;
	private int		nt_id;
	private String	po_subject;
	private String	po_contents;
	private int		po_reply;
	private String	userid;
	private Date  	po_date;
	private String 	lp_subject; 
	private int 	rnum;
	private String 	po_delete;
	
	public PostsVo() {
		super();
	}
	
	public PostsVo(int po_id, int po_id2, int nt_id, String po_subject,
			String po_contents, int po_reply, String userid, Date po_date, 
			String 	lp_subject, int rnum, String po_delete) {
		super();
		this.po_id = po_id;
		this.po_id2 = po_id2;
		this.nt_id = nt_id;
		this.po_subject = po_subject;
		this.po_contents = po_contents;
		this.po_reply = po_reply;
		this.userid = userid;
		this.po_date = po_date;
		this.lp_subject = lp_subject;
		this.rnum = rnum;
		this.po_delete = po_delete;
	}

	
	
	public String getPo_delete() {
		return po_delete;
	}

	public void setPo_delete(String po_delete) {
		this.po_delete = po_delete;
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	public int getPo_id() {
		return po_id;
	}

	public void setPo_id(int po_id) {
		this.po_id = po_id;
	}

	public int getPo_id2() {
		return po_id2;
	}

	public void setPo_id2(int po_id2) {
		this.po_id2 = po_id2;
	}

	public int getNt_id() {
		return nt_id;
	}

	public void setNt_id(int nt_id) {
		this.nt_id = nt_id;
	}

	public String getPo_subject() {
		return po_subject;
	}

	public void setPo_subject(String po_subject) {
		this.po_subject = po_subject;
	}

	public String getPo_contents() {
		return po_contents;
	}

	public void setPo_contents(String po_contents) {
		this.po_contents = po_contents;
	}

	public int getPo_reply() {
		return po_reply;
	}

	public void setPo_reply(int po_reply) {
		this.po_reply = po_reply;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Date getPo_date() {
		return po_date;
	}

	public void setPo_date(Date po_date) {
		this.po_date = po_date;
	}

	public String getLp_subject() {
		return lp_subject;
	}

	public void setLp_subject(String lp_subject) {
		this.lp_subject = lp_subject;
	}
	
	
	
}
