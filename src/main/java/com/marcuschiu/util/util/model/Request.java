package com.marcuschiu.util.util.model;

import lombok.Data;

import java.util.HashMap;

@Data
public class Request {
    String HTTPMethod;
    String pathInfo;
    String sourceIPAddress;
    Integer sourcePortNumber;
    HashMap<String, String> HTTPHeaders;
    HashMap<String, String> URLParameters;
}
