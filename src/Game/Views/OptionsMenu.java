package Game.Views;

import Game.Buttons.NoChangeButton;
import Game.Buttons.ShaderOptimizedButton;
import Game.Buttons.TwoStateButton;
import Game.Game;
import Game.UserControls;
import Game.StringRenderer;
import Game.LevelBase;
import Game.Entity;
import engine.EnigView;
import engine.OpenGL.EnigWindow;
import engine.OpenGL.FBO;
import org.joml.Vector4f;
import org.lwjgl.glfw.GLFWVidMode;
import sun.applet.Main;

import javax.xml.soap.Text;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import static org.lwjgl.glfw.GLFW.glfwGetPrimaryMonitor;
import static org.lwjgl.glfw.GLFW.glfwGetVideoMode;

public class OptionsMenu extends EnigView {
    public OptionsMenu(EnigWindow window){
        super(window, false);
    }

    public static OptionsMenu optionsView;

    StringRenderer fullScreen;
    StringRenderer fullScreenOption;
    StringRenderer resolution;
    StringRenderer resolutionOption1;
    StringRenderer resolutionOption2;
    StringRenderer backgroundMove;
    StringRenderer backgroundMoveOption;
    StringRenderer textureLock;
    StringRenderer textureLockOption;
    StringRenderer controlMenu;
    StringRenderer restart;
    StringRenderer restart2;
    StringRenderer timer;
    StringRenderer timerOption;
    StringRenderer boxNumbers;
    StringRenderer boxNumbersOption;

    String[] options;

    float aspectRatio;

    boolean keyInput = false;

    int xRes;
    int yRes;

    int keyCallbackState;

    int tempRes = 0;
    int callbackCounter = 0;
    int prevRes = 0;

    public static boolean escapeRes = false;

    @Override
    public void setup() {
        optionsView = this;


        window.callbackView = optionsView;

        xRes = window.getWidth();
        yRes = window.getHeight();
        aspectRatio = (float)window.getHeight()/(float)window.getWidth();

        fullScreen = new StringRenderer(180, -1700, 900);
        fullScreen.centered = false;

        fullScreenOption = new StringRenderer(180, 400, 900);
        fullScreenOption.centered = false;
        fullScreenOption.unselectedColor = new Vector4f(1f,0f,0f,1f);

        resolution = new StringRenderer(180, -1700, 700);
        resolution.centered = false;

        resolutionOption1 = new StringRenderer(180, 400, 700);
        resolutionOption1.centered = false;
        resolutionOption1.unselectedColor = new Vector4f(1f,0f,0f,1f);

        resolutionOption2 = new StringRenderer(180, 900, 700);
        resolutionOption2.centered = false;
        resolutionOption2.unselectedColor = new Vector4f(1f,0f,0f,1f);

        backgroundMove = new StringRenderer(180, -1700, 500);
        backgroundMove.centered = false;

        backgroundMoveOption = new StringRenderer(180, 400, 500);
        backgroundMoveOption.centered = false;
        backgroundMoveOption.unselectedColor = new Vector4f(1f,0f,0f,1f);

        textureLock = new StringRenderer(180, -1700, 300);
        textureLock.centered = false;

        textureLockOption = new StringRenderer(180, 400, 300);
        textureLockOption.centered = false;
        textureLockOption.unselectedColor = new Vector4f(1f,0f,0f,1f);

        timer = new StringRenderer(180, -1700, 100);
        timer.centered = false;

        timerOption = new StringRenderer(180, 400, 100);
        timerOption.centered = false;
        timerOption.unselectedColor = new Vector4f(1f,0f,0f,1f);

        boxNumbers = new StringRenderer(180, -1700, -100);
        boxNumbers.centered = false;

        boxNumbersOption = new StringRenderer(180, 400, -100);
        boxNumbersOption.centered = false;
        boxNumbersOption.unselectedColor = new Vector4f(1f,0f,0f,1f);

        controlMenu = new StringRenderer(280, 0, -400);

        restart = new StringRenderer(280, 0, -800);
        restart2 = new StringRenderer(50, 0, -950);

        options = getOptionsString().split("\n");

        keyCallbackState = 0;

    }

