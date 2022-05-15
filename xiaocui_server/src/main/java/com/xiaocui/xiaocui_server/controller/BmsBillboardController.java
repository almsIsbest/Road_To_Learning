package com.xiaocui.xiaocui_server.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xiaocui.xiaocui_server.common.api.ApiResult;
import com.xiaocui.xiaocui_server.model.entity.BmsBillboard;
import com.xiaocui.xiaocui_server.service.BmsBillboardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/billboard")
public class BmsBillboardController extends BaseController{

    @Resource
    private BmsBillboardService bmsBillboardService;

    @GetMapping("/show")
    private ApiResult<BmsBillboard> getNotices(){
        List<BmsBillboard> list = bmsBillboardService.list(new LambdaQueryWrapper<BmsBillboard>().eq(BmsBillboard::isShow ,true ));
        return ApiResult.success(list.get(list.size()-1));
    }
}
