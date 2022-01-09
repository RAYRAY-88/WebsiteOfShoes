package fcu.sep.fcushop.service;

import fcu.sep.fcushop.database.Sql2oDbHandler;
import fcu.sep.fcushop.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.*;
import java.util.List;

import java.util.List;

@Service
public class AccountRegister {

  @Autowired
  Sql2oDbHandler sql;
  public AccountRegister() {

  }
  public boolean find_same_username (String username){
    String query = "select user_id , username  , password"
        + " from user where username = :username";
    List<Account> account ;

    try (Connection con = sql.getConnector().open()) {
      account = con.createQuery(query)
          .addParameter("username", username)
          .executeAndFetch(Account.class);
      if(account!= null & account.size()>0 )return true;
      else return false;
    }
  }

  public void insertAccount( String username , String password){
    String insertQuery =
        "INSERT INTO user (username , password)" +
            "VALUES (:username , :password)";
    try (Connection con = sql.getConnector().open()) {
      con.createQuery(insertQuery)
          .addParameter("username",username )//account.getUName()
          .addParameter("password",password) //account.getPassword()
          .executeUpdate();
    }
  }
}
