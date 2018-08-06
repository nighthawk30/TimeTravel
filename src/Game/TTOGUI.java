package Game;

import Game.Views.MainView;
import engine.OpenGL.EnigWindow;
import engine.OpenGL.ShaderProgram;
import engine.OpenGL.Texture;
import engine.OpenGL.VAO;
import org.joml.Matrix4f;

import static org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_LEFT;

public class TTOGUI {
	public int selectedTZ;
	public Texture[] leftSide = new Texture[3];//open, on, closed
	public Texture[] middle = new Texture[3];
	public Texture[] rightSide = new Texture[3];
	public Texture arrow;
	public VAO vao;
	public ShaderProgram program;
	public TTOGUI() {
		float aspectRatio = (float) EnigWindow.mainWindow.getHeight() / (float)EnigWindow.mainWindow.getWidth();
		leftSide[0] = new Texture("res/timeline/left-open.png");
		leftSide[1] = new Texture("res/timeline/left-selected.png");
		leftSide[2] = new Texture("res/timeline/left-closed.png");
		middle[0] = new Texture("res/timeline/center-open.png");
		middle[1] = new Texture("res/timeline/center-selected.png");
		middle[2] = new Texture("res/timeline/center-closed.png");
		rightSide[0] = new Texture("res/timeline/right-open.png");
		rightSide[1] = new Texture("res/timeline/right-selected.png");
		rightSide[2] = new Texture("res/timeline/right-closed.png");
		arrow = new Texture("res/timeline/timeSelector.png");
		vao = new VAO(-0.1f, 0.4f, 0.2f, 0.2f);
		program = new ShaderProgram("ttoGUIShader");
	}
	public int render(float aspectRatio, int ttoInd) {
		int ret = -1;
		int tzCount = MainView.currentLevel.levelseries.size();
		int currentTZ = MainView.currentLevel.currentTZ;
		Boolean[] possibilities = MainView.currentLevel.timeZonePossibilities.get(ttoInd);
		float translation = -(float) (tzCount - 1) * 0.1f * aspectRatio;
		float[] translations = new float[tzCount];
		for (int i = 0; i < translations.length;++i) {
			translations[i] = translation + ((float) i) * 0.2f * aspectRatio;
		}
		float yOff = EnigWindow.mainWindow.cursorYFloat - 0.5f;
		float ys = (yOff) * (yOff);
		if (UserControls.leftArrowPress(EnigWindow.mainWindow)) {
			--selectedTZ;
			if (selectedTZ < 0) {
				selectedTZ = 0;
			}
		}
		if (UserControls.rightArrowPress(EnigWindow.mainWindow)) {
			++selectedTZ;
			if (selectedTZ >= tzCount) {
				selectedTZ = tzCount - 1;
			}
		}
		for (int i = 0; i < translations.length;++i) {
			float xOff = translations[i] - EnigWindow.mainWindow.cursorXFloat;
			if (ys + xOff * xOff < 0.01f) {
				selectedTZ = i;
				if (EnigWindow.mainWindow.mouseButtons[GLFW_MOUSE_BUTTON_LEFT] > 0) {
					if (possibilities[i]) {
						ret = i;
					}
				}
			}
		}
		if (UserControls.enter(EnigWindow.mainWindow)) {
			if (possibilities[selectedTZ]) {
				ret = selectedTZ;
			}
		}
		program.enable();
		program.shaders[0].uniforms[0].set(aspectRatio);
		program.shaders[0].uniforms[1].set(translation);
		vao.prepareRender();
		if (currentTZ == 0) {
			leftSide[1].bind();
		}else if (!possibilities[0]) {
			leftSide[2].bind();
		}else {
			leftSide[0].bind();
		}
		vao.drawTriangles();
		for (int i = 1; i < tzCount - 1; ++i) {
			program.shaders[0].uniforms[1].set(translations[i]);
			if (currentTZ == i) {
				middle[1].bind();
			}else if (!possibilities[i]) {
				middle[2].bind();
			}else {
				middle[0].bind();
			}
			vao.drawTriangles();
		}
		program.shaders[0].uniforms[1].set(translations[tzCount - 1]);
		if (currentTZ == tzCount - 1) {
			rightSide[1].bind();
		}else if (!possibilities[tzCount - 1]) {
			rightSide[2].bind();
		}else {
			rightSide[0].bind();
		}
		vao.drawTriangles();
		program.shaders[0].uniforms[1].set(translations[selectedTZ]);
		arrow.bind();
		vao.drawTriangles();
		vao.unbind();
		if (ret > -1) {
			return ret;
		}else {
			return currentTZ;
		}
	}
}
