package io.renren.modules.dds.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.dds.entity.DdsGoodsServiceEntity;
import io.renren.modules.dds.service.DdsGoodsServiceService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.common.utils.R;




/**
 * 关于商品类接口
 * 
 * @author cxq
 * @email kugiic@qq.com
 * @date 2018-12-12 17:54:36
 */
@RestController
@RequestMapping("/dds/ddsgoodsservice")
public class DdsGoodsServiceController {
	@Autowired
	private DdsGoodsServiceService ddsGoodsServiceService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("dds:ddsgoodsservice:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<DdsGoodsServiceEntity> ddsGoodsServiceList = ddsGoodsServiceService.queryList(query);
		int total = ddsGoodsServiceService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(ddsGoodsServiceList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("dds:ddsgoodsservice:info")
	public R info(@PathVariable("id") String id){
		DdsGoodsServiceEntity ddsGoodsService = ddsGoodsServiceService.queryObject(id);
		
		return R.ok().put("ddsGoodsService", ddsGoodsService);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("dds:ddsgoodsservice:save")
	public R save(@RequestBody DdsGoodsServiceEntity ddsGoodsService){
		ddsGoodsServiceService.save(ddsGoodsService);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("dds:ddsgoodsservice:update")
	public R update(@RequestBody DdsGoodsServiceEntity ddsGoodsService){
		ddsGoodsServiceService.update(ddsGoodsService);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("dds:ddsgoodsservice:delete")
	public R delete(@RequestBody String[] ids){
		ddsGoodsServiceService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
