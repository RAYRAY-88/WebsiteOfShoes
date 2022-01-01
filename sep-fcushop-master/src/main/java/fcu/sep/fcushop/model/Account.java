package fcu.sep.fcushop.model;

public class Account {

  private int user_id = 1 ;
  private String username;
  private String userpassword;

  public Account(int user_id, String username, String userpassword) {
    this.user_id = user_id;
    this.username = username;
    this.userpassword = userpassword;
  }

  public Account(){

  }
  public int getID() {
    return user_id;
  }
  public void setID(int ID) {
    this.user_id = ID;
  }

  public String getUName() {
    return username;
  }
  public void setUName(String name) {
    this.username = name;
  }

  public String getPassword() {return userpassword;}
  public void setPassword(String password) {this.userpassword = password;}

}
