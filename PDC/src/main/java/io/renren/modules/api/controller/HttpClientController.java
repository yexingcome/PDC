package io.renren.modules.api.controller;

import io.renren.modules.api.service.impl.HttpAPIServiceImpl;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpClientController {

	@Resource
	private HttpAPIServiceImpl httpAPIService;

	@RequestMapping("httpclient")
	public String test() throws Exception {
		String str = httpAPIService.doGet("http://www.baidu.com");
		System.out.println(str);
		return "hello";
	}
}