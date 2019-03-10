package io.renren.modules.dds.utils;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") 
public class KuCacheLock<T> {
	private Lock lock = new ReentrantLock();
	private long out = 5000;
	private long time;
	private T result = null;

	public KuCacheLock() {
	}

	public KuCacheLock(long out) {
		this.out = out;
	}

	public T execute(Callable<T> callable) {
		if (result != null && time + out > System.currentTimeMillis()) {
			return result;
		}
		if (!lock.tryLock()) {
			if (result != null) {
				return result;
			}
			for (int i = 0; i < 500; i++) {
				if (result != null) {
					return result;
				}
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
				}
			}
		}
		time = System.currentTimeMillis();
		try {
			result = callable.call();
			time = System.currentTimeMillis();
		} catch (Exception e) {
		} finally {
			lock.unlock();
		}
		return result;
	}
}
