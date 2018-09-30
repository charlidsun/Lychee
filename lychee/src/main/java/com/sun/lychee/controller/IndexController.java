package com.sun.lychee.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.lychee.domain.Account;
import com.sun.lychee.domain.BaseResp;
import com.sun.lychee.util.ConstUtil;
import com.sun.lychee.util.NetUtil;

@Controller
@RequestMapping("/")
public class IndexController {

	@Value("${wx_token}")
	private String token;

	@Value("${wx_cookie}")
	private String cookie;
	
	
	@GetMapping
	public String index() {
		return "index";
	}
	
	
	@PostMapping("/searchAccount")
	public String searchAccount(String keyword, String start, String length, Model model) {
		System.out.println(keyword);
		System.out.println(start);
		System.out.println(length);
		//组合链接
		String searchUrl = ConstUtil.getChatSearchUrl(token, keyword, start, length);
		//使用get方式请求数据
		String chatStr = NetUtil.GetChat(searchUrl,cookie);
				
		//解析参数
		//1.base_resp
		JSONObject object = JSON.parseObject(chatStr);
		
		BaseResp baseResp = JSON.parseObject(object.getString("base_resp"), BaseResp.class);
		List<Account> list = new ArrayList<>();
		
		model.addAttribute("keyword", keyword);
		
		if (baseResp.getErr_msg().equals("ok")) {
			//开始传参数
			list = JSON.parseArray(object.getString("list"), Account.class);
			model.addAttribute("list", list);
			model.addAttribute("err_msg", "ok");
			model.addAttribute("total",object.getString("total"));
		}else {
			model.addAttribute("err_msg", "err");
			model.addAttribute("list", list);
		}
		return "accList";
	}
}
