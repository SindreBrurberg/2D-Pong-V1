package GamePongV2;

import java.awt.*;

/**
 * Created by Haxer on 31.01.14.
 */
public class powerUpHandler{
    private pUGraphicHandler pUGH;
    private Rectangle effect;

    private int power;
    private boolean newPower = false;
    private boolean p1Enlarged = false, p2Enlarged = false, p1Reduced = false, p2Reduced = false;
    private int x, y, WIDTH = 75, HEIGHT = 75;

    public powerUpHandler() {
    }

    private double findX(){
        double random = Math.random() * 1000;
        double randomLarge = Math.random() * 10;
        double randomHuge = Math.random() * 50;
        if (random >= 200)
            return random;
        else if (random <= 100 && random > 25)
            return random * randomLarge;
        else if (random <= 25)
            return random * randomHuge;
        else if (random < 10)
            return random * 100;
        else if (random < 1)
            return random * 1000;
        else return ReferencePongV2.winX / 2;
    }

    private double findY(){
        double random = Math.random() * 1000;
        double randomLarge = Math.random() * 10;
        double randomHuge = Math.random() * 50;
        if (random >= ReferencePongV2.winY)
            return random - 300;
        else if (random >= 200 && random < ReferencePongV2.winY - 200)
            return random;
        else if (random <= 100 && random > 25)
            return random * randomLarge;
        else if (random <= 25)
            return random * randomHuge;
        else if (random < 10)
            return random * 100;
        else if (random < 1)
            return random * 1000;
        else return ReferencePongV2.winY / 2;
    }

    public void update(Ball ball, Player1 player1, Player2 player2, Computer computer) {
        double x = findX();
        double y = findY();
        if (time.getSec() >= 10 && time.getMilli() == 0 && Math.random() >= 0.1 && !newPower && x >= 150 && y >= 150){
            double r = Math.random();
            // speed up
            if (r <= 0.33){
                newPower = true;
                power = 1;
            }
            // more bounce
            else if (r > 0.33 && r <= 0.66 ){
                newPower = true;
                power = 2;
            }
            // smaler paddle
            else if (r > 0.66 && r <= 0.825 && !p2Reduced || r > 0.66 && r <= 0.825 && !p1Reduced){
                newPower = true;
                power = 3;
            }
            // larger paddle
            else if (r > 0.825 && !p2Enlarged || r > 0.825 && !p1Enlarged){
                newPower = true;
                power = 4;
            }
            effect = new  Rectangle((int) x, (int)y, WIDTH, HEIGHT);
            pUGH = new pUGraphicHandler(x, y, power);
        }
        if (power != 0 && ball.getBounds().intersects(effect) && newPower){
            if (power == 1){
                ball.incresSpeed();
                newPower = false;
            }else if (power == 2){
                ball.incresVel();
                newPower = false;
            }else if (power == 3){
                if (ball.getLastHit() == 1 && !p1Reduced){
                    player1.smalPaddle();
                    newPower = false;
                    if (p1Enlarged)
                        p1Enlarged = false;
                    else p1Reduced = true;
                }else if (ball.getLastHit() == 2 && !p2Reduced){
                    if (ReferencePongV2.gameMode == 1)
                        player2.smalPaddle();
                    else computer.smalPaddle();
                    newPower = false;
                    if (p2Enlarged)
                        p2Enlarged = false;
                    else p2Reduced = true;
                }else{
                    newPower = true;
                }
            }else if (power == 4){
                if (ball.getLastHit() == 1 && !p1Enlarged){
                    player1.largerPabble();
                    newPower = false;
                    if (p1Reduced)
                        p1Reduced = false;
                    else p1Enlarged = true;
                }else if (ball.getLastHit() == 2 && !p2Enlarged){
                    if (ReferencePongV2.gameMode == 1)
                        player2.largerPabble();
                    else computer.largerPabble();
                    newPower = false;
                    if (p2Reduced)
                        p2Reduced = false;
                    else p2Enlarged = true;
                }else{
                    newPower = true;
                }
            }
        }
    }

    public void draw(Graphics2D g2d) {
        if (power != 0 && newPower)
            pUGraphicHandler.loadPowerGraphic(g2d);
    }
}
