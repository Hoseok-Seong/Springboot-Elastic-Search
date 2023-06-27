package com.example.search.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Base64;

@Configuration
public class MyClientConfig extends ElasticsearchConfiguration {

    @Value("${elasticsearch.url}")
    private String elasticsearchServer;

    @Override
    public ClientConfiguration clientConfiguration() {
        return ClientConfiguration.builder()
                .connectedTo(elasticsearchServer)
                .build();
    }

//    private SSLContext getSSLContext() throws
//            CertificateException,
//            IOException, NoSuchAlgorithmException,
//            KeyStoreException,
//            KeyManagementException
//    {
//        byte[] decode = Base64.getDecoder().decode(certificateBase64);
//
//        CertificateFactory cf = CertificateFactory.getInstance("X.509");
//
//        Certificate ca;
//        try (InputStream certificateInputStream = new ByteArrayInputStream(decode)) {
//            ca = cf.generateCertificate(certificateInputStream);
//        }
//
//        String keyStoreType = KeyStore.getDefaultType();
//        KeyStore keyStore = KeyStore.getInstance(keyStoreType);
//        keyStore.load(null, null);
//        keyStore.setCertificateEntry("ca", ca);
//
//        String tmfAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
//        TrustManagerFactory tmf =
//                TrustManagerFactory.getInstance(tmfAlgorithm);
//        tmf.init(keyStore);
//
//        SSLContext context = SSLContext.getInstance("TLS");
//        context.init(null, tmf.getTrustManagers(), null);
//        return context;
//    }
}
