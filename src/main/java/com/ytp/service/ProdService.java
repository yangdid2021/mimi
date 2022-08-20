package com.ytp.service;

import com.github.pagehelper.PageInfo;
import com.ytp.pojo.ProductInfo;

import java.util.List;

public interface ProdService {
    List<ProductInfo> getall();
    PageInfo getpag(int num, int size);
}
