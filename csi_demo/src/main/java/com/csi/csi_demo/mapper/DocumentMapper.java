package com.csi.csi_demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.csi.csi_demo.pojo.Document;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface DocumentMapper extends BaseMapper<Document> {
}