    @Override
    public boolean loop() {

        FBO.prepareDefaultRender();


        fullScreen.renderStr("Fullscreen");
        String fullScreenOptionText;
        if(MainView.fullScreenBool){
            fullScreenOptionText = "Enabled";
        } else {
            fullScreenOptionText = "Disabled";
        }
        fullScreenOption.renderStr(fullScreenOptionText);
        resolution.renderStr("Resolution");


        resolutionOption1.renderStr(Integer.toString(xRes));
        resolutionOption2.renderStr(Integer.toString(yRes));


        backgroundMove.renderStr("Background Move");
        String backGroundMoveOptionText;
        if(MainView.backgroundMoveBool){
            backGroundMoveOptionText = "Enabled";
        } else {
            backGroundMoveOptionText = "Disabled";
        }
        backgroundMoveOption.renderStr(backGroundMoveOptionText);

        timer.renderStr("Timer");
        String timerOptionText;
        if(MainView.timerBool){
            timerOptionText = "Enabled";
        } else {
            timerOptionText = "Disabled";
        }
        timerOption.renderStr(timerOptionText);


        controlMenu.renderStr("Controls");
        controlMenu.unselectedColor = new Vector4f(.5f, .5f, 1f, 1f);

        textureLock.renderStr("Texture Lock");

        String lockedTexturesOptionText;
        if(LevelBase.lockedTextures){
            lockedTexturesOptionText = "Enabled";
        } else {
            lockedTexturesOptionText = "Disabled";
        }
        textureLockOption.renderStr(lockedTexturesOptionText);

        boxNumbers.renderStr("Box Numbers");
        String boxNumbersOptionText;
        if(Entity.renderNumbers){
            boxNumbersOptionText = "Enabled";
        } else {
            boxNumbersOptionText = "Disabled";
        }
        boxNumbersOption.renderStr(boxNumbersOptionText);


        if(fullScreenOption.hoverCheck(fullScreenOptionText, window.cursorXFloat, window.cursorYFloat, new Vector4f(.5f,.5f,1f,1f)) && UserControls.leftMBPress(window)){
            if(options[0].equals("fullscreen:t")){
                options[0] =  "fullscreen:f";
            } else {
                options[0] = "fullscreen:t";
            }
            MainView.fullScreenBool = !MainView.fullScreenBool;
        }
        if(resolutionOption1.hoverCheck(Integer.toString(xRes), window.cursorXFloat, window.cursorYFloat, new Vector4f(1f,1f,1f,1f)) && UserControls.leftMBPress(window)){
            if(keyCallbackState == 0) {
                prevRes = xRes;
                keyInput = true;
                keyCallbackState = 1;
            }

        }
        if(resolutionOption2.hoverCheck(Integer.toString(yRes), window.cursorXFloat, window.cursorYFloat, new Vector4f(1f,1f,1f,1f)) && UserControls.leftMBPress(window)){
            if(keyCallbackState == 0) {
                prevRes = yRes;
                keyInput = true;
                keyCallbackState = 2;
            }

        }
        if(backgroundMoveOption.hoverCheck(backGroundMoveOptionText, window.cursorXFloat, window.cursorYFloat, new Vector4f(.5f, .5f, 1f, 1f)) && UserControls.leftMBPress(window)){
            if(options[2].equals("backgroundmove:t")){
                options[2] =  "backgroundmove:f";
                MainView.backgroundMoveBool = false;
            } else {
                options[2] = "backgroundmove:t";
                MainView.backgroundMoveBool = true;
            }
        }
        if(textureLockOption.hoverCheck(lockedTexturesOptionText, window.cursorXFloat, window.cursorYFloat, new Vector4f(.5f,.5f,1f,1f)) && UserControls.leftMBPress(window)){
            if(options[3].equals("texLock:t")){
                options[3] =  "texLock:f";
            } else {
                options[3] = "texLock:t";
            }
            LevelBase.lockedTextures = !LevelBase.lockedTextures;
        }

        if(timerOption.hoverCheck(timerOptionText, window.cursorXFloat, window.cursorYFloat, new Vector4f(.5f,.5f,1f,1f)) && UserControls.leftMBPress(window)){
            if(options[4].equals("timer:t")){
                options[4] =  "timer:f";
            } else {
                options[4] = "timer:t";
            }
            MainView.timerBool = !MainView.timerBool;
        }

        if(boxNumbersOption.hoverCheck(boxNumbersOptionText, window.cursorXFloat, window.cursorYFloat, new Vector4f(.5f,.5f,1f,1f)) && UserControls.leftMBPress(window)){
            if(options[5].equals("boxNum:t")){
                options[5] =  "boxNum:f";
            } else {
                options[5] = "boxNum:t";
            }
            Entity.renderNumbers = !Entity.renderNumbers;
        }


        if(controlMenu.hoverCheck("Controls", window.cursorXFloat, window.cursorYFloat, new Vector4f(1f, 1f, 1f, 1f)) && UserControls.leftMBPress(window)){
            new ControlsMenu(window);
        }



        String[] currentOptions = getOptionsString().split("\n");

        boolean restartCheck = false;
        if(!options[0].equals(currentOptions[0])) restartCheck = true;
        if(!options[1].equals(currentOptions[1])) restartCheck = true;

        if(restartCheck) {
            restart.renderStr("Restart");
            restart.unselectedColor = new Vector4f(.5f, .5f, 1f, 1f);
            restart2.renderStr("You must start up the game again yourself after closing, Sorry");
        }


        boolean check = false;
        if(!options[2].equals(currentOptions[2])) check = true;
        if(!options[3].equals(currentOptions[3])) check = true;
        if(!options[4].equals(currentOptions[4])) check = true;
        if(!options[5].equals(currentOptions[5])) check = true;
        if(check){
            writeToOptions(options);
        }

        if(restartCheck && restart.hoverCheck("Restart", window.cursorXFloat, window.cursorYFloat, new Vector4f(1,1,1,1)) && UserControls.leftMBPress(window)){
            writeToOptions(options);
            MainView.quit = true;
            MainMenu.mainMenuQuit = true;
            Game.restart = true;
            window.callbackView = null;
            return true;
        }
        if(UserControls.pausePress(window) && !keyInput && !escapeRes) {
            window.callbackView = null;
            return true;

        } else if(UserControls.pausePress(window) && escapeRes) {
            escapeRes = false;
        }

        return false;
    }

