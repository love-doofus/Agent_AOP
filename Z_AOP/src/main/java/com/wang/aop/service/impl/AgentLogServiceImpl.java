package com.wang.aop.service.impl;

import org.springframework.stereotype.Service;

import com.wang.aop.common.JsonUtils;
import com.wang.aop.entity.AgentLog;
import com.wang.aop.service.AgentLogService;

/**
 * @author wxe
 * @since 1.0.0
 */
@Service
public class AgentLogServiceImpl implements AgentLogService {

	@Override
	public void insert(AgentLog log) {
		//保存log到数据库中
		System.out.println("inserting agentLog :{}..."+JsonUtils.toJson(log));
	}

}
