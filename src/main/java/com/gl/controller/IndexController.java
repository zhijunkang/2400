package com.gl.controller;

import org.apache.commons.collections.CollectionUtils;
import org.come.model.Boos;
import org.come.task.MonsterUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.come.task.MonsterUtil.booses;

@RestController
public class IndexController {


    @GetMapping(value = "/refresh")
    public String refresh(String name) {
        List<Boos> name1 = booses.stream().filter(e -> e.getBoosname().equals("小精灵活动")).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(name1)) {
            return "不存在";
        } else {
//            Boos boos=name1.get(0);
//            MonsterUtil.refreshMonsters(boos,null,null,0,0,0,null);
//            return boos.getBoosname();
            MonsterUtil.refreshMonsters(name1.get(0), null, null, null);
            return "成功";
        }
    }
}
