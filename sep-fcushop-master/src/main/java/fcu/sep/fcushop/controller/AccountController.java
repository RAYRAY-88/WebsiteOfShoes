package fcu.sep.fcushop.controller;

import fcu.sep.fcushop.service.AccountLogin;
import fcu.sep.fcushop.service.AccountRegister;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class AccountController {
  @Autowired
  AccountRegister accountRegister = new AccountRegister();
  @Autowired
  AccountLogin accountLogin = new AccountLogin();

  @PostMapping("/register")
  @ResponseBody
  public int register(@RequestParam("username")String username, @RequestParam("password")String password){
    int result = 1;
    if (accountRegister.find_same_username(username)){
      result = 0 ;
    }
    else {
      accountRegister.insertAccount(username,password);
    }
    return result;
  }

  @PostMapping("/login")
  @ResponseBody
  public int login(@RequestParam("username")String username, @RequestParam("password")String password){
    int result = 0;
    if (accountLogin.find_account(username,password)){
      result = 1 ;
    }
    return result;
  }
}