package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.ctrip.platform.dal.dao.annotation.Database;
import com.ctrip.platform.dal.dao.annotation.Sensitive;
import com.ctrip.platform.dal.dao.annotation.Type;
import java.sql.Types;
import java.sql.Timestamp;

import com.ctrip.platform.dal.dao.DalPojo;

@Entity
@Database(name="pkgdemoDB_W")
@Table(name="usertorole")
public class Usertorole implements DalPojo {

    // 主键
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(value=Types.INTEGER)
	private Integer id;

    // 用户id
	@Column(name="userId")
	@Type(value=Types.INTEGER)
	private Integer userId;

    // 角色id
	@Column(name="roleId")
	@Type(value=Types.INTEGER)
	private Integer roleId;

    // 创建时间
	@Column(name="CreateTime")
	@Type(value=Types.TIMESTAMP)
	private Timestamp createTime;

    // 修改者用户名
	@Column(name="ModifyUser")
	@Type(value=Types.VARCHAR)
	private String modifyUser;

    // DataChange_LastTime
	@Column(name="DataChange_LastTime", insertable=false, updatable=false)
	@Type(value=Types.TIMESTAMP)
	private Timestamp datachangeLasttime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getModifyUser() {
		return modifyUser;
	}

	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}

	public Timestamp getDatachangeLasttime() {
		return datachangeLasttime;
	}

	public void setDatachangeLasttime(Timestamp datachangeLasttime) {
		this.datachangeLasttime = datachangeLasttime;
	}

}