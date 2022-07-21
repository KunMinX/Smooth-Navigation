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
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.kunminx.puremusic.R;
import com.kunminx.puremusic.databinding.FragmentIndexBinding;
import com.kunminx.puremusic.domain.event.SharedViewModel;
import com.kunminx.puremusic.ui.base.BaseFragment;

/**
 * Create by KunMinX at 2020/5/30
 */
public class IndexFragment extends BaseFragment {

  private SharedViewModel mEvent;
  private FragmentIndexBinding mBinding;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mEvent = getActivityScopeViewModel(SharedViewModel.class);
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_index, container, false);
    mBinding = FragmentIndexBinding.bind(view);
    mBinding.setLifecycleOwner(this);
    return view;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    mBinding.vp.setAdapter(new FragmentPagerAdapter(mActivity));
    new TabLayoutMediator(mBinding.tab, mBinding.vp, (tab, position) -> {
      tab.setText(String.valueOf(position));
    }).attach();
    mBinding.tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
      @Override
      public void onTabSelected(TabLayout.Tab tab) {
        mBinding.vp.setCurrentItem(tab.getPosition(), mBinding.sw.isChecked());
      }

      @Override
      public void onTabUnselected(TabLayout.Tab tab) {

      }

      @Override
      public void onTabReselected(TabLayout.Tab tab) {

      }
    });
    mBinding.bottomView.setOnItemSelectedListener(item -> {
      int itemId = item.getItemId();
      if (itemId == R.id.navigation_item1) {
        mBinding.vp.setCurrentItem(0, false);
      } else if (itemId == R.id.navigation_item2) {
        mBinding.vp.setCurrentItem(1, false);
      } else if (itemId == R.id.navigation_item3) {
        mBinding.vp.setCurrentItem(2, false);
      }
      return true;
    });
    mBinding.sw.setOnCheckedChangeListener((buttonView, isChecked) -> {
      mBinding.vp.setUserInputEnabled(isChecked);
    });
  }

  public static class FragmentPagerAdapter extends FragmentStateAdapter {

    public FragmentPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
      super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
      return new ChildDFragment();
    }

    @Override
    public int getItemCount() {
      return 3;
    }
  }

}
