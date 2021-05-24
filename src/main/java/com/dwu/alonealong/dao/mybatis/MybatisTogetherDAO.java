package com.dwu.alonealong.dao.mybatis;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.dwu.alonealong.dao.TogetherDAO;
import com.dwu.alonealong.dao.mybatis.mapper.TogetherFoodMapper;
import com.dwu.alonealong.dao.mybatis.mapper.TogetherMapper;
import com.dwu.alonealong.dao.mybatis.mapper.TogetherMemberMapper;
import com.dwu.alonealong.domain.Together;

@Repository
public class MybatisTogetherDAO implements TogetherDAO {
	@Autowired
	private TogetherMapper togetherMapper;
	//추가함
	@Autowired
	private TogetherFoodMapper togetherFoodMapper;
	@Autowired
	private TogetherMemberMapper togetherMemberMapper;
	
	@Override
	public Together getTogetherByTodId(String togId) throws DataAccessException {
		Together together = togetherMapper.getTogetherByTogId(togId);
		String togetherId = together.getTogetherId();
		together.setTogetherFoodList(togetherFoodMapper.getTogetherFoodListByTogId(togetherId));
		together.setTogetherMemberList(togetherMemberMapper.getTogetherMemberListByTogId(togetherId));
		
		return together;
	}

	@Override
	public void insertTogether(Together together) throws DataAccessException {
		togetherMapper.insertTogether(together);
	}

	@Override
	public void removeTogether(Together together) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTogether(Together together) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Together> getTogetherList() throws DataAccessException {
		List<Together> togetherList = togetherMapper.getTogetherList();
		for(int i = 0; i < togetherList.size(); i++) {
			String togId = togetherList.get(i).getTogetherId();
			togetherList.get(i).setTogetherFoodList(togetherFoodMapper.getTogetherFoodListByTogId(togId));
			togetherList.get(i).setTogetherMemberList(togetherMemberMapper.getTogetherMemberListByTogId(togId));
		}
		
		return togetherList;
	}

	@Override
	public List<Together> getTogetherListByCategory(String area, Date date, String kind, int price, String sex, int age)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}
