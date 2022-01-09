package fcu.sep.fcushop.controller;

import fcu.sep.fcushop.model.Account;
import fcu.sep.fcushop.service.AccountLogin;
import fcu.sep.fcushop.service.AccountRegister;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.NullLiteral;

import java.util.List;
@RestController
public class AccountController {
  @Autowired
  AccountRegister accountRegister;
  @Autowired
  AccountLogin accountLogin;

  @PostMapping("/register")
  @ResponseBody
  public int register(@RequestParam("username")String username, @RequestParam("password")String password){
  int result = 1;
  System.out.println(username + "+" + password);
    if (accountRegister.find_same_username(username)){
      result = 0 ;
    }
    else {
      accountRegister.insertAccount(username , password);
    }
    System.out.println(result);
    return result;
  }

  @PostMapping("/login")
  @ResponseBody
  public int login(@RequestParam("username")String username, @RequestParam("password")String password){
    int result = 0;
    if (accountLogin.find_account(username , password)){
      result = 1 ;
    }
    return result;
  }
}

//class Account {
//  private String username;
//  private String password;
//
//  public String getUsername() {
//    return username;
//  }
//
//  public void setUsername(String username) {
//    this.username = username;
//  }
//
//  public String getPassword() {
//    return password;
//  }
//
//  public void setPassword(String password) {
//    this.password = password;
//  }
//}