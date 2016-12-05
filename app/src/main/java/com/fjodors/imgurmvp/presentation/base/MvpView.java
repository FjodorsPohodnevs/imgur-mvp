package com.fjodors.imgurmvp.presentation.base;

public interface MvpView {
    void showError(Throwable e);

    void showError(int e);

    void hideProgress();

    void showProgress();
}
