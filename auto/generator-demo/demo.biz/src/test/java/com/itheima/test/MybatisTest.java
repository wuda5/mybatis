package com.itheima.test;

import com.demo.biz.entity.base.User;
import com.demo.biz.entity.base.UserExample;
import com.demo.biz.mapper.base.UserMapper;

import org.junit.Test;

import java.util.List;

/**
 * @author 程序员
 * @Company http://www.ithiema.com
 *
 * 测试mybatis的crud操作
 */
//public class MybatisTest {
public class MybatisTest extends Basex{

    UserMapper userDao;

    @Override
    public void getMapper() {
        userDao = sqlSession.getMapper(UserMapper.class);
    }
    /**
     * 测试查询所有
     */
    @Test
    public void testFindAll(){
        System.out.println("开始方法 testFindAll +++++++++++=");
        //5.执行查询所有方法
        List<User> users = userDao.selectByExample(null);
        for(User user : users){
            System.out.println(user);
        }

    }


    /**
     * 测试单个
     */
    @Test
    public void testFindOneById(){
//        User  user = userDao.findById(50);
        System.out.println("开始方法 testFindOne ++++++ 单个 +++++=");
        User user = userDao.selectByPrimaryKey(50);
        System.out.println(user);

    }

    /**
     * --- 非常重要的动态查询 -------------
     * 测试模糊查询操作
     */
    @Test
    public void testFindByExample(){

        UserExample ex = new UserExample();

        UserExample.Criteria criteria = ex.createCriteria();
        criteria.andSexEqualTo("2");
        criteria.andAddressLike("%du");

        UserExample.Criteria or = ex.or();
        or.andSexEqualTo("1");// 查询并且包含 男生的 数据；

//        ex.or(ex.createCriteria().andSexEqualTo("1"));


        List<User> users = userDao.selectByExample(ex);// 自己构建条件动态查询！！！！
        System.out.println(users);
    }

    /**
     * 测试使用QueryVo作为查询条件
     */
    @Test
    public void testFindByVo() {
//        QueryVo vo = new QueryVo();
//        User user = new User();
//        user.setUserName("%王%");
//        vo.setUser(user);
//        //5.执行查询一个方法
//        List<User> users = userDao.findUserByVo(vo);
//        for (User u : users) {
//            System.out.println(u);
//        }
    }

    /**
     * 测试 保存
     *
     * 两者的区别在于如果选择insert 那么所有的字段都会添加一遍即使没有值
     */
    @Test
    public void testSave(){
        /** 1.但是如果使用inserSelective就会只给有值的字段赋值（会对传进来的值做非空判断） **/
        User u = new User();
        u.setUsername("jedi");
        u.setSex("2");//女人
        u.setAddress("chendu");

        int i = userDao.insertSelective(u);
//        insert into user ( username, sex, address ) values ( 'jedi', '2', 'chendu' );
        System.out.println("save hou +++ return i: "+i);

        /** 测试 两种插入的区别 */

        /** 2.选择insert 那么所有的字段都会添加一遍即使没有值，会是null */
        User u2 = new User();
        u2.setUsername("bob");
        u2.setSex("1");//男人
        u2.setAddress("nanchong");
//        insert into user (username, birthday, sex, address) values ('bob', null, '1', 'nanchong');
        int x = userDao.insert(u2);
        System.out.println("save hou +++ return x: "+x);

    }


    /**
     * 测试foreach标签的使用
     */
    @Test
    public void testFindInIds(){
//        QueryVo vo = new QueryVo();
//        List<Integer> list = new ArrayList<Integer>();
//        list.add(41);
//        list.add(42);
//        list.add(46);
//        vo.setIds(list);
//
//
//        //5.执行查询所有方法
//        List<User> users = userDao.findUserInIds(vo);
//        for(User user : users){
//            System.out.println(user);
//        }

    }


}
