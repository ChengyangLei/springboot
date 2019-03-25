package com.cloud.springboot.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class TSysUser implements UserDetails,Serializable {

    private Long id;


    private String nickname;


    private String username;


    private String password;


    private List<? extends GrantedAuthority> authorities;


    private Integer admin;


    private Date createDate;


    private Date modifiedTime;


    private Integer status;


    private Byte isDelete;


    private static final long serialVersionUID = 1L;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getNickname() {
        return nickname;
    }


    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }


    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }


    public Integer getAdmin() {
        return admin;
    }


    public void setAdmin(Integer admin) {
        this.admin = admin;
    }


    public Date getCreateDate() {
        return createDate;
    }


    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


    public Date getModifiedTime() {
        return modifiedTime;
    }


    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }


    public Integer getStatus() {
        return status;
    }


    public void setStatus(Integer status) {
        this.status = status;
    }


    public Byte getIsDelete() {
        return isDelete;
    }


    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }


    public void setAuthorities(List<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", nickname=").append(nickname);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", admin=").append(admin);
        sb.append(", createDate=").append(createDate);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", status=").append(status);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}