/********************************************************************************************************************
 ==============================
 Team MMKE
 UTSA CS 3443 Spring 2020
 Term Project
 ==============================
 club Class
 ==============================
 ///Description///

 ********************************************************************************************************************/
package clubFinderPackage.model;

public class user
{
    //Variables
    String username;
    String password;

    //Constructor
    public user(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    //Getter
    public String getUsername() { return username; }
    public String getPassword() { return password; }

    //Setter
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }

    /*****************************************************************************************************************
     * ///toString Method///
     *
     * //Description
     * this method displays the each var in the user into a single string var
     * //Parameters
     * no parameters
     * //Return
     * returns a string var named content
     *****************************************************************************************************************/
    public String toString()
    {
        String content = "";
        content = content.concat(username + ", " + password);
        return content;
    }

    //END OF CLASS

}
