package com.holddie.rules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;

public class UsesExternalResource {
    Server myServer = new Server();

    @Rule
    public final ExternalResource resource =
            new ExternalResource() {
                @Override
                protected void before() {
                    myServer.connect();
                }

                @Override
                protected void after() {
                    myServer.disconnect();
                }
            };

    @Test
    public void testFoo() {
        new Client().run(myServer);
    }

    private class Server {
        void connect() {
            System.out.println("connect");
        }

        void disconnect() {
            System.out.println("disconnect");
        }
    }

    private class Client {
        void run(Server myServer) {
            System.out.println("myServer");
        }
    }
}
