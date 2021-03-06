package Game;

import engine.OpenGL.EnigWindow;
import org.lwjgl.glfw.GLFW;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.lwjgl.glfw.GLFW.*;

public class UserControls {


	public static String forwardSettingString = "";
	public static String backwardSettingString;
	public static String leftSettingString;
	public static String rightSettingString;
	public static String leftArrowSettingString;
	public static String rightArrowSettingString;
	public static String upArrowSettingString;
	public static String downArrowSettingString;
	public static String downSettingString;
	public static String upSettingString;
	public static String pauseSettingString;
	public static String enterSettingString;
	public static String skipSettingString;
	public static String restartSettingString;

	public static int forwardSetting;
	public static int backwardSetting;
	public static int leftSetting;
	public static int rightSetting;
	public static int leftArrowSetting;
	public static int rightArrowSetting;
	public static int upArrowSetting;
	public static int downArrowSetting;
	public static int downSetting;
	public static int upSetting;
	public static int pauseSetting;
	public static int enterSetting;
	public static int skipSetting;
	public static int restartSetting;

	public static int forwardSetting2 = 0;
	public static int backwardSetting2 = 0;
	public static int leftSetting2 = 0;
	public static int rightSetting2 = 0;
	public static int leftArrowSetting2 = 0;
	public static int rightArrowSetting2 = 0;
	public static int upArrowSetting2 = 0;
	public static int downArrowSetting2 = 0;
	public static int downSetting2 = 0;
	public static int upSetting2 = 0;
	public static int pauseSetting2 = 0;
	public static int enterSetting2 = 0;
	public static int skipSetting2 = 0;
	public static int restartSetting2 = 0;

	public static int[] forward = new int[] {GLFW_KEY_W};
	public static int[] backward = new int[] {GLFW_KEY_S};
	public static int[] left = new int[] {GLFW_KEY_A};
	public static int[] right = new int[] {GLFW_KEY_D};
	public static int[] leftArrow = new int[] {GLFW_KEY_LEFT, GLFW_KEY_Q};
	public static int[] rightArrow = new int[] {GLFW_KEY_RIGHT, GLFW_KEY_E};
	public static int[] upArrow = new int[] {GLFW_KEY_UP};
	public static int[] downArrow = new int[] {GLFW_KEY_DOWN};
	public static int[] down = new int[] {GLFW_KEY_DOWN};
	public static int[] up = new int[] {GLFW_KEY_UP};
	public static int[] pause = new int[] {GLFW_KEY_ESCAPE};
	public static int[] enter = new int[] {GLFW_KEY_ENTER, GLFW_KEY_R};
	public static int[] rightMB = new int[] {GLFW_MOUSE_BUTTON_RIGHT};
	public static int[] leftMB = new int[] {GLFW_MOUSE_BUTTON_LEFT};
	public static int[] levelAdvance = new int[] {GLFW_KEY_N};
	public static int[] levelBack = new int[] {GLFW_KEY_B};
	public static int[] ohYknow = new int[] {GLFW_KEY_RIGHT_SHIFT};
	public static int[] skip = new int[] {GLFW_KEY_TAB, GLFW_KEY_ENTER};
	public static int[] restart = new int[] {GLFW_KEY_R};

	public static float sensitivity = 1f/500f;

	public static void intit(){
		forward  =  new int[] {forwardSetting, forwardSetting2};
		backward =  new int[] {backwardSetting, backwardSetting2};
		left =  new int[] {leftSetting, leftSetting2};
		right =  new int[] {rightSetting, rightSetting2};
		leftArrow =  new int[] {leftArrowSetting, leftArrowSetting2};
		rightArrow =  new int[] {rightArrowSetting, rightArrowSetting2};
		upArrow =  new int[] {upArrowSetting, upArrowSetting2};
		downArrow =  new int[] {downArrowSetting, downArrowSetting2};
		down =  new int[] {downSetting, downSetting2};
		up =  new int[] {upSetting, upSetting2};
		pause =  new int[] {pauseSetting, pauseSetting2};
		enter =  new int[] {enterSetting, enterSetting2};
		levelAdvance =  new int[] {GLFW_KEY_N};
		levelBack =  new int[] {GLFW_KEY_B};
		ohYknow =  new int[] {GLFW_KEY_RIGHT_SHIFT};
		skip = new int[] {skipSetting, skipSetting2};
		restart = new int[] {restartSetting, restartSetting2};
	}
	
