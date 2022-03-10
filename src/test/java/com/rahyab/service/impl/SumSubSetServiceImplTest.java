package com.rahyab.service.impl;


import com.rahyab.exceptions.ResponseNotExistException;
import com.rahyab.service.SumSubSetService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashSet;
import java.util.Set;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class SumSubSetServiceImplTest {

    @Autowired
    private SumSubSetService sumSubSetService;


    @Test
    void getSumSubSets_fail() {
        Set<Long> set = new HashSet<>();
        set.add(1L);
        Assertions.assertThrows(ResponseNotExistException.class, () -> sumSubSetService.getSumSubSets(5L, set));
    }


    @Test
    void getSumSubSets() {
        Set<Long> set = new HashSet<>();
        set.add(1L);
        set.add(2L);
        set.add(3L);
        Set<Set<Long>> sets = sumSubSetService.getSumSubSets(3L, set);
        Assertions.assertEquals(sets.size(), 2);
    }

    @Test
    void getSubsets() {
        Set<Long> set = new HashSet<>();
        set.add(1L);
        Set<Set<Long>> sets = sumSubSetService.getSubsets(set);
        Assertions.assertEquals(sets.size(), 2);
    }

    @Test
    void getSubsets2() {
        Set<Long> set = new HashSet<>();
        set.add(1L);
        set.add(2L);
        Set<Set<Long>> sets = sumSubSetService.getSubsets(set);
        Assertions.assertEquals(sets.size(), 4);
    }
}