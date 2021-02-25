/********************************************************************************************************************
 ==============================
 Team MMKE
 UTSA CS 3443 Spring 2020
 Term Project
 ==============================
 MainController Class
 ==============================
 ///Description///
 This class:

 ********************************************************************************************************************/

package clubFinderPackage;
///
import clubFinderPackage.model.*;
///
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
///
import java.io.IOException;
import java.util.ArrayList;

public class MainController
{
    //Variables
    public static String currentUser;   //holds the username when you successfully login

    //Labels
    @FXML
    private Button button;
    @FXML
    private TextField textInput;
    @FXML
    private TextArea textOutput;
    @FXML
    private Label lbStatus;
    @FXML
    private TextField txtUserName;
    @FXML
    private TextField txtPassword;
    ///
    @FXML
    private TextField tfCourseName;
    @FXML
    private TextField tfDotw;
    @FXML
    private TextField tfStartTime;
    @FXML
    private TextField tfEndTime;
    @FXML
    private TextField tfWeekly;

    ///     ///     ///LOGIN METHODS///     ///     ///
    /*****************************************************************************************************************
     * ///isUserExist Method///
     *
     * //Description
     * this method stores the username into currentUser and goes to the main menu scene if the user/pass is valid
     * //Parameters
     * ActionEvent event
     * //Return
     * this method is void and will not return anything
     *****************************************************************************************************************/
    public static Boolean validateUserExist(String findUsername) throws IOException
    {
        //Variables
        allUsers tempAllUsers = new allUsers();
        tempAllUsers.loadUser("src/clubFinderPackage/data/profiles.csv");
        user tempUser = new user("tempUsername", "tempPassword");

        //Searching allUsers for a match
        for(int i = 0; i < tempAllUsers.getUserArrayList().size(); i++)
        {
            tempUser = tempAllUsers.getUserArrayList().get(i);
            if(tempUser.getUsername().equals(findUsername))
            {
                return true;
            }
        }
        return false;
    }

    /*****************************************************************************************************************
     * ///createUser Method///
     *
     * //Description
     * this method stores the username into currentUser and goes to the main menu scene if the user/pass is valid
     * //Parameters
     * ActionEvent event
     * //Return
     * this method is void and will not return anything
     *****************************************************************************************************************/
    public void createUser(ActionEvent event) throws Exception
    {
        //Variables
        allUsers tempAllUsers = new allUsers();
        tempAllUsers.loadUser("src/clubFinderPackage/data/profiles.csv");
        String tempUsername = txtUserName.getText();
        String tempPassword = txtPassword.getText();
        boolean isUserExist = validateUserExist(tempUsername);

        //checking if username/password is valid
        if (isUserExist)
        {
            lbStatus.setText("User " + tempUsername + " already exists");
        }
        else
        {
            tempAllUsers.saveUser(tempUsername, tempPassword);
            lbStatus.setText("User " + tempUsername + " created");
        }
    }

    /*****************************************************************************************************************
     * ///validatelogin Method///
     *
     * //Description
     * this method searches all users in profiles.csv and will validate if the input is the same
     * //Parameters
     * takes in a string username and a string password
     * //Return
     * if the username and password match it will return true, otherwise it will return false
     *****************************************************************************************************************/
    public static boolean validateLogin(String findUsername,String findPassword) throws IOException
    {
        //Variables
        allUsers tempAllUsers = new allUsers();
        tempAllUsers.loadUser("src/clubFinderPackage/data/profiles.csv");
        user tempUser = new user("tempUsername", "tempPassword");

        //Searching allUsers for a match
        for(int i = 0; i < tempAllUsers.getUserArrayList().size(); i++)
        {
            tempUser = tempAllUsers.getUserArrayList().get(i);
            if(tempUser.getUsername().equals(findUsername) && tempUser.getPassword().equals(findPassword))
            {
                return true;
            }
        }
        return false;
    }

