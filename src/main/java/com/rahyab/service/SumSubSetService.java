package com.rahyab.service;

import com.rahyab.dto.SumSubSetResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

public interface SumSubSetService {
    Set<Set<Long>> getSumSubSets(Long sum, Set<Long> set);

    Set<Set<Long>> getSubsets(Set<Long> set);
}
