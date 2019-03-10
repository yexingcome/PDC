package io.renren.modules.dds.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.common.utils.R;
import io.renren.modules.dds.entity.DdsRouteConfigEntity;
import io.renren.modules.dds.service.DdsRouteConfigService;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 路由配置
 * 
 * @author yexing
 * @email 745235790@qq.com
 * @date 2018-12-12 17:06:30
 */
@RestController
@RequestMapping("/dds/ddsrouteconfig")
public class DdsRouteConfigController {
	@Autowired
	private DdsRouteConfigService routeConfigService;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("dds:ddsrouteconfig:list")
	public R list(@RequestParam Map<String, Object> params) {
		//查询列表数据
		Query query = new Query(params);

		List<DdsRouteConfigEntity> ddsRouteConfigList = routeConfigService.queryList(query);
		int total = routeConfigService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(ddsRouteConfigList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("dds:ddsrouteconfig:info")
	public R info(@PathVariable("id") Integer id) {
		DdsRouteConfigEntity ddsRouteConfig = routeConfigService.queryObject(id);

		return R.ok().put("ddsRouteConfig", ddsRouteConfig);
	}

	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("dds:ddsrouteconfig:save")
	public R save(@RequestBody DdsRouteConfigEntity ddsRouteConfig) {
		ddsRouteConfig.setCreateTime(new Date());
		routeConfigService.save(ddsRouteConfig);
		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("dds:ddsrouteconfig:update")
	public R update(@RequestBody DdsRouteConfigEntity ddsRouteConfig) {
		ddsRouteConfig.setUpdateTime(new Date());

		routeConfigService.update(ddsRouteConfig);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("dds:ddsrouteconfig:delete")
	public R delete(@RequestBody Integer[] ids) {
		routeConfigService.deleteBatch(ids);

		return R.ok();
	}

}
