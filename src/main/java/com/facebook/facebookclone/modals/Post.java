package com.facebook.facebookclone.modals;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

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

	public void setUser(User user) {
		this.user = user;
	}

	public Post(long id, int nbLikes, byte[] image, String postContent, User user) {
		super();
		this.Post_id = id;
		this.nbLikes = nbLikes;
		this.image = image;
		this.postContent = postContent;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Post [id=" + Post_id + ", nbLikes=" + nbLikes + ", image=" + Arrays.toString(image) + ", postContent="
				+ postContent + ", user=" + user + "]";
	}
	
	
	
	
	
	
	
	
	
}
