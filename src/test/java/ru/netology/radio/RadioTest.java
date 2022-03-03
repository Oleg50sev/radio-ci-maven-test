package ru.netology.radio;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @ParameterizedTest
    //Тест на ввод номера станции вручную по номеру с использованием метода граничных значений
    @CsvSource(value = {"middleStation, 5, 5",
            "nearLastStation, 8, 8",
            "lastStation, 9, 9",
            "overLastStation, 10, 0",
            "secondStation, 0, 0",
            "overSecondStation, 1, 1",
            "minusStation, -1, 0"})
    void setCurrentNumberStation(String testName, int currentNumberStation, int expected) {
        Radio radio = new Radio();

        radio.setCurrentNumberStation(currentNumberStation);

        int actual = radio.getCurrentNumberStation();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    //Тест на переключение вверх на одну станцию при нажатии на кнопку Next
    @CsvSource(value = {"middleStation, 5, 6",
            "nearLastStation, 8, 9",
            "lastStation, 9, 0",
            "secondStation, 0, 1",
            "overSecondStation, 1, 2"})
    void nextNumberStation(String testName, int currentNumberStation, int expected) {
        Radio radio = new Radio();

        radio.setCurrentNumberStation(currentNumberStation);

        radio.nextNumberStation();

        int actual = radio.getCurrentNumberStation();
        assertEquals(expected, actual);
    }


    @ParameterizedTest
    //Тест на переключение вверх на одну станцию вниз при нажатии на кнопку Prev
    @CsvSource(value = {"middleStation, 5, 4",
            "nearLastStation, 8, 7",
            "lastStation, 9, 8",
            "secondStation, 0, 9",
            "overSecondStation, 1, 0"})
    void prevNumberStation(String testName, int currentNumberStation, int expected) {
        Radio radio = new Radio();

        radio.setCurrentNumberStation(currentNumberStation);

        radio.prevNumberStation();

        int actual = radio.getCurrentNumberStation();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    //Тест на увеличение громкости на одну градацию при нажатии на кнопку +
    @CsvSource(value = {"middleStation, 5, 6",
            "nearLastStation, 9, 10",
            "lastStation, 10, 10",
            "secondStation, 0, 1",
            "overSecondStation, 1, 2"})
    void increaseVolume(String testName, int currentVolume, int expected) {
        Radio radio = new Radio();

        radio.setCurrentVolume(currentVolume);

        radio.increaseVolume();

        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    //Тест на уменьшение громкости на одну градацию при нажатии на кнопку -
    @CsvSource(value = {"middleStation, 5, 4",
            "nearLastStation, 9, 8",
            "lastStation, 10, 9",
            "secondStation, 0, 0",
            "overSecondStation, 1, 0"})
    void decreaseVolume(String testName, int currentVolume, int expected) {
        Radio radio = new Radio();

        radio.setCurrentVolume(currentVolume);

        radio.decreaseVolume();

        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }
}