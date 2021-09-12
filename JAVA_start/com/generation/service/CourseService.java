package com.generation.service;

import com.generation.model.*;
import com.generation.model.Module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseService
{
    private final Map<String, Course> courses = new HashMap<>(); //to store all the registered courses in the constructor below

    private final Map<String, List<Student>> enrolledStudents = new HashMap<>(); //to store all enrolled students for a particular course

    public CourseService()
    {
        Module module = new Module( "INTRO-CS", "Introduction to Computer Science",
                                    "Introductory module for the generation technical programs" );
        registerCourse( new Course( "INTRO-CS-1", "Introduction to Computer Science", 9, module ) );
        registerCourse( new Course( "INTRO-CS-2", "Introduction to Algorithms", 9, module ) );
        registerCourse( new Course( "INTRO-CS-3", "Algorithm Design and Problem Solving - Introduction ", 9, module ) );
        registerCourse( new Course( "INTRO-CS-4", "Algorithm Design and Problem Solving - Advanced", 9, module ) );
        registerCourse( new Course( "INTRO-CS-5", "Terminal Fundamentals", 9, module ) );
        registerCourse( new Course( "INTRO-CS-6", "Source Control Using Git and Github", 9, module ) );
        registerCourse( new Course( "INTRO-CS-7", "Agile Software Development with SCRUM", 9, module ) );

        Module moduleWebFundamentals = new Module( "INTRO-WEB", "Web Development Fundamentals",
                                                   "Introduction to fundamentals of web development" );
        registerCourse( new Course( "INTRO-WEB-1", "Introduction to Web Applications", 9, moduleWebFundamentals ) );
        registerCourse( new Course( "INTRO-WEB-2", "Introduction to HTML", 9, moduleWebFundamentals ) );
        registerCourse( new Course( "INTRO-WEB-3", "Introduction to CSS", 9, moduleWebFundamentals ) );
        registerCourse( new Course( "INTRO-WEB-4", "Advanced HTML", 9, moduleWebFundamentals ) );
        registerCourse( new Course( "INTRO-WEB-5", "Advanced CSS", 9, moduleWebFundamentals ) );
        registerCourse( new Course( "INTRO-WEB-6", "Introduction to Bootstrap Framework", 9, moduleWebFundamentals ) );
        registerCourse(
            new Course( "INTRO-WEB-7", "Introduction to JavaScript for Web Development", 9, moduleWebFundamentals ) );

    }

    public void registerCourse( Course course )
    {
        courses.put( course.getCode(), course );
    }

    public Course getCourse( String code )
    {
        if ( courses.containsKey( code ) )
        {
            return courses.get( code ); //return value from HashMap courses based on key "code"
        }
        return null;
    }

    public void enrollStudent( String courseId, Student student )
    {
        if ( !enrolledStudents.containsKey( courseId ) )
        {
            enrolledStudents.put( courseId, new ArrayList<>() );
            //for enrolled students who enrolled in NEW courses, thus create a empty ArrayList to store future interested students
        }
        enrolledStudents.get( courseId ).add( student ); //add Student object to existing List for a particular course
    }

    public void showEnrolledStudents( String courseId )
    {
        if ( enrolledStudents.containsKey( courseId ) )
        {
            List<Student> students = enrolledStudents.get( courseId );
            for ( Student student : students )
            {
                System.out.println( student );
            }
        }
    }


    public void showSummary()
    {
        System.out.println( "Available Courses:" );
        for ( String key : courses.keySet() )
        {
            Course course = courses.get( key );
            System.out.println( course );
        }
        System.out.println( "Enrolled Students" );
        for ( String key : enrolledStudents.keySet() )
        {
            List<Student> students = enrolledStudents.get( key );
            System.out.println( "Students on Course " + key + ": " );
            for ( Student student : students )
            {
                System.out.println( student );
            }
        }
    }

    public void averageGrade()
    {

        for ( String key : enrolledStudents.keySet() ) //key refers to the particular courseId
        {
            System.out.println( "Course: " + key );
            List<Student> students = enrolledStudents.get( key ); //List<Student> is used as it is declared above under enrolledStudents
            double sum = 0;
            for ( Student student : students )
            {
                sum = sum + student.getGrade(key);
            }
            double result = sum/students.size();
            System.out.println(String.format("Average Grade: %.2f", result));
        }
    }

}
