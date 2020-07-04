package HW1.obstacles;

import HW1.participants.Participant;

public class Wall implements Obstacle {

    private final int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean checkObstacle(Participant participant) {
        if(participant.jump() > height){
            System.out.println("Участник " + participant + " успешно перепрыгнул препядствие " + height + ".");
            return true;
        }else{
            System.out.println("Участник " + participant + " не смог перепрыгнуть препядствие " + height + ".");
            return false;
        }
    }
}
