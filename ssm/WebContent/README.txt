SpringMVC+Spring+Mybatis整合

1、拷贝所需jar包

2、创建Spring配置文件beans.xml放置在src目录下：
      配置文件包括Tx、Aop、Bean、Context
      
3、配置数据源
   <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">

        <!-- 指定连接数据库的驱动-->  
        <property name="driverClass" value="com.mysql.jdbc.Driver"/>  
        <!-- 指定连接数据库的URL-->  
        <property name="jdbcUrl" value="jdbc:mysql://localhost:3306/userinfo"/>  
        <!-- 指定连接数据库的用户名-->  
        <property name="user" value="root"/>  
        <!-- 指定连接数据库的密码-->  
        <property name="password" value="mysql"/>  
          
   </bean>
   
4、配置SqlSessionFactory
   <bean id="sqlSessionFactoryBean" class="org.mybatis.spring.SqlSessionFactoryBean">
		
		<!-- 指定数据源 -->
		<property name="dataSource" ref="dataSource"/>
		<!-- 指定mybatis配置文件 -->
		<property name="configLocation" value="classpath:mybatis-config.xml"/>
   
   </bean>

5、配置事务（事务管理器、事务转播特性）
   
   <!-- 配置事务 -->
   <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource"></property>
   </bean>
   
   <!-- 配置事务转播特性 -->
   <tx:advice id="txAdvice" transaction-manager="transactionManager">
		<tx:attributes>
			<tx:method name="find*" read-only="true"/>
			<tx:method name="get*" read-only="true"/>
			<tx:method name="query*" read-only="true"/>
			<tx:method name="add*" propagation="REQUIRED"/>
			<tx:method name="update*" propagation="REQUIRED"/>
			<tx:method name="del*" propagation="REQUIRED"/>
		</tx:attributes>
    </tx:advice>
   
6、配置aop(配置切点)
   <!-- 配置aop -->
   <aop:config>
		<!-- 切点 -->
		<aop:pointcut expression="execution(* com.king.service..*.*(..))" id="pointcut"/>
		<aop:advisor advice-ref="txAdvice" pointcut-ref="pointcut"/>
   </aop:config>

7、配置映射接口，扫描器
   <!-- 映射接口 -->
   <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
		<property name="basePackage" value="com.king.mapper"/>
   </bean>
   <context:component-scan base-package="com"/>

8、配置web.xml (DispatcherServlet)
   <!-- springmvc 核心控制器 -->
	  <servlet>
		  <servlet-name>springmvc</servlet-name>
		  <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
	  </servlet>
	  <servlet-mapping>
		  <servlet-name>springmvc</servlet-name>
		  <url-pattern>*.do</url-pattern>
	  </servlet-mapping>

9、配置编码过滤器
   <!-- 编码过滤器 -->
  <filter>
	  <filter-name>characterEncodingFilter</filter-name>
	  <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
	  <init-param>
		  <param-name>encoding</param-name>
		  <param-value>UTF-8</param-value>
  	  </init-param>
  </filter>
  <filter-mapping>
	  <filter-name>characterEncodingFilter</filter-name>
	  <url-pattern>/*</url-pattern>
  </filter-mapping>
  
10、配置springmvc-servlet.xml 需放置在WEB-INF目录下：
        配置文件包括mvc、context、bean
    
    <!-- 配置注解扫描器 -->
	<context:component-scan base-package="com.king"></context:component-scan>
	
	<!-- 配置视图解析器 -->
	<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
	 	<property name="prefix" value="/"></property>
		<property name="suffix" value=".jsp"></property>
	</bean>
	
	<!--导入beans.xml-->
	<import resource="classpath:beans.xml"/>
	    
