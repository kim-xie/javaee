SpringMVC+Spring+Mybatis����

1����������jar��

2������Spring�����ļ�beans.xml������srcĿ¼�£�
      �����ļ�����Tx��Aop��Bean��Context
      
3����������Դ
   <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">

        <!-- ָ���������ݿ������-->  
        <property name="driverClass" value="com.mysql.jdbc.Driver"/>  
        <!-- ָ���������ݿ��URL-->  
        <property name="jdbcUrl" value="jdbc:mysql://localhost:3306/userinfo"/>  
        <!-- ָ���������ݿ���û���-->  
        <property name="user" value="root"/>  
        <!-- ָ���������ݿ������-->  
        <property name="password" value="mysql"/>  
          
   </bean>
   
4������SqlSessionFactory
   <bean id="sqlSessionFactoryBean" class="org.mybatis.spring.SqlSessionFactoryBean">
		
		<!-- ָ������Դ -->
		<property name="dataSource" ref="dataSource"/>
		<!-- ָ��mybatis�����ļ� -->
		<property name="configLocation" value="classpath:mybatis-config.xml"/>
   
   </bean>

5�������������������������ת�����ԣ�
   
   <!-- �������� -->
   <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource"></property>
   </bean>
   
   <!-- ��������ת������ -->
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
   
6������aop(�����е�)
   <!-- ����aop -->
   <aop:config>
		<!-- �е� -->
		<aop:pointcut expression="execution(* com.king.service..*.*(..))" id="pointcut"/>
		<aop:advisor advice-ref="txAdvice" pointcut-ref="pointcut"/>
   </aop:config>

7������ӳ��ӿڣ�ɨ����
   <!-- ӳ��ӿ� -->
   <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
		<property name="basePackage" value="com.king.mapper"/>
   </bean>
   <context:component-scan base-package="com"/>

8������web.xml (DispatcherServlet)
   <!-- springmvc ���Ŀ����� -->
	  <servlet>
		  <servlet-name>springmvc</servlet-name>
		  <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
	  </servlet>
	  <servlet-mapping>
		  <servlet-name>springmvc</servlet-name>
		  <url-pattern>*.do</url-pattern>
	  </servlet-mapping>

9�����ñ��������
   <!-- ��������� -->
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
  
10������springmvc-servlet.xml �������WEB-INFĿ¼�£�
        �����ļ�����mvc��context��bean
    
    <!-- ����ע��ɨ���� -->
	<context:component-scan base-package="com.king"></context:component-scan>
	
	<!-- ������ͼ������ -->
	<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
	 	<property name="prefix" value="/"></property>
		<property name="suffix" value=".jsp"></property>
	</bean>
	
	<!--����beans.xml-->
	<import resource="classpath:beans.xml"/>
	    