	public static boolean forward(EnigWindow window) {
		for (int i:forward) {
			if (window.keys[i] > 0) {
				return true;
			}
		}
		return false;
	}
	public static boolean forwardPress(EnigWindow window) {
		for (int i:forward) {
			if (window.keys[i] == 1) {
				return true;
			}
		}
		return false;
	}
	public static boolean backward(EnigWindow window) {
		for (int i:backward) {
			if (window.keys[i] > 0) {
				return true;
			}
		}
		return false;
	}
	public static boolean backwardPress(EnigWindow window) {
		for (int i:backward) {
			if (window.keys[i] == 1) {
				return true;
			}
		}
		return false;
	}
	public static boolean left(EnigWindow window) {
		for (int i:left) {
			if (window.keys[i] > 0) {
				return true;
			}
		}
		return false;
	}
	public static boolean right(EnigWindow window) {
		for (int i:right) {
			if (window.keys[i] > 0) {
				return true;
			}
		}
		return false;
	}
	public static boolean leftArrow(EnigWindow window){
		for (int i:leftArrow) {
			if (window.keys[i] > 0) {
				return true;
			}
		}
		return false;
	}
	public static boolean leftArrowPress(EnigWindow window){
		for (int i:leftArrow) {
			if (window.keys[i] == 1) {
				return true;
			}
		}
		return false;
	}
	public static boolean rightArrow(EnigWindow window){
		for (int i:rightArrow) {
			if (window.keys[i] > 0) {
				return true;
			}
		}
		return false;
	}
	public static boolean rightArrowPress(EnigWindow window){
		for (int i:rightArrow) {
			if (window.keys[i] == 1) {
				return true;
			}
		}
		return false;
	}
	public static boolean upArrowPress(EnigWindow window){
		for (int i:upArrow) {
			if (window.keys[i] == 1) {
				return true;
			}
		}
		return false;
	}
	public static boolean downArrowPress(EnigWindow window){
		for (int i:downArrow) {
			if (window.keys[i] == 1) {
				return true;
			}
		}
		return false;
	}
	public static boolean down(EnigWindow window) {
		for (int i:down) {
			if (window.keys[i] > 0) {
				return true;
			}
		}
		return false;
	}
	public static boolean downPress(EnigWindow window) {
		for (int i:down) {
			if (window.keys[i] == 0) {
				return true;
			}
		}
		return false;
	}
	public static boolean up(EnigWindow window) {
		for (int i:up) {
			if (window.keys[i] > 0) {
				return true;
			}
		}
		return false;
	}
	public static boolean upPress(EnigWindow window) {
		for (int i:up) {
			if (window.keys[i] == 1) {
				return true;
			}
		}
		return false;
	}
	public static boolean pause(EnigWindow window) {
		for (int i:pause) {
			if (window.keys[i] > 0) {
				return true;
			}
		}
		return false;
	}
	public static boolean pausePress(EnigWindow window) {
		for (int i:pause) {
			if (window.keys[i] == 1) {
				return true;
			}
		}
		return false;
	}
	public static boolean enter(EnigWindow window) {
		for (int i:enter) {
			if (window.keys[i] > 0) {
				return true;
			}
		}
		return false;
	}
	public static boolean rightMB(EnigWindow window) {
		for (int i:rightMB) {
			if (window.mouseButtons[i] > 0) {
				return true;
			}
		}
		return false;
	}
	public static boolean leftMB(EnigWindow window) {
		for (int i:leftMB) {
			if (window.mouseButtons[i] > 0) {
				return true;
			}
		}
		return false;
	}
	public static boolean leftMBPress(EnigWindow window) {
		for (int i:leftMB) {
			if (window.mouseButtons[i] == 1) {
				return true;
			}
		}
		return false;
	}
	public static boolean levelAdvance(EnigWindow window) {
		for (int i:levelAdvance) {
			if (window.keys[i] > 0) {
				return true;
			}
		}
		return false;
	}
	public static boolean levelBack(EnigWindow window) {
		for (int i:levelBack) {
			if (window.keys[i] > 0) {
				return true;
			}
		}
		return false;
	}
	public static boolean ohYknow(EnigWindow window) {
		for (int i:ohYknow) {
			if (window.keys[i] > 0) {
				return true;
			}
		}
		return false;
	}
	public static boolean skip(EnigWindow window) {
		for (int i:skip) {
			if (window.keys[i] > 0) {
				return true;
			}
		}
		return false;
	}
	public static boolean restart(EnigWindow window) {
		for (int i:restart) {
			if (window.keys[i] > 0) {
				return true;
			}
		}
		return false;
	}
	public static void getControls(){
		try {
			Scanner s = new Scanner(new File("res/controls.txt"));
			
			UserControls.forwardSettingString = s.nextLine();
			UserControls.backwardSettingString = s.nextLine();
			UserControls.leftSettingString = s.nextLine();
			UserControls.rightSettingString = s.nextLine();
			UserControls.leftArrowSettingString = s.nextLine();
			UserControls.rightArrowSettingString = s.nextLine();
			UserControls.upArrowSettingString = s.nextLine();
			UserControls.downArrowSettingString = s.nextLine();
			UserControls.downSettingString = s.nextLine();
			UserControls.upSettingString = s.nextLine();
			UserControls.pauseSettingString = s.nextLine();
			UserControls.enterSettingString = s.nextLine();
			UserControls.skipSettingString = s.nextLine();
			UserControls.restartSettingString = s.nextLine();
			
			String[] forwardSettingStringArray = UserControls.forwardSettingString.substring(UserControls.forwardSettingString.indexOf(":") + 1).split(",");
			String[] backwardSettingStringArray = UserControls.backwardSettingString.substring(UserControls.backwardSettingString.indexOf(":") + 1).split(",");
			String[] leftSettingStringArray = UserControls.leftSettingString.substring(UserControls.leftSettingString.indexOf(":") + 1).split(",");
			String[] rightSettingStringArray = UserControls.rightSettingString.substring(UserControls.rightSettingString.indexOf(":") + 1).split(",");
			String[] leftArrowSettingStringArray = UserControls.leftArrowSettingString.substring(UserControls.leftArrowSettingString.indexOf(":") + 1).split(",");
			String[] rightArrowSettingStringArray = UserControls.rightArrowSettingString.substring(UserControls.rightArrowSettingString.indexOf(":") + 1).split(",");
			String[] upArrowSettingStringArray = UserControls.upArrowSettingString.substring(UserControls.upArrowSettingString.indexOf(":") + 1).split(",");
			String[] downArrowSettingStringArray = UserControls.downArrowSettingString.substring(UserControls.downArrowSettingString.indexOf(":") + 1).split(",");
			String[] downSettingStringArray = UserControls.downSettingString.substring(UserControls.downSettingString.indexOf(":") + 1).split(",");
			String[] upSettingStringArray = UserControls.upSettingString.substring(UserControls.upSettingString.indexOf(":") + 1).split(",");
			String[] pauseSettingStringArray = UserControls.pauseSettingString.substring(UserControls.pauseSettingString.indexOf(":") + 1).split(",");
			String[] enterSettingStringArray = UserControls.enterSettingString.substring(UserControls.enterSettingString.indexOf(":") + 1).split(",");
			String[] skipSettingStringArray = UserControls.skipSettingString.substring(UserControls.skipSettingString.indexOf(":") + 1).split(",");
			String[] restartSettingStringArray = UserControls.restartSettingString.substring(UserControls.restartSettingString.indexOf(":") + 1).split(",");
			
			UserControls.forwardSetting = Integer.parseInt(forwardSettingStringArray[0]);
			UserControls.backwardSetting = Integer.parseInt(backwardSettingStringArray[0]);
			UserControls.leftSetting = Integer.parseInt(leftSettingStringArray[0]);
			UserControls.rightSetting = Integer.parseInt(rightSettingStringArray[0]);
			UserControls.leftArrowSetting = Integer.parseInt(leftArrowSettingStringArray[0]);
			UserControls.rightArrowSetting = Integer.parseInt(rightArrowSettingStringArray[0]);
			UserControls.upArrowSetting = Integer.parseInt(upArrowSettingStringArray[0]);
			UserControls.downArrowSetting = Integer.parseInt(downArrowSettingStringArray[0]);
			UserControls.downSetting = Integer.parseInt(downSettingStringArray[0]);
			UserControls.upSetting = Integer.parseInt(upSettingStringArray[0]);
			UserControls.pauseSetting = Integer.parseInt(pauseSettingStringArray[0]);
			UserControls.enterSetting = Integer.parseInt(enterSettingStringArray[0]);
			UserControls.skipSetting = Integer.parseInt(skipSettingStringArray[0]);
			UserControls.restartSetting = Integer.parseInt(restartSettingStringArray[0]);
			
			if(forwardSettingStringArray.length > 1) UserControls.forwardSetting2 = Integer.parseInt(forwardSettingStringArray[1]);
			if(backwardSettingStringArray.length > 1) UserControls.backwardSetting2 = Integer.parseInt(backwardSettingStringArray[1]);
			if(leftSettingStringArray.length > 1) UserControls.leftSetting2 = Integer.parseInt(leftSettingStringArray[1]);
			if(rightSettingStringArray.length > 1) UserControls.rightSetting2 = Integer.parseInt(rightSettingStringArray[1]);
			if(leftArrowSettingStringArray.length > 1) UserControls.leftArrowSetting2 = Integer.parseInt(leftArrowSettingStringArray[1]);
			if(rightArrowSettingStringArray.length > 1) UserControls.rightArrowSetting2 = Integer.parseInt(rightArrowSettingStringArray[1]);
			if(upArrowSettingStringArray.length > 1) UserControls.upArrowSetting2 = Integer.parseInt(upArrowSettingStringArray[1]);
			if(downArrowSettingStringArray.length > 1) UserControls.downArrowSetting2 = Integer.parseInt(downArrowSettingStringArray[1]);
			if(downSettingStringArray.length > 1) UserControls.downSetting2 = Integer.parseInt(downSettingStringArray[1]);
			if(upSettingStringArray.length > 1) UserControls.upSetting2 = Integer.parseInt(upSettingStringArray[1]);
			if(pauseSettingStringArray.length > 1) UserControls.pauseSetting2 = Integer.parseInt(pauseSettingStringArray[1]);
			if(enterSettingStringArray.length > 1) UserControls.enterSetting2 = Integer.parseInt(enterSettingStringArray[1]);
			if(skipSettingStringArray.length > 1) UserControls.skipSetting2 = Integer.parseInt(skipSettingStringArray[1]);
			if(restartSettingStringArray.length > 1) UserControls.restartSetting2 = Integer.parseInt(restartSettingStringArray[1]);
			
			UserControls.intit();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e){
			System.out.println("Delete your controls.txt folder (TimeTravel/res/controls.txt) and try again.\n" +
					"Or fix the ordering manually if you have custom keybinds.");
			
			e.printStackTrace();
		}
	}
	
	
/*
	if commonCamera is true, the camera rotation for most 3d games will be used, if it is false, this alternate method is used:

	every frame the new rotation matrix is set to the rotation matrix from relative mouse position changes (from the last frame),
	will be multiplied by the old rotation matrix.
	R(xnew-xold)*R(ynew-yold)*R(znew-zold)*oldRotationMatrix.
	
	oh btw
	this variable has been moved from this file, to the Camera file, so you can have different cameras with different types of cameras
																																		 */
}
