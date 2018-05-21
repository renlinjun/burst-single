package burst.modular.system.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 系统账户表
 * </p>
 *
 * @author renlinjun
 * @since 2018-05-21
 */
public class Account extends Model<Account> {

    private static final long serialVersionUID = 1L;

    /**
     * 账号主键
     */
    @TableId(value = "ID", type = IdType.ID_WORKER)
    private String id;

    /**
     * 登录账号
     */
    private String accountName;

    /**
     * 密码
     */
    private String passwd;

    /**
     * 关联的人员详细信息ID
     */
    private String userInfoId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    public String getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(String userInfoId) {
        this.userInfoId = userInfoId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Account{" +
        "id=" + id +
        ", accountName=" + accountName +
        ", passwd=" + passwd +
        ", userInfoId=" + userInfoId +
        "}";
    }
}
