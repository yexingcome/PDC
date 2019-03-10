package io.renren.modules.job.task;

import io.renren.modules.dds.dao.DdsPublicRecordDao;
import io.renren.modules.dds.entity.DdsPublicRecordEntity;
import io.renren.modules.dds.service.PublicFactoryService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 测试定时任务(演示Demo，可删除)
 * 
 * testTask为spring bean的名称
 * 
 * @author yexing
 * @email 745235790@qq.com
 * @date 2016年11月30日 下午1:34:24
 */
@Component("republicRecordTask")
public class RepublicRecordTask {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private PublicFactoryService publicFactoryService;

	@Autowired
	private DdsPublicRecordDao publicRecordDao;

	//获取数据库中未发布的工单，要按照生成时间顺序排列
	public void republicRecordTask() {
		logger.info("开启定时任务读取数据库中未发布工单，丢入重新发布流程中！");

		List<DdsPublicRecordEntity> list = publicRecordDao.getWaitPublish();
		if (list != null && list.size() > 0) {
			for (DdsPublicRecordEntity ddsPublicRecordEntity : list) {
				publicFactoryService.repulishRecord(ddsPublicRecordEntity.getId());
			}
		}

	}
}
