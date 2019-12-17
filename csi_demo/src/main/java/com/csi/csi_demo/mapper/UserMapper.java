package com.csi.csi_demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.csi.csi_demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper extends BaseMapper<User> {
}
