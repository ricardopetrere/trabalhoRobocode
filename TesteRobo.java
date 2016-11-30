package testerobo;
import robocode.*;
//import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * TesteRobo - a robot by (your name here)
 */
public class TesteRobo extends Robot
{
	boolean esquerda = false;
	double timeout = 5000;
	double tmp_timeout = 0;
	/**
	 * run: TesteRobo's default behavior
	 */
	public void run() {
		setAdjustGunForRobotTurn(true);
		// Robot main loop
		while(true) {
			// Replace the next 4 lines with any behavior you would like
			virarArma(5);
			tmp_timeout++;
			if(tmp_timeout>=timeout) {
				tmp_timeout = 0;
				virarArma(5);
			}
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		stop();
		out.println("Bearing: "+ e.getBearing());
		out.println("Heading: "+ e.getHeading());
		out.println("RadarHeading: "+ getRadarHeading());
		if(e.getBearing()>0) {
			esquerda = false;
		} else {
			esquerda = true;
		}
		turnGunRight(e.getBearing() + getHeading() - getRadarHeading());
		turnRight(e.getBearing());
		fire(1);
		ahead(e.getDistance()/2);
		scan();
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		stop();
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		stop();
	}
	public void virarArma(float angulo) {
		if(esquerda) {
			turnGunLeft(angulo);
		} else {
			turnGunRight(angulo);
		}
	}
}
