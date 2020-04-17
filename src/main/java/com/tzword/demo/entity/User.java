package com.tzword.demo.entity;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2020-04-16 13:47:43
 */
public class User implements Serializable {
    private static final long serialVersionUID = 395900391534331644L;
    /**
    * 主键
    */
    private Object id;
    /**
    * 姓名
    */
    private String name;
    /**
    * 手机号
    */
    private String phone;
    /**
    * 电子邮件
    */
    private String email;
    /**
    * 自我介绍
    */
    private String aboutme;
    /**
    * 经过MD5加密的密码
    */
    private String passwd;
    /**
    * 头像图片
    */
    private String avatar;
    /**
    * 1:普通用户，2:房产经纪人
    */
    private Object type;
    /**
    * 创建时间
    */
    private Object createTime;
    /**
    * 是否启用,1启用，0停用
    */
    private Object enable;
    /**
    * 所属经纪机构
    */
    private Integer agencyId;


    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAboutme() {
        return aboutme;
    }

    public void setAboutme(String aboutme) {
        this.aboutme = aboutme;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Object getType() {
        return type;
    }

    public void setType(Object type) {
        this.type = type;
    }

    public Object getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Object createTime) {
        this.createTime = createTime;
    }

    public Object getEnable() {
        return enable;
    }

    public void setEnable(Object enable) {
        this.enable = enable;
    }

    public Integer getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(Integer agencyId) {
        this.agencyId = agencyId;
    }

}