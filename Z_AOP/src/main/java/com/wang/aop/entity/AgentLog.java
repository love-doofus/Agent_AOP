package com.wang.aop.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wxe
 * @since 1.0.0
 */
@SuppressWarnings("serial")
public class AgentLog implements Serializable {

	private String operator;// 操作人

	private String entityId;// 操作对象

	private String actionType;// 操作类型

	private String content;// 操作的内容

	private Date createTime = new Date();// 创建时间


	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public AgentLog(String operator, String entityId, String actionType,
			String content, Date createTime) {
		super();
		this.operator = operator;
		this.entityId = entityId;
		this.actionType = actionType;
		this.content = content;
		this.createTime = createTime;
	}

	public AgentLog() {

	}

	/**
	 * 动作：审核，升级，降级，充值密码，修改，保存
	 * 
	 * @author wxe
	 * @since 1.0.0
	 */
	public enum Operate {
		SAVE("修改"), 
		DELETE("删除"),
		UPGRADE("升级"),
		DOWNGRADE("降级"),
		AUDIT("审核");

		private String text;

		private Operate(String text) {
			this.text = text;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

	}

}
