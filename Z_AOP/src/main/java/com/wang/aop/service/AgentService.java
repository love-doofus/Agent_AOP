package com.wang.aop.service;

import com.wang.aop.entity.Agent;

/**
 * @author wxe
 * @since 1.0.0
 */
public interface AgentService {
	/**
	 * 保存代理商
	 * 
	 * @param agent
	 * @return
	 */
	Agent saveAgent(Agent agent);

	/**
	 * 删除代理商
	 * 
	 * @param id
	 */
	void deleteAgent(String id);

	/**
	 * 修改代理商
	 * 
	 * @param agent
	 * @return
	 */
	Agent modifyAgent(Agent agent);

	/**
	 * 查询代理商
	 * 
	 * @param id
	 * @return
	 */
	Agent queryAgentById(String id);
	/**
	 * 升级代理商
	 * @param agent
	 * @return
	 */
	boolean upgradeGradeAgent(Agent agent);
	/**
	 * 降级代理商
	 * @param agent
	 * @return
	 */
	boolean downGradeAgent(Agent agent);
	/**
	 * 解绑代理商
	 * @param agent
	 * @param subId
	 * @return
	 */
	Boolean unBindSubAgent(Agent agent, String subId);
	/**
	 * 绑定下级代理商
	 * @param agentNo
	 * @param subAgentIds
	 * @param loginName
	 * @return
	 */
	boolean bindSubAgents(String agentNo, String subAgentIds, String loginName);
	/**
	 * 充值密码
	 * @param id
	 * @param loginName
	 * @return
	 */
	boolean resetPassword(Agent agent);

}
