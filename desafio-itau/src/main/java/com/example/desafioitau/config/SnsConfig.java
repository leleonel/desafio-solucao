package com.example.desafioitau.config;

import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sns.SnsClient;

public class SnsConfig {


    public SnsClient createSnsClient() {
        SnsClient snsClient = SnsClient.builder()
                .region(Region.SA_EAST_1)
                .credentialsProvider(ProfileCredentialsProvider.create())
                .build();

        return snsClient;
    }

    public void closeSnsClient(SnsClient snsClient) {
        snsClient.close();

    }

}
