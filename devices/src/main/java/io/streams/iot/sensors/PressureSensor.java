/*
 * Copyright 2017-2018, IoT Streams authors.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.streams.iot.sensors;

/**
 * Interface for sensors providing pressure value
 */
public interface PressureSensor extends Sensor {

    /**
     * Return the read pressure value
     *
     * @return  pressure value
     */
    int getPressure();
}