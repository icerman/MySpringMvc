package Util;

import org.apache.ibatis.annotations.Param;

import com.zsx.web.entity.User;

public interface UserMapper {
	
    int deleteByPrimaryKey(@Param(value="id")String id);

    int insert(User user);

    User selectByPrimaryKey(@Param(value="id")String id);


	
}