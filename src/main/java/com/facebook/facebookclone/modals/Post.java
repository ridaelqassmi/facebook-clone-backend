package com.facebook.facebookclone.modals;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Post {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long Post_id;
	private int  nbLikes;
	@Lob
	private byte[] image;
	private String postContent;
	
	@ManyToOne
    @JoinColumn(name="id", nullable=false)
    private User user;
	
	@OneToMany(mappedBy="CommentId",fetch = FetchType.EAGER)
	private List<Comment> comment;

	public long getId() {
		return Post_id;
	}

	public void setId(long id) {
		this.Post_id = id;
	}

	public int getNbLikes() {
		return nbLikes;
	}

	public void setNbLikes(int nbLikes) {
		this.nbLikes = nbLikes;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public User getUser() {
		return user;
	}

	public long getPost_id() {
		return Post_id;
	}

	public void setPost_id(long post_id) {
		Post_id = post_id;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	public void setUser(User user2) {
		this.user = user2;
	}

	public Post(long id, int nbLikes, byte[] image, String postContent, User user) {
		super();
		this.Post_id = id;
		this.nbLikes = nbLikes;
		this.image = image;
		this.postContent = postContent;
		this.user = user;
	}
	

	public Post(int nbLikes, String postContent, User user) {
		super();
		this.nbLikes = nbLikes;
		this.postContent = postContent;
		this.user = user;
	}
	

	public Post() {
		super();
	}

	@Override
	public String toString() {
		return "Post [Post_id=" + Post_id + ", nbLikes=" + nbLikes + ", image=" + Arrays.toString(image)
				+ ", postContent=" + postContent + ", user=" + user + ", comment=" + comment + "]";
	}

	
	
	
	
	
	
	
	
	
}
