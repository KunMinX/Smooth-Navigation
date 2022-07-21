package com.kunminx.puremusic.ui.base.binding;

import androidx.databinding.BindingAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.kunminx.puremusic.R;
import com.kunminx.puremusic.ui.base.adapter.CommonViewPagerAdapter;

/**
 * Create by KunMinX at 2020/3/13
 */
public class TabPageBindingAdapter {

  @BindingAdapter(value = {"initTabAndPage"}, requireAll = false)
  public static void initTabAndPage(TabLayout tabLayout, boolean initTabAndPage) {
    int count = tabLayout.getTabCount();
    String[] title = new String[count];
    for (int i = 0; i < count; i++) {
      TabLayout.Tab tab = tabLayout.getTabAt(i);
      if (tab != null && tab.getText() != null) {
        title[i] = tab.getText().toString();
      }
    }
    ViewPager viewPager = (tabLayout.getRootView()).findViewById(R.id.vp);
    if (viewPager != null) {
      viewPager.setAdapter(new CommonViewPagerAdapter(false, title));
      tabLayout.setupWithViewPager(viewPager);
    }
  }

  @BindingAdapter(value = {"tabSelectedListener"}, requireAll = false)
  public static void tabSelectedListener(TabLayout tabLayout, TabLayout.OnTabSelectedListener listener) {
    tabLayout.addOnTabSelectedListener(listener);
  }

}
