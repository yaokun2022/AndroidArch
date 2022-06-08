package com.yk.getconfdemo;

import java.util.List;

public class MachineInfo {

    private int code;
    private Data data;
    private String msg;
    private int total;
    private int totalPage;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public static class Data {
        private String positionType;
        private boolean isFace;
        private String doorName;
        private int lockType;
        private String machinePassword;
        private String communityAddress;
        private String communityType;
        private List<BuildingAndUnit> buildingAndUnit;
        private boolean isVolume;
        private int machineVolume;
        private String communityName;
        private boolean isLuminance;
        private boolean isLed;
        private int machineLed;

        public String getPositionType() {
            return positionType;
        }

        public void setPositionType(String positionType) {
            this.positionType = positionType;
        }

        public boolean isIsFace() {
            return isFace;
        }

        public void setIsFace(boolean isFace) {
            this.isFace = isFace;
        }

        public String getDoorName() {
            return doorName;
        }

        public void setDoorName(String doorName) {
            this.doorName = doorName;
        }

        public int getLockType() {
            return lockType;
        }

        public void setLockType(int lockType) {
            this.lockType = lockType;
        }

        public String getMachinePassword() {
            return machinePassword;
        }

        public void setMachinePassword(String machinePassword) {
            this.machinePassword = machinePassword;
        }

        public String getCommunityAddress() {
            return communityAddress;
        }

        public void setCommunityAddress(String communityAddress) {
            this.communityAddress = communityAddress;
        }

        public String getCommunityType() {
            return communityType;
        }

        public void setCommunityType(String communityType) {
            this.communityType = communityType;
        }

        public List<BuildingAndUnit> getBuildingAndUnit() {
            return buildingAndUnit;
        }

        public void setBuildingAndUnit(List<BuildingAndUnit> buildingAndUnit) {
            this.buildingAndUnit = buildingAndUnit;
        }

        public boolean isIsVolume() {
            return isVolume;
        }

        public void setIsVolume(boolean isVolume) {
            this.isVolume = isVolume;
        }

        public int getMachineVolume() {
            return machineVolume;
        }

        public void setMachineVolume(int machineVolume) {
            this.machineVolume = machineVolume;
        }

        public String getCommunityName() {
            return communityName;
        }

        public void setCommunityName(String communityName) {
            this.communityName = communityName;
        }

        public boolean isIsLuminance() {
            return isLuminance;
        }

        public void setIsLuminance(boolean isLuminance) {
            this.isLuminance = isLuminance;
        }

        public boolean isIsLed() {
            return isLed;
        }

        public void setIsLed(boolean isLed) {
            this.isLed = isLed;
        }

        public int getMachineLed() {
            return machineLed;
        }

        public void setMachineLed(int machineLed) {
            this.machineLed = machineLed;
        }

        public static class BuildingAndUnit {
            private String buildingName;
            private int statusCd;
            private String unitName;

            public String getBuildingName() {
                return buildingName;
            }

            public void setBuildingName(String buildingName) {
                this.buildingName = buildingName;
            }

            public int getStatusCd() {
                return statusCd;
            }

            public void setStatusCd(int statusCd) {
                this.statusCd = statusCd;
            }

            public String getUnitName() {
                return unitName;
            }

            public void setUnitName(String unitName) {
                this.unitName = unitName;
            }
        }
    }
}
