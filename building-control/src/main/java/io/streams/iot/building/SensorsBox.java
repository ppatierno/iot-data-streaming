/*
 * Copyright 2017-2018, IoT Streams authors.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.streams.iot.building;

import io.streams.iot.devices.Device;
import io.streams.iot.sensors.HumiditySensor;
import io.streams.iot.sensors.PirSensor;
import io.streams.iot.sensors.TemperatureSensor;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

import java.util.Properties;

/**
 * A device implementing a sensors box
 */
public class SensorsBox extends AbstractVerticle implements Device {

    private String deviceId;
    private TemperatureSensor temperatureSensor;
    private HumiditySensor humiditySensor;
    private PirSensor pirSensor;

    public String deviceId() {
        return deviceId;
    }

    public TemperatureSensor temperatureSensor() {
        return temperatureSensor;
    }

    public HumiditySensor humiditySensor() {
        return humiditySensor;
    }

    public PirSensor pirSensor() {
        return pirSensor;
    }

    @Override
    public void start(Future<Void> startFuture) throws Exception {
        super.start(startFuture);
    }

    @Override
    public void stop(Future<Void> stopFuture) throws Exception {
        super.stop(stopFuture);
    }

    @Override
    public void init(Properties config) {
        // TODO
    }

    public static class Builder {

        private String deviceId;
        private TemperatureSensor temperatureSensor;
        private HumiditySensor humiditySensor;
        private PirSensor pirSensor;

        public Builder(String deviceId) {
            this.deviceId = deviceId;
        }

        public Builder withTemperatureSensor(TemperatureSensor temperatureSensor) {
            this.temperatureSensor = temperatureSensor;
            return this;
        }

        public Builder withHumiditySensor(HumiditySensor humiditySensor) {
            this.humiditySensor = humiditySensor;
            return this;
        }

        public Builder withPirSensor(PirSensor pirSensor) {
            this.pirSensor = pirSensor;
            return this;
        }

        public SensorsBox build() {
            SensorsBox sensorsBox = new SensorsBox();
            sensorsBox.deviceId = deviceId;
            sensorsBox.temperatureSensor = temperatureSensor;
            sensorsBox.humiditySensor = humiditySensor;
            sensorsBox.pirSensor = pirSensor;
            return sensorsBox;
        }
    }
}
