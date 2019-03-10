package io.renren.modules.api.service.impl;

import io.renren.modules.api.entity.HttpResult;
import io.renren.modules.api.service.HttpAPIService;

import java.util.Map;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("httpAPIService")
public class HttpAPIServiceImpl implements HttpAPIService {
	@Autowired
	private CloseableHttpClient httpClient;

	@Autowired
	private RequestConfig config;

	/**
	 * 不带参数的get请求，如果状态码为200，则返回body，如果不为200，则返回null
	 * 
	 * @param url
	 * @return
	 * @throws Exception
	 */
	@Override
	public String doGet(String url) throws Exception {
		// 声明 http get 请求
		HttpGet httpGet = new HttpGet(url);

		// 装载配置信息
		httpGet.setConfig(config);

		// 发起请求
		CloseableHttpResponse response = this.httpClient.execute(httpGet);

		// 判断状态码是否为200
		if (response.getStatusLine().getStatusCode() == 200) {
			// 返回响应体的内容
			return EntityUtils.toString(response.getEntity(), "UTF-8");
		}
		return null;
	}

	/**
	 * 带参数的get请求，如果状态码为200，则返回body，如果不为200，则返回null
	 * 
	 * @param url
	 * @return
	 * @throws Exception
	 */
	@Override
	public String doGet(String url, Map<String, Object> map) throws Exception {
		URIBuilder uriBuilder = new URIBuilder(url);

		if (map != null) {
			// 遍历map,拼接请求参数
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				uriBuilder.setParameter(entry.getKey(), entry.getValue().toString());
			}
		}

		// 调用不带参数的get请求
		return this.doGet(uriBuilder.build().toString());

	}

	/**
	 * 带参数的post请求
	 * 
	 * @param url
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public HttpResult doPostJson(String url, String jsonPram) throws Exception {
		// 声明httpPost请求
		HttpPost httpPost = new HttpPost(url);
		// 加入配置信息
		httpPost.setConfig(config);

		StringEntity s = new StringEntity(jsonPram, "UTF-8");
		s.setContentEncoding("UTF-8");
		s.setContentType("application/json;charset=UTF-8");//发送json数据需要设置contentType
		httpPost.setEntity(s);

		// 发起请求
		CloseableHttpResponse response = this.httpClient.execute(httpPost);
		return new HttpResult(response.getStatusLine().getStatusCode(), EntityUtils.toString(response.getEntity(),
				"UTF-8"));
	}

	@Override
	public HttpResult doPostXml(String url, String jsonPram) throws Exception {
		// 声明httpPost请求
		HttpPost httpPost = new HttpPost(url);
		// 加入配置信息
		httpPost.setConfig(config);

		// 判断map是否为空，不为空则进行遍历，封装from表单对象
		//		if (map != null) {
		//			List list = new ArrayList();
		//			for (Map.Entry<String, Object> entry : map.entrySet()) {
		//				list.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
		//			}
		//			// 构造from表单对象
		//			UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(list, "UTF-8");
		//
		//			// 把表单放到post里
		//			httpPost.setEntity(urlEncodedFormEntity);
		//		}
		StringEntity s = new StringEntity(jsonPram, "UTF-8");
		s.setContentEncoding("UTF-8");
		s.setContentType("text/xml; charset=UTF-8");//发送json数据需要设置contentType
		httpPost.setEntity(s);

		// 发起请求
		CloseableHttpResponse response = this.httpClient.execute(httpPost);
		return new HttpResult(response.getStatusLine().getStatusCode(), EntityUtils.toString(response.getEntity(),
				"UTF-8"));
	}

	/**
	 * 不带参数post请求
	 * 
	 * @param url
	 * @return
	 * @throws Exception
	 */
	@Override
	public HttpResult doPost(String url) throws Exception {
		return this.doPostJson(url, null);
	}
}
