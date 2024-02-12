
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMMotorController;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;

public class Drivetrain extends SubsystemBase {
  
    private PWMVictorSPX motorController1;
    private PWMVictorSPX motorController2;
    private DifferentialDrive differentialDrive1;

    public Drivetrain() {
    
        motorController1 = new PWMVictorSPX(0);
        addChild("Motor Controller 1", motorController1);
        motorController1.setInverted(true);

        motorController2 = new PWMVictorSPX(1);
        addChild("Motor Controller 2", motorController2);
        motorController2.setInverted(false);

        differentialDrive1 = new DifferentialDrive(motorController1, motorController2);
        addChild("DifferentialDrive", differentialDrive1);
        differentialDrive1.setSafetyEnabled(true);
        differentialDrive1.setExpiration(0.1);
        differentialDrive1.setMaxOutput(1.0);
    }

    public Command differentialDriveCommand
    (DoubleSupplier leftstick, DoubleSupplier rightstick) {
        return run(() -> differentialDrive1.differentialDrive1(leftstick.getAsDouble(),
        rightstick.getAsDouble()));
    }

    @Override
    public void periodic() {
    }

    @Override
    public void simulationPeriodic() {
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}
