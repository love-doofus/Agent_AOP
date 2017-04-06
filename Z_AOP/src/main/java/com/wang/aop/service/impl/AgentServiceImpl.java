package com.wang.aop.service.impl;

import org.springframework.stereotype.Service;

import com.wang.aop.annotation.AopLog;
import com.wang.aop.common.JsonUtils;
import com.wang.aop.entity.Agent;
import com.wang.aop.service.AgentService;

/**
 * @author wxe
 * @since 1.0.0
 */
@Service
public class AgentServiceImpl implements AgentService {

	@AopLog(name="保存合作商")
	@Override
	public Agent saveAgent(Agent agent) {
		System.out.println("agent:"+JsonUtils.toJson(agent));
		return agent;
	}

	@Override
	public void deleteAgent(String id) {
		// TODO Auto-generated method stub
	}

	@Override
	public Agent modifyAgent(Agent agent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Agent queryAgentById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean upgradeGradeAgent(Agent agent) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean downGradeAgent(Agent agent) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Boolean unBindSubAgent(Agent agent, String subId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean bindSubAgents(String agentNo, String subAgentIds,
			String loginName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean resetPassword(Agent agent) {
		// TODO Auto-generated method stub
		return false;
	}


}
