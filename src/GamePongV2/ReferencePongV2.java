package GamePongV2;

public class ReferencePongV2 {

    public static final boolean debugMode = false;

    public static final int winX = 1200, winY = 800;
    public static int paddelWith = 25;
    public static int paddelHight = 200;
    public static int scoreP1 = 0;
    public static int scoreP2 = 0;
    public static double speedP1 = 0;
    public static double speedP2 = 0;
    public static int scoreP1X = winX / 2 - 100;
    public static int scoreP1Y = 50;
    public static int scoreP2X = winX / 2 + 100;
    public static int scoreP2Y = 50;
    public static int speedFast = 12;
    public static int speedMedium = 8;
    public static int speedSlow = 4;
    public static int speedFastComputer = 6;
    public static int speedMediumComputer = 5;
    public static int speedSlowComputer = 4;
    public static float speedBall = 4f;
    public static float speedBallIncreas = 0.5f;
    public static int gameMode = 0;
    public static int time;

    public static final String Title = "Pong";
    public static final String Pause = "Game is paused";
    public static final String debug = "Debug: ";
    public static boolean isGameRunning = false;
}
