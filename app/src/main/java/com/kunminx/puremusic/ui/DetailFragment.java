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
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import com.kunminx.puremusic.R;
import com.kunminx.puremusic.databinding.FragmentDetailBinding;
import com.kunminx.puremusic.ui.base.BaseFragment;
import com.kunminx.puremusic.ui.event.SharedViewModel;
import com.kunminx.puremusic.ui.state.DetailViewModel;

/**
 * Create by KunMinX at 2020/5/30
 */
public class DetailFragment extends BaseFragment {

  private DetailViewModel mState;
  private SharedViewModel mEvent;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mState = getFragmentScopeViewModel(DetailViewModel.class);
    mEvent = getActivityScopeViewModel(SharedViewModel.class);
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_detail, container, false);
    FragmentDetailBinding binding = FragmentDetailBinding.bind(view);
    binding.setLifecycleOwner(this);
    binding.setVm(mState);
    binding.setClick(new ClickProxy());
    return view;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);


  }

  public class ClickProxy implements Toolbar.OnMenuItemClickListener {

    public void locate() {

    }

    public void back() {
      nav().navigateUp();
    }

    public void singleTopJump() {
      nav().navigate(R.id.action_detailFragment_to_detailFragment);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
      if (item.getItemId() == R.id.menu_edit) {
        nav().navigate(R.id.action_detailFragment_to_editorFragment);
      }
      return true;
    }
  }
}
