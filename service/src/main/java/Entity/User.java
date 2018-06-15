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
@Table(name="user")
public class User implements DalPojo {

    // 用户id
	@Id
	@Column(name="userId")
	@Type(value=Types.INTEGER)
	private Integer userId;

    // 名字
	@Column(name="userName")
	@Type(value=Types.VARCHAR)
	private String userName;

    // 密码
	@Column(name="password")
	@Type(value=Types.VARCHAR)
	private String password;

    // 年龄
	@Column(name="age")
	@Type(value=Types.INTEGER)
	private Integer age;

    // 性别
	@Column(name="sex")
	@Type(value=Types.VARCHAR)
	private String sex;

    // 创建时间
	@Column(name="createTime")
	@Type(value=Types.TIMESTAMP)
	private Timestamp createTime;

    // 修改人
	@Column(name="modifyUser")
	@Type(value=Types.VARCHAR)
	private String modifyUser;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
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

}