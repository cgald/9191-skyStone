package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
@TeleOp(name = "linearSlider", group = "9191")
@Disabled
public class linearSliderRev extends OpMode {
    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;
    private DcMotor armLift;
    private CRServo gripperLeft;
    private CRServo gripperRight;
    private Servo foundationOne; //Left from back
    private Servo foundationTwo; //Right from back
    private Servo capStone;
    private DcMotor linearSlider;
    private Servo grabBlock;
    private CRServo rotateBlock;
    @Override
    public void init() {
        frontLeft = hardwareMap.dcMotor.get("FL");
        frontRight = hardwareMap.dcMotor.get("FR");
        backLeft = hardwareMap.dcMotor.get("BL");
        backRight = hardwareMap.dcMotor.get("BR");
        armLift = hardwareMap.dcMotor.get("AL");
        gripperLeft = hardwareMap.crservo.get("GF"); //Front and Back Variable
        gripperRight = hardwareMap.crservo.get("GB");
        foundationOne = hardwareMap.servo.get("F1");
        foundationTwo = hardwareMap.servo.get("F2");
        capStone = hardwareMap.servo.get("CS");
        linearSlider = hardwareMap.dcMotor.get("LS");
        grabBlock = hardwareMap.servo.get("PB");
        rotateBlock = hardwareMap.crservo.get("RB");
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        foundationOne.setPosition(1);
        foundationTwo.setPosition(1);
    }

    @Override
    public void loop() {
        double r = Math.hypot(gamepad1.right_stick_x, gamepad1.left_stick_y);
        double robotAngle = Math.atan2(gamepad1.left_stick_y, gamepad1.right_stick_x) - Math.PI / 4;
        double rightX = gamepad1.left_stick_x;
        final double v1 = r * Math.cos(robotAngle) + rightX;
        final double v2 = r * Math.sin(robotAngle) - rightX;
        final double v3 = r * Math.sin(robotAngle) + rightX;
        final double v4 = r * Math.cos(robotAngle) - rightX;

        frontLeft.setPower(v1);
        frontRight.setPower(v2);
        backLeft.setPower(v3);
        backRight.setPower(v4);
        //armLift.setPower(-gamepad2.left_stick_y * .65); //arm input

        if(gamepad2.a){
            gripperLeft.setPower(1);
            gripperRight.setPower(1);
        } else if(gamepad2.y){
            gripperRight.setPower(-1);
            gripperLeft.setPower(-1);
        } else{
            gripperLeft.setPower(0);
            gripperRight.setPower(0);
        } if(gamepad1.dpad_up){
            foundationOne.setPosition(foundationOne.getPosition() + .01);
        } else if(gamepad1.dpad_down){
            foundationOne.setPosition(foundationOne.getPosition() - .01);
        } if(gamepad1.y){
            foundationTwo.setPosition(foundationTwo.getPosition() + .01);
        } else if(gamepad1.a){
            foundationTwo.setPosition(foundationTwo.getPosition() - .01);
        } if(gamepad1.left_bumper){
            capStone.setPosition(capStone.getPosition() - .0025);
        } else if(gamepad1.right_bumper){
            capStone.setPosition(capStone.getPosition() + .0025);
        } if(gamepad2.left_stick_y !=0){
            linearSlider.setPower(gamepad2.left_stick_y) ;
        } else{
            linearSlider.setPower(0);
        } if(gamepad2.left_bumper){
            grabBlock.setPosition(grabBlock.getPosition() - .01);
        } else if(gamepad2.right_bumper) {
            grabBlock.setPosition(grabBlock.getPosition() + .01);
        } rotateBlock.setPower(gamepad2.right_trigger - gamepad2.left_trigger);
    }
}
