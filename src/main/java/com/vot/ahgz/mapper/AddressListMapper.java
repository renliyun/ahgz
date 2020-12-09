package com.vot.ahgz.mapper;


import com.vot.ahgz.entity.AddressList;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author renlirong
 * @since 2020-12-08
 */
public interface AddressListMapper {

    AddressList getById(@Param("id") Integer id);

}
