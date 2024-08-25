package com.anez.status;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class StatusServiceTest {

    @Mock
    BESSClient bessClient;

    @Mock
    ImmigrationStatusCheckCheckedEventMapper immigrationStatusCheckCheckedEventMapper;

    @Mock
    StatusFilter statusFilter;

    @Mock
    StatusMapper statusMapper;

    //@Spy
    Integer limit;
//
    @InjectMocks
    StatusService statusService;
    //StatusService statusService = new StatusService(statusMapper,statusFilter,bessClient,immigrationStatusCheckCheckedEventMapper);

    @BeforeEach
    void setUp() {
        limit= 10;
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void dummy(){
        Assert.assertTrue(true);
    }



    @Test
    void ensureDependenciesWork(){

        //Mockito.when(statusService.getLimit()).thenReturn(10);
        Mockito.when(bessClient.callTheBessClien()).thenReturn("return value");
        Mockito.when(statusMapper.mapSomething(anyString())).thenReturn(asList("open","closed","partial","urgent"));
        Mockito.when(statusFilter.doFilteringOperation(anyList())).thenReturn(asList("open","closed","partial","urgent"));
        Mockito.when(immigrationStatusCheckCheckedEventMapper.mapEvent("map")).thenReturn(asList("open","closed","partial","urgent"));

        // call the Class under test
        List<String> actualStatus = statusService.getAllStatus();

        List<String> expectedStatus = Arrays.asList("open","closed","partial","urgent");

        assertThat(expectedStatus)
                .containsExactlyInAnyOrderElementsOf(actualStatus);

        Mockito.verify(statusMapper, times(1)).mapSomething(anyString());
        Mockito.verify(statusFilter,times(1)).doFilteringOperation(anyList());

        // other verify's here.




    }

}
