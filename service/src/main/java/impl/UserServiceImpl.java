package impl;

import Dao.RoleDao;
import Dao.UserDao;
import Dao.UsertoroleDao;
import Entity.Role;
import Entity.User;
import Entity.Usertorole;
import com.ctrip.framework.clogging.agent.log.ILog;
import com.ctrip.framework.clogging.agent.log.LogManager;
import com.ctrip.platform.dal.dao.DalClient;
import com.ctrip.platform.dal.dao.DalClientFactory;
import com.ctrip.platform.dal.dao.DalHints;
import com.ctrip.platform.dal.dao.KeyHolder;
import com.ctriposs.baiji.rpc.common.types.CheckHealthRequestType;
import com.ctriposs.baiji.rpc.common.types.CheckHealthResponseType;
import dto.UserDto;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.http.HttpRequest;
import request.UserRequestType;
import response.ResultResponseType;
import response.UserListResponseType;
import servcie.UserService;


/**
 * Created by djxu on 2018/6/14.
 */
public class UserServiceImpl implements UserService {

  private static final ILog LOGGER = LogManager.getLogger(UserServiceImpl.class);
  private static final String DATA_BASE = "pkgdemoDB_W";
  private static DalClient client = null;
  private static UserDao userDao = null;
  private static RoleDao roleDao = null;
  private static UsertoroleDao usertoroleDao = null;

  public UserServiceImpl() throws Exception {
    /**
     * Initialize DalClientFactory.
     * The Dal.config can be specified from class-path or local file path.
     * One of follow three need to be enabled.
     **/

    DalClientFactory.initClientFactory(); // load from class-path Dal.config
    DalClientFactory.warmUpConnections();
    client = DalClientFactory.getClient(DATA_BASE);
    userDao = new UserDao();
    roleDao = new RoleDao();
    usertoroleDao = new UsertoroleDao();
  }


  @Override
  public UserListResponseType selectList(UserRequestType userRequestType) throws SQLException {
    UserListResponseType userListResponseType = new UserListResponseType();
    if (null == userRequestType) {
      return userListResponseType;
    }
    String userName = userRequestType.getUserName();
    User user=new User();
    user.setUserName(userName);
    List<UserDto> userDtoList= userDao.selectList(user);
    userListResponseType.setList(userDtoList);
    return userListResponseType;
  }

  @Override
  public ResultResponseType addUser(UserRequestType userRequestType)
      throws SQLException {
// todo:从request中拿session，从session中拿修改者名称
    ResultResponseType result = new ResultResponseType();
    if (null == userRequestType) {
      result.setMessage("参数异常");
      result.setSuccess(false);
      return result;
    }

    String userName = userRequestType.getUserName();
    User user = new User();
    user.setUserName(userName);
    List<User> l = userDao.queryLike(user);
    if (!userDao.queryLike(user).isEmpty()) {
      result.setMessage("用户名已存在");
      result.setSuccess(false);
      return result;
    }
    Role role = new Role();
    role.setRoleId(userRequestType.getRoleId());
    if (roleDao.queryByPk(role) == null) {
      result.setMessage("角色不存在");
      result.setSuccess(false);
      return result;
    }
    user.setAge(userRequestType.getAge());
    user.setSex(userRequestType.getSex());
    user.setCreateTime(new Timestamp(System.currentTimeMillis()));
    user.setPassword(userRequestType.getPassword());
    //todo:取出session中的username，设置为修改人
    KeyHolder keyHolder = new KeyHolder();
    userDao.insert(user);
    Usertorole usertorole = new Usertorole();
    int userId = keyHolder.getKey().intValue();
    usertorole.setUserId(userId);
    usertorole.setRoleId(userRequestType.getRoleId());
    usertoroleDao.insert(usertorole);
    result.setSuccess(true);
    return result;
  }

  @Override
  public ResultResponseType updateUser(UserRequestType userRequestType) throws SQLException {
    ResultResponseType result = new ResultResponseType();

    if (null == userRequestType) {
      result.setMessage("参数异常");
      result.setSuccess(false);
      return result;
    }

    User user = new User();

    user.setUserName(userRequestType.getUserName());
    List<User> list = userDao.queryLike(user);
    if (list.size() > 1 || (list.size() == 1 && !list.get(0).getUserId()
        .equals(userRequestType.getUserId()))) {
      result.setMessage("登录名已存在");
      result.setSuccess(false);
      return result;
    }

    Role role = new Role();

    role.setRoleId(userRequestType.getRoleId());

    role = roleDao.queryByPk(role);

    if (null == role) {
      result.setMessage("角色信息不存在");
      result.setSuccess(false);
      return result;
    }
    user.setUserId(userRequestType.getUserId());
    user.setUserName(userRequestType.getUserName());
    user.setPassword(userRequestType.getPassword());
    user.setAge(userRequestType.getAge());
    userDao.update(user);
    Usertorole usertorole = new Usertorole();
    usertorole.setUserId(userRequestType.getUserId());
    List<Usertorole> existUserRoleList = usertoroleDao.queryLike(usertorole);
    if (existUserRoleList.isEmpty()) {
      usertorole.setRoleId(userRequestType.getRoleId());
      usertorole.setCreateTime(new Timestamp(System.currentTimeMillis()));
      usertoroleDao.insert(usertorole);
    } else {
      existUserRoleList.get(0).setRoleId(userRequestType.getRoleId());
      usertoroleDao.update(existUserRoleList.get(0));
    }
    result.setSuccess(true);
    return result;
  }

  @Override
  public ResultResponseType deleteUser(UserRequestType userRequestType) throws SQLException {
    ResultResponseType result = new ResultResponseType();
    if (null == userRequestType || userRequestType.getUserId() == null) {
      result.setMessage("参数异常");
      result.setSuccess(false);
      return result;
    }
    User user = new User();
    user.setUserId(userRequestType.getUserId());
    Usertorole usertorole = new Usertorole();
    usertorole.setUserId(userRequestType.getUserId());
    userDao.delete(user);
    usertoroleDao.delete(usertorole);
    result.setSuccess(true);
    return result;
  }

  @Override
  public CheckHealthResponseType checkHealth(CheckHealthRequestType request) throws Exception {
    return null;
  }


}
