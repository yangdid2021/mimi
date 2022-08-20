package com.ytp.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ytp.mapper.ProductInfoMapper;
import com.ytp.pojo.ProductInfo;
import com.ytp.pojo.ProductInfoExample;
import com.ytp.service.ProdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProdServiceImpl implements ProdService {
    @Autowired
    ProductInfoMapper mapper;
    @Override
    public List<ProductInfo> getall() {
        List<ProductInfo> list = mapper.selectByExample(new ProductInfoExample());
        return list;
    }


    @Override
    public PageInfo getpag(int num,int size) {

        PageHelper.startPage(num,size);
        ProductInfoExample example=new ProductInfoExample();
        example.setOrderByClause("p_id desc");
        List<ProductInfo> list = mapper.selectByExample(example);
        PageInfo<ProductInfo> info=new PageInfo(list);
        return info;
    }
}
