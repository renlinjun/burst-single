package burst.modular.system.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * 部门表
 * @author REN
 *
 */
@TableName("DEPT")
public class Dept extends Model<Dept> {

	 private static final long serialVersionUID = 1L;

	@TableId(value="ID",type=IdType.UUID)
	private String id;

	@TableField("DEPT_CODE")
	private String deptCode;

	@TableField("DEPT_NAME")
	private String deptName;

	@TableField("DEPT_TYPE")
	private String deptTypeId;

	@TableField("P_DEPTS_ID")
	private String pDeptId;

	@TableField("P_DEPTS_IDS")
	private String pDeptIds;

	@TableField("PRIMARY_PERSON")
	private String primaryPerson;

	@TableField("DEPUTY_PERSON")
	private String deputyPerson;

	@TableField("REMARK")
	private String remark;

	@TableField("DEL_FLAG")
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

	@Override
	protected Serializable pkVal() {
		return  this.id;
	}
}
