/*
 * Copyright 2017-2018, IoT Streams authors.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.streams.iot.sensors;

import java.util.Properties;

/**
 * Base interface for all the sensors
 */
public interface Sensor {

    /**
     * Sensor initialization
     *
     * @param config    properties bag with sensor configuration parameters
     */
    void init(Properties config);
}
