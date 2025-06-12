package model;

public class Compte {
    private int id;
    private String login;
    private String password;
    private String role;
    
    // Constructeurs
    public Compte() {}
    
    public Compte(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }
    
    // Getters et setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getLogin() {
        return login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
}