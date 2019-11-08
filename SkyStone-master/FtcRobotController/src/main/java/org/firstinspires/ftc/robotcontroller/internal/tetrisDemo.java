package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "tetrisDemo", group = "9191")
public class tetrisDemo extends OpMode {
    private DcMotor motor1;
    private DcMotor motor2;
    private DcMotor motor3;
    private DcMotor motor4;
    private DcMotor motor5;
    private CRServo servo1;
    @Override
    public void init() {
        motor1 = hardwareMap.dcMotor.get("m1");
        motor2 = hardwareMap.dcMotor.get("m2");
        motor3 = hardwareMap.dcMotor.get("m3");
        motor4 = hardwareMap.dcMotor.get("m4");
        motor5 = hardwareMap.dcMotor.get("m5");
        servo1 = hardwareMap.crservo.get("s1");

        motor2.setDirection(DcMotorSimple.Direction.REVERSE);
        motor4.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop() {
        if(gamepad1.left_stick_y != 0){
            motor1.setPower(gamepad1.left_stick_y * .5);
            motor2.setPower(gamepad1.left_stick_y * .5);
            motor3.setPower(gamepad1.left_stick_y * .5);
            motor4.setPower(gamepad1.left_stick_y * .5);
        } else if(gamepad1.right_stick_x !=0){
            motor1.setPower(gamepad1.right_stick_x * -.5);
            motor2.setPower(gamepad1.right_stick_x * .5);
            motor3.setPower(gamepad1.right_stick_x * -.5);
            motor4.setPower(gamepad1.right_stick_x * .5);
        } else {
            motor1.setPower(0);
            motor2.setPower(0);
            motor3.setPower(0);
            motor4.setPower(0);
        } if(gamepad2.left_stick_y != 0) {
            motor5.setPower(gamepad2.left_stick_y);
        } else{
            motor5.setPower(0);
        } if(gamepad2.a){
            servo1.setPower(1);
        } else if(gamepad2.y){
            servo1.setPower(-1);
        } else{
            servo1.setPower(0);
        }
    }
}
