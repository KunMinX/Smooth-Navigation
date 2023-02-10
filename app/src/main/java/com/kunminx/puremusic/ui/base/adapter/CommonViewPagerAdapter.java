/*
 * Copyright 2018-present KunMinX
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

package com.kunminx.puremusic.ui.base.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

/**
 * Create by KunMinX at 19/6/15
 */
public class CommonViewPagerAdapter extends PagerAdapter {

  private final int count;
  private final boolean enableDestroyItem;
  private final String[] title;
  private List<View> mViews;
  private final boolean childAtXml;

  public CommonViewPagerAdapter(boolean enableDestroyItem, List<View> views, String[] title) {
    this.mViews = views;
    this.childAtXml = false;
    this.title = title;
    this.count = title.length;
    this.enableDestroyItem = enableDestroyItem;
  }

  public CommonViewPagerAdapter(boolean enableDestroyItem, String[] title) {
    this.childAtXml = true;
    this.count = title.length;
    this.enableDestroyItem = enableDestroyItem;
    this.title = title;
  }

  @Override
  public int getCount() {
    return count;
  }

  @Override
  public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
    return view == object;
  }

  @NonNull
  @Override
  public Object instantiateItem(@NonNull ViewGroup container, int position) {
    if (childAtXml) return container.getChildAt(position);
    else {
      View view = mViews.get(position);
      container.addView(view);
      return view;
    }
  }

  @Override
  public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
    if (enableDestroyItem) {
      container.removeView((View) object);
    }
  }

  @Nullable
  @Override
  public CharSequence getPageTitle(int position) {
    return title[position];
  }
}

