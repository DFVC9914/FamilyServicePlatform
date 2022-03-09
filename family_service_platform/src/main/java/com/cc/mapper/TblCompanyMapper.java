package com.cc.mapper;

import com.cc.bean.TblCompany;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 企业档案 Mapper 接口
 * </p>
 *
 * @author cc
 * @since 2022-03-09
 */
@Component
public interface TblCompanyMapper extends BaseMapper<TblCompany> {
    public List<TblCompany> selectCompanyName();
}
