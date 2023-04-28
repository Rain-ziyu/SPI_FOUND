package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.entity.ResourceRole;
import org.example.entity.Role;
import org.example.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@PropertySource({"classpath:application.properties"})
/**
 * @author RainZiYu
 * @Date 2023/3/30
 */
@AllArgsConstructor
@RestController
public class TestController {

    // TestController testController;


    private RoleMapper roleMapper;

    @GetMapping("/test")
    public String testSharding() throws InterruptedException, ExecutionException {

        int a = 10_0000;
        ExecutorService executor = Executors.newFixedThreadPool(10); // 创建线程池，大小为 10

        CompletableFuture<List<ResourceRole>> asyncArticleCount = CompletableFuture.supplyAsync(() -> roleMapper.listResourceRoles(), executor);
        // CompletableFuture<List<ResourceRole>> asyncArticleCount = CompletableFuture.supplyAsync(() -> roleMapper.listResourceRoles());
        return asyncArticleCount.get().toString();
    }

    @Transactional
    public void testTransactional() {
        Role role = new Role();
        role.setId(10999);
        role.setCreateTime(new Date());
        role.setUpdateTime(new Date());
        roleMapper.insert(role);
        // testController.testTransactional1();
    }

    @Transactional
    public void testTransactional1() {
        Role role = new Role();
        role.setId(10999);
        roleMapper.insert(role);
    }
}
