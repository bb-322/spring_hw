package hw1.task2;

import hw1.task2.quests.Quest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Knight {

    private final Quest quest;

    public Knight(@Qualifier("dragonQuest") Quest quest) {
        this.quest = quest;
    }

    public void executeQuest() {
        quest.execute();
    }

}
