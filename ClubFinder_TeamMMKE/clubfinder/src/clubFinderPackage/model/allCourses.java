/********************************************************************************************************************
 ==============================
 Team MMKE
 UTSA CS 3443 Spring 2020
 Term Project
 ==============================
 allCourses Class
 ==============================
 ///Description///

 ********************************************************************************************************************/
package clubFinderPackage.model;

import java.io.*;
import java.util.ArrayList;

public class allCourses
{
	//Variables
	ArrayList<course> userCourseArrayList;
	ArrayList<course> fullCourseArrayList;

	//Constructor
	public allCourses()
	{
		userCourseArrayList = new ArrayList<course>();
		fullCourseArrayList = new ArrayList<course>();
	}

	//Getters
	public ArrayList<course> getUserCourseArrayList() { return userCourseArrayList; }
	public ArrayList<course> getFullCourseArrayList() { return fullCourseArrayList; }

	//Setters
	public void setUserCourseArrayList(ArrayList<course> userCourseArrayList) { this.userCourseArrayList = userCourseArrayList; }
	public void setFullCourseArrayList(ArrayList<course> fullCourseArrayList) { this.fullCourseArrayList = fullCourseArrayList; }

	/*****************************************************************************************************************
	 * ///addCourse Method///
	 *
	 * //Description
	 * this method adds a course to the fullCourseArrayList and userCourseArrayList if it doesnt already exist
	 * //Parameters
	 * you pass in a course
	 * //Return
	 * it is void and wont return anything
	 *****************************************************************************************************************/
	public void addCourse(course newCourse)
	{
		boolean exists = false;
		for(int index = 0; index < fullCourseArrayList.size(); index++)
		{
			if(newCourse.isEqual(fullCourseArrayList.get(index)))
			{
				exists = true;
			}
		}
		if(exists == false)
		{
			fullCourseArrayList.add(newCourse);
			userCourseArrayList.add(newCourse);
		}
		else
		{
			System.out.println("Duplicate course not added.");
		}
	}
	/*****************************************************************************************************************
	 * ///removeCourse Method///
	 *
	 * //Description
	 * this method searches for a course and removes it from the fullCourseArrayList and userCourseArrayList
	 * //Parameters
	 * you pass in a course you want to remove
	 * //Return
	 * it is void and will not return anything
	 *****************************************************************************************************************/
	public void removeCourse(course findCourse)
	{
		//full
		for(int index = 0; index < fullCourseArrayList.size(); index++)
		{
			if(findCourse.isEqual(fullCourseArrayList.get(index)))
			{
				fullCourseArrayList.remove(index);
			}
		}
		//user
		for(int index = 0; index < userCourseArrayList.size(); index++)
		{
			if(findCourse.isEqual(userCourseArrayList.get(index)))
			{
				userCourseArrayList.remove(index);
			}
		}
	}

	/*****************************************************************************************************************
	 * ///loadCourse Method///
	 *
	 * //Description
	 * this method loads courses from a csv file and adds them to userCourseArrayList and fullCourseArrayList
	 * //Parameters
	 * it takes in a string path to a file to read from
	 * //Return
	 * the method is void and will not return anything
	 *****************************************************************************************************************/
	public void loadCourses(String path, String username) throws IOException
	{
		try(BufferedReader courseFileReader = new BufferedReader(new FileReader(path)))
		{
			String line;
			while((line = courseFileReader.readLine()) != null)
			{
				String[] column = line.split(",");
				course fileCourse = new course(column[0], column[1], column[2], column[3], column[4], column[5]);
				if(column[5].equals(username))
				{
					userCourseArrayList.add(fileCourse);

            		/*System.out.println("coursetest\n");
            		System.out.println(fileCourse.toString());*/
				}
				fullCourseArrayList.add(fileCourse);

			}
			courseFileReader.close();
		}
		catch (IOException e)
		{
			// exception handling
		}
	}

	/*****************************************************************************************************************
	 * ///saveCourse Method///
	 *
	 * //Description
	 * this method writes the current fullCourseArrayList to the courses.csv file
	 * //Parameters
	 * none
	 * //Return
	 * it is void so it wont return anything
	 *****************************************************************************************************************/
	public void saveCourses() throws IOException
	{
		FileWriter courseWriter = new FileWriter("src/clubFinderPackage/data/courses.csv");
		for(int index = 0; index < fullCourseArrayList.size(); index++)
		{
			courseWriter.append(fullCourseArrayList.get(index).getCourseName());
			courseWriter.append(",");
			courseWriter.append(fullCourseArrayList.get(index).getDotw());
			courseWriter.append(",");
			courseWriter.append(fullCourseArrayList.get(index).getStartTime());
			courseWriter.append(",");
			courseWriter.append(fullCourseArrayList.get(index).getEndTime());
			courseWriter.append(",");
			courseWriter.append(fullCourseArrayList.get(index).getWeekly());
			courseWriter.append(",");
			courseWriter.append(fullCourseArrayList.get(index).getUsername());
			courseWriter.append("\n");
		}

		courseWriter.close();
	}

	/*****************************************************************************************************************
	 * ///addSingleCourse Method///
	 *
	 * //Description
	 * this method writes a single course to the courses.csv file
	 * //Parameters
	 * 6 strings
	 * //Return
	 * it is void so it wont return anything
	 *****************************************************************************************************************/
	public static void addSingleCourse(String courseName, String Dotw, String startTime, String endTime, String weekly, String user) throws IOException
	{
		File fileCourses = new File("src/clubFinderPackage/data/courses.csv");
		FileWriter frCourses = new FileWriter(fileCourses, true);
		BufferedWriter brCourses = new BufferedWriter(frCourses);

		String addedCourse = "";
		addedCourse = addedCourse.concat
				("\n" + courseName + "," + Dotw + "," + startTime + "," + endTime + "," +weekly + "," + user );
		brCourses.write(addedCourse);

		brCourses.close();
		frCourses.close();
	}

	/*****************************************************************************************************************
	 * ///toString Method///
	 *
	 * //Description
	 * this method displays the content in fullCourseArrayList in the string content
	 * //Parameters
	 * no parameters
	 * //Return
	 * returns a string var named content
	 *****************************************************************************************************************/
	public String toString()
	{
		String content = "";

		for (int i = 0; i < userCourseArrayList.size(); i++)
		{
			content = content.concat(userCourseArrayList.get(i).toString());
			content = content.concat("\n");
		}
		return content;
	}

	//END OF CLASS
}
