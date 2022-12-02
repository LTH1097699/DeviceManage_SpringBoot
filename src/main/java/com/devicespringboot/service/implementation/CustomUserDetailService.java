//package com.devicespringboot.service.implementation;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.springmvcdevice.dto.MyUser;
//import com.springmvcdevice.entity.AccountEntity;
//import com.springmvcdevice.entity.RoleEntity;
//import com.springmvcdevice.repository.AccountRepository;
//
//@Service
//public class CustomUserDetailService implements UserDetailsService {
//	
//	@Autowired
//	private AccountRepository accountRepository;
//	
//	@Override
//	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//		AccountEntity account = accountRepository.findByEmail(email);
//		if(account == null) {
//			throw new UsernameNotFoundException("User not found");
//		}
//		
//		RoleEntity role = account.getRole();
//		List<GrantedAuthority> authorities = new ArrayList<>();
//		authorities.add(new SimpleGrantedAuthority(role.getRoleCode()));
//		
//		MyUser user = new MyUser(account.getEmail(), account.getPassword(), true, true, true, true, authorities);
//		user.setName(account.getEmployee().getName());
//		user.setId(account.getEmployee().getId());
//		System.out.println(user.getName());
//		return user;
//	}
//
//}
