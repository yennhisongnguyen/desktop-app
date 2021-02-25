/********************************************************************************************************************
 ==============================
 Team MMKE
 UTSA CS 3443 Spring 2020
 Term Project
 ==============================
 course Class
 ==============================
 ///Description///

 ********************************************************************************************************************/
package clubFinderPackage.model;

public class course {
	//Variables
	String courseName;
	String dotw;
	String startTime;
	String endTime;
	String weekly;
	String username;
	
	//Constructor
	public course(String courseName, String dotw, String startTime, String endTime, String weekly, String username)
    {
        this.courseName = courseName;
        this.dotw = dotw;
        this.startTime = startTime;
        this.endTime = endTime;
        this.weekly = weekly;
        this.username = username;
    }
	
	//Getters
    public String getCourseName() { return courseName; }
    public String getDotw() { return dotw; }
    public String getStartTime() { return startTime; }
    public String getEndTime() { return endTime; }
    public String getWeekly() { return weekly; }
    public String getUsername() { return username; }

    //Setters
    public void setCourseName(String courseName) { this.courseName = courseName; }
    public void setDotw(String dotw) { this.dotw = dotw; }
    public void setStartTime(String startTime) { this.startTime = startTime; }
    public void setEndTime(String endTime) { this.endTime = endTime; }
    public void setWeekly(String weekly) { this.weekly = weekly; }
    public void setUsername(String username) { this.username = username; }

    /*****************************************************************************************************************
     * ///isEqual Method///
     *
     * //Description
     *
     * //Parameters
     *
     * //Return
     *
     *****************************************************************************************************************/
    public boolean isEqual(course compareClass)
    {
    	boolean same = false;
    	if(this.getCourseName().equals(compareClass.getCourseName()))
    	{
    		if(this.getDotw().equals(compareClass.getDotw()))
    		{
    			if(this.getStartTime().equals(compareClass.getStartTime()))
    			{
    				if(this.getEndTime().equals(compareClass.getEndTime()))
    				{
    					if(this.getWeekly().equals(compareClass.getWeekly()))
    					{
    						if(this.getUsername().equals(compareClass.getUsername()))
    							same = true;
    					}
    				}
    			}
    		}
    	}
    	return same;
    }
    
    /*****************************************************************************************************************
     * ///toString Method///
     *
     * //Description
     * this method displays the each var in the course into a single string var
     * //Parameters
     * no parameters
     * //Return
     * returns a string var named content
     *****************************************************************************************************************/
    public String toString()
    {
        String content = "";
        content = content.concat(courseName + ", " + dotw + " (" + startTime + " - " + endTime + ") " + weekly );
        return content;
    }

    //END OF CLASS
}
