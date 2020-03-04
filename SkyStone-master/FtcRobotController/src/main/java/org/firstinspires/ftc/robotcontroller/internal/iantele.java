package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "ianTele", group = "9191")
public class iantele extends OpMode {
    private DcMotor liftLeft;
    private DcMotor liftRight;
    private CRServo armIn;
    private CRServo armOut;


    //private CRServo pushBlock;*/
    @Override
    //TODO: Intake on GP1; Fix foundation servos; Slow down rotator
    public void init() {
        liftLeft = hardwareMap.dcMotor.get("LL");
        liftRight = hardwareMap.dcMotor.get("LR");

        armIn = hardwareMap.crservo.get("AI");
        armOut = hardwareMap.crservo.get("AO");


    }

    @Override

    public void loop() {
        liftLeft.setPower(gamepad2.right_stick_y);
        liftRight.setPower(gamepad2.right_stick_y);

        armIn.setPower(gamepad2.left_stick_y);
        armOut.setPower(gamepad2.left_stick_y);
        }
}

