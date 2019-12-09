package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "revAutoRed", group = "9191")
public class revAuto2 extends LinearOpMode {
    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;
    private Servo foundationOne;
    private Servo foundationTwo;
    private Servo capStone;

    private void forward(double power, int runtime) { //Positive power = backward, Negative power = forward (idk why pls no ask why)
        frontLeft.setPower(power);
        frontRight.setPower(power);
        backLeft.setPower(power);
        backRight.setPower(power);
        sleep(runtime);
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
    }

    private void sideways(double power, int runtime) { //Positive power = right, Negative power = left
        frontLeft.setPower(power);
        frontRight.setPower(-power);
        backLeft.setPower(power);
        backRight.setPower(-power);
        sleep(runtime);
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
    }

    private void turn(double power, int runtime) { //Positive power = right, Negative power = left
        frontLeft.setPower(power);
        frontRight.setPower(-power);
        backLeft.setPower(-power);
        backRight.setPower(power);
        sleep(runtime);
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
    }

    private void foundation(double pos){ //Positive power = up, Negative power = down
        foundationOne.setPosition(pos);
        foundationTwo.setPosition(pos);
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
        foundationOne.setPosition(1);
        foundationTwo.setPosition(1);
        capStone.setPosition(1);


        waitForStart();

        sideways(-.5, 626);
        forward(.5, 3100);
        foundationOne.setPosition(0); foundationTwo.setPosition(0);
        sleep(500);
        sideways(.75, 2000);
        forward(-.5, 4500);
        foundationOne.setPosition(1); foundationTwo.setPosition(1);
        sideways(.5, 1000);
        forward(.5, 500);
        sideways(.5, 3000);
        //forward(-.5, 1000); //14 3/8 in. (example)
    }
}
