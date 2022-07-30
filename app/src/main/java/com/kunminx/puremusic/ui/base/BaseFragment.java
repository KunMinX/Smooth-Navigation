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
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.kunminx.architecture.ui.scope.ViewModelScope;


/**
 * Create by KunMinX at 19/7/11
 */
public abstract class BaseFragment extends Fragment {

  private static final Handler HANDLER = new Handler();
  protected AppCompatActivity mActivity;
  protected boolean mAnimationLoaded;
  private final ViewModelScope mViewModelScope = new ViewModelScope();

  @Override
  public void onAttach(@NonNull Context context) {
    super.onAttach(context);
    mActivity = (AppCompatActivity) context;
  }

  @Nullable
  @Override
  public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
    HANDLER.postDelayed(() -> {
      if (!mAnimationLoaded) {
        mAnimationLoaded = true;
        loadInitData();
      }
    }, 280);
    return super.onCreateAnimation(transit, enter, nextAnim);
  }

  protected void loadInitData() {

  }

  protected <T extends ViewModel> T getFragmentScopeViewModel(@NonNull Class<T> modelClass) {
    return mViewModelScope.getFragmentScopeViewModel(this, modelClass);
  }

  protected <T extends ViewModel> T getActivityScopeViewModel(@NonNull Class<T> modelClass) {
    return mViewModelScope.getActivityScopeViewModel(mActivity, modelClass);
  }

  protected <T extends ViewModel> T getApplicationScopeViewModel(@NonNull Class<T> modelClass) {
    return mViewModelScope.getApplicationScopeViewModel(modelClass);
  }


  public boolean isDebug() {
    return mActivity.getApplicationContext().getApplicationInfo() != null &&
            (mActivity.getApplicationContext().getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
  }

  protected void showLongToast(String text) {
    Toast.makeText(mActivity.getApplicationContext(), text, Toast.LENGTH_LONG).show();
  }

  protected void showShortToast(String text) {
    Toast.makeText(mActivity.getApplicationContext(), text, Toast.LENGTH_SHORT).show();
  }

  protected void showLongToast(int stringRes) {
    showLongToast(mActivity.getApplicationContext().getString(stringRes));
  }

  protected void showShortToast(int stringRes) {
    showShortToast(mActivity.getApplicationContext().getString(stringRes));
  }

  protected NavController nav() {
    return NavHostFragment.findNavController(this);
  }

  protected void toggleSoftInput() {
    InputMethodManager imm = (InputMethodManager) mActivity.getSystemService(Activity.INPUT_METHOD_SERVICE);
    imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
  }
}
