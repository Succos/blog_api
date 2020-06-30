package com.succos.pojo;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "admin_user")
public class AdminUser {
    @Id
    private Integer id;

    private String username;

    private String password;

    private Byte enabled;

    private Byte locked;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return enabled
     */
    public Byte getEnabled() {
        return enabled;
    }

    /**
     * @param enabled
     */
    public void setEnabled(Byte enabled) {
        this.enabled = enabled;
    }

    /**
     * @return locked
     */
    public Byte getLocked() {
        return locked;
    }

    /**
     * @param locked
     */
    public void setLocked(Byte locked) {
        this.locked = locked;
    }
}