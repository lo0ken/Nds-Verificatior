package com.ndsverification;

import com.example.consumingwebservice.wsdl.NdsRequest2;
import com.example.consumingwebservice.wsdl.NdsResponse2;
import com.example.consumingwebservice.wsdl.ObjectFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class NdsClient extends WebServiceGatewaySupport {
    private static final Logger log = LoggerFactory.getLogger(NdsClient.class);

    public NdsResponse2 getNp(String inn) {
        ObjectFactory factory = new ObjectFactory();
        NdsRequest2 request = factory.createNdsRequest2();

        NdsRequest2.NP np = factory.createNdsRequest2NP();
        np.setINN(inn);
        request.getNP().add(np);

        log.info("Requesting stato for inn " + inn);

        NdsResponse2 response = (NdsResponse2) getWebServiceTemplate()
                .marshalSendAndReceive("http://npchk.nalog.ru/FNSNDSCAWS_2", request,
                        new SoapActionCallback("NdsRequest2"));

        return response;
    }
}
