package com.xiaocui.xiaocui_server.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.lang.reflect.Type;

/**
 * @ClassName BmsPromotion
 * @Description TODO
 * @Author alms
 * @Data 2022/5/17 14:39
 **/
@Data
@TableName("bms_promotion")
@Accessors(chain = true)
@NoArgsConstructor
public class BmsPromotion implements Serializable {
    private static final long serialVersionUID = 1L;

    /*
     * @Author alms
     * @Description 主键
     * @Date 16:05 2022/5/17
     * @Param 
     * @return 
     **/
    @TableId(value = "id ", type = IdType.AUTO)
    private Integer id;
    
    /**
     * @Author alms
     * @Description 广告标题
     * @Date 16:05 2022/5/17
     * @Param 
     * @return 
     **/
    @TableField("title")
    private String title ;

    /**
     * 广告链接
     */
    @TableField("link")
    private String link;

    /**
     * 说明
     */
    @TableField("`description`")
    private String description;

}
