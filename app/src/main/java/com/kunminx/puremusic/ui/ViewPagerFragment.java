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
import androidx.lifecycle.ViewModel;
import androidx.viewpager.widget.ViewPager;

import com.kunminx.architecture.ui.state.State;
import com.kunminx.puremusic.R;
import com.kunminx.puremusic.databinding.FragmentViewPagerBinding;
import com.kunminx.puremusic.ui.base.BaseFragment;
import com.kunminx.puremusic.ui.base.adapter.CommonViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by KunMinX at 2020/5/30
 */
public class ViewPagerFragment extends BaseFragment {

  private ViewPagerStates mStates;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mStates = getFragmentScopeViewModel(ViewPagerStates.class);
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_view_pager, container, false);
    FragmentViewPagerBinding binding = FragmentViewPagerBinding.bind(view);
    binding.setLifecycleOwner(this);
    binding.setClick(new ClickProxy());
    return view;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    String[] titles = {"tab1", "tab2"};

    ViewPager vp2 = view.findViewById(R.id.vp_2);
    vp2.setAdapter(new CommonViewPagerAdapter(false, titles));

    List<View> views = new ArrayList<>();
    View view1 = new View(getContext());
    view1.setBackgroundResource(R.color.blue);
    View view2 = new View(getContext());
    view2.setBackgroundResource(R.color.colorAccent);
    views.add(view1);
    views.add(view2);
    ViewPager vp3 = view.findViewById(R.id.vp_3);
    vp3.setAdapter(new CommonViewPagerAdapter(false, views, titles));
  }

  public class ClickProxy {
    public void jump() {
      nav().navigate(R.id.action_viewPagerFragment_self);
    }
  }

  public static class ViewPagerStates extends ViewModel {
    public final State<Boolean> initTabAndPage = new State<>(true);
  }
}
