package burst.modular.system.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author renlinjun
 * @since 2018-06-04
 */
public class RolePermission  implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
    */
    private String roleId;

    /**
     * 权限ID
     */
    private String permissionId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }


    @Override
    public String toString() {
        return "RolePermission{" +
        "roleId=" + roleId +
        ", permissionId=" + permissionId +
        "}";
    }
}
