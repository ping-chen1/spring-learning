package model;

import anno.JdbcColum;

import java.util.Date;

public class User {
    @JdbcColum("id")
    private Long id;
    @JdbcColum("name")
    private String name;
    @JdbcColum("age")
    private Integer age;
    @JdbcColum("email")
    private String email;
    @JdbcColum("address")
    private String address;
    @JdbcColum("telephone")
    private String telephone;
    @JdbcColum("create_time")
    private Date createTime;
    @JdbcColum("update_time")
    private Date updateTime;
    @JdbcColum("password")
    private String password;
    @JdbcColum("is_delete")
    private Boolean isDelete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", password='" + password + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }
}
