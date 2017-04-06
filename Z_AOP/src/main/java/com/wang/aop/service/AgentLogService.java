package com.wang.aop.service;

import com.wang.aop.entity.AgentLog;

/**
 * @author wxe
 * @since 1.0.0
 */
public interface AgentLogService {
	/**
	 * 添加日志
	 * @param log
	 */
	public void insert(AgentLog log);

}
