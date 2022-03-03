package ru.netology.radio;

public class Radio {
    private int currentNumberStation;
    private int currentVolume;

    public int getCurrentNumberStation() {
        return currentNumberStation;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentNumberStation(int currentNumberStation) {
        if (currentNumberStation > 9) {
            return;
        }
        if (currentNumberStation < 0) {
            return;
        }
        this.currentNumberStation = currentNumberStation;
    }

    public void setCurrentVolume(int currentVolume) {
        this.currentVolume = currentVolume;
    }

    public void nextNumberStation() {
        if (currentNumberStation == 9) {
            currentNumberStation = 0;
            return;
        }
        currentNumberStation++;
    }

    public void prevNumberStation() {
        if (currentNumberStation == 0) {
            currentNumberStation = 9;
            return;
        }
        currentNumberStation--;
    }

    public void increaseVolume() {
        if (currentVolume < 10) {
            currentVolume++;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume--;
        }
    }

}
