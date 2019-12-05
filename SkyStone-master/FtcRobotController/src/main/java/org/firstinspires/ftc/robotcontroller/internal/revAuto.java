package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "revAuto", group = "9191")
public class revAuto extends LinearOpMode {
    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;
    private Servo foundationOne;
    private Servo foundationTwo;

    private void forward(double power, int runtime) { //Positive power = forward, Negative power = backward
        frontLeft.setPower(power);
        frontRight.setPower(power);
        backLeft.setPower(power);
        backRight.setPower(power);
        sleep(runtime);
    }

    private void sideways(double power, int runtime) { //Positive power = right, Negative power = left
        frontLeft.setPower(power);
        frontRight.setPower(-power);
        backLeft.setPower(power);
        backRight.setPower(-power);
        sleep(runtime);
    }

    private void turn(double power, int runtime) { //Positive power = right, Negative power = left
        frontLeft.setPower(power);
        frontRight.setPower(-power);
        backLeft.setPower(-power);
        backRight.setPower(power);
        sleep(runtime);
    }

    private void foundation(double power, int runtime){ //Positive power = up, Negative power = down
        foundationOne.setPosition(foundationOne.getPosition() - power * .01);
        foundationTwo.setPosition(foundationTwo.getPosition() - power * .01);
        sleep(runtime);
    }
    @Override
    public void runOpMode() throws InterruptedException {
        frontLeft = hardwareMap.dcMotor.get("FL");
        frontRight = hardwareMap.dcMotor.get("FR");
        backLeft = hardwareMap.dcMotor.get("BL");
        backRight = hardwareMap.dcMotor.get("BR");
        foundationOne = hardwareMap.servo.get("F1");
        foundationTwo = hardwareMap.servo.get("F2");
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        sideways(-.5, 1000);
        forward(-.5, 1000);
        foundation(-.5, 500);
        forward(.5, 1000);
        foundation(.5, 500);
        sideways(-.5, 1000);
        forward(-.5, 1000);
        sideways(.5, 1000);
    }
}
