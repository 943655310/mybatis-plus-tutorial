package com.jifuwei;

import com.alibaba.fastjson.JSON;
import com.jifuwei.mptest.entity.Invite;
import com.jifuwei.mptest.entity.InviteVO;
import com.jifuwei.mptest.service.IInviteService;
import org.dozer.DozerBeanMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jifuwei on 2017/6/19.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
@Transactional
public class DozerTest {

    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    @Autowired
    private IInviteService inviteService;

    @Test
    public void test() {
        Invite invite = new Invite();
        invite.setId(1L);
        invite = inviteService.selectById(invite.getId());
        InviteVO inviteVO = dozerBeanMapper.map(invite, InviteVO.class);
        System.err.println(JSON.toJSONString(invite));
        System.err.println(JSON.toJSONString(inviteVO));
    }
}
