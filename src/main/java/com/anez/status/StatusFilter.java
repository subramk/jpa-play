package com.anez.status;

import java.util.List;

import static java.util.Arrays.asList;

public class StatusFilter {

    public List<String> doFilteringOperation(List<String> stringList){
        return asList("open","closed","partial","urgent");

    }
}
