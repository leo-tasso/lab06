package it.unibo.exceptions.fakenetwork.api;

import java.io.IOException;

public class NetworkExeption extends IOException {

    public NetworkExeption() {
        super("Network error: no response");
    }

    public NetworkExeption(final String message) {
        super("Network error while sending message: " + message);
    }

}
