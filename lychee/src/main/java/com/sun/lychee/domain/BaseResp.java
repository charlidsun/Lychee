package com.sun.lychee.domain;

import java.io.Serializable;

public class BaseResp implements Serializable {

	private static final long serialVersionUID = 1L;

	private int ret;
	private String err_msg;
	
	public BaseResp() {}
	
	public BaseResp(int ret, String err_msg) {
		this.ret = ret;
		this.err_msg = err_msg;
	}

	public int getRet() {
		return ret;
	}

	public void setRet(int ret) {
		this.ret = ret;
	}

	public String getErr_msg() {
		return err_msg;
	}

	public void setErr_msg(String err_msg) {
		this.err_msg = err_msg;
	}

	@Override
	public String toString() {
		return "BaseResp [ret=" + ret + ", err_msg=" + err_msg + "]";
	}

}
