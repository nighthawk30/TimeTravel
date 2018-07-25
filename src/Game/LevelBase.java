package Game;

import engine.Entities.Camera;
import engine.OpenGL.ShaderProgram;
import engine.OpenGL.Texture;
import engine.OpenGL.VAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LevelBase
{
	ArrayList<ArrayList<Character[]>> levelseries;
	float[] xstart;
	float[] ystart;
	int currentTZ;
    
    
    public static VAO tileObj;
    public static Texture floorTexture;
    public static Texture wallTexture;
    public static Texture newwallTexture;
    public static Texture[] ttoTexture;
    public static Texture controllerTexture;
    public static ShaderProgram levelProgram;
    public static int frameCounter;


	//Render Crap
    /*public LevelBase(String level, int width, int height)
    {
    	if (tileObj == null) {
			tileObj = new VAO(-25f, -25f, 50f, 50f);
    		floorTexture = new Texture("res/present-floor.png");
    		wallTexture = new Texture("res/present-wall.png");
    		levelProgram = new ShaderProgram("levelShader");
		}
		//creates a room from a string
		layout = new char[width][height];
        for (int i = 0; i < width; i++)
        {
            for (int j = 0; j < height; j++)
            {
                layout[i][j] =  level.charAt(i+j*width);
            }
        }
    }*/
    //gets the map
	public LevelBase(String filename)
	{
        if (tileObj == null) {
			tileObj = new VAO(-25f, -25f, 50f, 50f);
            floorTexture = new Texture("res/present-floor.png");
            wallTexture = new Texture("res/present-wall.png");
            newwallTexture = new Texture("res/future-wall.png");
			//changing texture for tto
			ttoTexture = new Texture[9];
			ttoTexture[0] = new Texture("res/anims/tto-1.png");
			ttoTexture[1] = new Texture("res/anims/tto-2.png");
			ttoTexture[2] = new Texture("res/anims/tto-3.png");
			ttoTexture[3] = new Texture("res/anims/tto-4.png");
			ttoTexture[4] = new Texture("res/anims/tto-5.png");
			ttoTexture[5] = new Texture("res/anims/tto-6.png");
			ttoTexture[6] = new Texture("res/anims/tto-7.png");
			ttoTexture[7] = new Texture("res/anims/tto-8.png");
			ttoTexture[8] = new Texture("res/anims/tto-9.png");

            levelProgram = new ShaderProgram("levelShader");
            controllerTexture = new Texture("res/controller-tto.png");
        }

		Scanner fileInput;
		String roomlist = "";
		//stores level rooms
		levelseries = new ArrayList<ArrayList<Character[]>>();
		//get the rooms
		try
		{
			fileInput = new Scanner(new File(filename));

			while (fileInput.hasNextLine())
			{
				String nextline = fileInput.nextLine();
				roomlist += nextline;
			}
		}
		catch (FileNotFoundException ex)
		{
			ex.printStackTrace();
			System.exit(0);
		}

		//splits the main string into level strings
		String[] rooms = roomlist.split(",");
		//start position of avatar
		xstart = new float[rooms.length];
		ystart = new float[rooms.length];

		//goes through each room
		for (int i = 0; i < rooms.length; i++)//level depth
		{
			//splits level string into rows
			String[] levelslices = rooms[i].split("@");
			ArrayList<Character[]> levelroom = new ArrayList<Character[]>();
			//goes through each row
			for (int j = 0; j < levelslices.length; j++)//character row number
			{
				//gets a row from the level string split
				String lane = levelslices[j];
				Character[] levelrow = new Character[levelslices[j].length()];
				//goes through the row
				for (int k = 0; k < lane.length(); k++)//character column number
				{
					//puts a character into the char array
					levelrow[k] = lane.charAt(k);
					if (lane.charAt(k) == 's')
					{
						xstart[i] = j;
						ystart[i] = k;
						currentTZ = i;
					}
				}
				//adds the row char array to the level arraylist
				levelroom.add(levelrow);
			}
			//adds the level arraylist to the levelseries arraylist
			levelseries.add(levelroom);
		}

		//LEVEL EXTRACTION
		/*
		String output = "";
		int tense = 2;//time period - 0,1,2
		for (int j = 0; j < levelseries.get(tense).size(); j++)
		{
			for (int k = 0; k < levelseries.get(tense).get(j).length; k++)
			{
				output += levelseries.get(tense).get(j)[k];
			}
			output += "\n";
		}
		System.out.println(output);
		*/
	}

	public static void updateTTO(int locationInArray) {
		frameCounter = locationInArray;
	}

	public void render(Camera cam) {
    	levelProgram.enable();
    	tileObj.prepareRender();
    	for (int row = 0; row < levelseries.get(currentTZ).size();++row) {
    		for (int chr = 0; chr < levelseries.get(currentTZ).get(row).length; ++chr) {
    			char currentChar = levelseries.get(currentTZ).get(row)[chr];
				if (currentChar != '_') {
					if (currentChar == ' ' || currentChar == 's') {
    					floorTexture.bind();
					}else if (currentChar == '#') {
    					newwallTexture.bind();
					}else if (currentChar == 't') {
						ttoTexture[frameCounter].bind();
					}
					float x = ((float) chr) * 50f;
					float y = -((float) row) * 50f;
					levelProgram.shaders[0].uniforms[0].set(cam.getCameraMatrix(x, y + 2*cam.y, 0));
					tileObj.drawTriangles();
				}
			}
		}
		tileObj.unbind();
	}
}
