package com.zsx.web.entity;

public class Newuser {
    /**
     * @mbggenerated
     */
    private Integer id;

    /**
     * @mbggenerated
     */
    private String name;

    /**
     * @mbggenerated
     */
    private String gender;

    /**
     * @mbggenerated
     */
    private String password;

    /**
     * @return the value of newuser.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the value for newuser.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the value of newuser.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the value for newuser.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return the value of newuser.gender
     *
     * @mbggenerated
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the value for newuser.gender
     *
     * @mbggenerated
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * @return the value of newuser.password
     *
     * @mbggenerated
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the value for newuser.password
     *
     * @mbggenerated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}