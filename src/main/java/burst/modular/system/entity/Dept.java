package burst.modular.system.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 部门表
 * @author REN
 *
 */
@TableName("DEPT")
public class Dept {
	
	@TableId(value="ID",type=IdType.UUID)
	private String id;
	private String deptCode;
	private String deptName;
	private String deptTypeId;
	private String pDeptId;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptTypeId() {
		return deptTypeId;
	}
	public void setDeptTypeId(String deptTypeId) {
		this.deptTypeId = deptTypeId;
	}
	public String getpDeptId() {
		return pDeptId;
	}
	public void setpDeptId(String pDeptId) {
		this.pDeptId = pDeptId;
	}

}
