package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "testTetris", group = "9191")
public class testTetris extends OpMode {
    private DcMotor motor1;
    private DcMotor motor2;
    private DcMotor motor3;
    private Servo servo1;
    @Override
    public void init() {
        motor1 = hardwareMap.dcMotor.get("m1");
        motor2 = hardwareMap.dcMotor.get("m2");
        motor3 = hardwareMap.dcMotor.get("m3");
        servo1 = hardwareMap.servo.get("s1");

        motor2.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop() {
        if(gamepad1.left_stick_y != 0){
            motor1.setPower(gamepad1.left_stick_y * .5);
            motor2.setPower(gamepad1.left_stick_y * .5);
        } else if(gamepad1.right_stick_x !=0){
            motor1.setPower(gamepad1.right_stick_x * -.5);
            motor2.setPower(gamepad1.right_stick_x * .5);
        } else {
            motor1.setPower(0);
            motor2.setPower(0);
        } if(gamepad2.left_stick_y != 0){
            motor3.setPower(gamepad2.left_stick_y);
        } if(gamepad2.a){
            servo1.setPosition(servo1.getPosition() + .01);
        } else if(gamepad2.y){
            servo1.setPosition(servo1.getPosition() - .01);
        }
    }
}
