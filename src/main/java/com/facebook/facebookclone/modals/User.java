package com.facebook.facebookclone.modals;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String firstName;
	private String LastName;
	private String email;
	private String phoneNumber;
	@Lob
	private byte[] profilePic;
	
	@OneToMany(mappedBy="user")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private List<Post> post;

	@OneToMany(mappedBy="user",fetch = FetchType.LAZY)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private List<Comment> comment;
	
	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public byte[] getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(byte[] picInBytes) {
		this.profilePic = picInBytes;
	}

	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}


	public User(String firstName, String lastName, String email, String phoneNumber, byte[] profilePic, List<Post> post,
			List<Comment> comment) {
		super();
		this.firstName = firstName;
		LastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.profilePic = profilePic;
		this.post = post;
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", LastName=" + LastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", profilePic=" + Arrays.toString(profilePic) + ", post=" + post
				+ "]";
	}

	public User() {
		super();
	}
	
	
}
