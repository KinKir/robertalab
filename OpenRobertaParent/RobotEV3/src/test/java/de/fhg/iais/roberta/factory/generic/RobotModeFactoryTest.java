package de.fhg.iais.roberta.factory.generic;

import java.util.Properties;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import de.fhg.iais.roberta.factory.ev3.lejos.v0.Factory;
import de.fhg.iais.roberta.mode.action.DriveDirection;
import de.fhg.iais.roberta.mode.action.MotorMoveMode;
import de.fhg.iais.roberta.mode.action.MotorSide;
import de.fhg.iais.roberta.mode.action.MotorStopMode;
import de.fhg.iais.roberta.mode.action.TurnDirection;
import de.fhg.iais.roberta.mode.action.ev3.ActorPort;
import de.fhg.iais.roberta.mode.action.ev3.BlinkMode;
import de.fhg.iais.roberta.mode.action.ev3.BrickLedColor;
import de.fhg.iais.roberta.mode.action.ev3.ShowPicture;
import de.fhg.iais.roberta.mode.general.IndexLocation;
import de.fhg.iais.roberta.mode.general.ListElementOperations;
import de.fhg.iais.roberta.mode.general.PickColor;
import de.fhg.iais.roberta.mode.sensor.TimerSensorMode;
import de.fhg.iais.roberta.mode.sensor.ev3.BrickKey;
import de.fhg.iais.roberta.mode.sensor.ev3.ColorSensorMode;
import de.fhg.iais.roberta.mode.sensor.ev3.GyroSensorMode;
import de.fhg.iais.roberta.mode.sensor.ev3.InfraredSensorMode;
import de.fhg.iais.roberta.mode.sensor.ev3.MotorTachoMode;
import de.fhg.iais.roberta.mode.sensor.ev3.SensorPort;
import de.fhg.iais.roberta.mode.sensor.ev3.UltrasonicSensorMode;
import de.fhg.iais.roberta.util.RobertaProperties;
import de.fhg.iais.roberta.util.Util1;
import de.fhg.iais.roberta.util.dbc.DbcException;

public class RobotModeFactoryTest {
    Factory factory = new Factory();

    @BeforeClass
    public static void loadPropertiesForTests() {
        Properties properties = Util1.loadProperties(null);
        RobertaProperties.setRobertaProperties(properties);
    }

    @Test
    public void getIndexLocationFromString() {
        Assert.assertEquals(this.factory.getIndexLocation("FIRST"), IndexLocation.FIRST);
    }

    @Test
    public void getIndexLocationByAlternativeName() {
        Assert.assertEquals(this.factory.getIndexLocation("FROMSTART"), IndexLocation.FROM_START);
    }

    @Test(expected = DbcException.class)
    public void invalidIndexLocation() {
        this.factory.getIndexLocation("FROMSTART1");
    }

    @Test
    public void getListElementOperationFromString() {
        Assert.assertEquals(this.factory.getListElementOpertaion("GET"), ListElementOperations.GET);
    }

    @Test(expected = DbcException.class)
    public void invalidListElementOperation() {
        this.factory.getListElementOpertaion("FROMSTART1");
    }

    @Test
    public void getPickColorFromString() {
        Assert.assertEquals(this.factory.getPickColor("RED"), PickColor.RED);
    }

    @Test
    public void getPickColorByAlternativeName() {
        Assert.assertEquals(this.factory.getPickColor("#00642E"), PickColor.GREEN);
    }

    @Test
    public void getPickColorById() {
        Assert.assertEquals(this.factory.getPickColor(-1), PickColor.NONE);
    }

    @Test(expected = DbcException.class)
    public void invalidPickColor() {
        this.factory.getPickColor("18");
    }

    @Test
    public void getActorPortFromString() {
        Assert.assertEquals(this.factory.getActorPort("A"), ActorPort.A);
    }

    @Test
    public void getActorPortByAlternativeName() {
        Assert.assertEquals(this.factory.getActorPort("MB"), ActorPort.B);
    }

    @Test
    public void getActorPortXmlName() {
        Assert.assertEquals(ActorPort.B.getXmlName(), "MB");
    }

    @Test(expected = DbcException.class)
    public void invalidActorPort() {
        this.factory.getActorPort("Q");
    }

    @Test
    public void getBlinkModeFromString() {
        Assert.assertEquals(this.factory.getBlinkMode("FLASH"), BlinkMode.FLASH);
    }

    @Test(expected = DbcException.class)
    public void invalidBlinkMode() {
        this.factory.getBlinkMode("18");
    }

    @Test
    public void getBrickLedColorFromString() {
        Assert.assertEquals(this.factory.getBrickLedColor("ORANGE"), BrickLedColor.ORANGE);
    }

    @Test(expected = DbcException.class)
    public void invalidBrickLedColor() {
        this.factory.getBrickLedColor("Q");
    }

    @Test
    public void getShowPictureFromString() {
        Assert.assertEquals(this.factory.getShowPicture("EYESCLOSED"), ShowPicture.EYESCLOSED);
    }

    @Test
    public void getShowPictureByAlternativeName() {
        Assert.assertEquals(this.factory.getShowPicture("BRILLE"), ShowPicture.OLDGLASSES);
    }

    @Test(expected = DbcException.class)
    public void invalidShowPicture() {
        this.factory.getShowPicture("Q");
    }

