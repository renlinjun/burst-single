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
	private String pDeptIds;
	private String primaryPerson;
	private String deputyPerson;
	private String remark;
	private String delFlag;


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

	public String getpDeptIds() {
		return pDeptIds;
	}

	public void setpDeptIds(String pDeptIds) {
		this.pDeptIds = pDeptIds;
	}

	public String getPrimaryPerson() {
		return primaryPerson;
	}

	public void setPrimaryPerson(String primaryPerson) {
		this.primaryPerson = primaryPerson;
	}

	public String getDeputyPerson() {
		return deputyPerson;
	}

	public void setDeputyPerson(String deputyPerson) {
		this.deputyPerson = deputyPerson;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}



	@Override
	public String toString() {
		return "Dept{" +
				"id='" + id + '\'' +
				", deptCode='" + deptCode + '\'' +
				", deptName='" + deptName + '\'' +
				", deptTypeId='" + deptTypeId + '\'' +
				", pDeptId='" + pDeptId + '\'' +
				", pDeptIds='" + pDeptIds + '\'' +
				", primaryPerson='" + primaryPerson + '\'' +
				", deputyPerson='" + deputyPerson + '\'' +
				", remark='" + remark + '\'' +
				", delFlag='" + delFlag + '\'' +
				'}';
	}
}
