package com.rahyab.service.impl;

import com.rahyab.exceptions.ResponseNotExistException;
import com.rahyab.service.SumSubSetService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SumSubSetServiceImpl implements SumSubSetService {

    @Override
    public Set<Set<Long>> getSumSubSets(Long sum, Set<Long> set) {

        Set<Set<Long>> response = new HashSet<>();
        Set<Set<Long>> sets = getSubsets(set);

        Iterator<Set<Long>> setIterator = sets.iterator();

        while (setIterator.hasNext()){
            Set<Long> res = setIterator.next();
            Long sumSub = res.stream()
                    .collect(Collectors.summingLong(Long::longValue));
            if(sumSub == sum){
                response.add(res);
            }
        }
        if (response.isEmpty()){
            throw new ResponseNotExistException("پاسخی یافت نشد.");
        }else {
            return response;
        }
    }




    @Override
    public Set<Set<Long>> getSubsets(Set<Long> set) {
        if (set.isEmpty()) {
            return Collections.singleton(Collections.emptySet());
        }

        Set<Set<Long>> subSets = set.stream().map(item -> {
                    Set<Long> clone = new HashSet<>(set);
                    clone.remove(item);
                    return clone;
                }).map(group -> getSubsets(group))
                .reduce(new HashSet<>(), (x, y) -> {
                    x.addAll(y);
                    return x;
                });

        subSets.add(set);
        return subSets;
    }
}