    @Test
    public void getTurnDirectionFromString() {
        Assert.assertEquals(this.factory.getTurnDirection("LEFT"), TurnDirection.LEFT);
    }

    @Test(expected = DbcException.class)
    public void invalidTurnDirection() {
        this.factory.getTurnDirection("Q");
    }

    @Test
    public void getMotorMoveModeFromString() {
        Assert.assertEquals(this.factory.getMotorMoveMode("ROTATIONS"), MotorMoveMode.ROTATIONS);
    }

    @Test(expected = DbcException.class)
    public void invalidMotorMoveMode() {
        this.factory.getMotorMoveMode("Q");
    }

    @Test
    public void getMotorStopModeFromString() {
        Assert.assertEquals(this.factory.getMotorStopMode("FLOAT"), MotorStopMode.FLOAT);
    }

    @Test(expected = DbcException.class)
    public void invalidMotorStopMode() {
        this.factory.getMotorStopMode("Q");
    }

    @Test
    public void getMotorSideFromString() {
        Assert.assertEquals(this.factory.getMotorSide("LEFT"), MotorSide.LEFT);
    }

    @Test
    public void getMotorSideByAlternativeName() {
        Assert.assertEquals(this.factory.getMotorSide("right"), MotorSide.RIGHT);
    }

    @Test(expected = DbcException.class)
    public void invalidMotorSide() {
        this.factory.getMotorSide("Q");
    }

    @Test
    public void getDriveDirectionFromString() {
        Assert.assertEquals(this.factory.getDriveDirection("BACKWARD"), DriveDirection.BACKWARD);
    }

    @Test
    public void getDriveDirectionByAlternativeName() {
        Assert.assertEquals(this.factory.getDriveDirection("OFF"), DriveDirection.FOREWARD);
    }

    @Test(expected = DbcException.class)
    public void invalidDriveDirection() {
        this.factory.getDriveDirection("Q");
    }

    @Test
    public void getBrickKeyFromString() {
        Assert.assertEquals(this.factory.getBrickKey("DOWN"), BrickKey.DOWN);
    }

    @Test(expected = DbcException.class)
    public void invalidBrickKey() {
        this.factory.getBrickKey("Q");
    }

    @Test
    public void getColorSensorModeFromString() {
        Assert.assertEquals(this.factory.getColorSensorMode("AMBIENTLIGHT"), ColorSensorMode.AMBIENTLIGHT);
    }

    @Test
    public void getColorSensorModeByAlternativeName() {
        Assert.assertEquals(this.factory.getColorSensorMode("ColorID"), ColorSensorMode.COLOUR);
    }

    @Test(expected = DbcException.class)
    public void invalidColorSensorMode() {
        this.factory.getColorSensorMode("Q");
    }

    @Test
    public void getGyroSensorModeFromString() {
        Assert.assertEquals(this.factory.getGyroSensorMode("ANGLE"), GyroSensorMode.ANGLE);
    }

    @Test
    public void getGyroSensorModeByAlternativeName() {
        Assert.assertEquals(this.factory.getGyroSensorMode("Rate"), GyroSensorMode.RATE);
    }

    @Test(expected = DbcException.class)
    public void invalidGyroSensorMode() {
        this.factory.getGyroSensorMode("Q");
    }

    @Test
    public void getInfraredSensorModeFromString() {
        Assert.assertEquals(this.factory.getInfraredSensorMode("DISTANCE"), InfraredSensorMode.DISTANCE);
    }

    @Test
    public void getInfraredSensorModeByAlternativeName() {
        Assert.assertEquals(this.factory.getInfraredSensorMode("Seek"), InfraredSensorMode.SEEK);
    }

    @Test(expected = DbcException.class)
    public void invalidInfraredSensorMode() {
        this.factory.getInfraredSensorMode("Q");
    }

    @Test
    public void getTimerSensorModeFromString() {
        Assert.assertEquals(this.factory.getTimerSensorMode("GET_SAMPLE"), TimerSensorMode.GET_SAMPLE);
    }

    @Test(expected = DbcException.class)
    public void invalidTimerSensorMode() {
        this.factory.getTimerSensorMode("Q");
    }

    @Test
    public void getMotorTachoModeFromString() {
        Assert.assertEquals(this.factory.getMotorTachoMode("DISTANCE"), MotorTachoMode.DISTANCE);
    }

    @Test(expected = DbcException.class)
    public void invalidMotorTachoMode() {
        this.factory.getMotorTachoMode("Q");
    }

    @Test
    public void getUltrasonicSensorModeFromString() {
        Assert.assertEquals(this.factory.getUltrasonicSensorMode("DISTANCE"), UltrasonicSensorMode.DISTANCE);
    }

    @Test
    public void getUltrasonicSensorModeByAlternativeName() {
        Assert.assertEquals(this.factory.getUltrasonicSensorMode("Listen"), UltrasonicSensorMode.PRESENCE);
    }

    @Test(expected = DbcException.class)
    public void invalidUltrasonicSensorMode() {
        this.factory.getUltrasonicSensorMode("Q");
    }

    @Test
    public void getSensorPortFromString() {
        Assert.assertEquals(this.factory.getSensorPort("S1"), SensorPort.S1);
    }

    @Test
    public void getSensorPortByAlternativeName() {
        Assert.assertEquals(this.factory.getSensorPort("4"), SensorPort.S4);
    }

    @Test(expected = DbcException.class)
    public void invalidSensorPort() {
        this.factory.getSensorPort("Q");
    }
}
