package com.zsx.web.entity;

import java.io.Serializable;

public class User implements Serializable {
	 /**
     * @mbggenerated
     */
    private Integer id;

    /**
     * @mbggenerated
     */
    private String username;

    /**
     * @mbggenerated
     */
    private String name;

    /**
     * @mbggenerated
     */
    private String code;

    /**
     * @mbggenerated
     */
    private Integer age;

    /**
     * @mbggenerated
     */
    private String gender;

    /**
     * @mbggenerated
     */
    private Double phone;

    /**
     * @mbggenerated
     */
    private String demand;

    /**
     * @return the value of frienduser.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the value for frienduser.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the value of frienduser.username
     *
     * @mbggenerated
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the value for frienduser.username
     *
     * @mbggenerated
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     *
     * @return the value of frienduser.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the value for frienduser.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return the value of frienduser.code
     *
     * @mbggenerated
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the value for frienduser.code
     *
     * @mbggenerated
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     *
     * @return the value of frienduser.age
     *
     * @mbggenerated
     */
    public Integer getAge() {
        return age;
    }

    /**
     *
     * @param age the value for frienduser.age
     *
     * @mbggenerated
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * @return the value of frienduser.gender
     *
     * @mbggenerated
     */
    public String getGender() {
        return gender;
    }

    /**
     *
     * @param gender the value for frienduser.gender
     *
     * @mbggenerated
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * @return the value of frienduser.phone
     *
     * @mbggenerated
     */
    public Double getPhone() {
        return phone;
    }

    /**
     * @param phone the value for frienduser.phone
     *
     * @mbggenerated
     */
    public void setPhone(Double phone) {
        this.phone = phone;
    }

    /**
     * @return the value of frienduser.demand
     *
     * @mbggenerated
     */
    public String getDemand() {
        return demand;
    }

    /**
     * @param demand the value for frienduser.demand
     *
     * @mbggenerated
     */
    public void setDemand(String demand) {
        this.demand = demand == null ? null : demand.trim();
    }
}