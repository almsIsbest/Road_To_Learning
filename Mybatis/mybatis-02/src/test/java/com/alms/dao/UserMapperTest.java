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
        List<User> userList = mapper.getUserList();

        for (User user:userList
             ) {
            System.out.println(user);
        }

        //关闭SqlSession
        sqlSession.close();
    }

}
