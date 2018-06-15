package servcie;

import com.ctriposs.baiji.rpc.common.BaijiContract;
import com.ctriposs.baiji.rpc.common.types.CheckHealthRequestType;
import com.ctriposs.baiji.rpc.common.types.CheckHealthResponseType;
import dto.UserDto;
import java.sql.SQLException;
import request.UserRequestType;
import response.ResultResponseType;
import response.UserListResponseType;

@SuppressWarnings("all")
@BaijiContract(serviceName = "soaService_djxu", serviceNamespace = "http://soa.ctrip.com/tour/SearchService/v1", codeGeneratorVersion = "BJCG-2.4.5.25")
public interface UserService {

    /**
     *
     *查询用户
     */
    public UserListResponseType selectList(UserRequestType user) throws SQLException;

//    /**
//     * 查询单个用户详情
//     */
//
//    public UserDto selectOne(UserRequestType user) throws SQLException;

    /**
     * 新增用户
     *
     */
    public ResultResponseType addUser(UserRequestType user) throws SQLException;

    /**
     * 修改用户
     *
     */
    public ResultResponseType updateUser(UserRequestType user) throws SQLException;

    /**
     * 删除用户
     *
     */
    public ResultResponseType deleteUser(UserRequestType user) throws SQLException;

    CheckHealthResponseType checkHealth(CheckHealthRequestType request) throws Exception;
}