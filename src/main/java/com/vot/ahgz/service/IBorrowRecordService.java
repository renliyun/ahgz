package com.vot.ahgz.service;

import com.vot.ahgz.entity.BorrowRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author renlirong
 * @since 2020-12-08
 */
public interface IBorrowRecordService  {

    //获取全部数据
    List<BorrowRecord> getAll(BorrowRecord borrowRecord);

    //  根据name名称获取
    List<BorrowRecord> getByName( String name);

    //  插入数据
    Integer insertBorrowRecord(BorrowRecord borrowRecord , HttpServletRequest request);

    //  根据借用人名称删除数据
    Integer deleteByName( String name);

    //  根据名称删除数据
    Integer deleteById( Integer id);

    //  更新数据
    Integer updateByName(BorrowRecord borrowRecord);
}
