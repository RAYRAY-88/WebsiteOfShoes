package fcu.sep.fcushop.service;

import fcu.sep.fcushop.database.Sql2oDbHandler;
import fcu.sep.fcushop.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.*;
import java.util.List;

@Service
public class AccountLogin {

  @Autowired
  private Sql2oDbHandler sql;
  public AccountLogin(){}

  public boolean find_account (String username, String password){
    String query = "SELECT user_id , username  , userpassword"
        + " FROM user WHERE username = :username AND userpassword = :password ";
    List<Account> accounts ;

    try (Connection con = sql.getConnector().open()) {
      accounts = con.createQuery(query)
          .addParameter("username", username)
          .addParameter("userpassword", password)
          .executeAndFetch(Account.class);

      if(accounts!= null & accounts.size()>0 ){
        return true;
      }
      else return false;
    }
  }
}
