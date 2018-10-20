/*
 * Copyright 2017-2018, IoT Streams authors.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.streams.iot.building;

import io.streams.iot.sensors.HumiditySensor;
import io.streams.iot.sensors.PirSensor;
import io.streams.iot.sensors.TemperatureSensor;
import io.streams.iot.sensors.impl.RandomHumiditySensor;
import io.streams.iot.sensors.impl.RandomPirSensor;
import io.streams.iot.sensors.impl.RandomTemperatureSensor;
import io.vertx.core.Vertx;

public class Main {

    public static void main(String[] args) {
        SensorsBoxConfig sensorsBoxConfig = SensorsBoxConfig.fromMap(System.getenv());
        Vertx vertx = Vertx.vertx();
        Main.run(vertx, sensorsBoxConfig);
    }

    private static void run(Vertx vertx, SensorsBoxConfig sensorsBoxConfig) {

        // TODO: get sensors configuration from sensorsBoxConfig
        TemperatureSensor temperatureSensor = new RandomTemperatureSensor();
        temperatureSensor.init(null);

        HumiditySensor humiditySensor = new RandomHumiditySensor();
        humiditySensor.init(null);

        PirSensor pirSensor = new RandomPirSensor(vertx);
        pirSensor.init(null);

        SensorsBox sensorsBox = new SensorsBox.Builder("device-id")
                .withTemperatureSensor(temperatureSensor)
                .withHumiditySensor(humiditySensor)
                .withPirSensor(pirSensor)
                .build();

        // TODO: get sensors box configuration from sensorsBoxConfig
        sensorsBox.init(null);

        vertx.deployVerticle(sensorsBox, result -> {
            if (result.succeeded()) {
                // TODO: just logging?
            } else {
                System.exit(1);
            }
        });
    }
}
