package kr.or.ddit.board.vo;

public class FileVo {
	private int fl_id;
	private int po_id;
	private String fl_file;
	
	public FileVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FileVo(int fl_id, int po_id, String fl_file) {
		super();
		this.fl_id = fl_id;
		this.po_id = po_id;
		this.fl_file = fl_file;
	}

	public int getFl_id() {
		return fl_id;
	}

	public void setFl_id(int fl_id) {
		this.fl_id = fl_id;
	}

	public int getPo_id() {
		return po_id;
	}

	public void setPo_id(int po_id) {
		this.po_id = po_id;
	}

	public String getFl_file() {
		return fl_file;
	}

	public void setFl_file(String fl_file) {
		this.fl_file = fl_file;
	}
	
	
}
