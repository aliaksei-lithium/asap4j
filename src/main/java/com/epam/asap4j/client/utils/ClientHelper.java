package com.epam.asap4j.client.utils;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.client.urlconnection.HTTPSProperties;

import javax.net.ssl.*;
import java.security.SecureRandom;

/**
 * @author Aliaksandr_Novik
 */
public class ClientHelper {

    public static ClientConfig configureClient() {
        TrustManager[] certs = new TrustManager[]{
                new X509TrustManager() {
                    @Override
                    public void checkClientTrusted(java.security.cert.X509Certificate[] xcs, String string) throws java.security.cert.CertificateException {
                    }

                    @Override
                    public void checkServerTrusted(java.security.cert.X509Certificate[] xcs, String string) throws java.security.cert.CertificateException {
                    }

                    @Override
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
                }
        };
        SSLContext ctx = null;
        try {
            ctx = SSLContext.getInstance("TLS");
            ctx.init(null, certs, new SecureRandom());
        } catch (java.security.GeneralSecurityException ex) {
        }
        HttpsURLConnection.setDefaultSSLSocketFactory(ctx.getSocketFactory());

        ClientConfig config = new DefaultClientConfig();
        try {
            config.getProperties().put(HTTPSProperties.PROPERTY_HTTPS_PROPERTIES, new HTTPSProperties(
                    new HostnameVerifier() {
                        @Override
                        public boolean verify(String hostname, SSLSession session) {
                            return true;
                        }
                    },
                    ctx
            ));
        } catch (Exception e) {
        }
        return config;
    }

    public static Client createClient() {
        return Client.create(ClientHelper.configureClient());
    }
}
