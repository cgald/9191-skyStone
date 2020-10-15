package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "box") //XanderG
public class box extends LinearOpMode {
    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;

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

        waitForStart();

        forward(.5, 2000);
        sideways(.5 , 2000); //comment out for ForwardBack
        forward( -.5, 2000);
        sideways( -.5, 2000); //comment out for ForwardBack
    }
}