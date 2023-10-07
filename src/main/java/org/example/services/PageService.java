package org.example.services;

import io.restassured.specification.RequestSpecification;
import org.example.helpers.GetRequestUtil;
import org.example.helpers.Specification;
import org.example.response.UserResponse;

import java.util.List;

import static java.net.HttpURLConnection.HTTP_OK;
import static org.example.helpers.BaseUrl.LIST_USERS;

public final class PageService {

    public RequestSpecification Specification() {
        return Specification.getReqSpec(LIST_USERS);
    }

    public List<UserResponse> getListUsers(int numberPage) {
        return GetRequestUtil.doGetReturnList(Specification(), HTTP_OK, numberPage, UserResponse.class);
    }
}
