package com.generation;

import com.generation.model.*;
import com.generation.service.CourseService;
import com.generation.service.StudentService;
import com.generation.utils.PrinterHelper;

import java.text.ParseException;
import java.util.Scanner;

public class Main
{

    public static void main( String[] args )
        throws ParseException
    {
        StudentService studentService = new StudentService(); //create new StudentService object to invoke the methods under StudentService Class
        CourseService courseService = new CourseService();  //create new CourseService object to invoke the methods under CourseService Class
        Scanner scanner = new Scanner( System.in );
        int option = 0;
        do
        {
            PrinterHelper.showMainMenu();
            option = scanner.nextInt();
            switch ( option )
            {
                case 1:
                    registerStudent( studentService, scanner ); //when selected, it will execute studentService method
                    break;
                case 2:
                    findStudent( studentService, scanner );
                    break;
                case 3:
                    gradeStudent( studentService, scanner );
                    break;
                case 4:
                    enrollStudentToCourse( studentService, courseService, scanner );
                    break;
                case 5:
                    showStudentsSummary( studentService, scanner );
                    break;
                case 6:
                    showCoursesSummary( courseService, scanner );
                    break;
                case 7:
                    showPassedCourses( studentService, scanner );
                    break;
                case 8:
                    showAverageGrade( courseService, scanner );
                    break;
                //need to include case 7-ShowPassedCourses and 8-ShowAverageGrade
                case 9:
                    exitProgram(scanner );
                    break;
            }
        }
        while ( option != 10 );//MainMenu will keep showing on terminal after each input
    }

    private static void enrollStudentToCourse( StudentService studentService, CourseService courseService,
                                               Scanner scanner )
    {
        //TODO implement
        System.out.println( "Insert student ID" );
        String studentId = scanner.next();
        Student student = studentService.findStudent( studentId ); // create new Student object to invoke Student class method (.findStudent())
        if ( student == null )
        {
            System.out.println( "Invalid Student ID" );
            return;
        }
        System.out.println( student );
        System.out.println( "Insert course ID" );
        String courseId = scanner.next();
        Course course = courseService.getCourse( courseId ); //create new Course object to invoke CourseService Class methods (.getCourse())
        if ( course == null )
        {
            System.out.println( "Invalid Course ID" );
            return;
        }
        System.out.println( course );
        courseService.enrollStudent( courseId, student ); //see above, courseService is a CourseService Class Object
        studentService.enrollToCourse( studentId, course );
        System.out.println( "Student with ID: " + studentId + " enrolled successfully to " + courseId );

    }

    private static void showCoursesSummary( CourseService courseService, Scanner scanner )
    {
        courseService.showSummary();
    }

    private static void showStudentsSummary( StudentService studentService, Scanner scanner )
    {
        studentService.showSummary();
    }

    private static void showPassedCourses( StudentService studentService, Scanner scanner )
    {
        //TODO implement
        System.out.println( "Insert student ID" );
        String studentId = scanner.next();
        Student student = studentService.findStudent( studentId ); // create new Student object to invoke Student class method (.findStudent())
        if ( student == null )
        {
            System.out.println( "Invalid Student ID" );
            return;
        }
        System.out.println( student );
        studentService.showPassedCourses(studentId);
    }

    private static void showAverageGrade( CourseService courseService, Scanner scanner )
    {
        //TODO implement
        courseService.averageGrade();
    }


    private static void gradeStudent( StudentService studentService, Scanner scanner )
    {
        //TODO implement
        System.out.println( "Insert student ID" );
        String studentId = scanner.next();
        Student student = studentService.findStudent( studentId ); // create new Student object to invoke Student class method (.findStudent())
        if ( student == null )
        {
            System.out.println( "Invalid Student ID" );
            return;
        } else {
            System.out.println(student);
            System.out.println("Enrolled Course: ");
            student.showApprovedCourses(); //.showApprovedCourses() will print out the Hashmap values
            System.out.println("\nInsert course ID");
            String courseId = scanner.next();

            if (student.checkApprovedCourse(courseId)) {
                System.out.println("Proceed to key in the Grade from 1 - 5");
                System.out.println("Insert Grade from 1 - 5"); // 3/5 is a pass
                int grade = Integer.parseInt(scanner.next());

                if (grade >= 0 && grade <=5){
                    student.assignGrade(courseId, grade);
                    if (grade >= 3) {
                        System.out.println(String.format("PASSED! Student ID_%s receive Grade %d for this course ID_%s", studentId, grade, courseId));
                    } else {
                        System.out.println(String.format("FAILED! Student ID_%s receive Grade %d for this course ID_%s", studentId, grade, courseId));
                    }

                } else {
                    System.out.println("Grade entered is out of range!");
                }


            } else {
                System.out.println("Course not found or Student did not register for this course!");

            }



        }



    }

    private static void findStudent( StudentService studentService, Scanner scanner )
    {
        System.out.println( "Enter student ID: " );
        String studentId = scanner.next();
        Student student = studentService.findStudent( studentId );
        if ( student != null )
        {
            System.out.println( "Student Found: " );
            System.out.println( student );
        }
        else
        {
            System.out.println( "Student with Id = " + studentId + " not found" );
        }
    }

    private static void registerStudent( StudentService studentService, Scanner scanner )
        throws ParseException
    {
        Student student = PrinterHelper.createStudentMenu( scanner );
        studentService.subscribeStudent( student );
    }

    private static void exitProgram( Scanner scanner ) //added this for Option 9
    {
        System.exit(0);
    }

}
