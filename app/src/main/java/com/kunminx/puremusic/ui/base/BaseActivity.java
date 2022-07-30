/*
 * Copyright 2018-2020 KunMinX
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.kunminx.puremusic.ui.base;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;

import com.kunminx.architecture.ui.scope.ViewModelScope;
import com.kunminx.puremusic.utils.AdaptScreenUtils;
import com.kunminx.puremusic.utils.BarUtils;
import com.kunminx.puremusic.utils.ScreenUtils;


/**
 * Create by KunMinX at 19/8/1
 */
public abstract class BaseActivity extends AppCompatActivity {

  private final ViewModelScope mViewModelScope = new ViewModelScope();

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    BarUtils.setStatusBarColor(this, Color.TRANSPARENT);
    BarUtils.setStatusBarLightMode(this, true);
  }

  public boolean isDebug() {
    return getApplicationContext().getApplicationInfo() != null &&
            (getApplicationContext().getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
  }

  @Override
  public Resources getResources() {
    if (ScreenUtils.isPortrait()) {
      return AdaptScreenUtils.adaptWidth(super.getResources(), 360);
    } else {
      return AdaptScreenUtils.adaptHeight(super.getResources(), 640);
    }
  }

  protected <T extends ViewModel> T getActivityScopeViewModel(@NonNull Class<T> modelClass) {
    return mViewModelScope.getActivityScopeViewModel(this, modelClass);
  }

  protected <T extends ViewModel> T getApplicationScopeViewModel(@NonNull Class<T> modelClass) {
    return mViewModelScope.getApplicationScopeViewModel(modelClass);
  }

  protected void showLongToast(String text) {
    Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
  }

  protected void showShortToast(String text) {
    Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
  }

  protected void showLongToast(int stringRes) {
    showLongToast(getApplicationContext().getString(stringRes));
  }

  protected void showShortToast(int stringRes) {
    showShortToast(getApplicationContext().getString(stringRes));
  }

  protected void toggleSoftInput() {
    InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
    imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
  }
}
