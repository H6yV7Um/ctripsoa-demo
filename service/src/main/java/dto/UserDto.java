package dto;

import com.ctriposs.baiji.exception.BaijiRuntimeException;
import com.ctriposs.baiji.schema.*;
import com.ctriposs.baiji.specific.*;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.io.Serializable;
import java.util.Calendar;

@SuppressWarnings("all")
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE) 
@JsonPropertyOrder({
    "userId",
    "userName",
    "password",
    "age",
    "sex",
    "createTime",
    "modifyUser",
    "datachangeLasttime",
    "roleId",
    "roleName"
})
public class UserDto implements SpecificRecord, Serializable {
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    public static final transient Schema SCHEMA = Schema.parse("{\"type\":\"record\",\"name\":\"UserDto\",\"namespace\":\"" + UserDto.class.getPackage().getName() + "\",\"doc\":null,\"fields\":[{\"name\":\"userId\",\"type\":[\"int\",\"null\"]},{\"name\":\"userName\",\"type\":[\"string\",\"null\"]},{\"name\":\"password\",\"type\":[\"string\",\"null\"]},{\"name\":\"age\",\"type\":[\"int\",\"null\"]},{\"name\":\"sex\",\"type\":[\"string\",\"null\"]},{\"name\":\"createTime\",\"type\":[\"datetime\",\"null\"]},{\"name\":\"modifyUser\",\"type\":[\"string\",\"null\"]},{\"name\":\"datachangeLasttime\",\"type\":[\"datetime\",\"null\"]},{\"name\":\"roleId\",\"type\":[\"int\",\"null\"]},{\"name\":\"roleName\",\"type\":[\"string\",\"null\"]}]}");

    @Override
    @JsonIgnore
    public Schema getSchema() { return SCHEMA; }

    public UserDto(
        Integer userId,
        String userName,
        String password,
        Integer age,
        String sex,
        Calendar createTime,
        String modifyUser,
        Calendar datachangeLasttime,
        Integer roleId,
        String roleName) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.sex = sex;
        this.createTime = createTime;
        this.modifyUser = modifyUser;
        this.datachangeLasttime = datachangeLasttime;
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public UserDto() {
    }

    @JsonProperty("userId") 
    public Integer userId;

    @JsonProperty("userName") 
    public String userName;

    @JsonProperty("password") 
    public String password;

    @JsonProperty("age") 
    public Integer age;

    @JsonProperty("sex") 
    public String sex;

    @JsonProperty("createTime") 
    public Calendar createTime;

    @JsonProperty("modifyUser") 
    public String modifyUser;

    @JsonProperty("datachangeLasttime") 
    public Calendar datachangeLasttime;

    @JsonProperty("roleId") 
    public Integer roleId;

    @JsonProperty("roleName") 
    public String roleName;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(final Integer userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(final String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }
    public Integer getAge() {
        return age;
    }

    public void setAge(final Integer age) {
        this.age = age;
    }
    public String getSex() {
        return sex;
    }

    public void setSex(final String sex) {
        this.sex = sex;
    }
    public Calendar getCreateTime() {
        return createTime;
    }

    public void setCreateTime(final Calendar createTime) {
        this.createTime = createTime;
    }
    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(final String modifyUser) {
        this.modifyUser = modifyUser;
    }
    public Calendar getDatachangeLasttime() {
        return datachangeLasttime;
    }

    public void setDatachangeLasttime(final Calendar datachangeLasttime) {
        this.datachangeLasttime = datachangeLasttime;
    }
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(final Integer roleId) {
        this.roleId = roleId;
    }
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(final String roleName) {
        this.roleName = roleName;
    }

    // Used by DatumWriter. Applications should not call.
    public Object get(int fieldPos) {
        switch (fieldPos) {
            case 0: return this.userId;
            case 1: return this.userName;
            case 2: return this.password;
            case 3: return this.age;
            case 4: return this.sex;
            case 5: return this.createTime;
            case 6: return this.modifyUser;
            case 7: return this.datachangeLasttime;
            case 8: return this.roleId;
            case 9: return this.roleName;
            default: throw new BaijiRuntimeException("Bad index " + fieldPos + " in get()");
        }
    }

    // Used by DatumReader. Applications should not call.
    @SuppressWarnings(value="unchecked")
    public void put(int fieldPos, Object fieldValue) {
        switch (fieldPos) {
            case 0: this.userId = (Integer)fieldValue; break;
            case 1: this.userName = (String)fieldValue; break;
            case 2: this.password = (String)fieldValue; break;
            case 3: this.age = (Integer)fieldValue; break;
            case 4: this.sex = (String)fieldValue; break;
            case 5: this.createTime = (Calendar)fieldValue; break;
            case 6: this.modifyUser = (String)fieldValue; break;
            case 7: this.datachangeLasttime = (Calendar)fieldValue; break;
            case 8: this.roleId = (Integer)fieldValue; break;
            case 9: this.roleName = (String)fieldValue; break;
            default: throw new BaijiRuntimeException("Bad index " + fieldPos + " in put()");
        }
    }

    @Override
    public Object get(String fieldName) {
        Schema schema = getSchema();
        if (!(schema instanceof RecordSchema)) {
            return null;
        }
        Field field = ((RecordSchema) schema).getField(fieldName);
        return field != null ? get(field.getPos()) : null;
    }

    @Override
    public void put(String fieldName, Object fieldValue) {
        Schema schema = getSchema();
        if (!(schema instanceof RecordSchema)) {
            return;
        }
        Field field = ((RecordSchema) schema).getField(fieldName);
        if (field != null) {
            put(field.getPos(), fieldValue);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        final UserDto other = (UserDto)obj;
        return 
            Objects.equal(this.userId, other.userId) &&
            Objects.equal(this.userName, other.userName) &&
            Objects.equal(this.password, other.password) &&
            Objects.equal(this.age, other.age) &&
            Objects.equal(this.sex, other.sex) &&
            Objects.equal(this.createTime, other.createTime) &&
            Objects.equal(this.modifyUser, other.modifyUser) &&
            Objects.equal(this.datachangeLasttime, other.datachangeLasttime) &&
            Objects.equal(this.roleId, other.roleId) &&
            Objects.equal(this.roleName, other.roleName);
    }

    @Override
    public int hashCode() {
        int result = 1;

        result = 31 * result + (this.userId == null ? 0 : this.userId.hashCode());
        result = 31 * result + (this.userName == null ? 0 : this.userName.hashCode());
        result = 31 * result + (this.password == null ? 0 : this.password.hashCode());
        result = 31 * result + (this.age == null ? 0 : this.age.hashCode());
        result = 31 * result + (this.sex == null ? 0 : this.sex.hashCode());
        result = 31 * result + (this.createTime == null ? 0 : this.createTime.hashCode());
        result = 31 * result + (this.modifyUser == null ? 0 : this.modifyUser.hashCode());
        result = 31 * result + (this.datachangeLasttime == null ? 0 : this.datachangeLasttime.hashCode());
        result = 31 * result + (this.roleId == null ? 0 : this.roleId.hashCode());
        result = 31 * result + (this.roleName == null ? 0 : this.roleName.hashCode());

        return result;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("userId", userId)
            .add("userName", userName)
            .add("password", password)
            .add("age", age)
            .add("sex", sex)
            .add("createTime", createTime)
            .add("modifyUser", modifyUser)
            .add("datachangeLasttime", datachangeLasttime)
            .add("roleId", roleId)
            .add("roleName", roleName)
            .toString();
    }
}
