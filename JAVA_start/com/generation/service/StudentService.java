package com.generation.service;

import com.generation.model.*;

import java.util.HashMap;
import java.util.Map;

public class StudentService
{
    private final Map<String, Student> students = new HashMap<>(); //store the list of registered students

    public void subscribeStudent( Student student )
    {
        students.put( student.getId(), student );
    }

    public Student findStudent(String studentId )
    {
        if ( students.containsKey( studentId ) )
        {
            return students.get( studentId );
        }
        return null;
    }


    public void showSummary()
    {
        //TODO implement
        for (Student details: students.values()){
            System.out.println(details);
        }
    }

    //added method
    public void showPassedCourses(String studentId)
    {
        //TODO implement
        students.get(studentId).getPassedCourses(); //students.get(studentId) will return a Student object which you can use the .getPassedCourses() method

    }



    public void enrollToCourse( String studentId, Course course )
    {
        if ( students.containsKey( studentId ) )
        {
            students.get( studentId ).enrollToCourse( course );
            //this ".enrollToCourse" method belongs to Student Class, not StudentServices Class
        }
    }


}
