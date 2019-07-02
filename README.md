
###### Spring-Cloud-Book-Code-1目录的代码是第一版《Spring Cloud微服务-全栈技术与案例解析》配套源码

###### Spring-Cloud-Book-Code-2目录的代码是第二版《Spring Cloud微服务 入门 实战与进阶》配套源码

###### 购买链接：

当当：http://product.m.dangdang.com/27884997.html

淘宝: https://m.tb.cn/h.egYN7Dm

京东：https://item.m.jd.com/product/49802442789.html

# spring-cloud 文章对应源码

- Spring Cloud Eureka 初探：http://cxytiandi.com/blog/detail/11988
- Spring Cloud Eureka 增加权限认证：http://cxytiandi.com/blog/detail/12171
- Spring Cloud Eureka 集群高可用：http://cxytiandi.com/blog/detail/12188
- Spring Cloud Eureka 控制台快速查看Swagger API文档：http://cxytiandi.com/blog/detail/12578
- Spring Cloud Eureka REST 接口：http://cxytiandi.com/blog/detail/12610
- Spring Cloud Eureka 服务上下线监控：http://cxytiandi.com/blog/detail/17640
- Spring Boot2中Spring Security导致Eureka注册失败 ：http://cxytiandi.com/blog/detail/19388
- Spring Cloud中如何优雅的使用Feign调用接口：http://cxytiandi.com/blog/detail/12189
- Spring Cloud Feign fallback错误解决：http://cxytiandi.com/blog/detail/12368
- Spring Cloud Feign 启动UnsatisfiedDependencyException：http://cxytiandi.com/blog/detail/12549
- Spring Cloud中如何保证各个微服务之间调用的安全性： http://cxytiandi.com/blog/detail/12267
- Spring Cloud中如何保证各个微服务之间调用的安全性(下篇)：http://cxytiandi.com/blog/detail/12300
- Spring Cloud中Feign如何统一设置验证token：http://cxytiandi.com/blog/detail/12369
- spring Cloud统一异常处理：http://cxytiandi.com/blog/detail/3106
- Spring Cloud 如何选择分布式配置中心：http://cxytiandi.com/blog/detail/12466
- Ribbon负载均衡策略介绍：http://cxytiandi.com/blog/detail/13598
- Spring Cloud Ribbon 重试机制：http://cxytiandi.com/blog/detail/12507
- Spring Cloud Zuul结合Smconf配置中心动态进行IP黑名单限制：http://cxytiandi.com/blog/detail/12508
- Spring Cloud Zuul Filter 使用小经验：http://cxytiandi.com/blog/detail/12632
- Spring Cloud Zuul过滤器获取请求参数问题:http://cxytiandi.com/blog/detail/20343
- Spring Cloud如何提供API给客户端:http://cxytiandi.com/blog/detail/14458
- Spring Cloud Sleuth 链路追踪：http://cxytiandi.com/blog/detail/12804
- Spring Cloud Sleuth Zipkin 展示追踪数据：http://cxytiandi.com/blog/detail/12828
- Spring Cloud Sleuth Zipkin 升级使用：http://cxytiandi.com/blog/detail/12855
- Spring Boot Admin管理监控数据：http://cxytiandi.com/blog/detail/12880
- Hystrix 配置信息：http://cxytiandi.com/blog/detail/13127
- Spring Cloud中使用Hystrix 线程隔离导致ThreadLocal数据丢失：http://cxytiandi.com/blog/detail/13331
- Spring Cloud中Hystrix 线程隔离导致ThreadLocal数据丢失下篇：http://cxytiandi.com/blog/detail/18782
- Spring Boot Admin监控服务上下线邮件通知：http://cxytiandi.com/blog/detail/13376
- Spring Cloud Gateway 网关尝鲜:http://cxytiandi.com/blog/detail/20430
- Spring Cloud Gateway 整合Eureka路由转发:http://cxytiandi.com/blog/detail/20518

# 项目代码工程目录讲解
- fangjia-api-client：Feign客户端，所有调用的API定义在里面，相当于API的SDK
- fangjia-auth-service：服务之间内部调用认证的服务，服务调用时需要来这边进行认证，获取访问Token
- fangjia-boot-admin：Spring Boot Admin来管理服务的监控数据
- fangjia-common：公共的包，放一些通用的工具类
- fangjia-eureka：Eureka注册中心
- fangjia-fsh-api：API网关
- fangjia-fsh-house-service：house服务
- fangjia-fsh-substitution-service：substitution服务
- fangjia-fsh-user-service：用户服务，登陆接口，swagger使用示列
- fangjia-hystrix-dashboard：hystrix-dashboard,turbine示列
- fangjia-job：分布式任务调度
- fangjia-sjdbc-read-write：数据库读写分离
- fangjia-sjdbc-sharding-db-table：数据库分库分表
- fangjia-sjdbc-sharding-table：数据库分表
- fangjia-zipkin：调用链
- hystrix：hystrix单独使用
- transaction-mq-client：可靠消息服务Feign客户端
- transaction-mq-service：可靠消息服务,提供接口
- transaction-mq-task：负责发送消息

# 注意事项
最近发现有很多同学问我项目中有一些依赖的jar包在哪里，比如redis cache, swagger等，这些都在我的Github主页中有。
查看 http://cxytiandi.com/blog/detail/20517 看看怎么启动整个项目。

# 作者
- 尹吉欢 1304489315@qq.com
- 博客 http://cxytiandi.com/blogs/yinjihuan
- 微信群请加我微信拉你进群：jihuan900
- Spring Cloud QQ技术交流群：626640827

### 欢迎加入我的知识星球，一起交流技术，免费学习猿天地的课程（http://cxytiandi.com/course）

## PS：目前星球中正在星主的带领下组队学习Sentinel，等你哦！

![微信扫码加入猿天地知识星球](https://upload-images.jianshu.io/upload_images/2685774-b11318670c1457fa.jpeg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![猿天地](https://upload-images.jianshu.io/upload_images/2685774-17a60e1ead7fd232.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
