package com.jifuwei.mptest.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.jifuwei.mptest.entity.Invite;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author JFW
 * @since 2017-06-15
 */
public interface InviteMapper extends BaseMapper<Invite> {

    /**
     * 分页插件自行处理sql 无需显示引用
     * 实际生成语句： SELECT t1.inviteCode, t2.id, t1.created FROM invite t1 LEFT JOIN `user` t2 ON t1.userId = t2.id LIMIT 0,2
     *
     * @param page
     * @return
     */
    @Select("SELECT t1.inviteCode, t2.id, t1.created FROM invite t1 LEFT JOIN `user` t2 ON t1.userId = t2.id")
    List<Invite> lianbiaoSelect(Page<Invite> page);
}