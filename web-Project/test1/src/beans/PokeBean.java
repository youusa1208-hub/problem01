package beans;

import java.io.Serializable;

public class PokeBean implements Serializable {

//	フィールドの定義(PokemonテーブルとPtypeテーブルのフィールド)
	private int pid;		//Pokemonテーブル
	private String pname;	//Pokemonテーブル
	private String pimg;	//Pokemonテーブル
	private int ptid;		//Pokemonテーブル
	private String ptname;	//Ptypeテーブル
	private String ptimg;	//Ptypeテーブル
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPimg() {
		return pimg;
	}
	public void setPimg(String pimg) {
		this.pimg = pimg;
	}
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
