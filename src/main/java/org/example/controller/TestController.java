package org.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.example.entity.ResourceRole;
import org.example.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author RainZiYu
 * @Date 2023/3/30
 */
@RestController
public class TestController {
    @Autowired
    private RoleMapper roleMapper;
    @GetMapping("/test")
    public String testSharding() throws InterruptedException, ExecutionException {
        CompletableFuture<List<ResourceRole>> asyncArticleCount = CompletableFuture.supplyAsync(()
                -> roleMapper.listResourceRoles());
        return asyncArticleCount.get().toString();
    }
}
