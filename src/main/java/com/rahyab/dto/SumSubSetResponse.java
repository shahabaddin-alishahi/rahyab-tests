package com.rahyab.dto;

import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SumSubSetResponse {

    private Set<Set<Long>> subSets;
}
