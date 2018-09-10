#springboot 定时任务

## 定时增量查询思路

    通过分页查询，降低每次执行查询过多的数据，
    在resources下面添加一个 sql_last_value 来记录上次分页查的最后一条数据的时间
    每次定时查询,读取传入即可实现


## @Schedule 的使用
    
1. cron 表达式，  * * * * * * 支持到 '秒'一级别的
    不同与linux 系统的crontab 表达式，支持到'分' 一级别
2. 用法同 linux crontab 
3. springboot 启用  @EnableScheduling 即可
    
    ssm 使用 参考如下
    
    applicationContext.xml 
    
    ### schema 中配置
    
    xmlns:task="http://www.springframework.org/schema/task"
    
    http://www.springframework.org/schema/task
    http://www.springframework.org/schema/task/spring-task-4.0.xsd
    
    ### bean 中配置
    
    <task:annotation-driven />
    
    
## Lombak 使用 可以简化代码编写

   项目配置，引入对应插件版本的 maven依赖即可，scope 设置为compile即可
   
   参考  https://juejin.im/post/5acaa4ab6fb9a028bf0599d5
    