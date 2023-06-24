package org.example.exceptions;

import java.util.List;

public class UserService {
    List<String> customerNames = List.of("Givi", "Danila", "Walter");
    List<String> studentList = List.of("George", "Ana", "Mike", "Tina", "Shota");

    public String getCustomerByName(String name) throws EmployeeNotFoundException {
        if(customerNames.contains(name)){
            return name;
        }else{
            throw new EmployeeNotFoundException("Employee With Given Name not Found");
        }
    }

    public List<String> getStudents() {
        if(studentList.size() > 3){
            throw new TeacherDataTooLargeException("Teacher Data too large");
        }
        return studentList;
    }
}
