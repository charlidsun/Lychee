package com.sun.lychee.domain;

import java.io.Serializable;

public class Account implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String fakeid;
	private String nickname;
	private String alias;
	private String round_head_img;
	private int service_type;
	
	public Account() {}
	
	public Account(String fakeid, String nickname, String alias, String round_head_img, int service_type) {
		this.fakeid = fakeid;
		this.nickname = nickname;
		this.alias = alias;
		this.round_head_img = round_head_img;
		this.service_type = service_type;
	}

	public String getFakeid() {
		return fakeid;
	}
	public void setFakeid(String fakeid) {
		this.fakeid = fakeid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getRound_head_img() {
		return round_head_img;
	}
	public void setRound_head_img(String round_head_img) {
		this.round_head_img = round_head_img;
	}
	public int getService_type() {
		return service_type;
	}
	public void setService_type(int service_type) {
		this.service_type = service_type;
	}
	
	@Override
	public String toString() {
		return "Account [fakeid=" + fakeid + ", nickname=" + nickname + ", alias=" + alias + ", round_head_img="
				+ round_head_img + ", service_type=" + service_type + "]";
	}
	
}
