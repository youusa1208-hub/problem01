package beans;

import java.io.Serializable;

public class PmBean implements Serializable {

//	フィールドの定義
	private int pmid;
	private String pmname;
	private String pmpass;
	
	public int getPmid() {
		return pmid;
	}
	public void setPmid(int pmid) {
		this.pmid = pmid;
	}
	public String getPmname() {
		return pmname;
	}
	public void setPmname(String pmname) {
		this.pmname = pmname;
	}
	public String getPmpass() {
		return pmpass;
	}
	public void setPmpass(String pmpass) {
		this.pmpass = pmpass;
	}
	
}