    /*****************************************************************************************************************
     * ///login Method///
     *
     * //Description
     * this method stores the username into currentUser and goes to the main menu scene if the user/pass is valid
     * //Parameters
     * ActionEvent event
     * //Return
     * this method is void and will not return anything
     *****************************************************************************************************************/
    public void Login(ActionEvent event) throws Exception
    {
        //Variables
        String tempUsername = txtUserName.getText();
        String tempPassword = txtPassword.getText();
        boolean isValidUser = validateLogin(tempUsername, tempPassword);

        //checking if username/password is valid
        if (isValidUser)
        {
            currentUser = txtUserName.getText();
            lbStatus.setText("Login Success");
            goToMenu(event);
        }
        else
        {
            lbStatus.setText("Login Failed");
        }
    }

    ///     ///     ///EDIT SCHEDULE METHODS///     ///     ///
    /*****************************************************************************************************************
     * ///generateUserCourses Method///
     *
     * //Description
     * this method loads all user courses
     * //Parameters
     * no parameters
     * //Return
     * this method is void and will not return anything
     *****************************************************************************************************************/
    @FXML
    public void generateUserCourses() throws IOException
    {
        allCourses tempAllCourses = new allCourses();
        tempAllCourses.loadCourses("src/clubFinderPackage/data/courses.csv", currentUser);

        String stringOutput = "";
        stringOutput = stringOutput.concat(currentUser + " has " + tempAllCourses.getUserCourseArrayList().size() + " courses\n\n");
        stringOutput = stringOutput.concat(tempAllCourses.toString());

        textOutput.setText(stringOutput);
    }

    /*****************************************************************************************************************
     * ///addUserCourses Method///
     *
     * //Description
     * this method adds a course
     * //Parameters
     * no parameters
     * //Return
     * this method is void and will not return anything
     *****************************************************************************************************************/
    @FXML
    public void addUserCourses(ActionEvent event) throws IOException
    {

        String tempCourseName = tfCourseName.getText();
        String tempDotw = tfDotw.getText();
        String tempStartTime = tfStartTime.getText();
        String tempEndTime = tfEndTime.getText();
        String tempWeekly = tfWeekly.getText();

        allCourses tempAllCourses = new allCourses();
        tempAllCourses.loadCourses("src/clubFinderPackage/data/courses.csv", currentUser);
        course newCourse = new course(tempCourseName, tempDotw, tempStartTime, tempEndTime, tempWeekly, currentUser);
        tempAllCourses.addCourse(newCourse);
        tempAllCourses.saveCourses();

        textOutput.setText(tempCourseName + " was added");
    }

    /*****************************************************************************************************************
     * ///removeUserCourses Method///
     *
     * //Description
     * this method removes a course
     * //Parameters
     * no parameters
     * //Return
     * this method is void and will not return anything
     *****************************************************************************************************************/
    @FXML
    public void removeUserCourses() throws IOException
    {
        String tempCourseName = tfCourseName.getText();
        String tempDotw = tfDotw.getText();
        String tempStartTime = tfStartTime.getText();
        String tempEndTime = tfEndTime.getText();
        String tempWeekly = tfWeekly.getText();

        allCourses tempAllCourses = new allCourses();
        tempAllCourses.loadCourses("src/clubFinderPackage/data/courses.csv", currentUser);
        course unwantedCourse = new course(tempCourseName, tempDotw, tempStartTime, tempEndTime, tempWeekly, currentUser);
        tempAllCourses.removeCourse(unwantedCourse);
        tempAllCourses.saveCourses();

        textOutput.setText(tempCourseName + " was removed");
    }

