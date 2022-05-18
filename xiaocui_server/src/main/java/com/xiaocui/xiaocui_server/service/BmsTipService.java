package com.xiaocui.xiaocui_server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaocui.xiaocui_server.model.entity.BmsTip;

public interface BmsTipService extends IService<BmsTip> {
    BmsTip getRandomTip();
}
