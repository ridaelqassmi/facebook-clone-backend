package com.facebook.facebookclone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.facebook.facebookclone.modals.Comment;

public interface CommentRepo extends JpaRepository<Comment,Long> {

	@Query(value="SELECT * FROM comment WHERE user_id=?1 and post_id=?2",nativeQuery=true)
	List<Comment> getComment(long idUser,long idPost);
	
}
