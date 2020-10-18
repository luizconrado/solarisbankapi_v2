package com.luizconrado.weisshaus.solarisbankapi_v2.utilities;

import com.luizconrado.weisshaus.solarisbankapi_v2.model.AuthenticationToken;
import org.glassfish.jersey.client.HttpUrlConnectorProvider;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class HttpClientResponse {

    public static Response getResponse(AuthenticationToken token, String host, WebTarget target, String method) {

        System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
        target.property(HttpUrlConnectorProvider.SET_METHOD_WORKAROUND, true);

        Invocation.Builder request = target
                .request(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .header("Host", host)
                .header("Authorization", token.getTokenType() + " " + token.getAccessToken())
                .header(HttpHeaders.ACCEPT_ENCODING, "gzip, deflate, br");


        if (method.toUpperCase().equals("GET")) {
            Response response = request.method(method.toUpperCase());
            return response;
        } else {
            System.out.println("Method not Implemented");
            return null;
        }


    }

}
