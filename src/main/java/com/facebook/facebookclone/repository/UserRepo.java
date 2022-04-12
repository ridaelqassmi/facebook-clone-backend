package com.facebook.facebookclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.facebook.facebookclone.modals.User;

public interface UserRepo  extends JpaRepository<User,Long>{
	@Query(value="Select * from user where id=?1",nativeQuery =true)
	public User findUserById(Long id) ;
}
