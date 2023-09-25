public class Main {
    public static void main(String[] args) {
        Rectangle R1 = new Rectangle(30,20,20,10);
        Rectangle R2 = new Rectangle(10,10,30,20);

//        R1.setWidth(20);
//        R1.setLength(30);
//        R1.setX(20);
//        R1.setY(10);
//
//        R2.setLength(10);
//        R2.setWidth(10);
//        R2.setX(30);
//        R2.setY(20);

        System.out.println(R1.calArea());
        System.out.println(R1.calCircum());

        System.out.println(R2.calArea());
        System.out.println(R2.calCircum());

        Rectangle.compare(R1.calArea(), R2.calArea());


        R1.comparewithsec(R1,R2);

        System.out.println("Did these two rectangles intersect : " +R1.compareWithIntersect(R1,R2));
    }
}
