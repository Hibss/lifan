package com.lifan.work.controller;

import com.lifan.work.model.User;
import com.lifan.work.model.vo.UserVO;
import com.lifan.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author : steven.sheng
 * Description : TODO
 * Date : 2018/7/17 14:21
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/login",method= RequestMethod.GET)
    public ModelAndView login(Model model){
        model.addAttribute("user", new User());
        return new ModelAndView("login/login");
    }

    @RequestMapping(value="/register",method=RequestMethod.GET)
    public ModelAndView toRegister(Model model){
        model.addAttribute("user", new User());
        return new ModelAndView("login/register");
    }

    @RequestMapping(value="/save",method=RequestMethod.POST)
    public ModelAndView save(@ModelAttribute(value="user") UserVO userVO, Model model){
        User user = userService.getUserByVO(userVO);
        if(user!=null){
            model.addAttribute("errorMessage","已存在"+user.getName());
            return new ModelAndView("login/register");
        }
        userService.insert(userVO);
        return new ModelAndView("login/login");
    }
}
