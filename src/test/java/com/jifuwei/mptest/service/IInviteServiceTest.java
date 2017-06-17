package com.jifuwei.mptest.service;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.jifuwei.mptest.entity.Invite;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by jifuwei on 2017/6/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
@Transactional
public class IInviteServiceTest {

    @Autowired
    private IInviteService inviteService;

    @Test
    public void insert() {
        Invite invite = new Invite();
        invite.setCreated(new Date());
        invite.setUpdated(new Date());
        invite.setVersion(0);
        invite.setUserId(51L);
        invite.setInviteUserId(345L);
        invite.setInviteCode("happy");
        invite.setStatus("New");
        invite.setChannel("JFW");
        boolean result = inviteService.insert(invite);
        System.err.println(result);
    }

    @Test
    public void insertBatch() {
        List<Invite> inviteList = Lists.newArrayList();
        Invite invite = new Invite();
        invite.setCreated(new Date());
        invite.setUpdated(new Date());
        invite.setVersion(0);
        invite.setUserId(51L);
        invite.setInviteUserId(345L);
        invite.setInviteCode("happy");
        invite.setStatus("New");
        invite.setChannel("JFW");
        for (int i = 0; i < 10; i++) {
            inviteList.add(invite);
        }
        boolean result = inviteService.insertBatch(inviteList);
        System.err.println(result);
    }

    @Test
    public void insertBatchBySize() {
        List<Invite> inviteList = Lists.newArrayList();
        Invite invite = new Invite();
        invite.setCreated(new Date());
        invite.setUpdated(new Date());
        invite.setVersion(0);
        invite.setUserId(51L);
        invite.setInviteUserId(345L);
        invite.setInviteCode("happy");
        invite.setStatus("New");
        invite.setChannel("JFW");
        for (int i = 0; i < 10; i++) {
            inviteList.add(invite);
        }
        boolean result = inviteService.insertBatch(inviteList, 15);
        System.err.println(result);
    }

    @Test
    public void insertOrUpdateBatch() {
        List<Invite> inviteList = Lists.newArrayList();
        Invite invite = new Invite();
        invite.setCreated(new Date());
        invite.setUpdated(new Date());
        invite.setVersion(0);
        invite.setUserId(51L);
        invite.setInviteUserId(345L);
        invite.setInviteCode("happy");
        invite.setStatus("New");
        invite.setChannel("JFW");
        for (int i = 0; i < 5; i++) {
            inviteList.add(invite);
        }
        Invite invite1 = new Invite();
        invite1.setId(1L);
        invite1.setCreated(new Date());
        invite1.setUpdated(new Date());
        invite1.setVersion(0);
        invite1.setUserId(51L);
        invite1.setInviteUserId(345L);
        invite1.setInviteCode("happy");
        invite1.setStatus("New");
        invite1.setChannel("JFW");
        inviteList.add(invite1);

        boolean result = inviteService.insertOrUpdateBatch(inviteList);
        System.err.println(result);
    }

    @Test
    public void insertOrUpdateBatchBySize() {
        List<Invite> inviteList = Lists.newArrayList();
        Invite invite = new Invite();
        invite.setCreated(new Date());
        invite.setUpdated(new Date());
        invite.setVersion(0);
        invite.setUserId(51L);
        invite.setInviteUserId(345L);
        invite.setInviteCode("happy");
        invite.setStatus("New");
        invite.setChannel("JFW");
        for (int i = 0; i < 5; i++) {
            inviteList.add(invite);
        }
        Invite invite1 = new Invite();
        invite1.setId(1L);
        invite1.setCreated(new Date());
        invite1.setUpdated(new Date());
        invite1.setVersion(0);
        invite1.setUserId(51L);
        invite1.setInviteUserId(345L);
        invite1.setInviteCode("happy");
        invite1.setStatus("New");
        invite1.setChannel("JFW");
        inviteList.add(invite1);

        boolean result = inviteService.insertOrUpdateBatch(inviteList, 50);
        System.err.println(result);
    }

    @Test
    public void deleteById() {
        Invite invite = new Invite();
        invite.setId(1L);
        boolean result = inviteService.deleteById(invite.getId());
        System.out.println(result);
    }

    @Test
    public void deleteByMap() {
        Map map = Maps.newHashMap();
        map.put("id", 1L);
        map.put("status", "Finish");
        boolean result = inviteService.deleteByMap(map);
        System.out.println(result);
    }

    @Test
    public void delete() {
        EntityWrapper<Invite> inviteEntityWrapper = new EntityWrapper<Invite>();
        inviteEntityWrapper.eq("id", 1L);
        boolean result = inviteService.delete(inviteEntityWrapper);
        System.out.println(result);
    }

    @Test
    public void selectById() {
        Invite invite = new Invite();
        invite.setId(1L);
        invite = inviteService.selectById(invite.getId());
        System.out.println(JSON.toJSONString(invite));
    }

    @Test
    public void selectPage() {
        EntityWrapper<Invite> inviteEntityWrapper = new EntityWrapper<Invite>();
        inviteEntityWrapper.eq("channel", "appShare");
        Page<Invite> page = new Page<Invite>(1, 10);
        page.getCondition().put("id", 1L);
        Page<Invite> invitePage = inviteService.selectPage(page, inviteEntityWrapper);
        System.out.println(JSON.toJSONString(invitePage));
    }

    @Test
    public void lianbiaoSelect() {
        Page<Invite> page = inviteService.lianbiaoSelect(new Page<Invite>(1, 2));
        System.out.println(JSON.toJSONString(page));
    }

}