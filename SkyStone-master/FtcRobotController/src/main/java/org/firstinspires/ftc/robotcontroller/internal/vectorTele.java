package org.firstinspires.ftc.robotcontroller.internal;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp(name = "vectorTele", group = "9191")
public class vectorTele extends OpMode {
    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;
    private DcMotor linearLift;
    private DcMotor intakeLeft;
    private DcMotor intakeRight;
    /*private CRServo gripperLeft;
    private CRServo gripperRight;
    private Servo foundationOne;
    private Servo foundationTwo;
    private Servo capStone;
    private CRServo pushBlock;*/
    @Override
    public void init() {
        frontLeft = hardwareMap.dcMotor.get("FL");
        frontRight = hardwareMap.dcMotor.get("FR");
        backLeft = hardwareMap.dcMotor.get("BL");
        backRight = hardwareMap.dcMotor.get("BR");
        linearLift = hardwareMap.dcMotor.get("LL");
        intakeLeft = hardwareMap.dcMotor.get("IL");
        intakeRight = hardwareMap.dcMotor.get("IR");
        /*gripperLeft = hardwareMap.crservo.get("GF");
        gripperRight = hardwareMap.crservo.get("GB");
        foundationOne = hardwareMap.servo.get("F1");
        foundationTwo = hardwareMap.servo.get("F2");
        pushBlock = hardwareMap.crservo.get("PB");
        capStone = hardwareMap.servo.get("CS");*/
    }

    @Override
    public void loop() {
        double mag = Math.abs(gamepad1.left_stick_x) + Math.abs(gamepad1.left_stick_y) + Math.abs(gamepad1.right_stick_x);
        double throtle = (1 - gamepad1.left_trigger);
        final double v1 = (gamepad1.left_stick_x - gamepad1.left_stick_y + gamepad1.right_stick_x) / mag ;
        final double v2 = (-gamepad1.left_stick_x - gamepad1.left_stick_y - gamepad1.right_stick_x) / mag;
        final double v3 = (-gamepad1.left_stick_x  - gamepad1.left_stick_y + gamepad1.right_stick_x) / mag;
        final double v4 = (gamepad1.left_stick_x - gamepad1.left_stick_y - gamepad1.right_stick_x) / mag;
        //make a throttle
        //add 6 speed transmission
        //todo change battery holder
        frontLeft.setPower(v1 * throtle);
        frontRight.setPower(-v2 * throtle);
        backLeft.setPower(v3 * throtle);
        backRight.setPower(-v4 * throtle);
        //broken settup 0 = FL, 1 = FR, 2 = BR, 3 BL
        //robot settup 0 = FR, FL = 1, 2 = BR, 3 = BL





        intakeRight.setPower(gamepad2.right_stick_y * 2);
        intakeLeft.setPower(-gamepad2.right_stick_y * 2);

        linearLift.setPower(gamepad2.left_stick_y);
/*
        if(gamepad2.a){
            gripperLeft.setPower(1);
            gripperRight.setPower(1);
        } else if(gamepad2.y){
            gripperRight.setPower(-1);
            gripperLeft.setPower(-1);
        } else{
            gripperLeft.setPower(0);
            gripperRight.setPower(0);
        } /*if(gamepad1.y){
            foundationTwo.setPosition(foundationTwo.getPosition() + .01);
            foundationOne.setPosition(foundationOne.getPosition() + .01);
        } else if(gamepad1.a) {
            foundationOne.setPosition(foundationOne.getPosition() - .01);
            foundationTwo.setPosition(foundationTwo.getPosition() - .01);
        } if(gamepad1.left_bumper){
            capStone.setPosition(capStone.getPosition() - .01);
        } else if(gamepad1.right_bumper){
            capStone.setPosition(capStone.getPosition() + .01);
        }
    */}
}
