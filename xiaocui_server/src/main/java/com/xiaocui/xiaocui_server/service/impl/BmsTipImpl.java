package com.xiaocui.xiaocui_server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaocui.xiaocui_server.mapper.BmsTipMapper;
import com.xiaocui.xiaocui_server.model.entity.BmsTip;
import com.xiaocui.xiaocui_server.service.BmsTipService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class BmsTipImpl extends ServiceImpl<BmsTipMapper, BmsTip> implements BmsTipService {

    @Override
    public BmsTip getRandomTip() {
        BmsTip todayTip = null;
        try {
            todayTip = this.baseMapper.getRandomTip();
        } catch (Exception e) {
            log.info("tip转化失败 {} ",e);
        }
        return todayTip;
    }

}
