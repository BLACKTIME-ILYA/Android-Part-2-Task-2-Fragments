package com.sourceit.task2.ui;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.sourceit.task2.R;
import com.sourceit.task2.utils.L;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Random random;
    private List<Integer> tempColors;
    private String[] colors;
    private final int MAX_RANDOM = 10;
    private List<MyFragment> fragments = new ArrayList<>();
    private int selectColor;
    Drawable currentColor;

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        MyFragment myFragment1 = MyFragment.newInstance();
        MyFragment myFragment2 = MyFragment.newInstance();
        MyFragment myFragment3 = MyFragment.newInstance();
        MyFragment myFragment4 = MyFragment.newInstance();
        fragments.add(myFragment1);
        fragments.add(myFragment2);
        fragments.add(myFragment3);
        fragments.add(myFragment4);

        fragmentTransaction.add(R.id.container1, myFragment1, "fragment1");
        fragmentTransaction.add(R.id.container2, myFragment2, "fragment2");
        fragmentTransaction.add(R.id.container3, myFragment3, "fragment3");
        fragmentTransaction.add(R.id.container4, myFragment4, "fragment4");

        init();
        fragmentTransaction.commit();
    }

    private void init() {
        random = new Random();
        tempColors = new ArrayList<>();
        colors = new String[]{"#D32F2F", "#AD1457", "#6A1B9A", "#7986CB", "#26C6DA", "#B2DFDB", "#1DE9B6", "#EEFF41", "#B2FF59", "#FFD54F"};
    }

    public void changeColors(String tag) {
        Drawable background = fragmentManager.findFragmentByTag(tag).getView().getBackground();
        tempColors.add(((ColorDrawable) background).getColor());

        for (MyFragment fragment : fragments) {
            if (!fragment.getTag().equals(tag)) {

                currentColor = fragment.getView().getBackground();
                selectColor = selectColor();

                fragment.getView().setBackgroundColor(selectColor);
            }
        }

        tempColors.clear();
    }

    private int selectColor() {
        L.d("selectColor...");
        int color = Color.parseColor(colors[random.nextInt(MAX_RANDOM)]);
        if (color != ((ColorDrawable) currentColor).getColor()) {
            if (!tempColors.contains(color)) {
                tempColors.add(color);
                return color;
            }
        }
        return selectColor();
    }
}
