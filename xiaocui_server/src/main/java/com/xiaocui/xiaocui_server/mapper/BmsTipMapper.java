package com.xiaocui.xiaocui_server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaocui.xiaocui_server.model.entity.BmsTip;
import org.springframework.stereotype.Repository;

@Repository
public interface BmsTipMapper extends BaseMapper<BmsTip> {
    BmsTip getRandomTip();
}
