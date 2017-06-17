package com.jifuwei.mptest.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.jifuwei.mptest.entity.Invite;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author JFW
 * @since 2017-06-15
 */
public interface IInviteService extends IService<Invite> {

    Page<Invite> lianbiaoSelect(Page<Invite> page);
}
