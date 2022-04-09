package com.facebook.facebookclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facebook.facebookclone.modals.User;

public interface UserRepo  extends JpaRepository<User,Long>{

}
