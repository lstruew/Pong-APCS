import java.awt.*;
public class Paddle {
    private int x, y;
    private final int WIDTH = 20, HEIGHT = 100;
    private int dy = 3,cdy = 2;

    Board board;
    Game game;

    public Paddle(Board board, Game game){
        x=0;
        y=0;
        this.board = board;
        this.game = game;
    }
   public Rectangle getBounds(){
       return new Rectangle(x,y,WIDTH, HEIGHT);
   }




    public void paint(Graphics g){
        g.fillRect(x,y,WIDTH,HEIGHT);
    }
    public void setPosition(int x, int y){
        this.x = x - WIDTH/2;
        this.y = y - HEIGHT/2;
    }
    public void move(Ball bBall){
        if (bBall.getX() + bBall.getDiam()> board.getWidth()/2){
            if (bBall.getY() < y + HEIGHT/2){
                y-= cdy;
            }
            if (bBall.getY() > y + HEIGHT/2) {
                y += cdy;
            }
        }

    }

    public void move(){
        if(game.isUpPressed()&&(y>=5)){
            y-=dy;
        }
        if (game.isDownPressed()&&(y<=(board.getHeight()-HEIGHT-5))){
            y+=dy;
        }
    }


}
