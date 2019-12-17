package com.csi.csi_demo.Service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.csi.csi_demo.Service.EmployeeService;

import com.csi.csi_demo.mapper.EmployeeMapper;

import com.csi.csi_demo.pojo.Employee;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 陈景
 * @QQ:895373488
 * @create 2019/11/18 0018
 * @since 1.0.0
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
}
