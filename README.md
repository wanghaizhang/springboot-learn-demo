# springboot-learn-demo
springboot学习

1.集成swagger2 用于生成接口文档

    1.常用注解： 
    - @Api()用于类； 
    - @ApiOperation()用于方法； 
    - @ApiParam()用于方法，参数，字段说明； 表示对参数的添加元数据（说明或是否必填等） 
    - @ApiModel()用于类 表示对类进行说明，用于参数用实体类接收 
    - @ApiModelProperty()用于方法，字段 表示对model属性的说明或者数据操作更改 
    - @ApiIgnore()用于类，方法，方法参数 表示这个方法或者类被忽略 
    - @ApiImplicitParam() 用于方法 表示单独的请求参数 
    - @ApiImplicitParams() 用于方法，包含多个 @ApiImplicitParam
  
    2.参考：
    https://blog.csdn.net/u014231523/article/details/54411026
    
    3.访问路径
    http://localhost:8080/swagger-ui.html  原生ui
    http://localhost:8080/doc.html bootstrap-ui

2. 添加定时任务

    参考 schedule 中的README.md