package com.insurance.app.Insurance.App.userService;

import com.insurance.app.Insurance.App.model.Users;
import com.insurance.app.Insurance.App.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements IUsersService{

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private  PasswordEncoder passwordEncoder;

    @Override
    public List<Users> listUsers() {
        return usersRepository.findAll();
    }

    @Override
    public Users findUserById(Long id) {
        return usersRepository.
                findById(id).orElse(null);
    }

    @Override
    public Users saveUser(Users user) {
        if(user.getPlan().equals("Basic device protection")){
          user.setClaimAllowance(3);
        } else if (user.getPlan().equals("Protection 360")) {
            user.setClaimAllowance(5);
        } else if (user.getPlan().equals("Premium care")) {
            user.setClaimAllowance(7);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return usersRepository.save(user);
    }

    @Override
    public void deleteUser(Users user) {
      usersRepository.delete(user);
    }
}
