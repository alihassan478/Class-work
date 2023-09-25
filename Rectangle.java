import org.w3c.dom.css.Rect;

public class Rectangle {
    private double length;

    private double width;

    int x;

    int y;

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }


    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public Rectangle(double length , double width , int x , int y) {
        setLength(length);
        setWidth(width);
        setX(x);
        setY(y);
    }


    public double calArea(){
        return this.length*this.width;
    }

    public double calCircum(){
        return 2*(length+width);
    }



    public Rectangle comparewithsec(Rectangle r1 , Rectangle r2){
        if(r1.calArea() > r2.calArea()){
            System.out.println("Rectangle One is larger");
            return r1;
        }
        else {
            System.out.println("Rectangle Two is larger");
            return r2;
        }
    }

    public static void compare(double area1 , double area2){
        if(area1 > area2){
            System.out.println("Recatnagle one is larger");
        }
        else {
            System.out.println("Rectangle second is larger");
        }
    }

    public Boolean compareWithIntersect(Rectangle r1 , Rectangle r2){
        if((r1.x + r1.length) > r2.x && (r1.y + r1.width) > r2.y){
            return true;
        }
        else {
            return false;
        }
    }
}
