import com.mmz.bean.Cat;
import com.mmz.bean.Employee;
import com.mmz.bean.Key;
import com.mmz.dao.CatDao;
import com.mmz.dao.EmployeeDao;
import com.mmz.dao.KeyDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : mengmuzi
 * create at:  2019-07-20  01:49
 * @description:
 */
public class MyBatisTest02 {
    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     * 1、根据xml配置文件（全局配置文件）创建一个SqlSessionFactory对象 有数据源一些运行环境信息
     * 2、sql映射文件；配置了每一个sql，以及sql的封装规则等。
     * 3、将sql映射文件注册在全局配置文件中
     * 4、写代码：
     *         1）、根据全局配置文件得到SqlSessionFactory；
     *         2）、使用sqlSession工厂，获取到sqlSession对象使用他来执行增删改查
     *             一个sqlSession就是代表和数据库的一次会话，用完关闭
     *         3）、使用sql的唯一标志来告诉MyBatis执行哪个sql。sql都是保存在sql映射文件中的。
     *
     * @throws IOException
     */

    //查询操作
    @Test
    public void test01() throws IOException {
        // 1、获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        // 2、获取sqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession(true);
        try {
            // 3、获取接口的实现类对象
            //会为接口自动的创建一个代理对象，代理对象去执行增删改查方法
            EmployeeDao mapper = openSession.getMapper(EmployeeDao.class);
            Employee employee = mapper.getEmpById(1);
            System.out.println(mapper.getClass());//class com.sun.proxy.$Proxy4
            System.out.println(employee);
        } finally {
            openSession.close();
        }

    }

    //插入操作
    @Test
    public void test02() throws IOException {
        // 1、获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        // 2、获取sqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession(true);
        try {
            // 3、获取接口的实现类对象
            //会为接口自动的创建一个代理对象，代理对象去执行增删改查方法
            EmployeeDao mapper = openSession.getMapper(EmployeeDao.class);
            Employee employee = new Employee(null,"gumin","gumin@126.cn",1);
            int number = mapper.insertEmployee(employee);
            System.out.println(number);
            System.out.println(employee.getId());
        } finally {
            openSession.close();
        }

    }

    //多个参数查询操作
    @Test
    public void test03() throws IOException {
        // 1、获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        // 2、获取sqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession(true);
        try {
            // 3、获取接口的实现类对象
            //会为接口自动的创建一个代理对象，代理对象去执行增删改查方法
            EmployeeDao mapper = openSession.getMapper(EmployeeDao.class);

            Employee employee = mapper.getEmpByIdAndEmpName(1,"admin");
            System.out.println(employee);
        } finally {
            openSession.close();
        }

    }

    //传入Map参数查询操作
    @Test
    public void test04() throws IOException {
        // 1、获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        // 2、获取sqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession(true);
        try {
            // 3、获取接口的实现类对象
            //会为接口自动的创建一个代理对象，代理对象去执行增删改查方法
            EmployeeDao mapper = openSession.getMapper(EmployeeDao.class);

            Map<String,Object> map = new HashMap<>();
            map.put("id",1);
            map.put("empName","admin");

            Employee employee = mapper.getEmpByIdAndEmpNameByMap(map);
            System.out.println(employee);
        } finally {
            openSession.close();
        }

    }
    //查询表中所有的元素
    @Test
    public void test05() throws IOException {
        // 1、获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        // 2、获取sqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession(true);
        try {
            // 3、获取接口的实现类对象
            //会为接口自动的创建一个代理对象，代理对象去执行增删改查方法
            EmployeeDao mapper = openSession.getMapper(EmployeeDao.class);
            List<Employee> list = mapper.getAllEmployee();
            for (Employee element : list) {
                System.out.println(element);
            }
        } finally {
            openSession.close();
        }

    }

    //根据id查询表中元素封装为map
    @Test
    public void test06() throws IOException {
        // 1、获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        // 2、获取sqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession(true);
        try {
            // 3、获取接口的实现类对象
            //会为接口自动的创建一个代理对象，代理对象去执行增删改查方法
            EmployeeDao mapper = openSession.getMapper(EmployeeDao.class);
            Map<String,Object> map = mapper.getEmpByIdReturnMap(2);
            System.out.println(map);
        } finally {
            openSession.close();
        }

    }

    //查询表中所有的元素封装为map(重要！！)
    @Test
    public void test07() throws IOException {
        // 1、获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        // 2、获取sqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession(true);
        try {
            // 3、获取接口的实现类对象
            //会为接口自动的创建一个代理对象，代理对象去执行增删改查方法
            EmployeeDao mapper = openSession.getMapper(EmployeeDao.class);
            Map<String,Employee> map = mapper.getAllEmployeeReturnMap();
            System.out.println(map);
        } finally {
            openSession.close();
        }

    }

    //cat表的查询操作
    /**
     * MyBatis自动封装的结果是：
     *   1）按照列名和属性名一一对应的规则（不区分大小写）
     *   2）如果不一一对应
     *      1）开启驼峰命名的规则（aabb aa_Bb）
     *      2）自定义结果集resultMap，数据库和JavaBean中的映射对应
     */
    @Test
    public void testCat01() throws IOException {
        // 1、获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        // 2、获取sqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession(true);
        try {
            // 3、获取接口的实现类对象
            //会为接口自动的创建一个代理对象，代理对象去执行增删改查方法
            CatDao mapper = openSession.getMapper(CatDao.class);
            Cat cat = mapper.getCatById(1);
            System.out.println(mapper.getClass());//class com.sun.proxy.$Proxy4
            System.out.println(cat);
        } finally {
            openSession.close();
        }

    }

    //Key表的联合查询
    //1.采用级联属性封装联合查询后的所有结果
    @Test
    public void testKey01() throws IOException {
        // 1、获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        // 2、获取sqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession(true);
        try {
            // 3、获取接口的实现类对象
            //会为接口自动的创建一个代理对象，代理对象去执行增删改查方法
            KeyDao mapper = openSession.getMapper(KeyDao.class);
            Key key = mapper.getKeyById(1);
            System.out.println(mapper.getClass());//class com.sun.proxy.$Proxy4
            System.out.println(key);
        } finally {
            openSession.close();
        }

    }




}
