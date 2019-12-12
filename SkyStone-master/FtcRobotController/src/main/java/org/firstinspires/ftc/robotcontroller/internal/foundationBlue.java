package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "revAutoBlue", group = "9191")
public class foundationBlue extends LinearOpMode {
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
        //What to call the motors/servos on the phones
        frontLeft = hardwareMap.dcMotor.get("FL");
        frontRight = hardwareMap.dcMotor.get("FR");
        backLeft = hardwareMap.dcMotor.get("BL");
        backRight = hardwareMap.dcMotor.get("BR");
        foundationOne = hardwareMap.servo.get("F1");
        foundationTwo = hardwareMap.servo.get("F2");
        capStone = hardwareMap.servo.get("CS");
        //Since the wheels are flipped on the right side, we need to permanently reverse the direction of the right motos
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        //Initialize servos
        foundationOne.setPosition(1);
        foundationTwo.setPosition(1);

        waitForStart();

        sideways(.5, 2500); //Drive left at half power for 2.5 seconds
        forward(.5, 2700); //Drive forward at half power for 2.7 seconds
        foundationOne.setPosition(0); foundationTwo.setPosition(0); //Set grippers down to grab foundation
        sleep(500); //Give grippers time to go down
        forward(-.5, 3650); //Drive backwards at half power for 3.65 seconds
        foundationOne.setPosition(1); foundationTwo.setPosition(1); //Set grippers up to release foundation
        sideways(-.5, 5200);
    }
}
