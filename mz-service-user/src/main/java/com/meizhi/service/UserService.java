package com.meizhi.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.meizhi.entity.User;
import com.meizhi.mapper.UserMapper;
import com.meizhi.model.response.QueryResult;
import com.meizhi.user.request.UserQueryParams;
import com.meizhi.user.response.UserDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public QueryResult<User> listUser(Integer pageNum, Integer pageSize, UserQueryParams params){
        PageHelper.startPage(pageNum, pageSize);


        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();

        if(StringUtils.isNotBlank(params.getName())){
            criteria.andLike("name", "%"+params.getName()+"%");
        }


        List<User> users = userMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(users);

        QueryResult queryResult = new QueryResult();
        queryResult.setTotal(pageInfo.getTotal());
        queryResult.setList(pageInfo.getList());

        return queryResult;
    }


    public UserDto getDetaiById(Integer id){
        return userMapper.getDetaiById(id);
    }
}
