package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "RevTele", group = "9191")
public class RevTele extends OpMode {
    private DcMotor wheelLeft;
    private DcMotor wheelRight;
    private DcMotor sweeperLift;
    private DcMotor sweeperWheel;


    @Override
    public void init() {
        wheelLeft = hardwareMap.dcMotor.get("wheelLeft");
        wheelRight = hardwareMap.dcMotor.get("wheelRight");
        sweeperLift = hardwareMap.dcMotor.get("sweeperLift");
        sweeperWheel = hardwareMap.dcMotor.get("sweeperWheel");
        wheelRight.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop() {
        if(gamepad2.y){ //Sweeper wheel holder thing
            sweeperLift.setPower(-.75); //In
        } else if(gamepad2.a){
            sweeperLift.setPower(.75); //Out
        } else{
            sweeperLift.setPower(0);
        } if(gamepad2.right_stick_y != 0){ //Running sweeper wheels
            sweeperWheel.setPower(gamepad2.right_stick_y * .5);
        } else{
            sweeperWheel.setPower(0);
        } if (gamepad1.left_stick_y != 0){ //Driving
            wheelLeft.setPower(gamepad1.left_stick_y);  //Driving
            wheelRight.setPower(gamepad1.left_stick_y);
        } else if (gamepad1.right_stick_x != 0){
            wheelLeft.setPower(-gamepad1.right_stick_x); //Turning
            wheelRight.setPower(gamepad1.right_stick_x);
        } else{
            wheelLeft.setPower(0);
            wheelRight.setPower(0);
        }
    }
}