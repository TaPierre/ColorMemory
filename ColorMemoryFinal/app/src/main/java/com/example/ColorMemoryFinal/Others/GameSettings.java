package com.example.ColorMemoryFinal.Others;

public class GameSettings {

    private boolean _canAnswer;
    private  int _IndexBtnAnswer;
    private int _currentLightsCount;
    private int _currentBlocsCount;

    public void setIndexBtnAnswer(int _IndexBtnAnswer) {
        this._IndexBtnAnswer = _IndexBtnAnswer;
    }

    public int getIndexBtnAnswer() {
        return _IndexBtnAnswer;
    }

    public boolean getAnswer() {
        return _canAnswer;
    }

    public void setAnswer(boolean _Answer) {
        this._canAnswer = _Answer;
    }

    public int getCurrentLightsCount() {
        return _currentLightsCount;
    }

    public void setCurrentLightsCount(int _currentLightsCount) {
        this._currentLightsCount = _currentLightsCount;
    }

    public int getCurrentBlocsCount() {
        return _currentBlocsCount;
    }

    public void setCurrentBlocsCount(int _currentBlocsCount) {
        this._currentBlocsCount = _currentBlocsCount;
    }
}
