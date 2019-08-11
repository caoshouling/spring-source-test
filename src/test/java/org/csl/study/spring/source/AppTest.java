package org.csl.study.spring.source;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.csl.study.spring.source.po.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	
	static Logger logger = LoggerFactory.getLogger(AppTest.class);
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    public static void main(String[] args) {
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//	
//		context.register(IndexDao.class);
//		context.refresh();
//		logger.info("1111");
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
    	
    	context.setConfigLocations("config/applicationContext.xml","config/application-mybatis.xml");
    	context.refresh();
		
		SqlSessionFactory sqlSessionFactory = context.getBean(SqlSessionFactory.class);
		SqlSession session = sqlSessionFactory.openSession();
		
		User user = session.selectOne("org.csl.study.spring.source.dao.UserMapper",1);
		
		logger.info("sqlSessionFactory."+ user.getUserName());
		
	}
}
