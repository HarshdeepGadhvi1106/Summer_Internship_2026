package com.sms.service;

import com.sms.entity.Student;
import com.sms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public Student addStudent(Student student) {
        return repository.save(student);
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudentById(int id) {
        Optional<Student> student = repository.findById(id);
        return student.orElse(null);
    }

    public Student updateStudent(int id, Student newStudent) {

        Student oldStudent = repository.findById(id).orElse(null);

        if (oldStudent != null) {

            oldStudent.setName(newStudent.getName());
            oldStudent.setDept(newStudent.getDept());
            oldStudent.setSem(newStudent.getSem());
            oldStudent.setCgpa(newStudent.getCgpa());
            oldStudent.setEmail(newStudent.getEmail());
            oldStudent.setCity(newStudent.getCity());

            return repository.save(oldStudent);
        }

        return null;
    }

    public String deleteStudent(int id) {

        repository.deleteById(id);

        return "Student Deleted Successfully";
    }
}