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

import java.io.*;
import java.util.ArrayList;

public class allClubs
{
    //Variables
    ArrayList<club> clubArrayList;

    //Constructor
    public allClubs() { clubArrayList = new ArrayList<club>(); }

    //Getters
    public ArrayList<club> getClubArrayList() { return clubArrayList; }

    //Setters
    public void setClubArrayList(ArrayList<club> clubArrayList) { this.clubArrayList = clubArrayList; }

    /*****************************************************************************************************************
     * ///createEligibleClubsList Method///
     *
     * //Description
     * this method checks to see if each club conflicts with your courses
     * //Parameters
     * you pass in the arrayList of courses for the user
     * //Return
     * it returns an arraylist of all eligible clubs
     *****************************************************************************************************************/
    public ArrayList<club> createEligibleClubsList(ArrayList<course> courseArrayList)
    {
        ArrayList<club> eligible = new ArrayList<club>();
        for(int clubIndex = 0; clubIndex < clubArrayList.size(); clubIndex++)
        {
            boolean isEligible = true;
            club currentClub = clubArrayList.get(clubIndex);
            for(int courseIndex = 0; courseIndex < courseArrayList.size(); courseIndex++)
            {
                course currentCourse = courseArrayList.get(courseIndex);
                if(currentCourse.getDotw().equals(currentClub.getDotw()))
                {
                    int clubStart = Integer.parseInt(currentClub.getStartTime());
                    int clubEnd = Integer.parseInt(currentClub.getEndTime());
                    int courseStart = Integer.parseInt(currentCourse.getStartTime());
                    int courseEnd = Integer.parseInt(currentCourse.getEndTime());

                    if((clubStart >= courseStart && clubStart <= courseEnd) || (courseStart >= clubStart && courseStart <= clubEnd))
                    {
                        isEligible = false;
                    }//club starts during class or class starts during club
                    else
                    {
                        if((clubEnd >= courseStart && clubEnd <= courseEnd) || (courseEnd >= clubStart && courseEnd <= clubEnd))
                        {
                            isEligible = false;
                        }//club ends during class or class ends during club
                        else
                        {
                            if(clubStart == courseStart && clubEnd == courseEnd)
                            {
                                isEligible = false;
                            }//club completely overlaps class
                        }
                    }
                }//club is same day as course
            }
//            System.out.println(isEligible + " " + currentClub.getClubName());
            if(isEligible == true)
            {
                eligible.add(currentClub);
            }//club has no overlap
        }

        return eligible;
    }

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
    public void loadClub(String path) throws IOException
    {
        try(BufferedReader clubFileReader = new BufferedReader(new FileReader(path)))
        {
            String line;
            while((line = clubFileReader.readLine()) != null)
            {
                String[] column = line.split(",");
                club fileClub = new club(column[0], column[1], column[2], column[3], column[4]);
                clubArrayList.add(fileClub);
            }
            clubFileReader.close();
        }
        catch (IOException e)
        {
            // exception handling
        }
    }


    /*****************************************************************************************************************
     * ///toString Method///
     *
     * //Description
     * this method displays the content in clubArrayList in the string content
     * //Parameters
     * no parameters
     * //Return
     * returns a string var named content
     *****************************************************************************************************************/
    public String toString()
    {
        String content = "";

        for (int i = 0; i < clubArrayList.size(); i++)
        {
            content = content.concat(clubArrayList.get(i).toString());
            content = content.concat("\n");
        }
        return content;
    }

    //END OF CLASS
}
