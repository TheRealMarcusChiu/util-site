package com.marcuschiu.utilsite.model;

import lombok.Data;

import java.util.HashMap;

@Data
public class Request {
    String httpMethod;
    String pathInfo;
    String ipAddress;
    String port;
    HashMap<String, String> httpHeaders;
    HashMap<String, String> urlParameters;
}
