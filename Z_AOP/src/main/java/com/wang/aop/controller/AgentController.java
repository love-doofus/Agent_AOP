package com.wang.aop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wang.aop.entity.Agent;
import com.wang.aop.service.AgentService;

/**
 * @author wxe
 * @since 1.0.0
 */
@Controller
@RequestMapping("/agentMng")
public class AgentController {
	@Autowired
	private AgentService agentService;

	
	@ResponseBody
	@RequestMapping(value = "/saveAgent",method = RequestMethod.GET)
	public String saveAgent() {
		Agent agent = new Agent();
		agent.setAgentNo("123");
		agent.setName("西安小贷");
		agent.setSex("1");
		agent.setCreater("张三");
		agentService.saveAgent(agent);
		return "AOP";
	}

}
