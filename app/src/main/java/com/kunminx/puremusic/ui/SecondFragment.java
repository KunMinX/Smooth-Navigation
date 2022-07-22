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

package com.kunminx.puremusic.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.kunminx.puremusic.R;
import com.kunminx.puremusic.databinding.FragmentSecondBinding;
import com.kunminx.puremusic.domain.message.SharedViewModel;
import com.kunminx.puremusic.ui.base.BaseFragment;

/**
 * Create by KunMinX at 2020/5/30
 */
public class SecondFragment extends BaseFragment {

  private DetailFragment.DetailViewModel mState;
  private SharedViewModel mEvent;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mState = getFragmentScopeViewModel(DetailFragment.DetailViewModel.class);
    mEvent = getActivityScopeViewModel(SharedViewModel.class);
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_second, container, false);
    FragmentSecondBinding binding = FragmentSecondBinding.bind(view);
    binding.setLifecycleOwner(this);
    return view;
  }
}
