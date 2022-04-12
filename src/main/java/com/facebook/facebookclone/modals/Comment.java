package com.facebook.facebookclone.modals;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Comment {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long CommentId;
	private String commentContent;
	private long post_id;
	
	
	@ManyToOne
    @JoinColumn(name="id", nullable=false)
	
    private User user;
	

	public long getPost_id() {
		return post_id;
	}

	public void setPost_id(long post_id) {
		this.post_id = post_id;
	}

	public long getCommentId() {
		return CommentId;
	}

	public void setCommentId(long commentId) {
		CommentId = commentId;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Comment(String commentContent, User user) {
		super();
		this.commentContent = commentContent;

		this.user = user;
	}

	public Comment() {
		super();
	}

	public Comment(String commentContent, long post_id, User user) {
		super();
		this.commentContent = commentContent;
		this.post_id = post_id;
		this.user = user;
	}

	
	

}