    @Override
    public String getName() {
        return "options";
    }

    public String concat(String[] array){
        String out = "";
        for(String i: array){
            out += i + "\n";
        }
        out = out.substring(0, out.length()-1);
        return out;
    }


    public String getOptionsString(){
        try {
            Scanner s = new Scanner(new File("res/options.txt"));
            String options = "";
            while(s.hasNextLine()){
                options += s.nextLine() + "\n";
            }
            return options;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    public void writeToOptions(String[] write){
        try {
            PrintWriter w = new PrintWriter(new File("res/options.txt"));
            for (String i: write){
                w.println(i);
            }
            w.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void keyCallback(int key, int state) {
        if (state != 0) {
            if (keyInput) {
                if (key == UserControls.enterSetting || key == UserControls.enterSetting2 || key == 335) {
                    keyInput = false;
                    if (tempRes < 200) tempRes = 200;
                    if (keyCallbackState == 1) {
                        xRes = tempRes;
                    } else if (keyCallbackState == 2) {
                        yRes = tempRes;
                    }
                    tempRes = 0;
                    callbackCounter = 0;
                    keyCallbackState = 0;
                    options[1] = "res:" + Integer.toString(xRes) + "," + Integer.toString(yRes);


                    return;
                }
                if(key == UserControls.pauseSetting){
                    if (keyCallbackState == 1) {
                        xRes = prevRes;
                    } else if (keyCallbackState == 2) {
                        yRes = prevRes;
                    }
                    keyInput = false;
                    tempRes = 0;
                    callbackCounter = 0;
                    keyCallbackState = 0;
                    escapeRes = true;
                    return;
                }
                if ((key > 47 && key < 58) || (key > 319 && key < 330)) {

                    tempRes = tempRes * 10;
                    if(key > 47 && key < 58){
                        tempRes += key - 48;
                    } else if(key > 319 && key < 330){
                        tempRes += key - 320;
                    }
                    callbackCounter++;
                }
                if (callbackCounter == 4) {
                    keyInput = false;
                    GLFWVidMode monitor = glfwGetVideoMode(glfwGetPrimaryMonitor());
                    if (tempRes < 200) tempRes = 200;
                    if (keyCallbackState == 1) {
                        if(tempRes > monitor.width()) tempRes = monitor.width();
                        xRes = tempRes;
                    } else if (keyCallbackState == 2) {
                        if(tempRes > monitor.height()) tempRes = monitor.height();
                        yRes = tempRes;
                    }
                    tempRes = 0;
                    callbackCounter = 0;
                    keyCallbackState = 0;
                    options[1] = "res:" + Integer.toString(xRes) + "," + Integer.toString(yRes);
                    return;
                }


            }
            if(keyCallbackState == 1){
                xRes = tempRes;
            } else if(keyCallbackState == 2){
                yRes = tempRes;
            }
        }
    }
}

