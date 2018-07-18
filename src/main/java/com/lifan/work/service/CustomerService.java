package com.lifan.work.service;

import com.github.pagehelper.PageHelper;
import com.lifan.work.mapper.CustomerMapper;
import com.lifan.work.mapper.page.Page;
import com.lifan.work.model.Customer;
import com.lifan.work.model.vo.CustomerVO;
import com.lifan.work.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author : steven.sheng
 * Description : TODO
 * Date : 2018/7/13 11:23
 */
@Service
public class CustomerService {

    @Autowired
    protected CustomerMapper customerMapper;

    public List<CustomerVO> getPageList(Page page){
        PageHelper.startPage(page.getPage(),page.getRows(),page.getOrderBy());
        List<Customer> customers = customerMapper.getPageList();
        List<CustomerVO> vos = customers.stream().map(customer -> BeanUtil.map(customer,CustomerVO.class)).collect(Collectors.toList());
        return vos;
    }

    public int getCount() {
        return 0;
    }

    public CustomerVO getById(Long id) {
        Customer customer = customerMapper.getById(id);
        return BeanUtil.map(customer,CustomerVO.class);
    }

    public Boolean insert(CustomerVO customerVO){
        Customer customer = BeanUtil.map(customerVO,Customer.class);
        return customerMapper.insert(customer)==1;
    }
}
