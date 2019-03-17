package cn.tedu.store.bean;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	 
	private static final long serialVersionUID = 1L;
	//实体类的创建
	private Integer id;
	private String username;
	private String password;
	private String email;
	private String phone;
	private String image;
	private Integer gender;
	private String created_user;
	private Date created_time;
	private String modified_user;
	private Date modified_time;
	
	public User(Integer id, String username, String password, String email, String phone, String image, Integer gender,
			String createdUser, Date createdTime, String modifiedUser, Date modifiedTime) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.image = image;
		this.gender = gender;
		this.created_user = createdUser;
		this.created_time = createdTime;
		this.modified_user = modifiedUser;
		this.modified_time = modifiedTime;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getCreatedUser() {
		return created_user;
	}
	public void setCreatedUser(String createdUser) {
		this.created_user = createdUser;
	}
	public Date getCreatedTime() {
		return created_time;
	}
	public void setCreatedTime(Date createdTime) {
		this.created_time = createdTime;
	}
	public String getModifiedUser() {
		return modified_user;
	}
	public void setModifiedUser(String modifiedUser) {
		this.modified_user = modifiedUser;
	}
	public Date getModifiedTime() {
		return modified_time;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modified_time = modifiedTime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((created_time == null) ? 0 : created_time.hashCode());
		result = prime * result + ((created_user == null) ? 0 : created_user.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((modified_time == null) ? 0 : modified_time.hashCode());
		result = prime * result + ((modified_user == null) ? 0 : modified_user.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (created_time == null) {
			if (other.created_time != null)
				return false;
		} else if (!created_time.equals(other.created_time))
			return false;
		if (created_user == null) {
			if (other.created_user != null)
				return false;
		} else if (!created_user.equals(other.created_user))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (modified_time == null) {
			if (other.modified_time != null)
				return false;
		} else if (!modified_time.equals(other.modified_time))
			return false;
		if (modified_user == null) {
			if (other.modified_user != null)
				return false;
		} else if (!modified_user.equals(other.modified_user))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", phone="
				+ phone + ", image=" + image + ", gender=" + gender + ", create_user=" + created_user + ", created_time="
				+ created_time + ", modified_user=" + modified_user + ", modified_time=" + modified_time + "]";
	}
	
	
}
