/*
 * Copyright 2017-2018, IoT Streams authors.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.streams.iot.sensors.impl;

import io.streams.iot.sensors.TemperatureSensor;

import java.util.Properties;

/**
 * A temperature sensor implementation which provides random values in a range
 */
public class RandomTemperatureSensor extends RandomValueSensor<Integer> implements TemperatureSensor {

    @Override
    public void init(Properties config) {
        init(Integer.valueOf(config.getProperty(CONFIG_MIN)),
                Integer.valueOf(config.getProperty(CONFIG_MAX)));
    }

    @Override
    Integer getValue() {
        return min + random.nextInt(max - min);
    }

    @Override
    public int getTemperature() {
        return getValue();
    }
}