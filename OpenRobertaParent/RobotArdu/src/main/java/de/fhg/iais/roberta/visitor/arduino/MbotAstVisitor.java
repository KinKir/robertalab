package de.fhg.iais.roberta.visitor.arduino;

import de.fhg.iais.roberta.syntax.action.arduino.mbot.DisplayImageAction;
import de.fhg.iais.roberta.syntax.action.arduino.mbot.DisplayTextAction;
import de.fhg.iais.roberta.syntax.expr.arduino.LedMatrix;
import de.fhg.iais.roberta.syntax.sensor.arduino.mbot.Accelerometer;
import de.fhg.iais.roberta.syntax.sensor.arduino.mbot.AmbientLightSensor;
import de.fhg.iais.roberta.syntax.sensor.arduino.mbot.FlameSensor;
import de.fhg.iais.roberta.syntax.sensor.arduino.mbot.GetSampleSensor;
import de.fhg.iais.roberta.syntax.sensor.arduino.mbot.Joystick;
import de.fhg.iais.roberta.syntax.sensor.arduino.mbot.PIRMotionSensor;
import de.fhg.iais.roberta.syntax.sensor.arduino.mbot.VoltageSensor;
import de.fhg.iais.roberta.syntax.sensor.generic.TemperatureSensor;

public interface MbotAstVisitor<V> extends ArduinoAstVisitor<V> {
    /**
     * visit a {@link VoltageSensor}.
     *
     * @param temperatureSensor to be visited
     */
    @Override
    V visitTemperatureSensor(TemperatureSensor<V> temperatureSensor);

    V visitAmbientLightSensor(AmbientLightSensor<V> lightSensor);

    V visitPIRMotionSensor(PIRMotionSensor<V> motionSensor);

    V visitJoystick(Joystick<V> joystick);

    V visitAccelerometer(Accelerometer<V> accelerometer);

    V visitFlameSensor(FlameSensor<V> flameSensor);

    V visitImage(LedMatrix<V> ledMatrix);

    V visitDisplayImageAction(DisplayImageAction<V> displayImageAction);

    V visitDisplayTextAction(DisplayTextAction<V> displayTextAction);

    V visitVoltageSensor(VoltageSensor<V> voltageSensor);

    V visitMbotGetSampleSensor(GetSampleSensor<V> getSampleSensor);

}
