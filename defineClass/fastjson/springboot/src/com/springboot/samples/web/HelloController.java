package com.springboot.samples.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.alibaba.fastjson.JSONObject;

@RestController   
public class HelloController {

	@RequestMapping(value = "/json/check")
	@ResponseBody
	public User jsonCheck(HttpServletRequest request) throws Exception {

		String a = request.getParameter("json");

		JSONObject jo = (JSONObject) JSONObject.parseObject(a);
		
		User user = new User();
		user.setAge(18);
		user.setName("<script>alert(1);</script>");
		
		return user;

	}
	
}
