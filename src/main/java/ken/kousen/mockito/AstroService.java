package ken.kousen.mockito;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import static org.springframework.web.client.RestClient.builder;

@Service
public class AstroService {

    private RestClient  restClient;
    private String baseUrl = "http://api.open-notify.org";

    @Autowired
    public AstroService(){
            restClient = builder().baseUrl(baseUrl).build();

    }


}
