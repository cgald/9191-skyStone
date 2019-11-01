package org.firstinspires.ftc.robotcontroller.internal;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "testRev", group = "9191")
public class test extends OpMode {
    private DcMotor motor1;
    private DcMotor motor2;
    private DcMotor motor3;
    private DcMotor motor4;
    @Override
    public void init() {
        motor1 = hardwareMap.dcMotor.get("m1");
        motor2 = hardwareMap.dcMotor.get("m2");
        motor3 = hardwareMap.dcMotor.get("m3");
        motor4 = hardwareMap.dcMotor.get("m4");
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
        } else{
            motor1.setPower(0);
            motor2.setPower(0);
        } if(gamepad2.left_stick_y != 0){
            motor3.setPower(gamepad2.left_stick_y);
        } else{
            motor3.setPower(0);
        } if(gamepad2.right_stick_x != 0){
            motor4.setPower(gamepad2.right_stick_x * .5);
        } else{
            motor4.setPower(0);
        }
        telemetry.addData("#", gamepad1.left_stick_y);
    }
}
