package com.insurance.app.Insurance.App.controllers;

import com.insurance.app.Insurance.App.model.Users;
import com.insurance.app.Insurance.App.userService.UsersServiceImpl;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(value = "https://react-insurance-app.vercel.app/")
@RequestMapping("/auth")
@EnableMethodSecurity
public class UsersRestController {

    @Autowired
    private UsersServiceImpl usersService;

    @Autowired
    private PasswordEncoder passwordEncoder;
    private final String SECRET_KEY = "lguguigighoihoigiugucfkjhgihoihbpoh";

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Users user){
        var savedUser = usersService.saveUser(user);
        return ResponseEntity.ok(savedUser);
    }
    @PreAuthorize("permitAll()")
    @GetMapping("/listUsers")
    public List<Users> listAllUsers(){
      return usersService.listUsers();

    }

    @PreAuthorize("permitAll()")
    @PutMapping("/fileClaim/{password}")
    public ResponseEntity<?>fileClaim(@PathVariable String password, @RequestBody Users user){
      Users User = usersService.findUserById(user.getId());

      if(User.getNumberOfClaim() < User.getClaimAllowance()){
          User.setPassword(password);
          User.setNumberOfClaim(User.getNumberOfClaim() + 1);
          usersService.saveUser(User);
          return ResponseEntity.ok(User);
      }

          return ResponseEntity.ok("You've reached your claim limit");


    }

    @PostMapping("/login/{email}/{password}")
    public ResponseEntity<?> login(@PathVariable String email, @PathVariable String password){

        var usersDB = listAllUsers();
        for(Users u: usersDB){
            if(u.getEmail().equals(email) && new BCryptPasswordEncoder().matches(password, u.getPassword())){

                String token = Jwts.builder().setSubject(u.getfName()).
                        setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + 3600000)).
                        signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()), SignatureAlgorithm.HS256).compact();

                u.setPassword(null);
                return ResponseEntity.ok(Map.of("jwt", token, "user", u));
            }
        }
        return null;
    }
}
