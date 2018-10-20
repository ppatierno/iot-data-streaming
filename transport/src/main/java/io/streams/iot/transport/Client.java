/*
 * Copyright 2017-2018, IoT Streams authors.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.streams.iot.transport;

import io.vertx.core.Vertx;

import java.util.Properties;

public abstract class Client {

    protected final Vertx vertx;

    /**
     * Client initialization
     *
     * @param config properties bag with client configuration parameters
     */
    public abstract void init(Properties config);

    public Client(Vertx vertx) {
        this.vertx = vertx;
    }
}
