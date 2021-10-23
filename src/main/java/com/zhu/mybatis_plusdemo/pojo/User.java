package com.zhu.mybatis_plusdemo.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

/***
 *   Created by IntelliJ IDEA.
 *   User: ZhuYaning
 *   Date: 2021/8/11
 *   Time: 21:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private String name;

    private Integer age;

    private String email;

    @Version
    private Integer version;

    @TableLogic
    private Integer deleted;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmt_create;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmt_modifie;
}
