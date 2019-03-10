package io.renren.modules.dds.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.common.utils.R;
import io.renren.modules.dds.entity.DdsPublicRecordEntity;
import io.renren.modules.dds.service.DdsPublicRecordService;

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
 * 发布记录
 * 
 * @author yexing
 * @email 745235790@qq.com
 * @date 2018-12-12 17:06:30
 */
@RestController
@RequestMapping("/dds/ddspublicrecord")
public class DdsPublicRecordController {
	@Autowired
	private DdsPublicRecordService publicRecordService;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("dds:ddspublicrecord:list")
	public R list(@RequestParam Map<String, Object> params) {
		//查询列表数据
		Query query = new Query(params);

		List<DdsPublicRecordEntity> ddsPublicRecordList = publicRecordService.queryList(query);
		int total = publicRecordService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(ddsPublicRecordList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("dds:ddspublicrecord:info")
	public R info(@PathVariable("id") String id) {
		DdsPublicRecordEntity ddsPublicRecord = publicRecordService.queryObject(id);

		return R.ok().put("ddsPublicRecord", ddsPublicRecord);
	}

	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("dds:ddspublicrecord:save")
	public R save(@RequestBody DdsPublicRecordEntity ddsPublicRecord) {
		publicRecordService.save(ddsPublicRecord);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("dds:ddspublicrecord:update")
	public R update(@RequestBody DdsPublicRecordEntity ddsPublicRecord) {
		publicRecordService.update(ddsPublicRecord);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("dds:ddspublicrecord:delete")
	public R delete(@RequestBody String[] ids) {
		publicRecordService.deleteBatch(ids);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/republish")
	@RequiresPermissions("dds:ddspublicrecord:republish")
	public R republish(@RequestBody String[] ids) {
		publicRecordService.republish(ids);

		return R.ok();
	}

}
