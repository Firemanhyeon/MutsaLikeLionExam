package ch11.Collection.Test;

import java.util.HashSet;
import java.util.Set;

public class EmployeeManager {
    Set<Employee> employees = new HashSet<>();


    public void addEmployee(Employee employee) {
        for(Employee e: employees) {
            if(e.getId().equals(employee.getId())) {
                System.out.println("이미 등록된 사원입니다");
                return;
            }
        }
        employees.add(employee);
        System.out.println("등록완료");
    }
    public void removeEmployee(Employee employee) {
        if(employees.contains(employee)) {
            employees.remove(employee);
            System.out.println("삭제완료되었습니다");
        }else{
            System.out.println("정보가 없습니다.");
        }
    }
    public void findEmployee(String id){
        for(Employee employee : employees){
            if(employee.getId().equals(id)){
                System.out.println("사원검색:"+"사원아이디: "+employee.getId()+" 사원이름: "+employee.getName()+" 사원부서: "+employee.getDepartment());
                return;
            }
        }
        System.out.println("검색한 사원이 없습니다");
    }
 }
