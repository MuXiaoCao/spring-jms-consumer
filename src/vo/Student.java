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
	private String xh;
	@Override
	public String toString() {
		return "Student id=" + id + ", xh=" + xh + ", psd=" + psd + ", date_time=" + date_time + ", IP=" + IP;
	}
	private String psd;
	
	private String date_time;
	private String IP;
	
	
	public String getDate_time() {
		return date_time;
	}
	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getXh() {
		return xh;
	}
	public void setXh(String xh) {
		this.xh = xh;
	}
	public String getPsd() {
		return psd;
	}
	public void setPsd(String psd) {
		this.psd = psd;
	}
	
	
	
}
