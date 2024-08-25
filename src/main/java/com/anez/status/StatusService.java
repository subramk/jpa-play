package com.anez.status;

import lombok.Getter;

import java.util.List;

import static java.util.Arrays.asList;

public class StatusService  {

    private StatusMapper statusMapper;
    private StatusFilter statusFilter;
    private BESSClient bessClient;
    private ImmigrationStatusCheckCheckedEventMapper immigrationStatusCheckCheckedEventMapper;

    //@Getter
    private int limit;
    StatusService(){
    }

    public StatusService(StatusMapper statusMapper, StatusFilter statusFilter , BESSClient bessClient , ImmigrationStatusCheckCheckedEventMapper
            immigrationStatusCheckCheckedEventMapper, int limit){

        this.statusMapper = statusMapper;
        this.statusFilter = statusFilter;
        this.bessClient = bessClient;
        this.immigrationStatusCheckCheckedEventMapper = immigrationStatusCheckCheckedEventMapper;
            this.limit = limit;


    }


    public List<String> getAllStatus(){
        // simply call the depdneicies
        statusMapper.mapSomething("input");
        statusFilter.doFilteringOperation(List.of("ass"));
        bessClient.callTheBessClien();
        immigrationStatusCheckCheckedEventMapper.mapEvent("map");

        // just return some random list .
        return asList("open","closed","partial","urgent");
    }

}
