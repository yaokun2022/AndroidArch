package com.yk.retrofit;

import java.util.List;

public class MachineInfo {

    public int code;
    public Data data;
    public String msg;
    public int total;
    public int totalPage;

    public static class Data {
        public String positionType;
        public boolean isFace;
        public String doorName;
        public int lockType;
        public String machinePassword;
        public String communityAddress;
        public String communityType;
        public boolean isVolume;
        public int machineVolume;
        public String communityName;
        public boolean isLuminance;
        public boolean isLed;
        public int machineLed;
        public List<BuildingAndUnit> buildingAndUnit;

        public static class BuildingAndUnit {
            public String buildingName;
            public int statusCd;
            public String unitName;
        }
    }
}
