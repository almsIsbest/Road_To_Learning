package com.xiaocui.xiaocui_server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaocui.xiaocui_server.model.dto.LoginDTO;
import com.xiaocui.xiaocui_server.model.dto.RegisterDTO;
import com.xiaocui.xiaocui_server.model.entity.UmsUser;
import com.xiaocui.xiaocui_server.model.vo.ProfileVO;

import java.rmi.registry.Registry;

public interface IUmsUserService extends IService<UmsUser> {

    /**
     * 注册功能
     *
     * @param dto
     * @return 注册对象
     */
    UmsUser executeRegister(RegisterDTO dto);
    /**
     * 获取用户信息
     *
     * @param username
     * @return dbUser
     */
    UmsUser getUserByUsername(String username);
    /**
     * 用户登录
     *
     * @param dto
     * @return 生成的JWT的token
     */
    String executeLogin(LoginDTO dto);
    /**
     * 获取用户信息
     *
     * @param id 用户ID
     * @return
     */
    ProfileVO getUserProfile(String id);

}
