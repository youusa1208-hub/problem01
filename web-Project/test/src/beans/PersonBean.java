package beans;

import java.io.Serializable;

public class PersonBean implements Serializable {

//	フィールドの定義(カプセル化の場合、privateを付与)
	private String name;
	private String addr;
	private String tel;
	private String bld;
	private String job;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getBld() {
		return bld;
	}
	public void setBld(String bld) {
		this.bld = bld;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
//		getter/setter以外のメソッドの定義も可能
	public void checkDate(){
//		電話番号の「-」を消す
		tel = tel.replace("-", "");
//		不明以外の血液型の最後に型を付与
		if(!bld.equals("不明")){
			bld+="型";
		}
//		職業「バイト」→「パート」に変更
		if(!bld.equals("バイト")){
			job="パート";
		}
	}
}
