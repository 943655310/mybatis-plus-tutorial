package com.jifuwei.mptest.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jifuwei.mptest.entity.Invite;
import com.jifuwei.mptest.mapper.InviteMapper;
import com.jifuwei.mptest.service.IInviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author JFW
 * @since 2017-06-15
 */
@Service
public class InviteServiceImpl extends ServiceImpl<InviteMapper, Invite> implements IInviteService {

    @Autowired
    private InviteMapper inviteMapper;

    public Page<Invite> lianbiaoSelect(Page<Invite> page) {
        page.setRecords(inviteMapper.lianbiaoSelect(page));
        return page;
    }
}
