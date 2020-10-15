package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "vectorTest", group = "9191")
public class vectorTest extends OpMode {
    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;

    //private CRServo pushBlock;*/
    @Override
    //TODO: Intake on GP1; Fix foundation servos; Slow down rotato
    public void init() {
        frontLeft = hardwareMap.dcMotor.get("FL");
        frontRight = hardwareMap.dcMotor.get("FR");
        backLeft = hardwareMap.dcMotor.get("BL");
        backRight = hardwareMap.dcMotor.get("BR");
    }

    @Override

    public void loop() {

        if(gamepad2.dpad_up){
            frontRight.setPower(1);
        } else {
            frontRight.setPower(0);
        }
        if(gamepad2.dpad_left){
            frontLeft.setPower(1);
        } else {
            frontLeft.setPower(0);
        }
        if(gamepad2.dpad_down){
            backLeft.setPower(1);
        } else {
            backLeft.setPower(0);
        }
        if(gamepad2.dpad_right){
            backRight.setPower(1);
        } else {
            backRight.setPower(0);
        }


        }
    }

