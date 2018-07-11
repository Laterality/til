package kr.latera.guestbook.dto;

import java.util.Date;

public class Log {
	private Long id;
	private String ip;
	private String method;
	private Date regdate;
	
	public Long getId() { return id; }
	public String getIp() { return ip; }
	public String getMethod() { return method; }
	public Date getRegdate() { return regdate; }
	
	public void setId(Long id) { this.id = id; }
	public void setIp(String ip) { this.ip = ip; }
	public void setMethod(String method) { this.method = method; }
	public void setRegdate(Date regdate) { this.regdate = regdate; }
	
	@Override
	public String toString() {
		return "Log [id=" + id + ", ip=" + ip + ", method=" + method + ", regdate=" + regdate + "]";
	}
}
