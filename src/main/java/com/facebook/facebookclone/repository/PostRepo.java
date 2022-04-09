package com.facebook.facebookclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facebook.facebookclone.modals.Post;

public interface PostRepo extends JpaRepository<Post,Long> {

}
