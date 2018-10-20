/*
 * Copyright 2017-2018, IoT Streams authors.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.streams.iot.building;

import io.streams.iot.sensors.impl.RandomHumiditySensor;
import io.streams.iot.sensors.impl.RandomPirSensor;
import io.streams.iot.sensors.impl.RandomTemperatureSensor;

import java.util.Map;

public class RandomSensorsBoxConfig extends SensorsBoxConfig {

    public static final String SENSORSBOX_TEMPERATURE_MAX = "SENSORSBOX_TEMPERATURE_MAX";
    public static final String SENSORSBOX_TEMPERATURE_MIN = "SENSORSBOX_TEMPERATURE_MIN";
    public static final String SENSORSBOX_HUMIDITY_MAX = "SENSORSBOX_HUMIDITY_MAX";
    public static final String SENSORSBOX_HUMIDITY_MIN = "SENSORSBOX_HUMIDITY_MIN";
    public static final String SENSORSBOX_PIR_MAX_INTERVAL = "SENSORSBOX_PIR_MAX_INTERVAL";

    private final int temperatureMin;
    private final int temperatureMax;
    private final int humidityMin;
    private final int humidityMax;
    private final int pirMaxInterval;

    public RandomSensorsBoxConfig(int samplingInterval,
                                  int temperatureMin, int temperatureMax,
                                  int humidityMin, int humidityMax,
                                  int pirMaxInterval) {
        super(samplingInterval);
        this.temperatureMin = temperatureMin;
        this.temperatureMax = temperatureMax;
        this.humidityMin = humidityMin;
        this.humidityMax = humidityMax;
        this.pirMaxInterval = pirMaxInterval;
    }

    public int temperatureMin() {
        return temperatureMin;
    }

    public int temperatureMax() {
        return temperatureMax;
    }

    public int humidityMin() {
        return humidityMin;
    }

    public int humidityMax() {
        return humidityMax;
    }

    public int pirMaxInterval() {
        return pirMaxInterval;
    }

    public static RandomSensorsBoxConfig fromMap(Map<String, String> map) {

        int samplingInterval = SensorsBoxConfig.DEFAULT_SAMPLING_INTERVAL;
        String samplingIntervalEnvVar = map.get(SensorsBoxConfig.SENSORSBOX_SAMPLING_INTERVAL);
        if (samplingIntervalEnvVar != null) {
            samplingInterval = Integer.valueOf(samplingIntervalEnvVar);
        }

        int temperatureMin = RandomTemperatureSensor.DEFAULT_CONFIG_MIN;
        String temperatureMinEnvVar = map.get(RandomSensorsBoxConfig.SENSORSBOX_TEMPERATURE_MIN);
        if (temperatureMinEnvVar != null) {
            temperatureMin = Integer.valueOf(temperatureMinEnvVar);
        }

        int temperatureMax = RandomTemperatureSensor.DEFAULT_CONFIG_MAX;
        String temperatureMaxEnvVar = map.get(RandomSensorsBoxConfig.SENSORSBOX_TEMPERATURE_MAX);
        if (temperatureMaxEnvVar != null) {
            temperatureMax = Integer.valueOf(temperatureMaxEnvVar);
        }

        int humidityMin = RandomHumiditySensor.DEFAULT_CONFIG_MIN;
        String humidityMinEnvVar = map.get(RandomSensorsBoxConfig.SENSORSBOX_HUMIDITY_MIN);
        if (humidityMinEnvVar != null) {
            humidityMin = Integer.valueOf(humidityMinEnvVar);
        }

        int humidityMax = RandomHumiditySensor.DEFAULT_CONFIG_MAX;
        String humidityMaxEnvVar = map.get(RandomSensorsBoxConfig.SENSORSBOX_HUMIDITY_MAX);
        if (humidityMaxEnvVar != null) {
            humidityMax = Integer.valueOf(humidityMaxEnvVar);
        }

        int pirMaxInterval = RandomPirSensor.DEFAULT_MAX_INTERVAL;
        String pirMaxIntervalEnvVar = map.get(RandomSensorsBoxConfig.SENSORSBOX_PIR_MAX_INTERVAL);
        if (pirMaxIntervalEnvVar != null) {
            pirMaxInterval = Integer.valueOf(pirMaxIntervalEnvVar);
        }

        return new RandomSensorsBoxConfig(samplingInterval,
                temperatureMin, temperatureMax,
                humidityMin, humidityMax,
                pirMaxInterval);
    }

    @Override
    public String toString() {
        return "RandomSensorsBoxConfig(" +
                "samplingInterval=" + samplingInterval +
                ",temperatureMin=" + temperatureMin +
                ",temperatureMax=" + temperatureMax +
                ",humidityMin=" + humidityMin +
                ",humidityMax=" + humidityMax +
                ",pirMaxInterval=" + pirMaxInterval +
                ")";

    }
}
