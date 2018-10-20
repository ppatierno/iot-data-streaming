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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.UUID;

public class Main {

    private static final Logger log = LogManager.getLogger(Main.class);

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

        SensorsBox sensorsBox = new SensorsBox.Builder(vertx, UUID.randomUUID().toString())
                .withTemperatureSensor(temperatureSensor)
                .withHumiditySensor(humiditySensor)
                .withPirSensor(pirSensor)
                .build();

        // TODO: get sensors box configuration from sensorsBoxConfig
        sensorsBox.init(null);

        vertx.deployVerticle(sensorsBox, result -> {
            if (result.succeeded()) {
                log.info("SensorsBox {} verticle started", sensorsBox.deviceId());
            } else {
                log.error("SensorsBox failed to start", result.cause());
                System.exit(1);
            }
        });
    }
}
