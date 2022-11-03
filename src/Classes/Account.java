package Classes;

public class Account{
    private String userName;
    private String password;
    private boolean isAdmin;

    public Account(String u, String p, boolean isAdmin){
        this.userName = u;
        this.password = p;
        this. isAdmin = isAdmin;
    }

    public Account(){

    }
    public String getUserName(){
        return this.userName;
    }
    public String getPassword(){
        return this.password;
    }
    public boolean getIsAdmin(){
        return this.isAdmin;
    }
    public void setUserName(String s){
        this.userName = s;
    } 

    public void setPassword(String p){
        this.password = p;
    }
    public void setIsAdmin(boolean isAdmin){
        this.isAdmin = isAdmin;
    }


}
