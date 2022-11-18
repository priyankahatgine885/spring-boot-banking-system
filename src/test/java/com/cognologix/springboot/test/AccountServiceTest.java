//package com.cognologix.springboot.test;
//import com.springboot.demo.dao.EmployeeDao;
//import com.springboot.demo.dto.employee.EmployeeDTO;
//import com.springboot.demo.dto.employee.EmployeeListResponse;
//import com.springboot.demo.dto.employee.EmployeeResponse;
//import com.springboot.demo.entities.Employee;
//import com.springboot.demo.exception.EmptyListException;
//import com.springboot.demo.exception.NameAlreadyExistException;
//import com.springboot.demo.exception.ResourceNotFoundException;
//import com.springboot.demo.service.EmployeeService;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class AccountServiceTest extends BaseInitializer {
//    @Autowired
//    private EmployeeService employeeService;
//    @Autowired
//    EmployeeDao employeeDao;
//
//    @Test
//    public void addEmployee_addNewEmployee_success() {
//        EmployeeDTO employeeDTO = new EmployeeDTO();
//        employeeDTO.setName("Janavi Mali");
//        employeeDTO.setSalary(23000.0f);
//        EmployeeResponse employee = employeeService.addEmployee(employeeDTO);
//        Assert.assertNotNull(employee);
//
//    }
//
//    @Test
//    public void addEmployee_addDuplicateEmployee_nameAlreadyExistException() {
//        EmployeeDTO employeeDTO = new EmployeeDTO();
//        employeeDTO.setName("Amit Patil11111");
//        employeeDTO.setSalary(2222);
//        EmployeeResponse response = employeeService.addEmployee(employeeDTO);
//        Exception exception = Assert.assertThrows(NameAlreadyExistException.class, () -> {
//            employeeService.addEmployee(employeeDTO);
//        });
//        String expectedMessage = "Employee Name already exist";
//        String actualMessage = exception.getMessage();
//        Assert.assertTrue(actualMessage.contains(expectedMessage));
//    }
//
//    @Test
//    public void getListEmployees_getListEmployees_emptyListException(){
//        EmployeeListResponse response = employeeService.getEmployees();
//        if(response.getSize() != 0) {
//            Assert.assertNotNull(response);
//        }else {
//            throw new EmptyListException("List is empty");
//        }
//    }
//
//    @Test
//    public void updateEmployee_updateNewEmployee_success() {
//        Employee employee = new Employee();
//        employee.setName("Dipali Patil");
//        employee.setSalary(20000);
//        EmployeeResponse response = employeeService.updateEmployee(1, employee);
//        Assert.assertNotNull(response);
//    }
//
//    @Test
//    public void deleteEmployee_success() {
//        Employee employee = employeeDao.findById(1).get();
//        if(employeeDao.existsById(employee.getId())){
//            employeeService.deleteEmployee(employee.getId());
//        }else {
//            throw new ResourceNotFoundException("Employee not found for this id : " + 1);
//        }
//    }
//}
