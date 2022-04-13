package com.facebook.facebookclone.modals;

import com.fasterxml.jackson.annotation.JsonProperty;

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
	private long id;
	private int  nbLikes;
	@Lob
	private byte[] image;
	private String postContent;
	
	@ManyToOne
    private User user;
	@OneToMany(mappedBy="post",fetch = FetchType.EAGER)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private List<Comment> comment;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	public Post( int nbLikes, byte[] image, String postContent, User user, List<Comment> comment) {

		this.nbLikes = nbLikes;
		this.image = image;
		this.postContent = postContent;
		this.user = user;
		this.comment = comment;
	}

	public Post() {

	}

	@Override
	public String toString() {
		return "Post{" +
				"id=" + id +
				", nbLikes=" + nbLikes +
				", image=" + Arrays.toString(image) +
				", postContent='" + postContent + '\'' +
				", user=" + user +
				", comment=" + comment +
				'}';
	}
}
