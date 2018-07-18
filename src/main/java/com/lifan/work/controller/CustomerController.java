package com.lifan.work.controller;

import com.google.gson.Gson;
import com.lifan.work.mapper.page.Page;
import com.lifan.work.model.vo.CustomerVO;
import com.lifan.work.service.CustomerService;
import com.lifan.work.util.GsonUtil;
import com.lifan.work.util.RequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author : steven.sheng
 * Description : TODO
 * Date : 2018/7/13 11:18
 */
@RestController
@RequestMapping(value = "/customer")
public class CustomerController extends BaseController {

    @Value("${project.name}")
    private String name = "";

    private Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    protected CustomerService customerService;

    @RequestMapping(value = "/get" , method = RequestMethod.GET)
    @ResponseBody
    public String getCustomer(HttpServletRequest request) throws Exception {
        logger.info("load in getAllUser");
        Page page = Page.getPageRequest(request);
        List<CustomerVO> users = customerService.getPageList(page);
        int count = customerService.getCount();
        Map<String,Object> res = new HashMap<>();
        res.put("name",name);
        res.put("list",users);
        String result = new Gson().toJson(res);
        return result;
    }

    @RequestMapping(value = "/edit" , method = RequestMethod.GET)
    @ResponseBody
    public String editCustomer(HttpServletRequest request) throws Exception {
        logger.info("load in editCustomer");
        Long id = RequestUtil.getLong(request,"id",null);
        CustomerVO customerVO = id==null?CustomerVO.builder().build():customerService.getById(id);
        Map<String,Object> res = new HashMap<>();
        res.put("name",name);
        res.put("customer",customerVO);
        String result = new Gson().toJson(res);
        return result;
    }

    @RequestMapping(value = "/save" , method = RequestMethod.POST)
    public void saveCustomer(@RequestBody  CustomerVO customerVO) throws Exception {
//    public String saveCustomer(@RequestBody CustomerVO customerVO) throws Exception {
        logger.info("load in saveCustomer");
        logger.info("post customer, "+ GsonUtil.toJson(customerVO));
        Map<String,Object> res = new HashMap<>();
        res.put("name",name);
        res.put("status",customerService.insert(customerVO));
        String result = new Gson().toJson(res);
//        return result;
    }

}
