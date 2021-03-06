package de.fhg.iais.roberta.mode.sensor.arduino.botnroll;

import de.fhg.iais.roberta.inter.mode.sensor.ILightSensorMode;

public enum LightSensorMode implements ILightSensorMode {
    RED( "light", "getSample" ), AMBIENTLIGHT( "getColorSensorAmbient", "Ambient" );

    private final String[] values;

    private LightSensorMode(String... values) {
        this.values = values;
    }

    @Override
    public String[] getValues() {
        return this.values;
    }

}