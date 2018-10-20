/*
 * Copyright 2017-2018, IoT Streams authors.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.streams.iot.sensors.impl;

import io.streams.iot.sensors.PirSensor;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;

import java.util.Properties;
import java.util.Random;

/**
 * A PIR sensor implementation which simulates motion detection every "random" interval
 */
public class RandomPirSensor implements PirSensor {

    public static final String CONFIG_MAX_INTERVAL = "max-interval";

    private Handler<Void> handler;
    private Vertx vertx;
    private int maxInterval;
    private Random random = new Random();

    public RandomPirSensor(Vertx vertx) {
        this.vertx = vertx;
    }

    @Override
    public PirSensor motionDetectedHandler(Handler<Void> handler) {
        this.handler = handler;
        return this;
    }

    @Override
    public void init(Properties config) {
        maxInterval = Integer.valueOf(config.getProperty(CONFIG_MAX_INTERVAL));

        Handler<Long> timer = new Handler<Long>() {

            @Override
            public void handle(Long aLong) {
                handler.handle(null);
                int interval = random.nextInt(maxInterval);
                vertx.setTimer(interval, this);
            }
        };

        this.vertx.setTimer(random.nextInt(maxInterval), timer);
    }
}
