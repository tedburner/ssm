# SSM
Spring + SpringMVC + MyBatis + Apollo。

- 配置中心，整合了携程的 Apollo 配置中心。启动时如图配置
![](/img/1540892049967.jpg)

## 项目结构简介
- ssm-common:项目工具，存放一些项目。
- ssm-model:model层，数据库对应的实体类，以及前端传参和返回前端参数的实体类。
- ssm-persist:持久层，操作数据库，使用的 ORM 是 MyBatis。
- ssm-service:业务逻辑层，项目实现业务逻辑。
- ssm-web:控制层，项目配置信息等都在这一层。

## Thanks
- [mybatis-generator](https://gitee.com/rohou/mybatis-generator)：一个mybatis生成实体类，SQL的插件，感觉还不错，
不过该插件不支持MySQL8，需要自己去修改源码生成新的插件。
- [apollo](https://github.com/ctripcorp/apollo):Apollo（阿波罗）
是携程框架部门研发的分布式配置中心，能够集中化管理应用不同环境、
不同集群的配置，配置修改后能够实时推送到应用端，并且具备规范的权限、
流程治理等特性，适用于微服务配置管理场景。



