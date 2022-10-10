package com.example.desafioitau.publishers;

import com.example.desafioitau.config.SnsConfig;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;
import software.amazon.awssdk.services.sns.model.PublishResponse;
import software.amazon.awssdk.services.sns.model.SnsException;

public class PublishMessageSns {


    public static void pubTopic() {

        SnsConfig snsConfig = new SnsConfig();
        final SnsClient snsClient = snsConfig.createSnsClient();
        final String topic = "arn:aws:sns:sa-east-1:522899399459:notifica-utilizacao-limite";
        final String message = "Atenção: Você está com limite negativo!";


        try {
            PublishRequest request = PublishRequest.builder()
                    .message(message)
                    .topicArn(topic)
                    .build();

            PublishResponse result = snsClient.publish(request);
            System.out.println(result.messageId() + " Message sent. Status is " + result.sdkHttpResponse().statusCode());
            snsClient.close();
        } catch (SnsException e) {
            System.err.println(e.awsErrorDetails().errorMessage());
            snsClient.close();
            System.exit(1);
        }
    }





}
