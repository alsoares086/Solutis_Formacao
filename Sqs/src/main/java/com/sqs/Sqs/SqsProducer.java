package com.sqs.Sqs;

import java.net.URI;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

public class SqsProducer {

    private static final String QUEUE_URL = "http://localhost:4566/000000000000/FilaTeste";

    public static void main(String[] args) {

        // Cria o cliente SQS
        SqsClient sqsClient = SqsClient.builder()
                .region(Region.SA_EAST_1)
                .endpointOverride(URI.create("http://localhost:4566"))
                .build();

        // Envia uma mensagem
        sendMessage(sqsClient, "Olá, esta é uma mensagem de teste!");

        // Fecha o cliente
        sqsClient.close();
    }

    public static void sendMessage(SqsClient sqsClient, String message) {
        SendMessageRequest sendMsgRequest = SendMessageRequest.builder()
                .queueUrl(QUEUE_URL)
                .messageBody(message)
                .delaySeconds(0)
                .build();

        sqsClient.sendMessage(sendMsgRequest);
        System.out.println("Mensagem enviada: " + message);
    }
}
