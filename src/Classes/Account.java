package Classes;

public class Account{
    private String userName;
    private String password;

    public Account(String u, String p){
        this.userName = u;
        this.password = p;
    }

    public Account(){

    }
    public String getUserName(){
        return this.userName;
    }
    public String getPassword(){
        return this.password;
    }
    public void setUserName(String s){
        this.userName = s;
    } 

    public void setPassword(String p){
        this.password = p;
    }

}
