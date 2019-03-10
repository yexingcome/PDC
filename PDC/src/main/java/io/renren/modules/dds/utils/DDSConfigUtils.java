package io.renren.modules.dds.utils;

import io.renren.modules.sys.service.SysConfigService;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DDSConfigUtils {
	@Autowired
	SysConfigService configService;

	@Autowired
	KuCacheLock<String> cache;

	Callable<String> callable = new Callable<String>() {
		@Override
		public String call() throws Exception {
			return configService.getValueNoCache("ForBossQueryClassInterfaceUrl");
		}
	};

	public String getForBossQueryClassInterfaceUrl() {
		return cache.execute(callable);
	}

}
