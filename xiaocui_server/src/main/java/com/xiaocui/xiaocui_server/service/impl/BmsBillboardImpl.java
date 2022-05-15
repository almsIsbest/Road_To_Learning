package com.xiaocui.xiaocui_server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaocui.xiaocui_server.mapper.BmsBillboardMapper;
import com.xiaocui.xiaocui_server.model.entity.BmsBillboard;
import com.xiaocui.xiaocui_server.service.BmsBillboardService;
import org.springframework.stereotype.Service;

@Service
public class BmsBillboardImpl extends ServiceImpl<BmsBillboardMapper, BmsBillboard> implements BmsBillboardService {
}
