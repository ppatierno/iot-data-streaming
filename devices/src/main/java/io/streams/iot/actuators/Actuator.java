/*
 * Copyright 2017-2018, IoT Streams authors.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.streams.iot.actuators;

import java.util.Properties;

/**
 * Base interface for all the actuators
 */
public interface Actuator {

    /**
     * Actuator initialization
     *
     * @param config    properties bag with actuator configuration parameters
     */
    void init(Properties config);
}
