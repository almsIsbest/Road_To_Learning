package com.xiaocui.xiaocui_server.controller;


import com.xiaocui.xiaocui_server.common.api.ApiResult;
import com.xiaocui.xiaocui_server.model.entity.BmsTip;
import com.xiaocui.xiaocui_server.service.BmsTipService;
import com.xiaocui.xiaocui_server.service.impl.BmsTipImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/tip")
public class BmsTipController extends BaseController {
    @Resource
    private BmsTipService bmsTipService;

    @GetMapping("/today")
    public ApiResult<BmsTip> getRandomTip() {
        List<BmsTip> randomTip = bmsTipService.list();
        return ApiResult.success(randomTip.get(0));
    }
}
