package org.firstinspires.ftc.robotcontroller.internal;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "revAutoRed", group = "9191") //Program will be called revAutoRed on the phone
public class foundationRed extends LinearOpMode {
    //Naming motors and servos
    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;
    private Servo foundationOne;
    private Servo foundationTwo;
    private Servo capStone;

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
        //What to call the motors/servos on the phones
        frontLeft = hardwareMap.dcMotor.get("FL");
        frontRight = hardwareMap.dcMotor.get("FR");
        backLeft = hardwareMap.dcMotor.get("BL");
        backRight = hardwareMap.dcMotor.get("BR");
        foundationOne = hardwareMap.servo.get("F1");
        foundationTwo = hardwareMap.servo.get("F2");
        capStone = hardwareMap.servo.get("CS");

        //Since the wheels are flipped on the right side, we need to permanently reverse the direction of the right motors
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        //Set starting position of servos
        foundationOne.setPosition(1);
        foundationTwo.setPosition(0);
        capStone.setPosition(.8);

        foundationOne.setPosition(1);
        foundationTwo.setPosition(0);
        //capStone.setPosition(.8);



        waitForStart();
        /*sideways(-.5, 3100); //Drive right to line up with the foundation
        forward(.5, 2500); //Drive backwards to foundation
        foundationOne.setPosition(0); foundationTwo.setPosition(0); //Set grippers down to grab foundation
        sleep(500); //Wait for servos to go all the way down
        forward(-.5, 4000); //Drive foundation back into building site
        foundationOne.setPosition(1); foundationTwo.setPosition(1); //Set grippers up to release foundation
        sideways(.5, 5000); //Drive left in order to park under bridge
        //Total runtime: 15.10 sec*/
        sideways(-.5, 2700); //Drive right to line up with the foundation
        forward(.5, 2500); //Drive backwards to foundation
        foundationOne.setPosition(0); foundationTwo.setPosition(1); //Set grippers down to grab foundation
        sleep(500); //Wait for servos to go all the way down
        forward(-.5, 4000); //Drive foundation back into building site
        foundationOne.setPosition(1); foundationTwo.setPosition(0); //Set grippers up to release foundation

        sideways(.5, 4700); //Drive left in order to park under bridge

        sideways(.5, 5000); //Drive left in order to park under bridge

        //Total runtime: 14.20 sec
    }
}
