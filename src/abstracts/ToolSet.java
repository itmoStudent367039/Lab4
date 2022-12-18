package abstracts;

import subjects.Hero;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class ToolSet {
    private ArrayList<Tool> tools;

    public ToolSet(Tool... tools) {
        this.tools = new ArrayList<Tool>();
        this.tools.addAll(Arrays.asList(tools));
    }

    public void subTool(Tool tool) {
        for (Tool tool1 : this.tools) {
            if (tool1.getName().equals(tool.getName())) {
                this.tools.remove(tool1);
                break;
            }
        }
    }
    public void addTool(Tool tool) {
        tools.add(tool);
    }
}
