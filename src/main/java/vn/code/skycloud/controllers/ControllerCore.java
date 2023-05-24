package vn.code.skycloud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import vn.code.skycloud.common.Lib;
import vn.code.skycloud.entity.Employee;
import vn.code.skycloud.service.EmployeeService;

@Controller
public class ControllerCore {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(path = "/acc")
    public ModelAndView getIndex() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("views/acc/invoice.html");
        return mv;
    }

    @GetMapping("/chat")
    public ModelAndView getChat() {
        ModelAndView mav = new ModelAndView("chat");
        mav.addObject("employees", employeeService.findAll());
        return mav;
    }

    @GetMapping(path = { "/acc/list", "/search" })
    public String getList(Model model,
            @RequestParam(required = false, name = "keyword", defaultValue = "") String keyword) {

        if (Lib.isEmpty(keyword)) {
            model.addAttribute("employees", employeeService.findAll());
        } else {
            List<Employee> list = employeeService.searchEmployee(keyword);
            System.out.println("Size: " + list.size());
            model.addAttribute("employees", list);
        }
        model.addAttribute("keyword", keyword);
        return "views/acc/list.html";
    }
}
