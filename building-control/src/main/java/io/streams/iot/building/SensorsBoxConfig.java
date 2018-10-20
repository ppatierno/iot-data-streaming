/*
 * Copyright 2017-2018, IoT Streams authors.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.streams.iot.building;

/**
 * Sensors box configuration
 */
public abstract class SensorsBoxConfig {

    public static final String SENSORSBOX_SAMPLING_INTERVAL = "SENSORSBOX_SAMPLING_INTERVAL";
    public static final String SENSORSBOX_TRANSPORT_CLASS = "SENSORSBOX_TRANSPORT_CLASS";

    public static final int DEFAULT_SAMPLING_INTERVAL = 1000; // ms
    public static final String DEFAULT_TRANSPORT_CLASS = "io.streams.iot.transport.KafkaClient";

    protected final int samplingInterval;
    protected final String transportClass;

    public SensorsBoxConfig(int samplingInterval, String transportClass) {
        this.samplingInterval = samplingInterval;
        this.transportClass = transportClass;
    }

    public int samplingInterval() {
        return samplingInterval;
    }

    public String transportClass() {
        return transportClass;
    }
}
