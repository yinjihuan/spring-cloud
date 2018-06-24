package com.fangjia.fsh.api;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.HystrixThreadPoolProperties;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import com.netflix.hystrix.strategy.properties.HystrixProperty;
import com.netflix.hystrix.util.PlatformSpecific;

public class ThreadLocalHystrixConcurrencyStrategy extends HystrixConcurrencyStrategy {
	private final static Logger logger = LoggerFactory.getLogger(ThreadLocalHystrixConcurrencyStrategy.class);

	@Override
	public ThreadPoolExecutor getThreadPool(HystrixThreadPoolKey threadPoolKey, HystrixProperty<Integer> corePoolSize,
			HystrixProperty<Integer> maximumPoolSize, HystrixProperty<Integer> keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue) {
		return this.doGetThreadPool(threadPoolKey, corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	}

	@Override
	public ThreadPoolExecutor getThreadPool(HystrixThreadPoolKey threadPoolKey,
			HystrixThreadPoolProperties threadPoolProperties) {
		return this.doGetThreadPool(threadPoolKey, threadPoolProperties);
	}

	private ThreadPoolExecutor doGetThreadPool(final HystrixThreadPoolKey threadPoolKey,
			HystrixProperty<Integer> corePoolSize, HystrixProperty<Integer> maximumPoolSize,
			HystrixProperty<Integer> keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
		final ThreadFactory threadFactory = getThreadFactory(threadPoolKey);

		final int dynamicCoreSize = corePoolSize.get();
		final int dynamicMaximumSize = maximumPoolSize.get();

		if (dynamicCoreSize > dynamicMaximumSize) {
			logger.error("Hystrix ThreadPool configuration at startup for : " + threadPoolKey.name()
					+ " is trying to set coreSize = " + dynamicCoreSize + " and maximumSize = " + dynamicMaximumSize
					+ ".  Maximum size will be set to " + dynamicCoreSize
					+ ", the coreSize value, since it must be equal to or greater than the coreSize value");
			return new ThreadLocalThreadPoolExecutor(dynamicCoreSize, dynamicCoreSize, keepAliveTime.get(), unit, workQueue,
					threadFactory);
		} else {
			return new ThreadLocalThreadPoolExecutor(dynamicCoreSize, dynamicMaximumSize, keepAliveTime.get(), unit, workQueue,
					threadFactory);
		}
	}

	private ThreadPoolExecutor doGetThreadPool(final HystrixThreadPoolKey threadPoolKey,
			HystrixThreadPoolProperties threadPoolProperties) {
		final ThreadFactory threadFactory = getThreadFactory(threadPoolKey);

		final boolean allowMaximumSizeToDivergeFromCoreSize = threadPoolProperties
				.getAllowMaximumSizeToDivergeFromCoreSize().get();
		final int dynamicCoreSize = threadPoolProperties.coreSize().get();
		final int keepAliveTime = threadPoolProperties.keepAliveTimeMinutes().get();
		final int maxQueueSize = threadPoolProperties.maxQueueSize().get();
		final BlockingQueue<Runnable> workQueue = getBlockingQueue(maxQueueSize);

		if (allowMaximumSizeToDivergeFromCoreSize) {
			final int dynamicMaximumSize = threadPoolProperties.maximumSize().get();
			if (dynamicCoreSize > dynamicMaximumSize) {
				logger.error("Hystrix ThreadPool configuration at startup for : " + threadPoolKey.name()
						+ " is trying to set coreSize = " + dynamicCoreSize + " and maximumSize = " + dynamicMaximumSize
						+ ".  Maximum size will be set to " + dynamicCoreSize
						+ ", the coreSize value, since it must be equal to or greater than the coreSize value");
				return new ThreadLocalThreadPoolExecutor(dynamicCoreSize, dynamicCoreSize, keepAliveTime, TimeUnit.MINUTES,
						workQueue, threadFactory);
			} else {
				return new ThreadLocalThreadPoolExecutor(dynamicCoreSize, dynamicMaximumSize, keepAliveTime, TimeUnit.MINUTES,
						workQueue, threadFactory);
			}
		} else {
			return new ThreadLocalThreadPoolExecutor(dynamicCoreSize, dynamicCoreSize, keepAliveTime, TimeUnit.MINUTES, workQueue,
					threadFactory);
		}
	}

	private static ThreadFactory getThreadFactory(final HystrixThreadPoolKey threadPoolKey) {
		if (!PlatformSpecific.isAppEngineStandardEnvironment()) {
			return new ThreadFactory() {
				private final AtomicInteger threadNumber = new AtomicInteger(0);

				@Override
				public Thread newThread(Runnable r) {
					Thread thread = new Thread(r,
							"hystrix-" + threadPoolKey.name() + "-" + threadNumber.incrementAndGet());
					thread.setDaemon(true);
					return thread;
				}

			};
		} else {
			return PlatformSpecific.getAppEngineThreadFactory();
		}
	}
}
