package beans;

import java.io.Serializable;

public class PtypeBean implements Serializable {

//	フィールドの定義
	private int ptid;
	private String ptname;
	private String ptimg;
	
//	getter/setterの定義
	public int getPtid() {
		return ptid;
	}
	public void setPtid(int ptid) {
		this.ptid = ptid;
	}
	public String getPtname() {
		return ptname;
	}
	public void setPtname(String ptname) {
		this.ptname = ptname;
	}
	public String getPtimg() {
		return ptimg;
	}
	public void setPtimg(String ptimg) {
		this.ptimg = ptimg;
	}
}
