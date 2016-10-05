package com.anikitin.library.security.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by anikitin on 05.10.2016.
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface LoginService {

    @WebMethod
    public String getToken(String userName,String password);
}
