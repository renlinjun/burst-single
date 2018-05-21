package burst.modular.system.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 角色类型表
 * </p>
 *
 * @author renlinjun
 * @since 2018-05-21
 */
public class RoleType extends Model<RoleType> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "ID", type = IdType.ID_WORKER)
    private String id;

    /**
     * 角色类型ID
     */
    private String roleTypeId;

    /**
     * 角色类型名称
     */
    private String roleTypeName;

    /**
     * 类型描述
     */
    private String roleDesc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getRoleTypeId() {
        return roleTypeId;
    }

    public void setRoleTypeId(String roleTypeId) {
        this.roleTypeId = roleTypeId;
    }
    public String getRoleTypeName() {
        return roleTypeName;
    }

    public void setRoleTypeName(String roleTypeName) {
        this.roleTypeName = roleTypeName;
    }
    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "RoleType{" +
        "id=" + id +
        ", roleTypeId=" + roleTypeId +
        ", roleTypeName=" + roleTypeName +
        ", roleDesc=" + roleDesc +
        "}";
    }
}
