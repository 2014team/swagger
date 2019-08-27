package cn.zzq.bean;
 
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.*;

public class User {
    @ApiModelProperty(value="用户名")
    @NotEmpty(message="姓名不能为空")
    private String name;

    @ApiModelProperty(value="密码")
    @NotEmpty(message="密码不能为空")
    private String password;

    @ApiModelProperty(value="性别")
    @NotEmpty(message="性别不能为空")
    private String gender;

    @ApiModelProperty(value="年龄")
    @NotNull(message="年龄不能为空")
    @Min(value=18,message="必须年满18岁！")
    @Max(value=30,message="年龄不能大于30岁！")
    private Integer age;
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getGender() {
        return gender;
    }
 
    public void setGender(String gender) {
        this.gender = gender;
    }
 
    public Integer getAge() {
        return age;
    }
 
    public void setAge(Integer age) {
        this.age = age;
    }
}
