/*
 * Copyright 2017-2018, IoT Streams authors.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.streams.iot.sensors.impl;

import io.streams.iot.sensors.HumiditySensor;

import java.util.Properties;

/**
 * A humidity sensor implementation which provides random values in a range
 */
public class RandomHumiditySensor extends RandomValueSensor<Integer> implements HumiditySensor {

    private static final int DEFAULT_CONFIG_MIN = 50;
    private static final int DEFAULT_CONFIG_MAX = 55;

    @Override
    public void init(Properties config) {
        int min = DEFAULT_CONFIG_MIN;
        int max = DEFAULT_CONFIG_MAX;
        if (config != null) {
            min = config.getProperty(CONFIG_MIN) != null ?
                    Integer.valueOf(config.getProperty(CONFIG_MIN)) : DEFAULT_CONFIG_MIN;
            max = config.getProperty(CONFIG_MAX) != null ?
                    Integer.valueOf(config.getProperty(CONFIG_MAX)) : DEFAULT_CONFIG_MAX;
        }
        init(min, max);
    }

    @Override
    Integer getValue() {
        return min + random.nextInt(max - min);
    }

    @Override
    public int getHumidity() {
        return getValue();
    }
}
