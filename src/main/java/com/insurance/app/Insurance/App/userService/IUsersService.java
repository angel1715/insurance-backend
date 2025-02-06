package com.insurance.app.Insurance.App.userService;

import com.insurance.app.Insurance.App.model.Users;

import java.util.List;

public interface IUsersService {

    //method to bring all the records from the DB
    public List<Users> listUsers();

    public Users findUserById(Long id);

    //method to save/register/insert a new user into the DB
    public Users saveUser(Users user);

    public void deleteUser(Users user);
}
