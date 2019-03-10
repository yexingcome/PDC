package io.renren.modules.dds.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.common.utils.R;
import io.renren.modules.dds.entity.DdsPlatConfigEntity;
import io.renren.modules.dds.service.DdsPlatConfigService;

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
 * 平台配置
 * 
 * @author yexing
 * @email 745235790@qq.com
 * @date 2018-12-12 12:00:28
 */
@RestController
@RequestMapping("/dds/ddsplatconfig")
public class DdsPlatConfigController {
	@Autowired
	private DdsPlatConfigService platConfigService;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("dds:ddsplatconfig:list")
	public R list(@RequestParam Map<String, Object> params) {
		//查询列表数据
		Query query = new Query(params);

		List<DdsPlatConfigEntity> ddsPlatConfigList = platConfigService.queryList(query);
		int total = platConfigService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(ddsPlatConfigList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}

	@RequestMapping("/listAll")
	public R listAll() {
		//查询列表数据
		List<DdsPlatConfigEntity> ddsPlatConfigList = platConfigService.queryListAll();

		return R.ok().put("allPlat", ddsPlatConfigList);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("dds:ddsplatconfig:info")
	public R info(@PathVariable("id") Integer id) {
		DdsPlatConfigEntity ddsPlatConfig = platConfigService.queryObject(id);

		return R.ok().put("ddsPlatConfig", ddsPlatConfig);
	}

	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("dds:ddsplatconfig:save")
	public R save(@RequestBody DdsPlatConfigEntity ddsPlatConfig) {
		ddsPlatConfig.setCreateTime(new Date());
		platConfigService.save(ddsPlatConfig);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("dds:ddsplatconfig:update")
	public R update(@RequestBody DdsPlatConfigEntity ddsPlatConfig) {
		ddsPlatConfig.setUpdateTime(new Date());
		platConfigService.update(ddsPlatConfig);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("dds:ddsplatconfig:delete")
	public R delete(@RequestBody Integer[] ids) {
		platConfigService.deleteBatch(ids);

		return R.ok();
	}

}
