package com.crossit.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crossit.dao.MemberDao;
import com.crossit.entity.Member;
import com.crossit.service.MemberService;

@Service("MemberService")
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberDao memberDao;

	@Override
	public int signUp(Member member) {
		
		int result = memberDao.findMemberByEmail(member.getEmail());
		
		if(result > 0) {
			return -1;
		}else {
			return memberDao.signUp(member);
		}
	}
	
	@Override
	public int signIn(Member member) {
		
		
		return memberDao.signIn(member);
		
	}

	@Override
	public int getMember(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
