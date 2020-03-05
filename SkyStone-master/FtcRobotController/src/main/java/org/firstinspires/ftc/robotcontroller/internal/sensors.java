package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@TeleOp(name = "sensors", group = "9191")
public class sensors extends OpMode {
    private DistanceSensor distanceSensor;
    private ColorSensor colorSensor;
    private Servo servo1;
    private DigitalChannel  touch;
    @Override
    public void init() {
        distanceSensor = hardwareMap.get(DistanceSensor.class, "CD");
        colorSensor = hardwareMap.get(ColorSensor.class, "CD");
        touch = hardwareMap.get(DigitalChannel.class, "TS");
        servo1 = hardwareMap.servo.get("s");
        touch.setMode(DigitalChannel.Mode.INPUT);

    }
    @Override
    public void loop() {
        double dis = distanceSensor.getDistance(DistanceUnit.CM);
        telemetry.addData("d : ", "%.2f", dis);
        telemetry.addData("Alpha : ", colorSensor.alpha());
        telemetry.addData("Red : ", colorSensor.red());
        telemetry.addData("Green : ", colorSensor.green());
        telemetry.addData("Blue  : ", colorSensor.blue());
        telemetry.addData("argb", colorSensor.argb());
        telemetry.addData("touch", touch.getState());
        telemetry.update();

        if(colorSensor.red() > 200){
            servo1.setPosition(servo1.getPosition() + .01);
        } else if(!touch.getState()){
            servo1.setPosition(servo1.getPosition() - .01);
        } if(colorSensor.blue() > 200) {
            servo1.setPosition(servo1.getPosition() - .01);
        }
    }
}
