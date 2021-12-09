# Mybatis学习记录

## 1.Mapper映射器注意事项

### 1.1*resource Mapper映射*

```xml
<!-- 使用相对于类路径的资源引用 -->
<mappers>
  <mapper resource="org/mybatis/builder/AuthorMapper.xml"/>
  <mapper resource="org/mybatis/builder/BlogMapper.xml"/>
  <mapper resource="org/mybatis/builder/PostMapper.xml"/>
</mappers>
```



### 1.2*class接口实现类*

```xml
<!-- 使用映射器接口实现类的完全限定类名 -->
<mappers>
  <mapper class="org.mybatis.builder.AuthorMapper"/>
  <mapper class="org.mybatis.builder.BlogMapper"/>
  <mapper class="org.mybatis.builder.PostMapper"/>
</mappers>

<!--注意点-->
1、接口名与他的Mapper配置文件必须同名
2、接口和他的Mapper配置文件必须在同一个包下
```



### 1.3*package扫描包*

```xml
<!-- 将包内的映射器接口实现全部注册为映射器 -->
<mappers>
  <package name="org.mybatis.builder"/>
</mappers>

<!--注意点-->
1、接口名与他的Mapper配置文件必须同名
2、接口和他的Mapper配置文件必须在同一个包下
```



### 2解决属性名和字段名不一致

第一种方法 起别名

```xml
select id,name,pwd AS password from mybatis.user where id=#{id}
```