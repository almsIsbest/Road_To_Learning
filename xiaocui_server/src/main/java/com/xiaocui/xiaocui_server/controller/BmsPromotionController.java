package com.xiaocui.xiaocui_server.controller;

import com.xiaocui.xiaocui_server.common.api.ApiResult;
import com.xiaocui.xiaocui_server.model.entity.BmsPromotion;
import com.xiaocui.xiaocui_server.service.IBmsPromotionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName BmsPromotionController
 * @Description
 * @Author alms
 * @Data 2022/5/17 16:12
 **/
@RestController
@RequestMapping("/promotion")
public class BmsPromotionController extends BaseController{
    @Resource
    private IBmsPromotionService bmsPromotionService;

    @GetMapping("/all")
    public ApiResult<List<BmsPromotion>> list() {
        List<BmsPromotion> list = bmsPromotionService.list();
        return ApiResult.success(list);
    }
}
