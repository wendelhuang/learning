https://tech.meituan.com/2018/01/19/mybatis-cache.html  

mybatis一级缓存不能被关闭，只能设置为STATEMENT  

application.yml配置了cache-enabled，只是配置了二级缓存生效，要想具体namespace生效，还需要加上@CacheNamespace