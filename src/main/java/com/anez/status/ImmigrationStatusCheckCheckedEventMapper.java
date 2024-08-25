package com.anez.status;

import java.util.List;

import static java.util.Arrays.asList;

public class ImmigrationStatusCheckCheckedEventMapper {


    public List<String> mapEvent(String map) {
        return asList("open","closed","partial","urgent");


    }


}
