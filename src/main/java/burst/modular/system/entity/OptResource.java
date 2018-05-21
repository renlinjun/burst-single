package burst.modular.system.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 功能操作资源表
 * </p>
 *
 * @author renlinjun
 * @since 2018-05-21
 */
public class OptResource extends Model<OptResource> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "ID", type = IdType.ID_WORKER)
    private String id;

    /**
     * 资源名称
     */
    private String resourceName;

    /**
     * 资源URL
     */
    private String resourceUrl;

    /**
     * 资源代码
     */
    private String resourceCode;

    /**
     * 是否需要登录(true,false)
     */
    private String isLogin;

    /**
     * 是否需要签名(true.false)
     */
    private String isSign;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }
    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }
    public String getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
    }
    public String getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(String isLogin) {
        this.isLogin = isLogin;
    }
    public String getIsSign() {
        return isSign;
    }

    public void setIsSign(String isSign) {
        this.isSign = isSign;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "OptResource{" +
        "id=" + id +
        ", resourceName=" + resourceName +
        ", resourceUrl=" + resourceUrl +
        ", resourceCode=" + resourceCode +
        ", isLogin=" + isLogin +
        ", isSign=" + isSign +
        "}";
    }
}
