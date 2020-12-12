package com.vot.ahgz.mapper;



import com.vot.ahgz.entity.BorrowRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author renlirong
 * @since 2020-12-08
 */
public interface BorrowRecordMapper  {

    //获取全部数据
    List<BorrowRecord> getAll();

    //  根据name名称获取
    List<BorrowRecord> getByName(@Param("name") String name);

    //  插入数据
    Integer insertBorrowRecord(@Param("list") BorrowRecord borrowRecord);

    //  根据借用人名称删除数据
    Integer deleteByName(@Param("name") String name);

    //  更新数据
    BorrowRecord updateByName(@Param("name") String name,
                             @Param("addressList") BorrowRecord borrowRecord);



}
