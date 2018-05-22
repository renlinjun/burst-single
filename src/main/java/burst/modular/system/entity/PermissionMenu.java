package burst.modular.system.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 权限菜单表
 * </p>
 *
 * @author renlinjun
 * @since 2018-05-21
 */
@TableName("permission_menu")
public class PermissionMenu extends Model<PermissionMenu> {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单ID
     */
    @TableId(value = "MENU_iD", type = IdType.ID_WORKER)
    private String menuId;

    /**
     * 权限ID
     */
    private String permissionId;

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }
    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    protected Serializable pkVal() {
        return this.menuId;
    }

    @Override
    public String toString() {
        return "PermissionMenu{" +
        "menuId=" + menuId +
        ", permissionId=" + permissionId +
        "}";
    }
}
