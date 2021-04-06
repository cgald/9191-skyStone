package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "autoTest", group = "9191") //Program will be called revAutoBlue on the phone
public class autoTest extends LinearOpMode {
    //Naming motors and servos
    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;
    private DcMotor ConveyorBelt;
    private DcMotor shooter;
    private CRServo intake;
    private DcMotor WobbleGoal;
    private Servo wobbleflipper;
    private Servo LeftGripper;
    private Servo RightGripper;
 //todo deploy during init
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
        shooter.setPower(-power);
        sleep(runtime); //Wait for runtime milliseconds USE 0 SLEEP, do inbetween other methods to shave time
    }

    private void load(double power, int runtime) { //Pieces are loaded, trips
        //Set wheels power to the value of power
        ConveyorBelt.setPower(power);
        sleep(800);
        ConveyorBelt.setPower(0);
        sleep(runtime);
    }

    private void grip(double power, int runtime) { //Power One should be Grip engaged, power 0 should be grip disengage
        LeftGripper.setPosition(1-power);
        RightGripper.setPosition(power);
        sleep(runtime);
    }



    @Override
    public void runOpMode() throws InterruptedException {
        //What to call the motors/servos on the phones
        frontLeft = hardwareMap.dcMotor.get("FL");
        frontRight = hardwareMap.dcMotor.get("FR");
        backLeft = hardwareMap.dcMotor.get("BL");
        backRight = hardwareMap.dcMotor.get("BR");
        shooter = hardwareMap.dcMotor.get("SH");
        intake = hardwareMap.crservo.get("IN");
        ConveyorBelt = hardwareMap.dcMotor.get("CB");
        WobbleGoal = hardwareMap.dcMotor.get("WG");
        wobbleflipper = hardwareMap.servo.get("WF");
        LeftGripper = hardwareMap.servo.get("LG");
        RightGripper = hardwareMap.servo.get("RG");
        LeftGripper.setPosition(1); RightGripper.setPosition(0);
        wobbleflipper.setPosition(0);

        int right = 1; //If its on the right side keep it 1, if its on the left make it -1
        float sidemult = (float) (1000/52.51256281407035); //term A is time to go one meter, term B is pixels per meter
        float fowardmult = (float) (1000/55.733333333333334); //term A is time to go one meter, term B is pixels per meter
        float anglemult = (float) (0.015555555555555555); // time/angle
        int waitvalue = 100;
        int loadvalue = 1000;
        waitForStart();
        sideways(-.5 * right, (int) (120 * sidemult)); //Right
        sleep(1 * waitvalue);
        forward(.5 * right, (int) (110 * fowardmult)); //Forward
        sleep(waitvalue);
        sideways(-.5 * right, (int) (220 * sidemult)); //Right
        sleep(1 * waitvalue);
        forward(.5 * right, (int) (110 * fowardmult)); //back
        sleep(1 * waitvalue);
        wind(1, 2000);
        turn(.5 * right,(int) (65 * anglemult)); //left turn
        load(-1, loadvalue);
        turn(.5 * right,(int) (6.5 * anglemult)); //right turn
        load(-1, loadvalue);
        turn(.5 * right,(int) (6.5 * anglemult)); //right turn
        load(-1, loadvalue);
        turn(.5 * right,(int) (14 * anglemult)); //right turn
        wind(0,0 );
        sleep(500);



    }
}
