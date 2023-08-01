package com.example.jpause;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepositary studentRepositary;

    public void addStudent(Student student){
        studentRepositary.save(student);
    }

    public Student getStudentByRollNo(int rollNo) {
        Optional<Student> optionalStudent = studentRepositary.findById(rollNo);
        if(optionalStudent.isPresent()){
            return optionalStudent.get();
        }

        return null;
    }

    public void deleteStudentByRollNo(int rollNo) {
        Optional<Student> optionalStudent = studentRepositary.findById(rollNo);
        if(optionalStudent.isPresent()){
            studentRepositary.deleteById(rollNo);
        }

    }

    public boolean updateAgeByRollNo(int rollNo, int age) {
        Optional<Student> optionalStudent = studentRepositary.findById(rollNo);
        if(optionalStudent.isPresent()){
           Student student= studentRepositary.getReferenceById(rollNo);
           student.setAge(age);
           return true;
        }
        return false;
    }

    public void deleteAllData() {
        studentRepositary.deleteAll();
    }
//    public List<Student> getDataByName(String name){
//        List<Student> list=studentRepositary.findAll()
//    }


}
