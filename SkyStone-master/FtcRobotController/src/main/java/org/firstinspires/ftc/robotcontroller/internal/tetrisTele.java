package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

//All directions "left/right" are facing from the back
@TeleOp(name = "tetrisTele", group = "9191")
public class tetrisTele extends OpMode {
    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;
    private DcMotor inLeft;
    private DcMotor inRight;
    private DcMotor armLift;
    private CRServo foundationMove;
    private CRServo grabBlock;
    private CRServo rotateBlock;


    @Override
    public void init() {
        frontLeft = hardwareMap.dcMotor.get("FL");
        frontRight = hardwareMap.dcMotor.get("FR");
        backLeft = hardwareMap.dcMotor.get("BL");
        backRight = hardwareMap.dcMotor.get("BR");
        inLeft = hardwareMap.dcMotor.get("IL");
        inRight = hardwareMap.dcMotor.get("IR");
        armLift = hardwareMap.dcMotor.get("AL");
        foundationMove = hardwareMap.crservo.get("FM");
        grabBlock = hardwareMap.crservo.get("GB");
        rotateBlock = hardwareMap.crservo.get("RB");
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop() {
        double r = Math.hypot(gamepad1.right_stick_x, gamepad1.left_stick_y);
        double robotAngle = Math.atan2(gamepad1.left_stick_y, gamepad1.right_stick_x) - Math.PI / 4;
        double rightX = gamepad1.left_stick_x;
        //if(gamepad1.left_bumper || gamepad2.left_bumper) i /= 2;
        //if(gamepad1.right_bumper || gamepad2.right_bumper) i /= 4;
        final double v1 = r * Math.cos(robotAngle) + rightX;
        final double v2 = r * Math.sin(robotAngle) - rightX;
        final double v3 = r * Math.sin(robotAngle) + rightX;
        final double v4 = r * Math.cos(robotAngle) - rightX;


        frontLeft.setPower(v1);
        frontRight.setPower(v2);
        backLeft.setPower(v3);
        backRight.setPower(v4);
       inLeft.setPower(gamepad2.right_stick_y);
        inRight.setPower(-gamepad2.right_stick_y);
        armLift.setPower(gamepad2.left_stick_y);

        if(gamepad2.a){
            grabBlock.setPower(1);
        } else if(gamepad2.y){
            grabBlock.setPower(-1);
        } else{
            grabBlock.setPower(0);
        } if(gamepad2.x){
            rotateBlock.setPower(1);
        } else if(gamepad2.b){
            rotateBlock.setPower(-1);
        } else{
            rotateBlock.setPower(0);
        } if(gamepad1.right_bumper){
            foundationMove.setPower(1);
        } else if(gamepad1.left_bumper){
            foundationMove.setPower(-1);
        } else{
            foundationMove.setPower(0);
        }
    }
}
