package burst.modular.system.entity;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 功能操作资源表
 * </p>
 *
 * @author renlinjun
 * @since 2018-05-21
 */
@TableName("opt_resource")
@Alias(value="optResource")
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
    private boolean isLogin;

    /**
     * 是否需要签名(true.false)
     */
    private boolean isSign;

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

    public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}

	public boolean isSign() {
		return isSign;
	}

	public void setSign(boolean isSign) {
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
