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
import io.streams.iot.sensors.impl.RandomValueSensor;
import io.vertx.core.Vertx;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Properties;
import java.util.UUID;

public class Main {

    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        RandomSensorsBoxConfig sensorsBoxConfig = RandomSensorsBoxConfig.fromMap(System.getenv());
        Vertx vertx = Vertx.vertx();
        Main.run(vertx, sensorsBoxConfig);
    }

    private static void run(Vertx vertx, RandomSensorsBoxConfig sensorsBoxConfig) {

        log.info(sensorsBoxConfig);

        TemperatureSensor temperatureSensor = new RandomTemperatureSensor();
        Properties temperatureProps = new Properties();
        temperatureProps.setProperty(RandomValueSensor.CONFIG_MIN, String.valueOf(sensorsBoxConfig.temperatureMin()));
        temperatureProps.setProperty(RandomValueSensor.CONFIG_MAX, String.valueOf(sensorsBoxConfig.temperatureMax()));
        temperatureSensor.init(temperatureProps);

        HumiditySensor humiditySensor = new RandomHumiditySensor();
        Properties humidityProps = new Properties();
        humidityProps.setProperty(RandomValueSensor.CONFIG_MIN, String.valueOf(sensorsBoxConfig.humidityMin()));
        humidityProps.setProperty(RandomValueSensor.CONFIG_MAX, String.valueOf(sensorsBoxConfig.humidityMax()));
        humiditySensor.init(humidityProps);

        PirSensor pirSensor = new RandomPirSensor(vertx);
        Properties pirProps = new Properties();
        pirProps.setProperty(RandomPirSensor.CONFIG_MAX_INTERVAL, String.valueOf(sensorsBoxConfig.pirMaxInterval()));
        pirSensor.init(pirProps);

        SensorsBox sensorsBox = new SensorsBox.Builder(vertx, UUID.randomUUID().toString())
                .withTemperatureSensor(temperatureSensor)
                .withHumiditySensor(humiditySensor)
                .withPirSensor(pirSensor)
                .build();

        Properties sensorsProps = new Properties();
        sensorsProps.setProperty(SensorsBox.SAMPLING_INTERVAL, String.valueOf(sensorsBoxConfig.samplingInterval()));
        sensorsBox.init(sensorsProps);

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
