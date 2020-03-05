package org.firstinspires.ftc.robotcontroller.internal;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "mixTele", group = "9191")
public class mixedTele extends OpMode {
    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;
    private DcMotor linearLift;
    private DcMotor intakeLeft;
    private DcMotor intakeRight;
    private CRServo counterServo;
    private CRServo gripperLeft;
    private CRServo gripperRight;
    private CRServo gripperChange;
    private Servo foundationOne;
    private Servo foundationTwo;
    private Servo capStone;
    @Override
    public void init() {
        frontLeft = hardwareMap.dcMotor.get("FL");
        frontRight = hardwareMap.dcMotor.get("FR");
        backLeft = hardwareMap.dcMotor.get("BL");
        backRight = hardwareMap.dcMotor.get("BR");
        linearLift = hardwareMap.dcMotor.get("LL");
        intakeLeft = hardwareMap.dcMotor.get("IL");
        intakeRight = hardwareMap.dcMotor.get("IR");
        counterServo = hardwareMap.crservo.get("CL");
        gripperLeft = hardwareMap.crservo.get("GF");
        gripperRight = hardwareMap.crservo.get("GB");
        foundationOne = hardwareMap.servo.get("F1");
        foundationTwo = hardwareMap.servo.get("F2");
        capStone = hardwareMap.servo.get("CS");
        gripperChange = hardwareMap.crservo.get("GC");
        foundationOne.setPosition(1);
        foundationTwo.setPosition(0);
    }

    @Override
    public void loop() {
        if (gamepad1.left_stick_y != 0){ //This moves the robot forward and back
            frontLeft.setPower(-gamepad1.left_stick_y);
            frontRight.setPower(gamepad1.left_stick_y);
            backLeft.setPower(-gamepad1.left_stick_y);
            backRight.setPower(gamepad1.left_stick_y);
        } else if (gamepad1.left_stick_x != 0){ //This moves the robot left and right
            frontLeft.setPower(gamepad1.left_stick_x);
            frontRight.setPower(gamepad1.left_stick_x);
            backLeft.setPower(-gamepad1.left_stick_x);
            backRight.setPower(-gamepad1.left_stick_x);
        } else if (gamepad1.right_stick_x != 0){ //This rotates the robot left and right
            frontLeft.setPower(gamepad1.right_stick_x * .85);
            frontRight.setPower(gamepad1.right_stick_x * .85);
            backLeft.setPower(gamepad1.right_stick_x * .85);
            backRight.setPower(gamepad1.right_stick_x * .85);
        } else{
            frontLeft.setPower(0);
            frontRight.setPower(0);
            backLeft.setPower(0);
            backRight.setPower(0);
        }
        intakeRight.setPower(gamepad2.right_stick_y);
        intakeLeft.setPower(-gamepad2.right_stick_y);

        linearLift.setPower(gamepad2.right_trigger);
        counterServo.setPower(gamepad2.left_trigger);
        linearLift.setPower(gamepad2.left_trigger * -.4);

        if(gamepad2.x){
            gripperChange.setPower(1);
        } else if(gamepad2.b){
            gripperChange.setPower(-1);
        } else {
            gripperChange.setPower(0);
        }
        if(gamepad2.a){
            gripperLeft.setPower(1);
            gripperRight.setPower(-1);
        } else if(gamepad2.y){
            gripperRight.setPower(1);
            gripperLeft.setPower(-1);
        } else {
            gripperLeft.setPower(0);
            gripperRight.setPower(0);
        } if(gamepad1.y){
            foundationOne.setPosition(foundationOne.getPosition() - .01);
            foundationTwo.setPosition(foundationTwo.getPosition() + .01);
        } else if(gamepad1.a) {
            foundationOne.setPosition(foundationOne.getPosition() + .01);
            foundationTwo.setPosition(foundationTwo.getPosition() - .01);
        } if(gamepad1.left_bumper){
            capStone.setPosition(capStone.getPosition() - .01);
        } else if(gamepad1.right_bumper){
            capStone.setPosition(capStone.getPosition() + .01);
        }
        telemetry.addData("CS Pos :: ", capStone.getPosition());
        telemetry.update();
    }
}
