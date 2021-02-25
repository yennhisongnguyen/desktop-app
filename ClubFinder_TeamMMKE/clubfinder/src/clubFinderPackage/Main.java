/********************************************************************************************************************
 ==============================
 Team MMKE
 UTSA CS 3443 Spring 2020
 Term Project
 ==============================

 ///Purpose///

 ///Command Parameters///

 ///Input///

 ///Results///

 ///Returns///

 ///Notes///

 ********************************************************************************************************************/
package clubFinderPackage;

//Import
import java.io.IOException;
///
import clubFinderPackage.model.course;
import clubFinderPackage.model.allClubs;
import clubFinderPackage.model.allCourses;
///
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{

    @Override
    public void start(Stage stage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("view/loginScene.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Club Finder");
        stage.show();
    }

    public static void main(String[] args) throws IOException
    {
        launch(args);

//        //Testing
//        allClubs clubTest = new allClubs();
//        clubTest.loadClub("src/clubFinderPackage/data/clubs.csv");
//        System.out.println("---All Clubs---");
//        System.out.println(clubTest);
//
//        allCourses courseTest = new allCourses();
//        courseTest.loadCourses("src/clubFinderPackage/data/courses.csv", "yel939");
//        System.out.println("---All Courses for User---");
//        System.out.println(courseTest);
//
//        System.out.println("---Do Classes Conflict---");
//        clubTest.createEligibleClubsList(courseTest.getCourseArrayList());
//        System.out.println(clubTest.createEligibleClubsList(courseTest.getCourseArrayList()));
//
//        System.out.println("\n---Add and Remove Courses---");
//        course testAddCourse = new course("addedCourse", "Monday", "900","1000","Weekly","yel939");
//        courseTest.addCourse(testAddCourse);
//        courseTest.saveCourses();
////        courseTest.removeCourse(testAddCourse);
//        System.out.println(courseTest);

    }
}
