package HW1;

import HW1.obstacles.Treadmill;
import HW1.obstacles.Wall;
import HW1.participants.Cat;
import HW1.participants.Human;
import HW1.participants.Participant;
import HW1.participants.Robot;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Competition competition = create();
        System.out.println("Начали соревнование! " + competition);
        competition.startCompetition();
        System.out.println("Закончили соревнование! Подводим итоги!");
        for(Participant winner : competition.getLastWinners()) {
            System.out.println(winner);
        }
    }

    private static Competition create(){
        Random rnd = new Random();

        Participant human = new Human("Sett", 100, 4000);
        Participant cat = new Cat("Ragnar",300, 3000);
        Participant robot = new Robot("SkyNet", 200, 10000);
        Treadmill treadmill = new Treadmill(rnd.nextInt(5000));
        Wall wall = new Wall(rnd.nextInt(220));

        Competition competition = new Competition("Hungry games.");
        competition.setParticipants(human, cat, robot);
        competition.setObstacles(wall, treadmill);

        return competition;
    }
}
