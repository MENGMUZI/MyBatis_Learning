import com.mmz.bean.Employee;
import com.mmz.dao.EmployeeDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author : mengmuzi
 * create at:  2019-07-20  00:03
 * @description:
 */


public class MyBatisTest {


    @Test
    public void test() throws IOException {
        //1.根据全局配置文件创建出一个SqlSessionFactory(负责创建SqlSession对象)
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        //2.获取和数据库的一次会话，getConnection();
        SqlSession openSession = sqlSessionFactory.openSession();

        //3.使用SqlSession 操作数据库，获得dao接口的实现
        EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
        Employee employee = employeeDao.getEmpById(1);
        System.out.println(employee);

    }

}
