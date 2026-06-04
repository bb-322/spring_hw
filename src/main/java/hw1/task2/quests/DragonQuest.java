package hw1.task2.quests;

import org.springframework.stereotype.Component;

@Component
public class DragonQuest implements Quest {
    @Override
    public void execute() {
        System.out.println("Dragon Quest executed");
    }
}
