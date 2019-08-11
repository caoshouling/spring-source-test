package org.csl.study.spring.source.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.RowBounds;
import org.csl.study.spring.source.common.utils.HttpKit;
import org.csl.study.spring.source.dao.UserMapper;
import org.csl.study.spring.source.exception.BusinessException;
import org.csl.study.spring.source.po.User;
import org.csl.study.spring.source.vo.RegisterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service("UserService")
public class UserService {

	@Autowired
	UserMapper userMapper;
	
	public User getUserById(Integer id) {
		
		return userMapper.selectByPrimaryKey(id);
	}
	
	public User getUserByUserNameAndPassword(String userName, String password) {
		return userMapper.selectUserByUserNameAndPassword( userName,  password);
	}
    /**
     * 分页查询用户
     * @param rowBounds
     * @return
     */
	public List<User> getUserList(RowBounds rowBounds) {
		
		return userMapper.findAllWithRowBounds(rowBounds);
	}

	public void register(RegisterVo registerVo) {
		User user = userMapper.selectUserByUserName(registerVo.getUserName());
		if(user != null){
			throw new BusinessException("用户名["+registerVo.getUserName()+"]已存在");
		}
		user = new User();
		user.setUserName(registerVo.getUserName());
		user.setPassword(registerVo.getPassword());
		user.setPhone(registerVo.getPhone());
		user.setMail(registerVo.getMail());
		user.setDeptId(1);
		user.setStatus("0");
		
		userMapper.insert(user);
	}
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void update(User user) {
		User user1 = new User();
		user1.setId(1);
		user1.setRemark("11111");
		userMapper.updateByPrimaryKeySelective(user1);
		
		User user2 = new User();
		user2.setId(2);
		user2.setRemark("22222");
		userMapper.updateByPrimaryKeySelective(user2);
			
	}

}
