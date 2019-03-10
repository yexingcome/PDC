package io.renren.modules.dds.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.common.utils.R;
import io.renren.modules.dds.entity.DdsAreaEntity;
import io.renren.modules.dds.service.DdsAreaService;

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
 * 区域
 * 
 * @author yexing
 * @email 745235790@qq.com
 * @date 2019-01-03 10:08:55
 */
@RestController
@RequestMapping("/dds/ddsarea")
public class DdsAreaController {
	@Autowired
	private DdsAreaService ddsAreaService;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("dds:ddsarea:list")
	public R list(@RequestParam Map<String, Object> params) {
		//查询列表数据
		Query query = new Query(params);

		List<DdsAreaEntity> ddsAreaList = ddsAreaService.queryList(query);
		int total = ddsAreaService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(ddsAreaList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("dds:ddsarea:info")
	public R info(@PathVariable("id") String id) {
		DdsAreaEntity ddsArea = ddsAreaService.queryObject(id);

		return R.ok().put("ddsArea", ddsArea);
	}

	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("dds:ddsarea:save")
	public R save(@RequestBody DdsAreaEntity ddsArea) {
		ddsAreaService.save(ddsArea);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("dds:ddsarea:update")
	public R update(@RequestBody DdsAreaEntity ddsArea) {
		ddsAreaService.update(ddsArea);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("dds:ddsarea:delete")
	public R delete(@RequestBody String[] ids) {
		ddsAreaService.deleteBatch(ids);

		return R.ok();
	}

}
