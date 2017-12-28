package com.mrl.spring.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class JdbcTest {

	private ApplicationContext ctx = null;
	
	private JdbcTemplate jdbcTemplate = null;
	
	private AccountDao dao = null;
	
	{
		ctx = new ClassPathXmlApplicationContext("jdbc/applicationContext.xml");
		jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		dao = ctx.getBean(AccountDao.class);
	}
	
	@Test  //Insert Update Delete
	public void testUpdate(){
		String sql = "update account set name=?,money=? where id=?"; 
		jdbcTemplate.update(sql, "lwq","20000","4");
	}
	
	
	/**
	 * 批量更新
	 * insert
	 * update
	 * delete
	 * 最后一个参数是object集合的类型
	 */
	@Test
	public void testBatchUpdate(){
		String sql = "insert into account(id,name,money) values(?,?,?)";
		List<Object[]> list = new ArrayList<>();
		list.add(new Object[]{5,"小米",2000});
		list.add(new Object[]{6,"小1",3000});
		list.add(new Object[]{7,"小2",4000});
		list.add(new Object[]{8,"小3",5000});
		jdbcTemplate.batchUpdate(sql,list);
	}
	
	/**
	 * 获取一条记录,转换成一条记录
	 * 如果sql列名和属性名不一致要通过别名映射
	 * 不支持级联属性
	 */
	@Test
	public void testGetOne(){
		String sql = "SELECT * FROM account WHERE id=?";
		RowMapper<Account> rowMapper = new BeanPropertyRowMapper<>(Account.class);
		Account obj = jdbcTemplate.queryForObject(sql, rowMapper,1);
		System.out.println(obj);
	}
	
	/**
	 * 查询集合
	 */
	@Test
	public void getList(){
		String sql = "SELECT * FROM account WHERE id > ?";
		RowMapper<Account> rowMapper = new BeanPropertyRowMapper<>(Account.class);
		List<Account> query = jdbcTemplate.query(sql, rowMapper,4);
		query.forEach(System.out::println);
	}
	
	/**
	 * 获取单个值
	 * queryForObject
	 */
	@Test
	public void testGetForObj(){
		String sql = "SELECT count(id) FROM account";
		Long count = jdbcTemplate.queryForObject(sql, Long.class);
		System.out.println(count);
	}
	
	@Test
	public void testDataSource() throws SQLException {
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}
	
	
	@Test
	public void testDao(){
		Account account = dao.get(1);
		System.out.println(account);
	}
	

}
