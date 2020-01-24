package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "shortBlue") //Lined up on right
public class shortRight extends LinearOpMode {
    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;
    private Servo foundationOne;
    private Servo foundationTwo;
    private Servo capStone;
    
    private void forward(double power, int runtime) { //Positive power = backward, Negative power = forward
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

    private void sideways(double power, int runtime) { //Positive power = right, Negative power = left
        //Set wheels power to the value of power
        frontLeft.setPower(power);
        frontRight.setPower(-power);
        backLeft.setPower(power);
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
        frontRight.setPower(-power);
        backLeft.setPower(-power);
        backRight.setPower(power);
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
        foundationOne = hardwareMap.servo.get("F1"); //Hardware mapping Servo for foundation hook (left)
        foundationTwo = hardwareMap.servo.get("F2"); //Hardware mapping Servo for foundation hook (right)
        capStone = hardwareMap.servo.get("CS"); //Hardware mapping Servo for Capstone release
        //Since the wheels are flipped on the right side, we need to permanently reverse the direction of the right motors
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        capStone.setPosition(1);


        waitForStart(); //Starts when button on phone pushed

        forward(.5, 1250); //Drive forward at half power for 1.25 seconds
        sideways(.5, 2500); //Drive sideways (right) at half power for 2.5 seconds
    }
}