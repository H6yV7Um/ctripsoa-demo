package impl;

import static org.junit.Assert.*;

import Dao.UserDao;
import Entity.User;
import com.ctrip.platform.dal.dao.DalClient;
import dto.UserDto;
import org.junit.Test;
import request.UserRequestType;
import response.ResultResponseType;
import response.UserListResponseType;
import servcie.UserService;

/**
 * Created by djxu on 2018/6/14.
 */
public class UserServiceImplTest {


  @Test
  public void selectList() throws Exception {
    UserRequestType userRequestType=new UserRequestType();
    userRequestType.setUserName("a");
    UserService userService=new UserServiceImpl();
    UserListResponseType userListResponseType=userService.selectList(userRequestType);
    for(UserDto userDto:userListResponseType.getList()){
      System.out.println(userDto.getUserName());
    }
  }



  @Test
  public void addUser() throws Exception {
    UserRequestType userRequestType=new UserRequestType();
    userRequestType.setUserName("a");
    userRequestType.setUserId(1);
    userRequestType.setPassword("3fwefwe");
    UserService userService=new UserServiceImpl();
    userService.addUser(userRequestType);
  }

  @Test
  public void updateUser() throws Exception {
  }

  @Test
  public void deleteUser() throws Exception {
  }

}