package com.alms.dao;

import com.alms.pojo.User;
import com.alms.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * @ClassName UserDaoTest
 * @Description TODO
 * @Author UserDaoTest
 * @Data 2021/12/7 17:56
 **/
public class UserMapperTest {
    static Logger logger=Logger.getLogger(UserMapperTest.class);
    @Test
    public void test() {
        //获得sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);


        System.out.println(user);


        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void testLog4j(){
        logger.info("info 进入了testLog4j");
        logger.debug("info 进入了testLog4j");
        logger.error("info 进入了testLog4j");
    }

}
