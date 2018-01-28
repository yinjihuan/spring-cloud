# spring-cloud 文章对应源码

- Spring Cloud Eureka 初探：http://cxytiandi.com/blog/detail/11988
- Spring Cloud Eureka 增加权限认证：http://cxytiandi.com/blog/detail/12171
- Spring Cloud Eureka 集群高可用：http://cxytiandi.com/blog/detail/12188
- Spring Cloud Eureka 控制台快速查看Swagger API文档：http://cxytiandi.com/blog/detail/12578
- Spring Cloud Eureka REST 接口：http://cxytiandi.com/blog/detail/12610
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
- Spring Cloud Sleuth 链路追踪：http://cxytiandi.com/blog/detail/12804
- Spring Cloud Sleuth Zipkin 展示追踪数据：http://cxytiandi.com/blog/detail/12828
- Spring Cloud Sleuth Zipkin 升级使用：http://cxytiandi.com/blog/detail/12855
- Spring Boot Admin管理监控数据：http://cxytiandi.com/blog/detail/12880
- Hystrix 配置信息：http://cxytiandi.com/blog/detail/13127
- Spring Cloud中使用Hystrix 线程隔离导致ThreadLocal数据丢失：http://cxytiandi.com/blog/detail/13331
- Spring Boot Admin监控服务上下线邮件通知：http://cxytiandi.com/blog/detail/13376


# 项目代码工程目录讲解
- fangjia-api-client：Feign客户端，所有调用的API定义在里面，相当于API的SDK
- fangjia-auth-service：服务之间内部调用认证的服务，服务调用时需要来这边进行认证，获取访问Token
- fangjia-boot-admin：Spring Boot Admin来管理服务的监控数据
- fangjia-common：公共的包，放一些通用的工具类
- fangjia-eureka：Eureka注册中心

# 作者
- 尹吉欢 1304489315@qq.com
- 博客 http://cxytiandi.com/blogs/yinjihuan
