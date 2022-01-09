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
  Sql2oDbHandler sql;
  public AccountLogin(){

  }

  public boolean find_account (String username , String password){
    String query = "SELECT user_id , username , userpassword"
        + " FROM user WHERE username = :username AND userpassword = :password ";
    List<Account> account ;

    try (Connection con = sql.getConnector().open()) {
      account = con.createQuery(query)
          .addParameter("username" , username)
          .addParameter("password" , password)
          .executeAndFetch(Account.class);
      if(account!= null & account.size()>0 ) return true;
      else return false;
    }
  }
}
