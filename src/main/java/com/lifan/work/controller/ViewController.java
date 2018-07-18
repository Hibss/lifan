package com.lifan.work.controller;

import com.lifan.work.mapper.page.Page;
import com.lifan.work.model.Customer;
import com.lifan.work.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author : steven.sheng
 * Description : TODO
 * Date : 2018/7/13 11:23
 */
@Controller
public class ViewController {

    private Logger logger = LoggerFactory.getLogger(ViewController.class);

    @Value("${project.name}")
    private String name = "";
    @Autowired
    protected CustomerService customerService;

    @RequestMapping("/customer")
    public String initCustomerPage(Model model){
//        Page page = this.initPageInfo();
        model.addAttribute("name",name);
//        model.addAttribute("list",customerService.getPageList(page));
        return "customer";
    }

    @RequestMapping("/customer/add")
    public String addCustomer(Model model){
//        Page page = this.initPageInfo();
        model.addAttribute("name",name);
        model.addAttribute("customer",new Customer());
//        model.addAttribute("list",customerService.getPageList(page));
        return "customerAdd";
    }

    private Page initPageInfo() {
        return new Page(0,10,"id");
    }
}
