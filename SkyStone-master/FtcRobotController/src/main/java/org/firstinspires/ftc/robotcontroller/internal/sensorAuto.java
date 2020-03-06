package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class sensorAuto extends LinearOpMode {
    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;
    private DistanceSensor distanceSensor;
    private ColorSensor colorSensor;
    private Servo servo1;
    private DigitalChannel touch;
    private void forward(double power, int runtime) { //Positive power = backward, Negative power = forward
        //Set wheels power to the value of power
        frontLeft.setPower(-power);
        frontRight.setPower(power);
        backLeft.setPower(-power);
        backRight.setPower(power);
        sleep(runtime); //Wait for runtime milliseconds
        //Set wheels power to 0
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
    }

    private void sideways(double power, int runtime) { //Positive power = right, Negative power = left
        //Set wheels power to the value of power
        frontLeft.setPower(power);
        frontRight.setPower(power);
        backLeft.setPower(-power);
        backRight.setPower(-power);
        sleep(runtime); //Wait for runtime milliseconds
        //Set wheels power to 0
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
    }

    @Override
    public void runOpMode() throws InterruptedException {
        frontLeft = hardwareMap.dcMotor.get("FL"); //Hardware mapping DC Motor for front left wheel
        frontRight = hardwareMap.dcMotor.get("FR"); //Hardware mapping DC Motor for front right wheel
        backLeft = hardwareMap.dcMotor.get("BL"); //Hardware mapping DC Motor for back left wheel
        backRight = hardwareMap.dcMotor.get("BR"); //Hardware mapping DC Motor for back right wheel
        distanceSensor = hardwareMap.get(DistanceSensor.class, "CD");
        colorSensor = hardwareMap.get(ColorSensor.class, "CD");
        touch = hardwareMap.get(DigitalChannel.class, "TS");
        servo1 = hardwareMap.servo.get("s");
        touch.setMode(DigitalChannel.Mode.INPUT);
        double dis = distanceSensor.getDistance(DistanceUnit.CM);
        telemetry.addData("d : ", "%.2f", dis);
        telemetry.addData("Alpha : ", colorSensor.alpha());
        telemetry.addData("Red : ", colorSensor.red());
        telemetry.addData("Green : ", colorSensor.green());
        telemetry.addData("Blue  : ", colorSensor.blue());
        telemetry.addData("argb", colorSensor.argb());
        telemetry.addData("touch", touch.getState());
        telemetry.addData("servo", servo1.getPosition());
        telemetry.update();

        waitForStart();
        forward(.5, 2500);
        while(!(colorSensor.red() > 200)) {
            sideways(.5, 1000);
        }
        //arm memer

    }
}
