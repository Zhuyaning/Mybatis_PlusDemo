package com.zhu.mybatis_plusdemo.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

/***
 *   Created by IntelliJ IDEA.
 *   User: ZhuYaning
 *   Date: 2021/8/11
 *   Time: 23:20
 */


@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    /***
     * 插入时的填充策略
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "gmt_create", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "gmt_modifie", LocalDateTime.class, LocalDateTime.now());
    }

    /***
     * 更新时的填充策略
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "gmt_modifie", LocalDateTime.class, LocalDateTime.now());
    }
}