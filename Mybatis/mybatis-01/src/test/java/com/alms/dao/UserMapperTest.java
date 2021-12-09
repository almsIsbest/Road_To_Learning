package com.alms.dao;

import com.alms.pojo.User;
import com.alms.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UserDaoTest
 * @Description TODO
 * @Author UserDaoTest
 * @Data 2021/12/7 17:56
 **/
public class UserMapperTest {
    @Test
    public void test() {
        //获得sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userList = mapper.getUserById(1);

        System.out.println(userList);


        //关闭SqlSession
        sqlSession.close();
    }

    //增删改需要提交事物
    @Test
    public void addUser() {
        //获得sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(5, "张三丰", "123123");
        int res = mapper.addUser(user);
        if (res > 0) {
            System.out.println("插入成功");
        }
        //提交事务
        sqlSession.commit();
        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void addUser2() {
        //获得sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("userid", 6);
        map.put("name", "hhhhh");
        map.put("password", 1231251);
        int res = mapper.addUser2(map);
        if (res > 0) {
            System.out.println("插入成功");
        }
        //提交事务
        sqlSession.commit();
        //关闭SqlSession
        sqlSession.close();
    }

    //增删改需要提交事物
    @Test
    public void updateUser() {
        //获得sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(5, "张大姐", "1324141");
        int res = mapper.updateUser(user);
        if (res > 0) {
            System.out.println("更新成功");
        }
        //提交事务
        sqlSession.commit();
        //关闭SqlSession
        sqlSession.close();
    }


    //增删改需要提交事物
    @Test
    public void deleteUser() {
        //获得sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.deleteUser(5);
        if (res > 0) {
            System.out.println("删除成功");
        }
        //提交事务
        sqlSession.commit();
        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void getUserLike() {
        //获得sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserLike("%李%");
        for (User user :
                userList) {
            System.out.println(user);
        }


        //关闭SqlSession
        sqlSession.close();
    }
}
