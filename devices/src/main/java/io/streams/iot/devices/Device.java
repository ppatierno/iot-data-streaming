/*
 * Copyright 2017-2018, IoT Streams authors.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.streams.iot.devices;

import java.util.Properties;

/**
 * Base interface for a generic device
 */
public interface Device {

    /**
     * Device initialization
     *
     * @param config    properties bag with device configuration parameters
     */
    void init(Properties config);
}