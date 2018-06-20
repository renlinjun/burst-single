package burst.modular.system.entity;

import java.util.ArrayList;
import java.util.List;

public class MenuTree {
	/**
     * 主键ID
     */
    private String id;

    /**
     * 菜单代码
     */
    private String menuCode;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单URL
     */
    private String menuUrl;

    /**
     * 菜单所属应用
     */
    private String appId;
    
    /**
     * 是否显示
     */
    private int isHidden;
    
    /**
     * 子菜单
     */
    private List<Menu> childMenu = new ArrayList<>();

	public String getId() {
		return id;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public String getMenuName() {
		return menuName;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public String getAppId() {
		return appId;
	}

	public int getIsHidden() {
		return isHidden;
	}

	public List<Menu> getChildMenu() {
		return childMenu;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public void setIsHidden(int isHidden) {
		this.isHidden = isHidden;
	}

	public void setChildMenu(List<Menu> childMenu) {
		this.childMenu = childMenu;
	}
}
