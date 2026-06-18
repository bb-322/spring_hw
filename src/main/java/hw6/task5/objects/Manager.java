package hw6.task5.objects;

import java.util.Map;
import java.util.Set;

public interface Manager {

	Set<String> getExtensionList(String folder);

	Map<String, Integer> getExtensionCount(String folder);

}
