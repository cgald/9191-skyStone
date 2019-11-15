package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

//Color sensor blocks: Normal = 80, skystone = 120

@Autonomous(name = "revAuto", group = "9191")
public class revAuto extends LinearOpMode {
    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;
    private Servo foundationOne;
    private Servo foundationTwo;
    private ColorSensor color;


    private void forward(double power, int runtime) { //Positive power = forward, Negative power = backward
        frontLeft.setPower(power);
        frontRight.setPower(power);
        backLeft.setPower(power);
        backRight.setPower(power);
    }

    private void turn(double power, int runtime) { //Positive power = right, Negative power = left
        frontLeft.setPower(power);
        frontRight.setPower(-power);
        backLeft.setPower(power);
        backRight.setPower(-power);
    }

    private void sideways(double power, int runtime) { //Positive power = right, Negative power = left
        frontLeft.setPower(power);
        frontRight.setPower(-power);
        backLeft.setPower(-power);
        backRight.setPower(power);
    }

    private void foundation(double power, int runtime){ //Positive power = up, Negative power = down
        foundationOne.setPosition(foundationOne.getPosition() - power * .01);
        foundationTwo.setPosition(foundationTwo.getPosition() - power * .01);
    }

    @Override
    public void runOpMode() throws InterruptedException {
        frontLeft = hardwareMap.dcMotor.get("FL");
        frontRight = hardwareMap.dcMotor.get("FR");
        backLeft = hardwareMap.dcMotor.get("BL");
        backRight = hardwareMap.dcMotor.get("BR");
        foundationOne = hardwareMap.servo.get("F1");
        foundationTwo = hardwareMap.servo.get("F2");
        color = hardwareMap.colorSensor.get("color");
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();
        color.red();   // Red channel value
        color.green(); // Green channel value
        color.blue();  // Blue channel value
        color.alpha(); // Total luminosity
        color.argb();  // Combined color value

        forward(1, 1000);
        while(color.alpha() < 110){
            sideways(.25, 50);
        }
        //TODO: Add skystone arm

        forward(-1, 1000);

        sideways(-1, 1000);

        telemetry.addData("argb: ", color.argb());
    }
}