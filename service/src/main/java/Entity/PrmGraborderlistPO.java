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
@Database(name="ttlorderbookingdb_W")
@Table(name="prm_graborderlist")
public class PrmGraborderlistPO implements DalPojo {

    // ID,自增主键
	@Id
	@Column(name="GrabOrderID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(value=Types.BIGINT)
	private Long grabOrderID;

    // 客户ID
	@Column(name="UserId")
	@Type(value=Types.VARCHAR)
	private String userId;

    // 客户名称
	@Column(name="UserName")
	@Type(value=Types.VARCHAR)
	private String userName;

    // 是否抢到(T/F)
	@Column(name="IsGrabed")
	@Type(value=Types.CHAR)
	private String isGrabed;

    // 抢订时间
	@Column(name="GrabTime")
	@Type(value=Types.TIMESTAMP)
	private Timestamp grabTime;

    // VBK产品编号
	@Column(name="VBKProductID")
	@Type(value=Types.BIGINT)
	private Long vBKProductID;

    // VBK产品名称
	@Column(name="VBKProductIName")
	@Type(value=Types.VARCHAR)
	private String vBKProductIName;

    // 对接方产品ID
	@Column(name="CSProductID")
	@Type(value=Types.VARCHAR)
	private String cSProductID;

    // 对接方套餐类型
	@Column(name="CSProductType")
	@Type(value=Types.VARCHAR)
	private String cSProductType;

    // 对接方活动ID
	@Column(name="CSActivityID")
	@Type(value=Types.VARCHAR)
	private String cSActivityID;

    // 订单号
	@Column(name="RequirementOrderId")
	@Type(value=Types.BIGINT)
	private Long requirementOrderId;

    // 创建时间
	@Column(name="DataChange_CreateTime")
	@Type(value=Types.TIMESTAMP)
	private Timestamp datachangeCreatetime;

    // 创建人
	@Column(name="CreateUser")
	@Type(value=Types.VARCHAR)
	private String createUser;

    // 修改人
	@Column(name="ModifyUser")
	@Type(value=Types.VARCHAR)
	private String modifyUser;

    // 更新时间
	@Column(name="datachange_lasttime", insertable=false, updatable=false)
	@Type(value=Types.TIMESTAMP)
	private Timestamp datachangeLasttime;

    // 联系电话
	@Column(name="ContactPhone")
	@Type(value=Types.VARCHAR)
	private String contactPhone;

	public Long getGrabOrderID() {
		return grabOrderID;
	}

	public void setGrabOrderID(Long grabOrderID) {
		this.grabOrderID = grabOrderID;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getIsGrabed() {
		return isGrabed;
	}

	public void setIsGrabed(String isGrabed) {
		this.isGrabed = isGrabed;
	}

	public Timestamp getGrabTime() {
		return grabTime;
	}

	public void setGrabTime(Timestamp grabTime) {
		this.grabTime = grabTime;
	}

	public Long getVBKProductID() {
		return vBKProductID;
	}

	public void setVBKProductID(Long vBKProductID) {
		this.vBKProductID = vBKProductID;
	}

	public String getVBKProductIName() {
		return vBKProductIName;
	}

	public void setVBKProductIName(String vBKProductIName) {
		this.vBKProductIName = vBKProductIName;
	}

	public String getCSProductID() {
		return cSProductID;
	}

	public void setCSProductID(String cSProductID) {
		this.cSProductID = cSProductID;
	}

	public String getCSProductType() {
		return cSProductType;
	}

	public void setCSProductType(String cSProductType) {
		this.cSProductType = cSProductType;
	}

	public String getCSActivityID() {
		return cSActivityID;
	}

	public void setCSActivityID(String cSActivityID) {
		this.cSActivityID = cSActivityID;
	}

	public Long getRequirementOrderId() {
		return requirementOrderId;
	}

	public void setRequirementOrderId(Long requirementOrderId) {
		this.requirementOrderId = requirementOrderId;
	}

	public Timestamp getDatachangeCreatetime() {
		return datachangeCreatetime;
	}

	public void setDatachangeCreatetime(Timestamp datachangeCreatetime) {
		this.datachangeCreatetime = datachangeCreatetime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
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

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

}