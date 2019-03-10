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

import io.renren.modules.dds.entity.DdsAuthServiceEntity;
import io.renren.modules.dds.service.DdsAuthServiceService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.common.utils.R;




/**
 * 关于授权类接口
 * 
 * @author cxq
 * @email kugiic@qq.com
 * @date 2018-12-12 17:54:36
 */
@RestController
@RequestMapping("/dds/ddsauthservice")
public class DdsAuthServiceController {
	@Autowired
	private DdsAuthServiceService ddsAuthServiceService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("dds:ddsauthservice:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<DdsAuthServiceEntity> ddsAuthServiceList = ddsAuthServiceService.queryList(query);
		int total = ddsAuthServiceService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(ddsAuthServiceList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("dds:ddsauthservice:info")
	public R info(@PathVariable("id") String id){
		DdsAuthServiceEntity ddsAuthService = ddsAuthServiceService.queryObject(id);
		
		return R.ok().put("ddsAuthService", ddsAuthService);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("dds:ddsauthservice:save")
	public R save(@RequestBody DdsAuthServiceEntity ddsAuthService){
		ddsAuthServiceService.save(ddsAuthService);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("dds:ddsauthservice:update")
	public R update(@RequestBody DdsAuthServiceEntity ddsAuthService){
		ddsAuthServiceService.update(ddsAuthService);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("dds:ddsauthservice:delete")
	public R delete(@RequestBody String[] ids){
		ddsAuthServiceService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
