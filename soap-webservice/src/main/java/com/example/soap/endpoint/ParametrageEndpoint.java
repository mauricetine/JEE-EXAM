package com.example.soap.endpoint;

import com.example.soap.model.Classe;
import com.example.soap.model.Sector;
import com.example.soap.service.ParametrageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.stereotype.Component;

import java.util.List;

@Endpoint
@Component
public class ParametrageEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/soap";

    @Autowired
    private ParametrageService service;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetAllSectorsRequest")
    @ResponsePayload
    public GetAllSectorsResponse getAllSectors(@RequestPayload Object request) {
        GetAllSectorsResponse resp = new GetAllSectorsResponse();
        resp.getSectors().addAll(service.getAllSectors());
        return resp;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetClassesBySectorIdRequest")
    @ResponsePayload
    public GetClassesBySectorIdResponse getClassesBySectorId(@RequestPayload GetClassesBySectorIdRequest request) {
        GetClassesBySectorIdResponse resp = new GetClassesBySectorIdResponse();
        resp.getClasses().addAll(service.getClassesBySectorId(request.getSectorId()));
        return resp;
    }
}
