package com.marcuschiu.utilsite.controller;

import com.marcuschiu.utilsite.model.Request;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;

@RestController
public class UtilRestController {

    @GetMapping(value="/display-request-data")
    public @ResponseBody Request processData(HttpServletRequest request) {
        Request r = new Request();
        r.setHTTPMethod(request.getMethod());
        r.setPathInfo(request.getPathInfo());
        r.setSourceIPAddress(request.getRemoteAddr());
        r.setSourcePortNumber(request.getRemotePort());

        HashMap<String, String> headers = new HashMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            headers.put(headerName, request.getHeader(headerName));
        }
        r.setHTTPHeaders(headers);

        HashMap<String, String> parameters = new HashMap<>();
        Enumeration<String> parameterNames = request.getParameterNames();
        while(parameterNames.hasMoreElements()) {
            String parameterName = parameterNames.nextElement();
            headers.put(parameterName, request.getParameter(parameterName));
        }
        r.setURLParameters(parameters);

        return r;
    }
}
