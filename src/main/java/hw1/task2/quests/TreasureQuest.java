package hw1.task2.quests;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary // если Qualifier в Knight нет, тогда по дефолту будет браться TreasureQuest
@Component
public class TreasureQuest implements Quest {
    @Override
    public void execute() {
        System.out.println("Treasure Quest executed");
    }
}
