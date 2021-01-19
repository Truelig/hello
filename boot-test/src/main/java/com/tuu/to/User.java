package com.tuu.to;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

@TableName(value = "test1")
@Data
public class User extends Model<User> {
    @TableId(type = IdType.AUTO)
    private int id;
    private String name;

    @Override
    protected Serializable pkVal() {
        return id;
    }
}
