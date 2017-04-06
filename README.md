# Agent_AOP
做了一个合作商系统，其中有合作商的审核，升级，降级等操作，其中，如果一个一级合作商下面挂靠了一个二级代理商，这个时候一级代理商的业绩统计里面是需要有这个二级代理商业绩的存在的。但是如果后台人员误操作把这个一级代理商的下级代理商取消了，那么一级代理商的业绩就有问题。当时由于时间比较紧凑，于是自己写了一个简单的合作商日志收集系统，主要是参考消费者生产者模式。

queue队列设计

队列，主要是三个方法
获取队列大小。

```java
/**
     * 获取队列大小
     *
     * @return
     */
    public static int size() {
        return queue.size();
    }
```

向队列中添加元素。

```java
 /**
     * 添加队列
     *
     * @param field
     */
	public static void add(String entityId, Operate actionType, String content, String loginName) {
		if (StringUtils.isEmpty(entityId)) {
			return;
		}

		try {
			AgentLog message = new AgentLog(entityId, loginName, actionType, content);
			log.info("添加队列 " + entityId);
			if (!queue.offer(message)) {
				log.info("添加日志队列失败!");
			}
		} catch (Exception e) {
			log.error("queue offer error!", e);
		}
	}
    
```

从队列中获取元素。

```
//获取队列元素
    public static AgentLog get(){
        AgentLog message = null;
        try{
            message = queue.take();
        }catch(Exception e){
            log.error("queue take error!", e);
        }
        
        return message;
    }
```





消费者：

```java
/**
 * 日志处理线程
 * wxe
 */
@Slf4j
public class AgentQueueHandleThread extends Thread {

	@Autowired
	private MessageHandle messageHandle;

	public void run() {
		while (true) {
			try {
				messageHandle.execute();
			} catch (Exception e) {
				log.error("AgentQueueHandleThread 异常!!", e);
			}
		}
	}
}
```

配置

```java
<bean class="com.wang.queue.AgentQueueHandleThread" init-method="start"></bean>
```

```java
@Component
public class MessageHandle {
    
    @Autowired
    private AgentLogServiceImp logServiceImp;
    
    public void execute() {
        AgentLog message = AgentQueue.get();
        if(message == null || StringUtils.isEmpty(message.getLoginName())){
            return ;
        }
        
        AgentLog entity = new AgentLog(message.getEntityId(),message.getLoginName(),message.getActionType(),message.getContent());
        logServiceImp.save(entity); 
    }   
    
}
```

然后在对合作商进行审核，升级，降级，解绑的时候相当于一个生产者，只需要调用queue.add(***)。向这个队列中添加合作商日志对象。

优点：

* 简单，易实现。学习成本低。

缺点：

* 代码入侵到我的核心业务逻辑中，对核心业务逻辑有影响。
* 重复代码多，不利于复用。