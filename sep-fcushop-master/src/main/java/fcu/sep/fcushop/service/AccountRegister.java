package fcu.sep.fcushop.service;

import fcu.sep.fcushop.database.Sql2oDbHandler;
import fcu.sep.fcushop.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.*;
import java.util.List;

@Service
public class AccountRegister {

  @Autowired
  private Sql2oDbHandler sql;
  public AccountRegister() {

  }
  public boolean find_same_username (String username){
    String query = "select user_id , username  , userpassword"
        + " from user where username = :username";
    List<Account> accounts ;

    try (Connection con = sql.getConnector().open()) {
      accounts = con.createQuery(query)
          .addParameter("username", username)
          .executeAndFetch(Account.class);
      if(accounts!= null & accounts.size()>0 ){
        return true;
      }
      else return false;
    }
  }

  public void insertAccount( String username, String password){
    String insertQuery =
        "INSERT INTO account ( username, userpassword) "
            + "VALUES (:username, :password)";
    try (Connection con = sql.getConnector().open()) {
      con.createQuery(insertQuery)
          .addParameter("username",username )//account.getUName()
          .addParameter("userpassword",password) //account.getPassword()
          .executeUpdate();
    }
  }
}
