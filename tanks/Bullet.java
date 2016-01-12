package tanks;

public class Bullet extends RoundGameObject {
    public double damage;

    public Bullet(double startX, double startY, double startDegree, double radius, double velocity, double damage) {
        super(startX, startY, startDegree, radius, velocity);
        this.damage = damage;
    }
}
