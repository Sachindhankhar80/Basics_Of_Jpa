package com.example.jpause;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/addStudent")
    public ResponseEntity addStudent(@RequestBody Student student){
        studentService.addStudent(student);
        return new ResponseEntity("Student Add Succesfully", HttpStatus.CREATED);
    }

    @GetMapping("/get_by_id")
    public ResponseEntity getStudentByid(@RequestParam("id") int rollNo){
        Student student=studentService.getStudentByRollNo(rollNo);
        if(student==null){
            return new ResponseEntity("Invalid RollNO",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(student,HttpStatus.FOUND);

    }
    @DeleteMapping("/delete_student_by_Rollno")
    public ResponseEntity deleteStudentByRollNo(@RequestParam("id")int rollNo){
        studentService.deleteStudentByRollNo(rollNo);
        return new ResponseEntity("Delete Succesfully",HttpStatus.FOUND);
    }

    @PutMapping("/update_age_byid/{id}/{age}")
    public ResponseEntity  udateAgeByRollNo(@PathVariable("id") int rollNo, @PathVariable("age") int age){
        if(studentService.updateAgeByRollNo(rollNo,age)){
            return new ResponseEntity("Update SuccesFully",HttpStatus.UPGRADE_REQUIRED);
        }
        return new ResponseEntity("Invalid Rollno",HttpStatus.NOT_FOUND);
    }

     

    @DeleteMapping("/delete_all")
    public ResponseEntity deleteAllData(){
        studentService.deleteAllData();
        return new ResponseEntity("Done",HttpStatus.CREATED);
    }


    @GetMapping("/get_data_by_name/{name}")
    public ResponseEntity getDataByName(@PathVariable("name")String name){
        List<Student>student=new ArrayList<>();
        if(student.size()==0){
            System.out.println("akjdf");
            return new ResponseEntity("there is no student with this name",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(student,HttpStatus.FOUND);

    }

}
