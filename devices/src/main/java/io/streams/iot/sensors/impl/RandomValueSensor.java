/*
 * Copyright 2017-2018, IoT Streams authors.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.streams.iot.sensors.impl;

import java.util.Random;

/**
 * A sensor base class for generating random value in a range
 *
 * @param <T> value type returned by the sensor
 */
public abstract class RandomValueSensor<T> {

    public static final String CONFIG_MIN = "min";
    public static final String CONFIG_MAX = "max";

    protected T min;
    protected T max;
    protected Random random = new Random();

    public void init(T min, T max) {
        this.min = min;
        this.max = max;
    }

    abstract T getValue();
}
