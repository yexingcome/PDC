package io.renren.modules.dds.utils;

import java.util.concurrent.Callable;

public class KuCacheSync<T> {

	private long out = 100;
	private long time;
	private T result = null;

	public KuCacheSync() {
	}

	public KuCacheSync(long out) {
		this.out = out;
	}

	public T execute(Callable<T> callable) {
		if (result != null && time + out > System.currentTimeMillis()) {
			return result;
		}
		synchronized (this) {
			if (result != null && time + out > System.currentTimeMillis()) {
				return result;
			}
			time = System.currentTimeMillis();
			try {
				result = callable.call();
				time = System.currentTimeMillis();
			} catch (Exception e) {
			}
			return result;
		}
	}

	
}



