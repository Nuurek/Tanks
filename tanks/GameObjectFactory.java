package tanks;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GameObjectFactory {
    private static ImageLoader imageLoader;
    Random randomEngine;

    public GameObjectFactory() {
        loadImageAlbum();
    }

    private void loadImageAlbum() {
        imageLoader = new ImageLoader();
        Map<String, String> imageEntries = new HashMap<String, String>();

        imageEntries.put("/assets/tanks/tankGray.png", "tankGray");
        imageEntries.put("/assets/tanks/tankRudy.png", "tankRudy");
        imageEntries.put("/assets/tanks/tankWaffen.png", "tankWaffen");
        imageEntries.put("/assets/bullet.png", "bullet");
        imageEntries.put("/assets/boosts/boosts_health.png", "health");
        imageEntries.put("/assets/boosts/boosts_shield_red.png", "armor");
        imageEntries.put("/assets/boosts/boosts_sight_inversed.png", "vision");
        imageEntries.put("/assets/boosts/boosts_speed_red.png", "speed");

        imageLoader.putMapIntoImageAlbum(imageEntries);

        randomEngine = new Random();
    }

    private double getRandomDouble(double min, double max) {
        return min + (max - min) * randomEngine.nextDouble();
    }

    public Tank createTank(double startX, double startY, double startDegree, double radius, double velocity, double angularVelocity, String imageName, String playerName) {
        Tank newTank = new Tank(startX, startY, startDegree, radius, velocity, angularVelocity);
        newTank.setImage(imageLoader.getImageFromAlbum(imageName));
        newTank.setOwnerName(playerName);

        return newTank;
    }

    public Tank createGenericTank(double startX, double startY, double startDegree, String imageName, String playerName) {
        return createTank(startX, startY, startDegree, 32, 50, 50, imageName, playerName);
    }

    public Bullet createBullet(double startX, double startY, double startDegree, double radius, double velocity, double damage) {
        double damageWithRandom = damage + getRandomDouble(-0.2 * damage, 0.2 * damage);
        Bullet newBullet = new Bullet(startX, startY, startDegree, radius, velocity, damageWithRandom);
        newBullet.setImage(imageLoader.getImageFromAlbum("bullet"));

        return newBullet;
    }

    public Bonus createBonus(double x, double y, double radius, int numberOfBonuses) {
        Bonus newBonus = new Bonus(x, y, 0, radius, 0, 0);
        BonusType type = BonusType.getRandomBonus(numberOfBonuses);
        newBonus.setBonusType(type);
        newBonus.setImage(imageLoader.getImageFromAlbum(BonusType.getString(type)));

        return newBonus;
    }

    private void setImage(RoundGameObject gameObject, String name) {
        gameObject.setImage(imageLoader.getImageFromAlbum(name));
    }
}
