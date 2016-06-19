package com.xaruy.spitter.dao;

import java.util.List;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Spitter {
	
	private Long id;
	
	@Size(min=3, max=20, message="Username must be between 3 and 20 characters long.")
	@Pattern(regexp="^[a-zA-Z0-9]+$", message="Username must be alphanumeric with no spaces.")
	private String username;
	
	@Size(min = 6, max = 20, message = "The password must at least 6 characters long.")
	private String password;
	
	@Size(min = 3, max = 50, message = "Your full name must be btw 3 and 50 charaters long.")
	private String fullName;
	
    private List<Spittle> spittles;
    
    @Pattern(regexp = "^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$", message = "Invalid email address.")
    private String email;
    
    
    private boolean updateByEmail;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public List<Spittle> getSpittles() {
		return spittles;
	}
	public void setSpittles(List<Spittle> spittles) {
		this.spittles = spittles;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isUpdateByEmail() {
		return updateByEmail;
	}
	public void setUpdateByEmail(boolean updateByEmail) {
		this.updateByEmail = updateByEmail;
	}
    
	@Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;
        if(! (obj instanceof Spitter))
            return false;
        Spitter other = (Spitter) obj;
        return new EqualsBuilder().append(fullName, other.getFullName()).
                append(username, other.getUsername()).append(password, other.getPassword()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 31).append(fullName).append(username).append(password).toHashCode();
    }

}
