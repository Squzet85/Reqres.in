package org.example.services;

import io.restassured.specification.RequestSpecification;
import org.example.helpers.PostRequestUtil;
import org.example.helpers.Specification;
import org.example.request.UserData;
import org.example.response.RegistrationResponse;

import static java.net.HttpURLConnection.HTTP_OK;
import static org.example.helpers.BaseUrl.REGISTRATION;

public final class RegistrationService {

    private RequestSpecification Specification() {
        return Specification.getReqSpec(REGISTRATION);
    }

    public RegistrationResponse successfulRegisterUser(UserData user) {
        return PostRequestUtil.doPostReturnItem(user, HTTP_OK, Specification(), RegistrationResponse.class);
    }
}
