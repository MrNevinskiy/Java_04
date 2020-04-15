package HW1;

import HW1.obstacles.Obstacle;
import HW1.participants.Participant;
import java.util.LinkedList;
import java.util.List;

public class Competition {

    private final String competitionTitle;

    private Obstacle[] obstacles;
    private Participant [] participants;

    private final List<Participant> lastWinners = new LinkedList<>();

    public Competition(String competitionTitle) {
        this.competitionTitle = competitionTitle;
    }

    public void setObstacles(Obstacle... obstacles) {
        this.obstacles = obstacles;
    }

    public void setParticipants(Participant... participants) {
        this.participants = participants;
    }

    public void startCompetition() {
        lastWinners.clear();

        for(Participant participant : participants) {
            boolean success = passAllObstacles(participant);
            if (!success) {
                System.out.println("Участник " + participant + " покинул испытание.");
            } else {
                lastWinners.add(participant);
            }
        }
    }

    public List<Participant> getLastWinners() {
        return lastWinners;
    }

    private boolean passAllObstacles(Participant participant){
        for (Obstacle obstacle : obstacles) {
            if(!obstacle.checkObstacle(participant)){
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Competition{" +
                "competitionTitle='" + competitionTitle + '\'' +
                '}';
    }
}
