package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "autoTrials", group = "9191") //Program will be called revAutoBlue on the phone
public class autoTrials extends LinearOpMode {
    //Naming motors and servos
    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;
    private DcMotor gripperMotor;
    private DcMotor intakeMotor;
    private DcMotor launcherMotor;
    private Servo gripperLeft;
    private Servo gripperRight;
    private Servo gripperDeploy; //todo deploy during init
    //private Servo intakeServo;

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

    private void turn(double power, int runtime) { //Positive power = right, Negative power = left
        //Set wheels power to the value of power
        frontLeft.setPower(power);
        frontRight.setPower(power);
        backLeft.setPower(power);
        backRight.setPower(power);
        sleep(runtime); //Wait for runtime milliseconds
        //Set wheels power to 0
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
    }


    private void wind(double power, int runtime) { //do 2/5 seconds of wind before shooting, use again with power 0 to unwind
        //Set wheels power to the value of power
        launcherMotor.setPower(power);
        sleep(runtime); //Wait for runtime milliseconds USE 0 SLEEP, do inbetween other methods to shave time
    }


    @Override
    public void runOpMode() throws InterruptedException {
        //What to call the motors/servos on the phones
        frontLeft = hardwareMap.dcMotor.get("FL");
        frontRight = hardwareMap.dcMotor.get("FR");
        backLeft = hardwareMap.dcMotor.get("BL");
        backRight = hardwareMap.dcMotor.get("BR");
        gripperMotor = hardwareMap.dcMotor.get("GM");
        intakeMotor = hardwareMap.dcMotor.get("IM");
        launcherMotor = hardwareMap.dcMotor.get("LM");
        gripperLeft = hardwareMap.servo.get("GL");
        gripperRight = hardwareMap.servo.get("GR");
        gripperDeploy = hardwareMap.servo.get("GD");

        gripperDeploy.setPosition(1);
        gripperLeft.setPosition(1); gripperRight.setPosition(0);

        waitForStart();
        sideways(.5, 1000); //Left
        sideways(-.5, 1000); //Right
        forward(-.5, 1000); //Forward
        wind(1, 0);
        forward(.5, 1000); //Backward
        wind(0,0 );
         //Set grippers down to grab foundation
        turn(.5,1000); //right turn
        turn(-.5,1000); //left turn
        sleep(500);

        waitForStart();
        //scan the stack
        //store value of stack (Pos A, B, or C)
        // Move foward
        forward(-.5, 1000); //Forward
        //Pick up wobble goal

        //Move foward
        //move left
        //move foward
        //move right
        //wait forward
        //break off/abc
        //drop off
        //reverse abc
        //windup
        //rotate left
        //shoot
        //sleep
        //shoot
        //sleep
        //shoot
    }
}
