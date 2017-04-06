package com.wang.aop.model;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wang.aop.entity.Agent;
import com.wang.aop.entity.AgentLog;
import com.wang.aop.entity.AgentLog.Operate;
import com.wang.aop.service.AgentLogService;

/**
 * @author wxe
 * @since 1.0.0
 */

@Aspect
@Component
public class LogAspect {
	
	public LogAspect(){
		System.out.println("aop constructor ...");
	}

	@Autowired
	private AgentLogService agentLogService;
	
	@Pointcut("@annotation(com.wang.aop.annotation.AopLog)")
	private void pointCutMethod() {
		System.out.println("我是一个切入点");
	}


	// 声明后置通知
	@AfterReturning(pointcut = "pointCutMethod()", returning="rtv", argNames="rtv")
	public void doAfterReturning(JoinPoint joinPoint, Object rtv) {
		String methodName = joinPoint.getSignature().getName();
		AgentLog agentLog = new AgentLog();
		Agent agent = (Agent) rtv;
		
		if(methodName.equals("saveAgent")) {
			agentLog.setActionType(Operate.SAVE.getText());
			agentLog.setEntityId(agent.getId());
		}else if(methodName.equals("editAgent")) {
			agentLog.setActionType(Operate.AUDIT.getText());
			agentLog.setEntityId(agent.getId());
		}else if(methodName.equals("deleteAgent")) {
			Object[] args = joinPoint.getArgs();
			String agentId = (String) args[0];//方法传入参数为Id时候
			
			agentLog.setActionType(Operate.DELETE.getText());
			agentLog.setEntityId(agentId);
		}else {
			System.out.println(agent.getId());
		}
		
		agentLog.setCreateTime(new Date());
		agentLog.setOperator(agent.getCreater());//操作者，可以写一个工具类获取

		agentLogService.insert(agentLog);
		System.out.println("aop end ...");
	}



}
