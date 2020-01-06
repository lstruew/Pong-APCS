import java.awt.*;
public class Ball {
    private int x,y;
    final int DIAMETER = 20;
    private final int SPEED = 3;
    double dx = SPEED, dy = SPEED;
    double MAXANGLE = 5*Math.PI/12;

    Board board;

    public Ball(Board board){
        x=0;
        y=0;

        //the 'this' keyword references the object that is executing or calling the 'this' reference
        this.board = board;

    }

    public Rectangle getBounds(){
        return new Rectangle(x,y,DIAMETER, DIAMETER);
    }

    public void checkCollisions(Paddle other){
        if(getBounds().intersects(other.getBounds())){
            double paddleY = other.getBounds().getY();
            double paddleC = other.getBounds().getHeight()/2;
            double bally = y;

            double relativeIntersect = (paddleY+paddleC)-bally;
            double normalIntersect = relativeIntersect/paddleC;
            double bounceAngle = MAXANGLE + normalIntersect;

            if(x < board.getWidth()/2){
                dx *= -1;
            }
            if (x > board.getWidth()/2){
                dx *= -1;
            }
            dy = SPEED *(Math.random()*2-1);

        }
    }

    public void move(){

        //LEFT AND RIGHT
        if (x<= 25){
           board.setcScore(board.getcScore()+1);
           x= board.getWidth()/2;
           y= board.getHeight()/2;

        }
        if(x>=board.getWidth()-25){
            board.setpScore(board.getpScore()+1);
            x= board.getWidth()/2;
            y= board.getHeight()/2;
        }
        if ((x<= 0)||(x>=board.getWidth()-DIAMETER)){
            dx *= -1;
        }
        //TOP AND BOTTOM
        if((y<= 0)||(y>=board.getHeight()-DIAMETER)){
            dy*= -1;
        }
        x+=dx;
        y+=dy;
    }

    public void paint(Graphics g){
        g.fillOval(x,y,DIAMETER,DIAMETER);
    }
    public void setPosition(int x,int y){

        this.x = x - DIAMETER/2;
        this.y = y - DIAMETER/2;

    }

    public int getY(){
        return y;
    }
    public int getX(){
        return x;
    }

    public int getDiam(){
        return DIAMETER;
    }

}
