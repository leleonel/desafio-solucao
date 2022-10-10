package com.example.desafioitau.config;

import com.example.desafioitau.services.SqsService;
import lombok.AllArgsConstructor;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;


@AllArgsConstructor
public class SqsConfig {

    public SqsClient createSqsClient() throws Exception {

        try{
            SqsClient sqsClient = SqsClient.builder()
                    .region(Region.SA_EAST_1)
                    .credentialsProvider(ProfileCredentialsProvider.create())
                    .build();
            return sqsClient;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    public String listSqsQueueUrl(SqsClient sqsClient, String queueName) throws Exception {

        try{
            String queueUrl = SqsService.listQueues(sqsClient, queueName);
            return queueUrl;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

}
