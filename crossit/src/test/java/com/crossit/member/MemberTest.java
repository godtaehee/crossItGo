package com.crossit.member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.crossit.dao.MemberDao;
import com.crossit.entity.Member;

@SpringBootTest
public class MemberTest {
	
	
	@Autowired
	private MemberDao memberDao;
	
	@Test
	public void testFindMemberById() {
		
		int result = memberDao.findMemberById(Long.parseLong("4"));
		System.out.println(result);
	
	}
	
	@Test
	public void testFindMemberByEmail() {
		
		int result = memberDao.findMemberByEmail("wonderfulhuman@naveer.com");
		System.out.println(result);
	
	}
	
	@Test
	public void testSignin() {
		
		Member member = new Member();
		member.setEmail("wonderfulhuman@naveer.com");
		member.setPassword("123123");
		
		int result = memberDao.signIn(member);
		System.out.println(result);
		
	}
	

}
