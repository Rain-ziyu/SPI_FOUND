package org.example.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.entity.ResourceRole;
import org.example.entity.Role;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2020-01-12
 */
public interface RoleMapper extends BaseMapper<Role> {
    /**
     * 方法listResourceRoles作用为：
     * 查询所有接口对应的角色   可以匿名访问的不加载进来
     *
     * @param
     * @return java.util.List<asia.huayu.auth.entity.ResourceRole>
     * @throws
     * @author RainZiYu
     */
    List<ResourceRole> listResourceRoles();

}
