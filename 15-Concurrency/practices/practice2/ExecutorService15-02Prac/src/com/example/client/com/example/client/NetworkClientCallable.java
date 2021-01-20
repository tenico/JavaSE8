package com.example.client;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class NetworkClientCallable implements Callable<RequestResponse> {

    private final RequestResponse refResponse;

    public NetworkClientCallable(RequestResponse refResponse) {
        this.refResponse = refResponse;
    }

    @Override
    public RequestResponse call() throws IOException {
        try (Socket sock = new Socket(refResponse.host, refResponse.port);
                Scanner scanner = new Scanner(sock.getInputStream())) {
                    refResponse.response = scanner.next();
            return refResponse;
        }
    }
}