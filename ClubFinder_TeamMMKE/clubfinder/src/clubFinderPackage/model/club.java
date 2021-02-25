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

public class club
{
    //Variables
    String clubName;    //name of the club
    String dotw;        //day of the week 1-7 starting from monday
    String startTime;   //start time in 24 hour format (1230)
    String endTime;     //end time in 24 hour format (1230)
    String weekly;      //Weekly, Biweekly, Monthly

    //Constructor
    public club(String clubName, String dotw, String startTime, String endTime, String weekly)
    {
        this.clubName = clubName;
        this.dotw = dotw;
        this.startTime = startTime;
        this.endTime = endTime;
        this.weekly = weekly;
    }

    //Getters
    public String getClubName() { return clubName; }
    public String getDotw() { return dotw; }
    public String getStartTime() { return startTime; }
    public String getEndTime() { return endTime; }
    public String getWeekly() { return weekly; }

    //Setters
    public void setClubName(String clubName) { this.clubName = clubName; }
    public void setDotw(String dotw) { this.dotw = dotw; }
    public void setStartTime(String startTime) { this.startTime = startTime; }
    public void setEndTime(String endTime) { this.endTime = endTime; }
    public void setWeekly(String weekly) { this.weekly = weekly; }


    /*****************************************************************************************************************
     * ///toString Method///
     *
     * //Description
     * this method displays the each var in the club into a single string var
     * //Parameters
     * no parameters
     * //Return
     * returns a string var named content
     *****************************************************************************************************************/
    public String toString()
    {
        String content = "";
        content = content.concat(clubName + ", " + dotw + " (" + startTime + " - " + endTime + ") " + weekly );
        return content;
    }

    //END OF CLASS
}
