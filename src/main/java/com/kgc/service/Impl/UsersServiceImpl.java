package com.kgc.service.Impl;

import com.kgc.entity.Users;
import com.kgc.entity.UsersExample;
import com.kgc.mapper.UsersMapper;
import com.kgc.service.UsersService;
import com.kgc.utils.UsersParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;
    @Override
    public List<Users> getUsers(UsersParam usersParam) {
        UsersExample usersExample=new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        if(usersParam!=null){
            if(usersParam.getUsercode()!=null&&!usersParam.getUsercode().equals( "" )&&
                    usersParam.getPassword()!=null&&!usersParam.getPassword().equals( "" )){
                criteria.andUsercodeEqualTo( usersParam.getUsercode() );
                criteria.andPasswordEqualTo( usersParam.getPassword() );
            }
        }
        List<Users> list = usersMapper.selectByExample( usersExample );
        return list;
    }
}
