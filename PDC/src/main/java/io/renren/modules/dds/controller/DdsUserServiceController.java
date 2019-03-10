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

import io.renren.modules.dds.entity.DdsUserServiceEntity;
import io.renren.modules.dds.service.DdsUserServiceService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.common.utils.R;




/**
 * 关于用户信息类接口
 * 
 * @author cxq
 * @email kugiic@qq.com
 * @date 2018-12-12 17:54:36
 */
@RestController
@RequestMapping("/dds/ddsuserservice")
public class DdsUserServiceController {
	@Autowired
	private DdsUserServiceService ddsUserServiceService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("dds:ddsuserservice:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<DdsUserServiceEntity> ddsUserServiceList = ddsUserServiceService.queryList(query);
		int total = ddsUserServiceService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(ddsUserServiceList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("dds:ddsuserservice:info")
	public R info(@PathVariable("id") String id){
		DdsUserServiceEntity ddsUserService = ddsUserServiceService.queryObject(id);
		
		return R.ok().put("ddsUserService", ddsUserService);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("dds:ddsuserservice:save")
	public R save(@RequestBody DdsUserServiceEntity ddsUserService){
		ddsUserServiceService.save(ddsUserService);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("dds:ddsuserservice:update")
	public R update(@RequestBody DdsUserServiceEntity ddsUserService){
		ddsUserServiceService.update(ddsUserService);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("dds:ddsuserservice:delete")
	public R delete(@RequestBody String[] ids){
		ddsUserServiceService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
