package com.caesar.pressme;

public class Character {
    private int mTextResId;

    public Character(int TextResId){
        mTextResId = TextResId;
    }

    public int getTextResId() {
        return mTextResId;
    }
    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }
}
