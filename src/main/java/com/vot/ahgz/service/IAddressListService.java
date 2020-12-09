package com.vot.ahgz.service;

import com.vot.ahgz.entity.AddressList;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author renlirong
 * @since 2020-12-08
 */
public interface IAddressListService  {

    AddressList getById( Integer id);
}
