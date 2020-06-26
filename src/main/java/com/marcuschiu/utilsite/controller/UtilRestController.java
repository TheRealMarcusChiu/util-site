package com.marcuschiu.utilsite.controller;

import com.marcuschiu.utilsite.model.MyIPAddressAndPort;
import com.marcuschiu.utilsite.model.Request;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;

@RestController
@RequestMapping(value = "/api")
public class UtilRestController {

    @GetMapping(value = "/my-ip-address-and-port")
    public @ResponseBody MyIPAddressAndPort myIPAddressAndPort(HttpServletRequest request) {
        MyIPAddressAndPort response = new MyIPAddressAndPort();

        // because its behind a nginx proxy, use the following headers:
        // - x-forwarded-for-port
        // - x-forwarded-for
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            if (headerName.equals("x-forwarded-for-port")) {
                response.setPort(request.getHeader(headerName));
            } else if (headerName.equals("x-forwarded-for")) {
                response.setIpAddress(request.getHeader(headerName));
            }
        }

        return response;
    }

    @GetMapping(value = "/request")
    public @ResponseBody Request request(HttpServletRequest request) {
        Request r = new Request();
        r.setHttpMethod(request.getMethod());
        r.setPathInfo(request.getPathInfo());

        HashMap<String, String> headers = new HashMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            headers.put(headerName, request.getHeader(headerName));
        }

        // because its behind a nginx proxy, use the following headers:
        // - x-forwarded-for-port
        // - x-forwarded-for
        r.setIpAddress(headers.get("x-forwarded-for"));
        r.setPort(headers.get("x-forwarded-for-port"));
        headers.remove("x-forwarded-for");
        headers.remove("x-forwarded-for-port");

        r.setHttpHeaders(headers);

        HashMap<String, String> parameters = new HashMap<>();
        Enumeration<String> parameterNames = request.getParameterNames();
        while(parameterNames.hasMoreElements()) {
            String parameterName = parameterNames.nextElement();
            headers.put(parameterName, request.getParameter(parameterName));
        }
        r.setUrlParameters(parameters);

        return r;
    }
}
