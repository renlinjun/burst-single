package burst.modular.system.entity;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 人员信息表
 * </p>
 *
 * @author renlinjun
 * @since 2018-05-21
 */
//@TableName(value="USER_INFO")
public class UserInfo extends Model<UserInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @NotBlank
    @TableId(value = "ID", type = IdType.UUID)
    private String id;

    /**
     * 人员编号
     */
    @NotEmpty
    private String userCode;

    /**
     * 人员姓名
     */
    @NotEmpty
    private String userName;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 性别(0:男，1：女，2:其它)
     */
    private String sex;

    /**
     * 年龄
     */
    private String age;

    /**
     * 职称
     */
    private String title;

    /**
     * 人员信息状态(Y:可用，N：删除)
     */
        private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
        "id=" + id +
        ", userCode=" + userCode +
        ", userName=" + userName +
        ", email=" + email +
        ", sex=" + sex +
        ", age=" + age +
        ", title=" + title +
        ", status=" + status +
        "}";
    }
}
