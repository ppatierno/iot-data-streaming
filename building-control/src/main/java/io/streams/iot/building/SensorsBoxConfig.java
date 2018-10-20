/*
 * Copyright 2017-2018, IoT Streams authors.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.streams.iot.building;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Map;

/**
 * Sensors box configuration
 */
public abstract class SensorsBoxConfig {

    public static final String SENSORSBOX_SAMPLING_INTERVAL = "SENSORSBOX_SAMPLING_INTERVAL";

    public static final int DEFAULT_SAMPLING_INTERVAL = 1000; // ms

    protected final int samplingInterval;

    public SensorsBoxConfig(int samplingInterval) {
        this.samplingInterval = samplingInterval;
    }

    public int samplingInterval() {
        return samplingInterval;
    }
}
