/********************************************************************************************************************
 ==============================
 Team MMKE
 UTSA CS 3443 Spring 2020
 Term Project
 ==============================
 allClubs Class
 ==============================
 ///Description///

 ********************************************************************************************************************/
package clubFinderPackage.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class allUsers
{

    //Variables
    ArrayList<user> userArrayList;

    //Constructor
    public allUsers() { userArrayList = new ArrayList<user>(); }

    //Getters
    public ArrayList<user> getUserArrayList() { return userArrayList; }

    //Setters
    public void setUserArrayList(ArrayList<user> userArrayList) { this.userArrayList = userArrayList; }


    /*****************************************************************************************************************
     * ///loadClub Method///
     *
     * //Description
     * this method loads clubs from a csv file and adds them to clubArrayList
     * //Parameters
     * it takes in a string path to a file to read from
     * //Return
     * the method is void and will not return anything
     *****************************************************************************************************************/
    public void loadUser(String path) throws IOException
    {
        try(BufferedReader userFileReader = new BufferedReader(new FileReader(path)))
        {
            String line;
            while((line = userFileReader.readLine()) != null)
            {
                String[] column = line.split(",");
                user fileUser = new user(column[0], column[1]);
                userArrayList.add(fileUser);
            }
            userFileReader.close();
        }
        catch (IOException e)
        {
            // exception handling
        }
    }

    /*****************************************************************************************************************
     * ///saveUser Method///
     *
     * //Description
     * this method writes the appends a username,password to profiles.csv
     * //Parameters
     * string username and string password
     * //Return
     * it is void so it wont return anything
     *****************************************************************************************************************/
    public void saveUser(String username, String password) throws IOException
    {
        userArrayList.add(new user(username, password));
        FileWriter courseWriter = new FileWriter("src/clubFinderPackage/data/profiles.csv");
        for(int index = 0; index < userArrayList.size(); index++)
        {
            courseWriter.append(userArrayList.get(index).getUsername()).append(",").append(userArrayList.get(index).getPassword()).append("\n");
        }
        courseWriter.close();
    }

    /*****************************************************************************************************************
     * ///toString Method///
     *
     * //Description
     * this method displays the content in userArrayList in the string content
     * //Parameters
     * no parameters
     * //Return
     * returns a string var named content
     *****************************************************************************************************************/
    public String toString()
    {
        String content = "";

        for (int i = 0; i < userArrayList.size(); i++)
        {
            content = content.concat(userArrayList.get(i).toString());
            content = content.concat("\n");
        }
        return content;
    }

    //END OF CLASS
}
