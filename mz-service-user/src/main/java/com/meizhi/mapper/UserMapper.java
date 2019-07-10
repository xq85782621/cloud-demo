package com.meizhi.mapper;

import com.meizhi.entity.User;
import com.meizhi.user.response.UserDto;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
@Repository
public interface UserMapper extends Mapper<User> {

    UserDto getDetaiById(Integer id);

}
