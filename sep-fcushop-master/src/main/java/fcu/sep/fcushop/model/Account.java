package fcu.sep.fcushop.model;

public class Account {

  private int user_id = 1 ;
  private String username;
  private String password;

  public Account(int user_id, String username, String password) {
    this.user_id = user_id;
    this.username = username;
    this.password = password;
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

  public String getPassword() {return password;}
  public void setPassword(String password) {this.password = password;}

}
