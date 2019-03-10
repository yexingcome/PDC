package io.renren.modules.dds.api;

import io.renren.modules.dds.apiservice.DdsGoodsAipService;
import io.renren.modules.dds.utils.BR;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 关于商品类接口api
 * 
 * @author cxq
 * @email kugiic@qq.com
 * @date 2018-12-12 17:54:36
 */
@RestController
@RequestMapping("/ddsapi")
public class DdsGoodsApiController {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DdsGoodsAipService ddsGoodsAipService;

	/**
	 * 商品维护接口(modifyGoods)
	 */
	@PostMapping("/modifyGoods")
	public BR modifyGoods(@RequestBody String value) {
		try {
			ddsGoodsAipService.modifyGoods(value);
			return BR.ok();
		} catch (Exception e) {
			logger.error("商品维护接口: ", e);
			return BR.error();
		}
	}

	/**
	 * 商品删除接口(delGoods)
	 */
	@PostMapping("/delGoods")
	public BR delGoods(@RequestBody String value) {
		try {
			ddsGoodsAipService.delGoods(value);
			return BR.ok();
		} catch (Exception e) {
			logger.error("商品删除接口: ", e);
			return BR.error();
		}
	}

}
