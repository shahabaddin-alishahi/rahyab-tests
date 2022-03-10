package com.rahyab.controller;

import com.rahyab.dto.SumSubSetRequest;
import com.rahyab.dto.SumSubSetResponse;
import com.rahyab.service.SumSubSetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;


@RestController
@RequestMapping
@RequiredArgsConstructor
public class SumSubSetController {

    private final SumSubSetService sumSubSetService;


    @PostMapping(path = "/v1/api/sum-sub-set")
    public SumSubSetResponse create(@RequestBody SumSubSetRequest request) {
        Set<Set<Long>> response = sumSubSetService.getSumSubSets(request.getSum(), request.getSet());

        return SumSubSetResponse.builder()
                .subSets(response)
                .build();
    }

}