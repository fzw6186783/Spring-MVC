package com.pojo;

import java.util.List;

public class PageBean<T> {
	private int cp;
	private int pc;//

	private int md;//

	private List<T> pd;

	private int dt;

	private int cd;//

	private String url;

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public int getPc() {
		return pc;
	}

	public void setPc(int pc) {
		this.pc = pc;
	}

	public int getMd() {
		return md;
	}

	public void setMd(int md) {
		this.md = md;
	}

	public List<T> getPd() {
		return pd;
	}

	public void setPd(List<T> pd) {
		this.pd = pd;
	}

	public int getDt() {
		return dt;
	}

	public void setDt(int dt) {
		this.dt = dt;
	}

	public int getCd() {
		return cd;
	}

	public void setCd(int cd) {
		this.cd = cd;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
