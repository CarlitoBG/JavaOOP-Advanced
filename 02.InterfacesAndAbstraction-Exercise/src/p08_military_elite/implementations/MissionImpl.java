package p08_military_elite.implementations;

import p08_military_elite.interfaces.Mission;

public class MissionImpl implements Mission{

    private static final String MISSION_FINISHED_STATUS = "Finished";
    private static final String MISSION_IN_PROGRESS_STATUS = "inProgress";

    private String codeName;
    private String state;

    public MissionImpl(String codeName, String state) {
        this.codeName = codeName;
        this.setState(state);
    }

    private void setState(String state) {
        if (MISSION_IN_PROGRESS_STATUS.equals(state) || MISSION_FINISHED_STATUS.equals(state)){
            this.state = state;
        }
    }

    @Override
    public String getCodeName() {
        return this.codeName;
    }

    @Override
    public String getState() {
        return this.state;
    }

    @Override
    public void completeMission() {
        this.setState(MISSION_FINISHED_STATUS);
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", this.getCodeName(), this.getState());
    }
}