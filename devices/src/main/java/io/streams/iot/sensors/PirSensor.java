/*
 * Copyright 2017-2018, IoT Streams authors.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.streams.iot.sensors;

import io.vertx.core.Handler;

/**
 * Interface for passive infrared sensors (PIR)
 */
public interface PirSensor extends Sensor {

    /**
     * Set the handler called when motion is detected
     *
     * @param handler handler called when motion is detected
     * @return current sensor instance
     */
    PirSensor motionDetectedHandler(Handler<Void> handler);
}
