package com.anez.status;

import java.util.List;

import static java.util.Arrays.asList;

public class StatusMapper {

    public List<String> mapSomething(final String inputs){

        return asList("open","closed","partial","urgent");


    }
}
