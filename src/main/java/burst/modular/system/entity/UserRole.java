package burst.modular.system.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 人员角色关联表
 * </p>
 *
 * @author renlinjun
 * @since 2018-05-21
 */
@TableName("USER_ROLE")
public class UserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 人员ID
     */
    private String userId;

    /**
     * 角色ID
     */
    private String roleId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserRole{" +
        "userId=" + userId +
        ", roleId=" + roleId +
        "}";
    }
}
