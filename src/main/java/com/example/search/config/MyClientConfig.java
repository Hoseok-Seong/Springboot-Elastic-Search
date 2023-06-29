package com.example.search.config;

import co.elastic.clients.transport.TransportUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import javax.net.ssl.SSLContext;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.example.search.repository")
public class MyClientConfig extends ElasticsearchConfiguration {

    private static final String elasticsearchServer = System.getenv("ELASTIC_URL");

    private static final String username = System.getenv("ELASTIC_USERNAME");
    private static final String password = System.getenv("ELASTIC_PASSWORD");

    private static final String fingerprint = System.getenv("ELASTIC_FINGERPRINT");

    SSLContext sslContext = TransportUtils
            .sslContextFromCaFingerprint(fingerprint);

    @Override
    public ClientConfiguration clientConfiguration() {
        return ClientConfiguration.builder()
                .connectedTo(elasticsearchServer)
                .usingSsl(sslContext)
                .withBasicAuth(username, password)
                .build();
    }
}
