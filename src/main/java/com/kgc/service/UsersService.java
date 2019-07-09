package com.kgc.service;

import com.kgc.entity.Users;
import com.kgc.utils.UsersParam;

import java.util.List;

public interface UsersService {
    public List<Users> getUsers(UsersParam usersParam);
}
