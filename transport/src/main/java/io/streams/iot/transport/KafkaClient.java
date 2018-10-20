/*
 * Copyright 2017-2018, IoT Streams authors.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.streams.iot.transport;

import io.vertx.core.Vertx;
import io.vertx.kafka.client.consumer.KafkaConsumer;
import io.vertx.kafka.client.producer.KafkaProducer;

import java.util.Properties;

public class KafkaClient extends Client {

    private KafkaProducer producer;
    private KafkaConsumer consumer;

    public KafkaClient(Vertx vertx) {
        super(vertx);
    }

    @Override
    public void init(Properties config) {

    }
}
