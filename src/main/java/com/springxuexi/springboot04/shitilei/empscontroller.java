package com.springxuexi.springboot04.shitilei;

import com.springxuexi.springboot04.dao.DepartmentDao;
import com.springxuexi.springboot04.dao.Employee;
import com.springxuexi.springboot04.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Collection;

@Controller
public class empscontroller {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    //查询所有员工换回员工列表
    @GetMapping("/emps")
    public String list(Model model){
   Collection<com.springxuexi.springboot04.dao.Employee> e= employeeDao.getAll();
   model.addAttribute("empc",e);
return "list";
    }
    @GetMapping("/emp")
//来到员工添加页面
    public String tianjia(Model model){
        Collection<com.springxuexi.springboot04.dao.Department>a=departmentDao.getDepartments();
        model.addAttribute("deps",a);
return "tianjia";
    }
    //springmvc自动将亲求参数和如产参数自动封装 只需保持名称一样
    @PostMapping("/emp")
    public String tianjianzhen(Employee employee){
System.out.println(employee);
       employeeDao.save(employee);
        //表示转发  redirect表示重定向
        return "redirect:/emps";
    }
    //来到修改页面
    @GetMapping("/emp{id}")
    public String xiugai(@PathVariable("id") Integer id,Model model){
        Employee employee=employeeDao.get(id);
        model.addAttribute("emp",employee);
        return "xiugai";
    }

    //员工修改  需要提交员工id
    @PutMapping("/emp")
    public String xiygaizhen(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    //员工删除
    @PutMapping("/emp{id}")
    public String shanchu(@PathVariable("id") Integer id){

        employeeDao.delete(id);
        return "redirect:/emps";

    }
}