    ///     ///     ///JOINABLE METHODS///     ///     ///
    /*****************************************************************************************************************
     * ///generateJoinableClubs Method///
     *
     * //Description
     * this method loads all joinable clubs and displays it in the fxml
     * //Parameters
     * no parameters
     * //Return
     * this method is void and will not return anything
     *****************************************************************************************************************/
    @FXML
    public void generateJoinableClubs() throws IOException
    {
        //Variables
        String joinableClubsString = "";
        ArrayList<club> joinableClubsList;
        allClubs tempClubs = new allClubs();
        allCourses tempCourses = new allCourses();

        //Loading
        tempClubs.loadClub("src/clubFinderPackage/data/clubs.csv");
        tempCourses.loadCourses("src/clubFinderPackage/data/courses.csv", "yel939");

        //Set arraylist to string
        joinableClubsList = tempClubs.createEligibleClubsList(tempCourses.getUserCourseArrayList());

        joinableClubsString = joinableClubsString.concat(
                currentUser + " has " + joinableClubsList.size() + " clubs available\n\n");
        for(int i = 0; i < joinableClubsList.size(); i++)
        {
            joinableClubsString = joinableClubsString.concat(joinableClubsList.get(i).toString() + "\n");
        }

        textOutput.setText(joinableClubsString);
    }

    ///     ///     ///ALL CLUB METHODS///     ///     ///
    /*****************************************************************************************************************
     * ///generateAllClubs Method///
     *
     * //Description
     * this method loads all clubs and displays it in the fxml
     * //Parameters
     * no parameters
     * //Return
     * this method is void and will not return anything
     *****************************************************************************************************************/
    @FXML
    public void generateAllClubs() throws IOException
    {
        allClubs clubTest = new allClubs();
        clubTest.loadClub("src/clubFinderPackage/data/clubs.csv");
        textOutput.setText(clubTest.toString());
    }

    ///     ///     ///MENU METHODS///     ///     ///
    /*****************************************************************************************************************
     * ///goToMenu Method///
     *
     * //Description
     * this method changes the scene to the menu
     * //Parameters
     * ActionEvent event
     * //Return
     * this method is void and will not return anything
     *****************************************************************************************************************/
    @FXML
    public void goToMenu(ActionEvent event) throws IOException
    {
        Parent newParent = FXMLLoader.load(getClass().getResource("view/menuScene.fxml"));
        Scene newScene = new Scene(newParent);
        Stage newStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        newStage.setScene(newScene);
        newStage.show();
    }

    /*****************************************************************************************************************
     * ///goToJoinableClubs Method///
     *
     * //Description
     * this method changes the scene to the Joinable clubs page
     * //Parameters
     * ActionEvent event
     * //Return
     * this method is void and will not return anything
     *****************************************************************************************************************/
    @FXML
    public void goToJoinableClubs(ActionEvent event) throws IOException
    {
        Parent newParent = FXMLLoader.load(getClass().getResource("view/joinableClubsScene.fxml"));
        Scene newScene = new Scene(newParent);
        Stage newStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        newStage.setScene(newScene);
        newStage.show();
    }

    /*****************************************************************************************************************
     * ///goToAllClubs Method///
     *
     * //Description
     * this method changes the scene to the all clubs page
     * //Parameters
     * ActionEvent event
     * //Return
     * this method is void and will not return anything
     *****************************************************************************************************************/
    @FXML
    public void goToAllClubs(ActionEvent event) throws IOException
    {
        Parent newParent = FXMLLoader.load(getClass().getResource("view/allClubsScene.fxml"));
        Scene newScene = new Scene(newParent);
        Stage newStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        newStage.setScene(newScene);
        newStage.show();
    }

    /*****************************************************************************************************************
     * ///goToEditSchedule Method///
     *
     * //Description
     * this method changes the scene to the edit schedule scene
     * //Parameters
     * ActionEvent event
     * //Return
     * this method is void and will not return anything
     *****************************************************************************************************************/
    @FXML
    public void goToEditSchedule(ActionEvent event) throws IOException
    {
        Parent newParent = FXMLLoader.load(getClass().getResource("view/editScheduleScene.fxml"));
        Scene newScene = new Scene(newParent);
        Stage newStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        newStage.setScene(newScene);
        newStage.show();
    }

    /*****************************************************************************************************************
     * ///quitClubFinder Method///
     *
     * //Description
     * this method closes the application
     * //Parameters
     * no parameters
     * //Return
     * this method is void and will not return anything
     *****************************************************************************************************************/
    @FXML
    public void quitClubFinder() throws IOException
    {
        System.exit(0);
    }
}
