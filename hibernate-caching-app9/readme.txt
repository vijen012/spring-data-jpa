Steps to enable first level cache:-

1. It's enable by default but we have to use annotation @Transactional on test method and service methods  

Steps to enable second level cache:-

1. Add maven dependency
2. Add hibernate and spring jpa proeprties in application.properties file
3. Add ehcache.xml file in classpath with required attributes
4. Mark entity classes with annotation @Cache(usage = CacheConcurrencyStrategy.READ_ONLY)