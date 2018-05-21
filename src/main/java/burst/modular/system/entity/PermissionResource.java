package burst.modular.system.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 权限资源关联表
 * </p>
 *
 * @author renlinjun
 * @since 2018-05-21
 */
public class PermissionResource extends Model<PermissionResource> {

    private static final long serialVersionUID = 1L;

    /**
     * 权限ID
     */
    @TableId(value = "PERMISSION_ID", type = IdType.ID_WORKER)
    private String permissionId;

    /**
     * 资源ID
     */
    private String resourceId;

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }
    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    protected Serializable pkVal() {
        return this.permissionId;
    }

    @Override
    public String toString() {
        return "PermissionResource{" +
        "permissionId=" + permissionId +
        ", resourceId=" + resourceId +
        "}";
    }
}
