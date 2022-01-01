package fcu.sep.fcushop.controller;

import fcu.sep.fcushop.service.AccountLogin;
import fcu.sep.fcushop.service.AccountRegister;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class AccountController {
  @Autowired
  private AccountRegister accountRegister;
  @Autowired
  private AccountLogin accountLogin;

  @PostMapping("register")
  @ResponseBody
  public int register(@RequestParam("usernameC")String usernameB , @RequestParam("passwordC")String passwordB){
    int check = 1;
    System.out.println("asdasdasdsadsaasdasdasdasdasda");
    if (accountRegister.find_same_username(usernameB)) check = 0;
    else accountRegister.insertAccount(usernameB , passwordB);
    return check;
  }

  @PostMapping("/login")
  @ResponseBody
  public int login(@RequestParam("username")String username , @RequestParam("password")String password){
    int check = 0;
    if (accountLogin.find_account(username , password)) check = 1 ;
    return check;
  }
}