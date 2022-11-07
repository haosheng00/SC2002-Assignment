package classes;

public class Account{
    private String userName;
    private String password;
    private boolean isAdmin;

    public Account(String username, String password, boolean isAdmin){
        this.userName = username;
        this.password = password;
        this.isAdmin = isAdmin;
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
