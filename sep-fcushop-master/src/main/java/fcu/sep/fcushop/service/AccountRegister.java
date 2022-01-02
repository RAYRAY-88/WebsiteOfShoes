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
  public boolean find_same_username (String Username){
    String query = "select user_id , username  , userpassword"
        + " from user where username = :Username";
    List<Account> account ;

    try (Connection con = sql.getConnector().open()) {
      account = con.createQuery(query)
          .addParameter("username", Username)
          .executeAndFetch(Account.class);
      if(account!= null & account.size()>0 )return true;
      else return false;
    }
  }

  public void insertAccount( String Username , String Password){
    String insertQuery =
        "INSERT INTO Account (username , userpassword) "
            + "VALUES (:Username , :Password)";
    try (Connection con = sql.getConnector().open()) {
      con.createQuery(insertQuery)
          .addParameter("username",Username )//account.getUName()
          .addParameter("password",Password) //account.getPassword()
          .executeUpdate();
    }
  }
}
