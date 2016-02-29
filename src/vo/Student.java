package vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.web.filter.CharacterEncodingFilter;
@Entity
@Table(name="students")
public class Student implements Serializable{
	@Id  
	@Column(name="[id]")
	@SequenceGenerator(name="seqhilo",sequenceName="st_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="seqhilo")  
	private Integer id;
	private String uname;
	private String psd;
	private int sex;
	private String xh;
	private int groupid;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPsd() {
		return psd;
	}
	public void setPsd(String psd) {
		this.psd = psd;
	}
	public int isSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getXh() {
		return xh;
	}
	public void setXh(String xh) {
		this.xh = xh;
	}
	public int getGroupid() {
		return groupid;
	}
	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}
	
	
	
	
	
}
